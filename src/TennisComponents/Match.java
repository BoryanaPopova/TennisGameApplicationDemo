package TennisComponents;

import java.util.HashMap;
import java.util.Map;

public class Match {

    private final Player player1;
    private final Player player2;
    private final int setsToWin;

    private final Map<Player, Integer> sets = new HashMap<>();
    private Set currentSet;

    public Match(Player p1, Player p2, int setsToWin) {
        this.player1 = p1;
        this.player2 = p2;
        this.setsToWin = setsToWin;

        sets.put(p1, 0);
        sets.put(p2, 0);

        currentSet = new Set(p1, p2);
    }

    public void pointWonBy(Player player) {

        currentSet.pointWonBy(player);

        if (currentSet.isFinished()) {
            Player winner = currentSet.getWinner();
            sets.put(winner, sets.get(winner) + 1);
            currentSet = new Set(player1, player2);
        }
    }

    public boolean isFinished() {
        return sets.get(player1) != setsToWin &&
                sets.get(player2) != setsToWin;
    }

    public Player getWinner() {
        if (isFinished()) return null;
        return sets.get(player1) == setsToWin ? player1 : player2;
    }

    public Set getCurrentSet() {
        return currentSet;
    }

    public String getScore() {
        return sets.get(player1) + " - " + sets.get(player2);
    }
}
