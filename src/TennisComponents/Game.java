package TennisComponents;

public interface Game {
    void pointWonBy(Player player);

    boolean isFinished();

    Player getWinner();

    String getScore();
}
