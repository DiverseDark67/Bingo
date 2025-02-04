import java.util.Random;
/**
 * Author: Andrew Rhode
 * Date: 2025-02-03
 * Version: 1.1.0
 * This is a class that represents a Bingo ball. It will roll a random number between 1 and 75. Based on that number,
 * It will determine if it is a B, I, N, G, or O ball.
 */
public class BingoBall {
    private int number;
    private String letter;
    private Random random = new Random();

    public BingoBall() {
        this.number = random.nextInt(75) + 1;
        setLetter();
    }

    public int getNumber() {
        return number;
    }

    public String getLetter() {
        return letter;
    }

    private void setLetter() {
        if (number >= 1 && number <= 15) {
            letter = "B";
        } else if (number >= 16 && number <= 30) {
            letter = "I";
        } else if (number >= 31 && number <= 45) {
            letter = "N";
        } else if (number >= 46 && number <= 60) {
            letter = "G";
        } else {
            letter = "O";
        }
    }

    public String toString() {
        return letter + number;
    }

    // Check for bingo
    public boolean checkBingo(int[][] card) {
        int count = 0;
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if (card[i][j] == number) {
                    card[i][j] = 0;
                    count++;
                }
            }
        }
        return count >= 5;
    }
}
