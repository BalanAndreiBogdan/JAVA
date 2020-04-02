package game_utils;

import players.Player;

import java.util.*;

public class Game {
    private static final long TIME_LIMIT = 10000; //seconds
    private String HR = "__________________________";

    public boolean inProgress = false;

    private Integer k;
    private final List<Player> players = new ArrayList<>();
    private final Timekeeper timekeeper = new Timekeeper();

    private Board board;

    public Game(Integer n, Integer m, Integer k) {
        this.k = k;
        board = new Board(n, m);
    }

    public void notifyNextPlayer(Player player) {
        Integer pos = players.indexOf(player);
        if (pos == players.size() - 1) {
            synchronized (players.get(0)) {
                players.get(0).notify();
            }
        } else
            synchronized (players.get(pos + 1)) {
                players.get(pos + 1).notify();
            }
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public void start() {
        Thread timekeeperThread = new Thread(timekeeper);
        inProgress = true;
        timekeeperThread.start();
        createPlayerThreads();
        synchronized (players.get(0)) {
            players.get(0).notify();
        }
    }


    private void createPlayerThreads() {
        for (Player player : players) {
            Thread playerThread = new Thread(player);
            playerThread.start();
        }
    }

    private Integer getSizeOfMaximumSeq(ArrayList<Integer> arr){
        if(arr.size() <= 1)
            return arr.size();
        Integer ratio = arr.get(1) - arr.get(0);
        Integer kMax = 2;

        for(int i=1; i<arr.size(); i++){
            if (arr.get(i) - arr.get(i - 1) != ratio){
               break;
            }
            kMax++;
        }
        return kMax - 1;
    }

    public synchronized void gameOver()  {
        Player winner = null;
        Integer szMax = 0;

        for(int i=0; i<players.size(); i++){
            int szNew = getSizeOfMaximumSeq(players.get(i).answer);

            if(szNew > szMax){
                winner = players.get(i);
                szMax = szNew;
            }
        }

        System.out.println("Game over.");

        if(null != winner){
            System.out.println("The winner is " + winner.getName());
            System.out.println("Size of sequence = [" + szMax + "]");
            System.out.print("Sequence = [ ");
            for(int i=0;i<szMax;i++){
                System.out.print(winner.answer.get(i) + " ");
            }
            System.out.println("]");
        } else {
            System.out.println("No one has won this round. Tie.");
        }
        timekeeper.terminate();
    }

    public boolean validateAndUpdateBoard(Player player, Integer selectedValue) {
        System.out.println(player.getName() + " selected value=[" + selectedValue + "]");
        boolean validMove = false;
        Integer indexFind = board.contains(selectedValue);

        if(-1 != indexFind){
            System.out.println("Verdict: Valid selection.");
            board.extract(indexFind);
            validMove = true;
        } else {
            System.out.println("Verdict: Invalid selection.");
        }

        System.out.println(HR);

        if(board.getTokens().size() == 0){
            inProgress = false;
        }

        return validMove;
    }


    public boolean chekPlayerHasWon(Player player) {
        ArrayList<Integer> arr = player.answer;

        if(arr.size() < k){
            return false;
        }

        int ratio = arr.get(1) - arr.get(0);

        for(int i=1; i<k; i++){
            if(arr.get(i) - arr.get(i-1) != ratio){
                return false;
            }
        }

        System.out.println("Game over.\nThe winner is " + player.getName());
        System.out.print("Sequence of size k = [ ");
        for(int i=0;i<k;i++){
            System.out.print(player.answer.get(i) + " ");
        }
        System.out.print("]");
        timekeeper.terminate();
        return true;
    }

    public Board getBoard() {
        return board;
    }

    public boolean timeLimitExceed() {
        long currTime = (long) ((System.nanoTime() - timekeeper.getStartTime())/1000000000.0);
        return currTime > TIME_LIMIT;
    }
}