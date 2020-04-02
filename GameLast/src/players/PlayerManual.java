package players;

import java.util.HashMap;
import java.util.Scanner;

public class PlayerManual extends Player {
    public PlayerManual(String name) {
        super(name);
    }

    @Override
    Integer selectValueFromBoard() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.print("Type your selection: ");
        Integer inputInt = input.nextInt();
        return inputInt;
    }


}
