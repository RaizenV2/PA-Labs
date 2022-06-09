package compulsory.components;

import java.util.ArrayList;
import java.util.List;


public class Dictionary {
    private final List<String> words;

    public Dictionary() {
        this.words = new ArrayList<>();
    }

    public boolean isWord(String word) {
        return this.words.contains(word);
    }

    public void addWord(String word) {
        this.words.add(word);
    }

    @Override
    public String toString() {
        return "Dictionary{" + "words=" + words + '}';
    }
}
