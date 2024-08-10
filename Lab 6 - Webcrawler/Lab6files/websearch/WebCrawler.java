package websearch;

import jsjf.ArrayUnorderedList;
import jsjf.LinkedQueue;
import websearch.URLParser;

public class WebCrawler {
    
    int maxURL = 100;
    String startURL = "";

    public WebCrawler(String s){
        startURL = s;
    }

    public WebCrawler(){
        startURL = "http://www.acm.org";
    }

    public void setMaxURLs(int i){
        maxURL = i;
    }

    public void setStartURL(String s){
        startURL = s;
    }

    public void crawlAndPrint(){

        ArrayUnorderedList<String> visitedList = new ArrayUnorderedList<>();
        LinkedQueue<String> pendingQueue = new LinkedQueue<>();

        pendingQueue.enqueue(startURL);

        int visited = 0;

        while(!(pendingQueue.isEmpty()) && visited < maxURL){

            String nextURL = pendingQueue.dequeue();

            if(!(visitedList.contains(nextURL))){

                System.out.println(nextURL);
                visitedList.addToRear(nextURL);

                URLParser parser = new URLParser(nextURL);


                for (String s : parser.getSubURLS()) {
                    if(!(visitedList.contains(s)))
                        pendingQueue.enqueue(s);
                }
            }
        }

    }
}
