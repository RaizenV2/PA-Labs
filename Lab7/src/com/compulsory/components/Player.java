package compulsory.components;

import compulsory.Game;

import java.util.List;


public class Player implements Runnable {
    private final String name;
    private Game game;

    public Player(String name) {
        this.name = name;
    }

   
    private void submitWord() {
        while (game.getBag().getBagSize() > 0) {
            List<Tile> extracted = game.getBag().extractTiles(7);
            if (extracted.isEmpty()) {
                break;
            }
            StringBuilder generateWord = new StringBuilder();
            for (Tile tile : extracted) {
                generateWord.append(tile.getLetter());
            }
            String word = String.valueOf(generateWord);
            if (game.getDictionary().isWord(word)) {
                game.getBoard().addWord(this, word);
            }
        }
    }

 
    public void setGame(Game game) {
        this.game = game;
    }

    
    @Override
    public void run() {
        submitWord();
    }
}