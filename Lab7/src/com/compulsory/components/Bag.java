package compulsory.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> tiles;

    public Bag() {
        this.tiles = new ArrayList<>();
    }

    public void addTileMultipleTimes(Tile tile, int numberOfTimes) {
        while (numberOfTimes > 0) {
            this.tiles.add(tile);
            numberOfTimes -= 1;
        }
    }

   
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            if (tiles.isEmpty()) {
                break;
            }
            extracted.add(this.tiles.remove(random.nextInt(this.tiles.size())));
        }
        return extracted;
    }

 
    public int getBagSize() {
        return this.tiles.size();
    }

    @Override
    public String toString() {
        return "Bag{" + "tiles=" + tiles + '}';
    }
}
