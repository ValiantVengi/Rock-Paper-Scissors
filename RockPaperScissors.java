import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"Rock", "Paper", "Scissors"};
        System.out.println("Welcome to Rock, Paper, Scissors!\nWhoever takes first 5 points,wins the game");
        int humanscore=0;
        int computerscore=0;
        while (humanscore<5 && computerscore<5) {
            System.out.print("Enter your choice (Rock, Paper, Scissors or Quit to exit): ");
            String Choice = scanner.nextLine();
            Choice=Choice.substring(0,1).toUpperCase()+Choice.substring(1).toLowerCase();
            if (Choice.equals("Quit")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }
            boolean validChoice = false;
            for (String input : choices) {
                if (input.equalsIgnoreCase(Choice)) {
                    validChoice = true;
                    break;
                }
            }
            if (!validChoice) {
                System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
                continue;
            }
            int computerIndex = random.nextInt(3);
            String computerChoice = choices[computerIndex];
            System.out.println("Computer chose: " + computerChoice);
            if (Choice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((Choice.equals("Rock") && computerChoice.equals("Scissors")) ||
                       (Choice.equals("Paper") && computerChoice.equals("Rock")) ||
                       (Choice.equals("Scissors") && computerChoice.equals("Paper"))) {
                System.out.println("You win!");
                humanscore++;
            } else {
                computerscore++;
                System.out.println("Computer wins!");
            }
        }
        System.out.println((humanscore>computerscore)?"Congratualtions ! you won the game ":"Sorry you lost the game,please try again");
        scanner.close();
    }
}
