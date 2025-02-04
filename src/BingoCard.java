/**
 * Author: Andrew Rhode
 * Date: 2025-02-03
 * Version: 1.1.0
 */

public class BingoCard {
    private int numCards = 0;
    private final int TOTALCARDS = 8;
    private int[] selectedCards = new int[4];

    UserInterface base = new UserInterface();

    // numCard mutator and accessor
    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }
    public void setSelectedCards(int[] selectedCards) {
        this.selectedCards = selectedCards;
    }
    public int getNumCards() {
        return numCards;
    }
    public int[] getSelectedCards() {
        return selectedCards;
    }

    // Function to print out card based on card number
    public void print(int cardNum) {
        System.out.println("Card " + cardNum);
        System.out.println("       B     I     N     G     O");
        System.out.println("    -------------------------------");
        for (int z = 1; z < 6; z++) {
            System.out.print( " " + z + " | ");
            for (int i = 0; i < 5; i++) {
                System.out.print("  " + cardNum + " | ");
            }
            System.out.println();
        }
    }

    // Mark bingo numbers on card
    public void markCard(int cardNum, String number) {
        try {
            System.out.println("Marking card " + cardNum + " with number " + number);

        } catch (Exception e) {
            System.out.println("Error marking card with slected number");
            base.menu();
        }
    }

    // Check for bingo
    public boolean checkBingo(int cardNum) {
        return false; //Temp leave at false. Check through the possible wins in the bingo check directory
    }

    // Card Selection menu
    public void cardSelection() {

        System.out.println("There are " + TOTALCARDS + " cards available to select from.");
    }
}
