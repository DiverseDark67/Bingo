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
    private int[] numbers = new int[75];
    private Random random = new Random();

    public BingoBall() {
        do {
            number = random.nextInt(75) + 1;
        } while (isNumberUsed(number));

        storeNumber(number);
        setLetter();
    }

    private boolean isNumberUsed(int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                return true; // Number is already used
            }
            if (numbers[i] == 0) {
                break; // Stop checking at the first empty slot
            }
        }
        return false;
    }

    private void storeNumber(int num) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = num;
                break;
            }
        }
    }

    private void setLetter() {
        char[] letters = {'B', 'I', 'N', 'G', 'O'};
        letter = letters[(number - 1) / 15] + "";
    }

    public int getNumber() {
        return number;
    }

    public String getLetter() {
        return letter;
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
