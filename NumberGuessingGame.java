import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number.");
                    score++;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + score);

            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String userResponse = scanner.next().toLowerCase();

            if (!userResponse.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Your final score is: " + score);
            }
        }

        scanner.close();
    }
}
