package Collections;

import java.util.HashMap;
import java.util.Map;

public class Games {
    Map<Integer, String> storedGame = new HashMap<>();

    public void addGame(int year, String name) {
        storedGame.put(year, name);
    }

    public void removeGame(int year) {
        storedGame.remove(year);
    }

    public void printGames() {
        for (Map.Entry<Integer, String> entry : storedGame.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}