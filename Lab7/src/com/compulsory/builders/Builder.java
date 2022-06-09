package compulsory.builders;

import compulsory.components.Dictionary;
import compulsory.components.Tile;
import compulsory.exceptions.BuildException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Builder{
   
    public static List<Tile> buildUniqueTiles() throws BuildException {
        List<Tile> tempTiles = new ArrayList<>();
        Random random = new Random();

        for (char letter = 'A'; letter <= 'Z'; letter++) {
            tempTiles.add(new Tile(letter, random.nextInt(1, 11)));
        }

        return tempTiles;
    }

    
    public static void buildDictionary(Dictionary dictionary) throws BuildException{
        dictionary.addWord("word");
        dictionary.addWord("apple");
        dictionary.addWord("juice");
        dictionary.addWord("table");
        dictionary.addWord("desk");
        dictionary.addWord("lamp");
        dictionary.addWord("laptop");
        dictionary.addWord("discord");
        dictionary.addWord("programmer");
        dictionary.addWord("java");
        dictionary.addWord("exam");
    }
}
