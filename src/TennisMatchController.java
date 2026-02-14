import TennisComponents.Match;
import TennisComponents.Player;

import java.util.Scanner;

public class TennisMatchController {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("TennisComponents.Player 1: ");
        Player p1 = new Player(scanner.nextLine());

        System.out.print("TennisComponents.Player 2: ");
        Player p2 = new Player(scanner.nextLine());

        Match match = new Match(p1, p2, 2); // Best of 3

        System.out.println("🎾 TennisComponents.Match Started 🎾");

        while (match.isFinished()) {

            System.out.print("Point won by: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(p1.getName()))
                match.pointWonBy(p1);
            else if (input.equalsIgnoreCase(p2.getName()))
                match.pointWonBy(p2);
            else
                System.out.println("Invalid player!");

            System.out.println("Sets: " + match.getScore());
            System.out.println("Games: " + match.getCurrentSet().getScore());
            System.out.println("Points: " +
                    match.getCurrentSet().getCurrentGame().getScore());
        }

        System.out.println("🏆 MATCH WON BY " +
                match.getWinner().getName().toUpperCase() + " 🏆");

        scanner.close();
    }
}
