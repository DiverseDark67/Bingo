import java.util.Scanner;



public class Bingo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BingoCard base = new BingoCard();
        CardReader reader = new CardReader();
        UserInterface ui = new UserInterface();

        boolean manual = false;
        boolean realBingo = false;
        boolean checkBingo = false;

        // Read the cards from a text file
        try {
            for (int i = 0; i < 7; i++) {
                reader.readCard(i);
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        // Welcome message
        System.out.println("Welcome to Bingo!\nHow many cards would you like to play with?(1-4)");
        int numCards = scanner.nextInt();

        // Validate the number of cards
        if (numCards < 1 || numCards > 4) {
            System.out.println("Invalid number of cards. Please enter a number between 1 and 4.");
            while (numCards < 1 || numCards > 4) {
                numCards = scanner.nextInt();
            }
        }

        base.setNumCards(numCards);

        System.out.println("You have selected " + numCards + " cards\nWould you like to select your cards manually or have them randomly selected?(manual/random)");
        String input = scanner.next();
        input = input.toLowerCase();

        // Validate the input
        if (!input.equals("manual") && !input.equals("random")) {
            System.out.println("Invalid input. Please enter 'manual' or 'random'.");
            while (!input.equals("manual") && !input.equals("random")) {
                input = scanner.next();
            }
        }
        if (input.equals("manual")) {
            manual = true;
        }

        // Select the cards based on the user's input
        if (manual) {
            System.out.println("You have selected to manually select your cards.");
            byte cardsChosen = 0;
            String selectCard;
            while (cardsChosen < numCards) {
                System.out.println("Please enter the card number you would like to view (1-9)");
                int answer = scanner.nextInt();
                if (answer < 1 || answer > 9) {
                    int cardNum = scanner.nextInt();
                    base.print(cardNum);
                    System.out.println("Would you like to choose this card?(yes/no)");
                    selectCard = scanner.next();
                    selectCard = selectCard.toLowerCase();
                    if (selectCard.equals("yes") || selectCard.equals("no")) {
                        if (selectCard.equals("yes")) {
                            cardsChosen++;
                        }
                    }
                    else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                } else {
                    System.out.println("Invalid card number. Please enter a number between 1 and 9.");
                }
            }
        } else {
            System.out.println("You have selected to have your cards randomly selected.");
            for (int i = 0; i < numCards; i++) {
                int cardNum = (int)(Math.random() * 8) + 1;
                base.print(cardNum);
            }
        }

        // Start the game
        System.out.println("\nStarting Bingo");
        while (realBingo == false) {
            ui.menu();
            ui.printCards();
        }

        scanner.close();
    }
}
