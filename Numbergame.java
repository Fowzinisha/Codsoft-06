import java.util.Random;
import java.util.Scanner;
public class Numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repeat = true;

        System.out.println("Welcome to my fist task i.e. Number Guessing Game!");
        System.out.println("NUMBER GUESSING GAME");
        while (repeat) {
            Random random = new Random();
            int randomNumber = random.nextInt(100) + 1;
            boolean success = false;
            int attempts = 0;

            System.out.println("Choose the number between 1 and 100.");
            System.out.println("You have 10 attempts to guess.");

            while (attempts < 10) {
                System.out.print("Enter your guessed Number: ");
                int my_guess = sc.nextInt();
                attempts++;

                if (my_guess < randomNumber) 
                {
                    System.out.println("Oops the guessed number is Too low! Try again.");
                } 
                else if (my_guess > randomNumber) 
                {
                    System.out.println("Oops the guessed number is Too high! Try again.");
                } 
                else 
                {
                    success = true;
                    break;
                }
            }

            if (success) 
            {
                System.out.println("Congratulations! You have guessed the correct number in " + attempts + " attempts.");
            } else 
            {
                System.out.println("Game over! You have run out of attempts. The number was: " + randomNumber);
            }

            System.out.print("Would you like to play again? (yes/no): ");
            System.out.print("");

            String repeatChoice = sc.next();
            repeat = repeatChoice.equals("yes");
        }

        System.out.println("Thanks for playing the Number Guessing Game.!");
        sc.close();
    }
}