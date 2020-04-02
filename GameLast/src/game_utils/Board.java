package game_utils;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final ArrayList<Token> tokens = new ArrayList<>();
    public Integer n, m;

    public Board(Integer n, Integer m) {
        generateTokens(n, m);
    }

    private void generateTokens(Integer n, Integer m) {
        while(tokens.size() < n){
            Integer value = new Random().nextInt(m + 1);

            if(contains(value) < 0) {
                Token token = new Token(new Random().nextInt(m + 1));
                tokens.add(token);
            }
        }
    }

    public Integer contains(Integer value){
        for(int i=0;i<tokens.size();i++){
            if(tokens.get(i).getValue() == value){
                return i;
            }
        }
        return -1;
    }

    public void extract(Integer index){
        tokens.remove(tokens.get(index));
    }

    public void print() {
        if(tokens.size() == 0)
            return;
        System.out.print("Board numbers: [ ");
        tokens.forEach((elem -> {
            System.out.print(elem.getValue() + " ");
        }));
        System.out.println(" ]\n");
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
}