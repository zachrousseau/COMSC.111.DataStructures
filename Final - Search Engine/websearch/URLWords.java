package websearch;

import jsjf.LinkedBinarySearchTree;

public class URLWords{
    String URL;
    LinkedBinarySearchTree<Word> tree = new LinkedBinarySearchTree<Word>();

    URLWords(String s){
        URL = s;
    }

    public String getURL() {
        return URL;
    }

    public void addWord(String s){
        Word w = new Word(s);
        
        if(!(tree.contains(w)))
            tree.addElement(w);  
        else   
            (tree.find(w)).incrementCount();   
                 
    }

    public void addWord(Word w){

        if(!(tree.contains(w)))
            tree.addElement(w);  
        else   
            (tree.find(w)).incrementCount();    
    }

    public boolean contains(String s){

        Word w = new Word(s);

        if(tree.contains(w))
            return true;

        return false;
    }

    public int getFrequency(String s){

        Word w = new Word(s);
        if((tree.contains(w))){
            return (tree.find(w)).getCount();
        }
        return 0;
        

    }

    @Override
    public String toString() {
        
        String s = URL;
         
        
        for(Word w: tree){
            s = s + " " + w.toString();
        }

        return s;

        /* 
        for (Object i : tree){
            s = s + " "  + Word.toString();
        }
        */
    }

}