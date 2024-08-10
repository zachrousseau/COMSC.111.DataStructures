
//package filecompression;

/**
 * Test program for FileCompression methods.
 */
public class TestFileCompression {
 
    public static void main(String[] args){
        String[] testStrings = {"11110", "00000", "101010", "11100010"};
        for (String testString : testStrings) {
            System.out.println("Compressing: " + testString);
            System.out.println("Recursive Output: " + FileCompression.recursiveCompress(testString));
            //System.out.println("Iterative Output: " + FileCompression.iterativeCompress(testString));
            //System.out.println("Uncompressed Output: " +
            //        FileCompression.uncompress(FileCompression.iterativeCompress(testString)));
        }
        
    }
}
