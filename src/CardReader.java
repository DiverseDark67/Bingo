import java.io.*;
import java.util.*;

/**
 * Author: Andrew Rhode
 * Date: 2025-02-03
 * Version: 1.1.0
 */

public class CardReader {
    String filename = "BingoCards.txt";
    Map<String, List<int[]>> cards = new LinkedHashMap<>();

    public void readCard(int cardNum) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String currentCard = null;
                
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("Card")) {
                    // New card found, create a new list for storing its grid
                    currentCard = line;
                    cards.put(currentCard, new ArrayList<>());
                } else if (!line.isEmpty() && currentCard != null) {
                    // Split numbers and store them as an integer array
                    String[] parts = line.split(",");
                    int[] row = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
                    cards.get(currentCard).add(row);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
