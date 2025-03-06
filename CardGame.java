import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the number of cards to distribute to each player: ");
            int numCards = sc.nextInt();
            System.out.print("Enter the number of players: ");
            int numPlayers = sc.nextInt();

            // Initialize the deck of cards
            String[] deck = initializeDeck();

            // Shuffle the deck of cards
            shuffleDeck(deck);

            // Distribute the deck of cards to the players
            String[][] playersCards = distributeCards(deck, numCards, numPlayers);

            // Print the players and their cards
            printPlayersCards(playersCards);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    // Method to initialize the deck of cards
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Method to shuffle the deck of cards
    public static void shuffleDeck(String[] deck) {
        int n = deck.length;
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Method to distribute the deck of cards to the players
    public static String[][] distributeCards(String[] deck, int numCards, int numPlayers) {
        if (numCards * numPlayers > deck.length) {
            throw new IllegalArgumentException("Not enough cards to distribute among players.");
        }
        String[][] playersCards = new String[numPlayers][numCards];
        int index = 0;
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < numCards; j++) {
                playersCards[i][j] = deck[index++];
            }
        }
        return playersCards;
    }

    // Method to print the players and their cards
    public static void printPlayersCards(String[][] playersCards) {
        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i + 1) + "'s cards:");
            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println(playersCards[i][j]);
            }
            System.out.println();
        }
    }
}

/*
Example Input:
Enter the number of cards to distribute to each player: 5
Enter the number of players: 4

Example Output:
Player 1's cards:
10 of Spades
4 of Diamonds
Queen of Hearts
7 of Clubs
9 of Hearts

Player 2's cards:
3 of Clubs
Ace of Spades
2 of Diamonds
King of Hearts
6 of Spades

Player 3's cards:
7 of Diamonds
Jack of Clubs
5 of Hearts
8 of Diamonds
4 of Hearts

Player 4's cards:
9 of Clubs
3 of Hearts
Queen of Spades
8 of Hearts
5 of Clubs
*/

