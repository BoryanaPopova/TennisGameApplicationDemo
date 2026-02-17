package TennisComponents;

import java.util.HashMap;
import java.util.Map;

public class StandardGame implements Game {

    private final Player p1;
    private final Player p2;

    private final Map<Player, Point> points = new HashMap<>();
    private final Map<Player, Integer> rawPoints = new HashMap<>();

    public StandardGame(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;

        points.put(p1, Point.LOVE);
        points.put(p2, Point.LOVE);

        rawPoints.put(p1, 0);
        rawPoints.put(p2, 0);
    }

    @Override
    public void pointWonBy(Player player) {

        rawPoints.put(player, rawPoints.get(player) + 1);

        if (rawPoints.get(player) <= 3) {
            points.put(player, points.get(player).next());
        }
    }

    @Override
    public boolean isFinished() {
        int p1Points = rawPoints.get(p1);
        int p2Points = rawPoints.get(p2);

        int diff = Math.abs(p1Points - p2Points);
        int max = Math.max(p1Points, p2Points);

        return max >= 4 && diff >= 2;
    }

    @Override
    public Player getWinner() {
        if (!isFinished()) return null;
        return rawPoints.get(p1) > rawPoints.get(p2) ? p1 : p2;
    }

    @Override
    public String getScore() {

        int p1Points = rawPoints.get(p1);
        int p2Points = rawPoints.get(p2);

        if (p1Points >= 3 && p2Points >= 3) {
            if (p1Points == p2Points) return "Deuce";

            if (Math.abs(p1Points - p2Points) == 1)
                return "Advantage " + getLeader().getName();
        }

        return points.get(p1).getDisplayValue() + " - " +
                points.get(p2).getDisplayValue();
    }

    private Player getLeader() {
        return rawPoints.get(p1) > rawPoints.get(p2) ? p1 : p2;
    }
}
