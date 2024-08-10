package websearch;

import jsjf.ArrayUnorderedList;
import jsjf.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;

public class SearchEngine{
    ArrayUnorderedList<URLWords> webcrawl = new ArrayUnorderedList<URLWords>();
    HashMap<String, String> cache = new HashMap<>();

    int maxResults = 10;

    public SearchEngine(ArrayUnorderedList<URLWords> array){
        webcrawl = array;
    }


    public String search(String s){


        String [] searchTerms = s.split("\\s");

        /* Sorts the array */
        Arrays.sort(searchTerms);

        /* Turns the Array into a String to use as a key */
        String key = "";
        for (String keyterm : searchTerms) {
            key = key + keyterm;
        }

        if(cache.get(key) == null)
            System.out.println("Query not found in cache");
        else{
            System.out.println("Query found in cache");
            return cache.get(key);
        }
        
        

        PriorityQueue<URLWords> searchResults = new PriorityQueue<>();
        
        for (URLWords urlWord : webcrawl) {
            int frequency = 0;

            //sum frequency of urlWords from split
            for (String term : searchTerms){
               frequency -= urlWord.getFrequency(term);
            }

            // Add the website address to a priority queue (sum of frequencies)
            if(frequency != 0){
                searchResults.addElement(urlWord, frequency);
            }
            
            }
        int count = 0;
        String result = "";

        while(!searchResults.isEmpty() && count<=maxResults){
            result += searchResults.removeNext().getURL() + "\n";
            count++;
        }
        
        /* Puts result into cache */
        cache.put(key, result);
        
        return result;
    }
        
}