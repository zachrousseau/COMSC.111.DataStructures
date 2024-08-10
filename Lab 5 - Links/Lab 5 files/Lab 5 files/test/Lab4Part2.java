package test;

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import jsjf.LinkedStack;

public class Lab4Part2 {

    public static void main(String args[]) throws IOException{
        
        File f = new File ("goingthere.txt");
        Scanner File = new Scanner(f);


        String line = null;

        LinkedStack<String> directions = new LinkedStack<String>();
        LinkedStack<String> reverse = new LinkedStack<String>();
        
        String temp = "";

        while(File.hasNext()){
           directions.push(File.nextLine());
        }  

        System.out.println("Original Directions:");
        while(!(directions.isEmpty())){
            System.out.println(directions.peek());
            reverse.push(directions.pop());
        }

        System.out.println(" ");
        System.out.println("Reverse Directions");
        while(!(reverse.isEmpty())){
            String[] tempSplit = (reverse.pop()).split(" on ");

            if(tempSplit[0].equalsIgnoreCase("north"))
                tempSplit[0] = "south";
            else if(tempSplit[0].equalsIgnoreCase("south"))
                tempSplit[0] = "north";
            else if(tempSplit[0].equalsIgnoreCase("east"))
                tempSplit[0] = "west";
            else if(tempSplit[0].equalsIgnoreCase("west"))
                tempSplit[0] = "east";

            System.out.println(tempSplit[0] + " on " + tempSplit[1]);
        }
        
    }

}
