package players;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerRandom extends Player {
    public PlayerRandom(String name) {
        super(name);
    }

    //Selecteaza un index random din valorile disponibile
    @Override
    Integer selectValueFromBoard() throws InterruptedException {
        Integer selectedIndex = ThreadLocalRandom.current().nextInt(this.game.getBoard().getTokens().size());
        return this.game.getBoard().getTokens().get(selectedIndex).getValue();
    }

}
