package game;
import java.util.Random;

public class Die implements Comparable<Die>{
    private int value;
    public final int SIDES = 6;

    public Die (){
        this.value = 1;
    }

    public int roll(){

        Random roll = new Random();
        value = ((roll.nextInt(6)) + 1);

        return value;
    }
    
    public int getValue(){
        return value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }

    public int compareTo(Die d) {
        if(getValue() > d.getValue())
            return 1;
        else if( getValue() < d.getValue())
            return -1;
        else 
            return 0;
	}

}
