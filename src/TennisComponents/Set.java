package TennisComponents;

import java.util.HashMap;
import java.util.Map;

public class Set {


    private final Player player1;
    private final Player player2;

    private final Map<Player, Integer> games = new HashMap<>();
    private StandardGame currentStandardGame;

    public Set(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        games.put(p1, 0);
        games.put(p2, 0);
        currentStandardGame = new StandardGame(p1, p2);
    }

    public void pointWonBy(Player player) {

        currentStandardGame.pointWonBy(player);

        if (currentStandardGame.isFinished()) {
            Player winner = currentStandardGame.getWinner();
            games.put(winner, games.get(winner) + 1);
            currentStandardGame = new StandardGame(player1, player2);
        }
    }

    public boolean isFinished() {
        int g1 = games.get(player1);
        int g2 = games.get(player2);

        return (g1 >= 6 || g2 >= 6) && Math.abs(g1 - g2) >= 2;
    }

    public Player getWinner() {
        if (!isFinished()) return null;
        return games.get(player1) > games.get(player2) ? player1 : player2;
    }

    public String getScore() {
        return games.get(player1) + " - " + games.get(player2);
    }

    public StandardGame getCurrentGame() {
        return currentStandardGame;
    }
}
