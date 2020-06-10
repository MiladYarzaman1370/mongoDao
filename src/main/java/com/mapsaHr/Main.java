package com.mapsaHr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("pleas insert number of Team Member: ");
        int input;
        while (true)
        {
            input = sc.nextInt();
            NewGame newGame = new NewGame(input);
    }
    }
}
