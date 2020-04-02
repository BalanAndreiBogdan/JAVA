package players;

import game_utils.Game;

import java.util.ArrayList;
import java.util.Collections;


public abstract class Player implements Runnable {
    protected String name;
    public ArrayList<Integer> answer = new ArrayList<>();
    protected Game game;
    protected int score = 0;
    private int timesLost = 0;

    Player(String name) {
        this.name = name;
    }

    abstract Integer  selectValueFromBoard() throws InterruptedException;

    public synchronized void run() {
        Boolean rez;
        while (true) {
            try {
                wait();

                game.getBoard().print();

                System.out.println("--->" + name + "\n");

                printCurrentAnswer();

                Integer selectedValue = selectValueFromBoard();

                if(game.validateAndUpdateBoard(this, selectedValue)){
                    answer.add(selectedValue);
                    Collections.sort(answer);
                }

                if(game.chekPlayerHasWon(this)){
                    return;
                }

                if(!game.inProgress){
                    game.gameOver();
                    return;
                } else
                    {
                    notifyNextPlayer();
                }

                if(game.timeLimitExceed()){
                    System.out.print("Game over. Time limit exceed.");
                    return;
                }

            } catch (InterruptedException e) {
                System.out.println("failed to run player");
                e.printStackTrace();
            }
        }
    }

    private void printCurrentAnswer() {

        if(answer.size() == 0)
            return;

        System.out.print("Current numbers: ");

        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i) + " ");
        }

        System.out.println();
    }

    private void notifyNextPlayer() {
        game.notifyNextPlayer(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "players.Player{" +
                "name='" + name + '\'' +
                ", game=" + game +
                ", score=" + score +
                '}';
    }
}