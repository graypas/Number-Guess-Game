import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int min = 0;
        int max = 0;
        while (min >= max) {
            System.out.println("Enter the range of the game (e.g. 1 100): ");
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter two integers separated by a space.");
                input.nextLine();
            }
            min = input.nextInt();
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter two integers separated by a space.");
                input.nextLine();
            }
            max = input.nextInt();
            if (min >= max) {
                System.out.println("Invalid range. Please enter a valid range where the first number is less than the second.");
            }
        }
        input.nextLine();

        Random rand = new Random();
        int number = rand.nextInt(max - min + 1) + min;
        ArrayList<Integer> previousGuesses = new ArrayList<Integer>();

        System.out.println("I'm thinking of a number between " + min + " and " + max + ". Can you guess it?");
        int guess = -1;
        int guessCount = 0;
        while (guess != number) {
            System.out.print("Enter your guess: ");
            if (input.hasNextInt()) {
                guess = input.nextInt();
                if (previousGuesses.contains(guess)) {
                    System.out.println("You already tried this number. This guess isn't counted.");
                    continue;
                }
                previousGuesses.add(guess);
                guessCount++;
                if (guess < min || guess > max) {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                if (guess < number) {
                    System.out.println("Your guess is too low.");
                } else if (guess > number) {
                    System.out.println("Your guess is too high.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                input.nextLine();
            }
        }
        System.out.println("You guessed the number in " + guessCount + " attempts.");
        input.close();
    }
}
