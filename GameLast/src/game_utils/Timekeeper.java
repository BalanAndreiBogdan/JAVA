package game_utils;

public class Timekeeper implements Runnable {
    private long startTime = System.nanoTime();
    private boolean running = true;

    public void run() {
        while (running) {
            //System.out.println("Current time: " + (double)(System.nanoTime() - startTime)/1000000000.0);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getStartTime() {
        return startTime;
    }

    public void terminate() {
        running = false;
    }
}
