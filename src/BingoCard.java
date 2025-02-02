public class BingoCard {
    private int numCards = 0;
    private final int TOTALCARDS = 8;
    private int[] selectedCards = new int[4];

    // numCard mutator and accessor
    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }
    public void setSelectedCards(int[] selectedCards) {
        this.selectedCards = selectedCards;
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

    // Card Selection menu
    public void cardSelection() {

        System.out.println("There are " + TOTALCARDS + " cards available to select from.");
    }
}
