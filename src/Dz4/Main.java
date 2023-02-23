package Dz4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new UserInterface( new Scanner(System.in), new Calendar<>()).start();
    }
}
