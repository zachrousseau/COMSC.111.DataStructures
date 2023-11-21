/**
 * @author Zach Rousseau
 * @date Feb 10, 2023 
 * Class: COMSC 111 Lab
 */
package game;
import java.util.Scanner;

/** Creates HumanPlayer object inherited from player */
public class HumanPlayer extends Player{
    
    Scanner in = new Scanner(System.in);
    
    /** Prompts and sets name */
    public HumanPlayer(){
        System.out.println("What's your name?");
        String name = in.nextLine();
        setName(name);
    }

    /** Prompts to keep rolling the die */
    public boolean isRolling(){
        System.out.println("Would you like to keep rolling? y/n");
        String rolling = in.nextLine();

        if(rolling.equals("y"))
            return true;
        return false;
    }
}
