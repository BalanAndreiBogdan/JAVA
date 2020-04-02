import game_utils.Game;
import players.PlayerManual;
import players.PlayerRandom;
import players.PlayerSmart;

public class Main {
    public static void main(String args[]) {
        Integer n = 10;
        Integer m = 50;
        Integer k = 3;

        Game game = new Game(n, m, k);

        game.addPlayer(new PlayerManual("Manuel"));
        game.addPlayer(new PlayerRandom("Radu"));
        game.addPlayer(new PlayerSmart("Smaranduca"));

        game.start();
    }
}
