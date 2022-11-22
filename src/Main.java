import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int attempts = 0;
    private static int min;
    private static int max;
    private static int guess;
    private static boolean won = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lets play the Number Guessing Game! You've got 5 attempts");
        System.out.print("The range will be between: ");
        min = scanner.nextInt();
        System.out.print("and: ");
        max = scanner.nextInt();
        int answer = getRndNumInRange(min, max);

        while (guess != answer && attempts != 6) {
            System.out.print("Guess: " );
            guess = scanner.nextInt();
            attempts++;
            if (guess == answer) {
                System.out.println("Correct! The answer is " + answer + "!");
                won = true;
                break;
            }
            if (attempts == 1) {
                System.out.println(hint1(answer, guess));
            } else if (attempts == 2) {
                System.out.println(hint1(answer, guess));

            } else if (attempts == 3) { //
                System.out.println(hint2(answer, guess));
            }
            else if (attempts == 4) {
                System.out.println(hint1(answer, guess));
            } else if (attempts == 5) {
                System.out.println(hint3(answer));
            }
        }
        if (!won) {
            System.out.println("You lost. The answer was " + answer + ". Better luck next time!");
        }

    }

    private static String hint3(int answer) {
             return "The answer is somewhere between " + (answer+randomizer()) + " and " + (answer-randomizer()) + "!";
    }

    private static String hint2(int answer, int guess) {
        String s = "";
        if (answer % 2 == 0) {
            s = "The answer is divisible by 2.";
        } else if (answer % 5 == 0) {
            s = "The answer is divisible by 5.";
        } else if (answer % 3 == 0) {
            s = "The answer is divisible by 3.";
        }
        return s;
    }

    private static String hint1(int answer, int guess) {
        String s = "";
        if (answer < guess) {
            s = "The answer is smaller than your guess.";
        }
        else if (answer > guess) {
            s =  "The answer is greater than your guess.";
        }
        return s;
    }

    private static int getRndNumInRange(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Max must be greater than min.");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private static int randomizer() {
        Random ran = new Random();
        return (int) ran.nextInt(3)+1;
    }
}