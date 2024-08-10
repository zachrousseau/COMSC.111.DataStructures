import javax.lang.model.util.ElementScanner14;

//package filecompression;
/*
 * A class to compress Strings of 0s and 1s.
 */
public class FileCompression {

    /** a recursive method to compress files **/
	 public static String recursiveCompress(String input) {
        
        if(input.length() == 0)
            return input;

        int count = 0;
        while(count<input.length()){
            if(input.charAt(0) == input.charAt(count))
                count++;
            else  
                break;
                
        }

        return String.valueOf(count) + input.charAt(0) + recursiveCompress(input.substring(count));
    }
   
    /** an iterative method to compress files **/
    public static String iterativeCompress(String input) {
        //initialize the compressed result
        String result = "";
    
        //keep a count of the number of consecutive characters in the current 'block'
        int count = 1;
        
        //walk down the input string
        for(int i = 0; i < input.length(); i++) {
            //if we are in the middle of a 'block' (the next character is the same and we aren't at the end)
            //then increment the counter
            if((i + 1) < input.length() && input.charAt(i) == input.charAt(i + 1))
                count++;
            //if we have reached the end of a 'block' 
            //then add the count and current character to the compressed result
            //and reset the counter for the next 'block'
            else {
                result += " " + count + " " + input.charAt(i);
                count = 1; 
            }
        }
        return result;
    }
    
}
