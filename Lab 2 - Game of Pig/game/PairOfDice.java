package game;

public class PairOfDice {
    private Die die1;
    private Die die2;

    public PairOfDice() {
        die1 = new Die();
        die2 = new Die();
    }

    public int roll() {
        return die1.roll() + die2.roll();
    }

    public int getSum() {
        return die1.getValue() + die2.getValue();
    }

    public int getDie1Value() {
        return die1.getValue();
    }

    public int getDie2Value() {
        return die2.getValue();
    }

    public boolean hasSnakeEyes() {
        if ((die1.getValue() + die2.getValue()) == 2)
            return true;
        return false;
    }

    public boolean hasOne() {
        if (die1.getValue() == 1 | die2.getValue() == 1)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return die1.toString() + " " + die2.toString();
    }

}
