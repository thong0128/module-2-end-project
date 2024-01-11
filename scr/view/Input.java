package view;

import java.util.Scanner;

public class Input {
    public static int intInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static String stringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
