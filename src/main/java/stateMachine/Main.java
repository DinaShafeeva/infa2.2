package stateMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StateMachine stateMachine = new StateMachine(new ArrayList<>());
        Interpretator interpretator = new Interpretator(stateMachine);
        System.out.println(interpretator.checkStatement(string));

    }
}
