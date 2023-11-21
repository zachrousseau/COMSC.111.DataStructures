package test;

import game.ComputerPlayer;
import game.HumanPlayer;

public class TestPlayerZR {

    /** Tests player class */
    public static void main(String args[]) {

        HumanPlayer human = new HumanPlayer();
        ComputerPlayer computer = new ComputerPlayer();

        //test beginning totals
        human.resetGameTotal();
        human.resetRoundTotal();
        computer.resetGameTotal();
        computer.resetRoundTotal();
        
        if(((human.getRoundTotal() != 0) | human.getGameTotal() != 0) | ((computer.getRoundTotal() != 0) | computer.getGameTotal() != 0))
            System.out.println("Totals Not Working");
        
        //test names
        human.setName("test");
        computer.setName("Computer");
        if(!(human.getName().equals("Test") | computer.getName().equals("Computer")))
            System.out.println("Check name methods");

        //test totals
        human.addToTotal(1);
        computer.addToTotal(1);

      
        if(((human.getRoundTotal() != 1) | human.getGameTotal() != 0) | ((computer.getRoundTotal() != 1) | computer.getGameTotal() != 0))
            System.out.println("Issue with round totals");

        computer.endTurn();
        human.endTurn();

        if(((human.getRoundTotal() != 0) | human.getGameTotal() != 1) | ((computer.getRoundTotal() != 0) | computer.getGameTotal() != 1))
            System.out.println("Issue with game totals");

        


        human.isWinner();
        computer.isWinner();
        
        //test isRolling
        human.isRolling();

        computer.addToTotal(20);
        computer.isRolling();
        if(computer.getRoundTotal() < 20)
            System.out.println("Computer is rolling is not working");
        
        // test winner
        computer.addToTotal(100);
        computer.endTurn();

        if(computer.isWinner() == false)
            System.out.println("Issue with winner, computer");
        if(human.isWinner())
            System.out.println("Issue with winner, human");


        System.out.println("Tests Complete");
    }

}
