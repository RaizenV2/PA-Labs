package compulsory.components;

import java.util.HashMap;
import java.util.Map;

public class Board {

    Map<Player, String> words = new HashMap<>();


    public void addWord(Player player, String word) {
        this.words.put(player, word);
    }
}
