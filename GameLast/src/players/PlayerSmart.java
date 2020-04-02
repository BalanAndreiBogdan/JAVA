package players;

import game_utils.Board;
import game_utils.Token;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerSmart extends Player {
    public PlayerSmart(String name) {
        super(name);
    }

    //Selecteaza un index care are diferenta ratia dintre ultimele 2 valori din answer array
    @Override
    Integer selectValueFromBoard() throws InterruptedException {
        Integer selectedIndex = 0;
        ArrayList<Token> tokens = game.getBoard().getTokens();

        if(answer.size() > 1){
            int ratio = answer.get(answer.size() - 1) - answer.get(answer.size() - 2);

            for(int i=0;i<tokens.size();i++){
                if(tokens.get(i).getValue() - answer.get(answer.size() - 1) == ratio){
                    selectedIndex = i;
                    break;
                }
            }
        }

        return tokens.get(selectedIndex).getValue();
    }

}
