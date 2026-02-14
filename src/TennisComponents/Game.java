package TennisComponents;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final String[] GAME_POINTS = {"Love", "15", "30", "40"};

    private final Player player1;
    private final Player player2;

    private final Map<Player, Integer> points = new HashMap<>();

    public Game(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        points.put(p1, 0);
        points.put(p2, 0);
    }

    public void pointWonBy(Player player) {
        points.put(player, points.get(player) + 1);
    }

    public boolean isFinished() {
        return isGameWon();
    }

    public Player getWinner() {
        if (!isFinished()) return null;
        return points.get(player1) > points.get(player2) ? player1 : player2;
    }

    private boolean isGameWon() {
        int p1 = points.get(player1);
        int p2 = points.get(player2);

        return (p1 >= 4 || p2 >= 4) && Math.abs(p1 - p2) >= 2;
    }

    public String getScore() {
        int p1 = points.get(player1);
        int p2 = points.get(player2);

        if (p1 >= 3 && p2 >= 3) {
            if (p1 == p2) return "Deuce";

            if (Math.abs(p1 - p2) == 1) {
                return "Advantage " +
                        (p1 > p2 ? player1.getName() : player2.getName());
            }
        }

        return GAME_POINTS[p1] + " - " + GAME_POINTS[p2];
    }
}
