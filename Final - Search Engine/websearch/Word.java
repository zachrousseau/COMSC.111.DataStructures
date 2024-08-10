package websearch;

public class Word implements Comparable<Word>{
    
    private String word;
    private int count;

    public Word(String s, int i ){
        word = s; 
        count = i;
    }
    public Word(String s){
        word = s; 
        count = 1;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void incrementCount(){
        count++;
    }

    public String toString(){
        return word + " " + count;
    }

    @Override
    public boolean equals(Object obj){

        Word word2 = (Word) obj;

        return (this.getWord().equals(word2.getWord()));
    }


    @Override
    public int compareTo(Word obj) {

        return (word.compareTo(obj.getWord()));
    }

}
