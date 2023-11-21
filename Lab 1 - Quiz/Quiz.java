/**
 * @Author: Zach Rousseau
 * @Date 2023.02.1
 * Instructor: Professor. Correira
 * Class: COMSC 111 Lab
 * 
 * Purpose: Play a quiz with capitals
 */
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;

/** play a Quiz game given a file */
public class Quiz{
    
    public static void main(String args[]) throws IOException{
        
        
        Scanner input = new Scanner(System.in); // Scanner for input
        String playAgain = "y";

        while(playAgain.equals("y")){

            // Set up the file
            System.out.println("What file would you like to read from?"); 
            String quizFile = (input.nextLine()).toLowerCase();
    

            File f = new File (quizFile);
            Scanner File = new Scanner(f);
            String fileCount = File.nextLine();

            int count = (Integer.parseInt(fileCount))/2;
            int countTotal = count;


            //build out the array
            String[][] quizArray = new String [count][2];
            
           
            while(0 < count){
                quizArray [count-1][0] = File.nextLine();
                quizArray [count-1][1] = File.nextLine();

                count--;
            }
            
            System.out.print("How many questions would you like? ");
            int numQuestions = Integer.parseInt(input.nextLine());

            int numCorrect = 0; 
            int numTotal = numQuestions; //var that doesn't change for the end

            Random random = new Random();
            
            //Pull random questions and test if equal
            while(0 < numQuestions){
                int question = random.nextInt(countTotal);
                
                System.out.println("What is the capital of " + quizArray[question][0] + "?");
                String response = input.nextLine();

                if((response.toLowerCase()).equals((quizArray[question][1]).toLowerCase())){
                    System.out.println("Correct!");
                    numCorrect++;
                }
                else   
                    System.out.println("Incorrect, the capital is " + quizArray[question][1]);
                numQuestions--;
            }

            //Output correct ask to play again
            System.out.println("Congrats you got " + numCorrect + "/" +numTotal + " Correct!");
            System.out.println("Would you like another quiz? (y/n)");
            playAgain = input.nextLine();
        }
    } 
}