package game;

public class ComputerPlayer extends Player{

    public ComputerPlayer(){
        setName("Computer");
    }
    
    
    public boolean isRolling() {
        if(getRoundTotal() < 20)
            return true;
        return false;
    }
}
