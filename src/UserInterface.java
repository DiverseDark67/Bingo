import java.util.Scanner;

/**
 * Author: Andrew Rhode
 * Date: 2025-02-03
 * Version: 1.1.0
 */

public class UserInterface {
    BingoBall ball = new BingoBall();
    BingoCard card = new BingoCard();

    private char input;
    private Scanner scan = new Scanner(System.in);
    private int cardNum;
    private String number;

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }
    public int getCardNum() {
        return cardNum;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    // Menu for the user
    public void menu() {
        input = ' ';
        System.out.println("--------------------------------");
        System.out.println("q: quit, p: print cards, x: mark card");
        System.out.println("--------------------------------");
        System.out.println("c: check bingo, r: roll ball");
        System.out.println("--------------------------------");
    
        try {
            input = scan.next().charAt(0);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid character.");
            menu();
        }
    
        switch (input) {
            case 'q':
                System.out.println("Thank you for playing!");
                scan.close(); // Close the scanner
                System.exit(0); // Exit the program
                break;
    
            case 'p':
                System.out.println("Printing cards...");
                card.print(cardNum);
                break;
    
            case 'x':
                System.out.println("Which card would you like to mark?");
                cardNum = scan.nextInt();
                scan.nextLine(); // Consume newline character
    
                System.out.println("Which number would you like to mark?");
                number = scan.nextLine(); // Read the number to mark
    
                card.markCard(cardNum, number);
                break;
    
            case 'c':
                System.out.println("Checking bingo...");
                if (card.checkBingo(cardNum)) { // Assuming checkBingo() is in BingoCard
                    System.out.println("Bingo! You win!");
                } else {
                    System.out.println("No bingo yet. Keep playing!");
                }
                break;
    
            case 'r':
                System.out.println("Rolling ball...");
                ball = new BingoBall(); // Generate a new Bingo ball
                System.out.println("Rolled: " + ball.getLetter() + ball.getNumber());
                break;
    
            default:
                System.out.println("Invalid input. Please enter a valid character.");
                menu();
                break;
        }
    }

    // method for printing cards for ui
    public void printCards() {
        //card.print(cardNum);
    }
}
