import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of games: ");
        int numberOfGames = sc.nextInt();
        sc.nextLine(); 

        String[][] results = new String[numberOfGames][2];
        int playerWins = 0;
        int computerWins = 0;

        for (int i = 0; i < numberOfGames; i++) {
            System.out.print("Enter your choice (rock, paper, scissors): ");
            String userChoice = sc.nextLine();

            // Get computer's choice
            String computerChoice = getComputerChoice();

            // Determine the winner
            String winner = getWinner(userChoice, computerChoice);
            results[i][0] = userChoice;
            results[i][1] = computerChoice;
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }

        // Calculate the average and percentage of wins
        String[][] stats = calculateStats(playerWins, computerWins, numberOfGames);

        // Display the results and stats
        displayResults(results, stats);
    }

    // Method to find the computer choice using Math.random
    public static String getComputerChoice() {
        int randomChoice = (int) (Math.random() * 3);
        switch (randomChoice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return "rock";
        }
    }

    // Method to find the winner between the user and the computer
    public static String getWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Tie";
        } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "Player";
        } else {
            return "Computer";
        }
    }

    // Method to find the average and percentage of wins for the user and computer
    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.format("%.2f%%", (playerWins * 100.0) / totalGames);
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f%%", (computerWins * 100.0) / totalGames);
        return stats;
    }

    // Method to display the results 
    public static void displayResults(String[][] results, String[][] stats) {
        System.out.println("Game Results:");
        System.out.println("Player Choice\tComputer Choice");
        for (String[] result : results) {
            System.out.println(result[0] + "\t\t" + result[1]);
        }

        System.out.println("\nStats:");
        System.out.println("Player\tWins\tWinning Percentage");
        for (String[] stat : stats) {
            System.out.println(stat[0] + "\t" + stat[1] + "\t" + stat[2]);
        }
    }
}

/*
Input:
Enter the number of games: 2
Enter your choice (rock, paper, scissors): rock
Enter your choice (rock, paper, scissors): paper

Output:
Game Results:
Player Choice   Computer Choice
rock            paper
paper           rock

Stats:
Player  Wins    Winning Percentage
Player   1       50.00%
Computer 1       50.00%
*/

