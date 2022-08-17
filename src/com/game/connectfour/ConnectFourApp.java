package com.game.connectfour;


import com.apps.util.Console;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ConnectFourApp {
    // FIELDS
    private final Scanner scanner = new Scanner(System.in);
    private Board board;

    // CONSTRUCTOR
    public ConnectFourApp() {
        // how do we do setName() when we have player 1 and player 2?
    }


    // BUSINESS METHODS
    public void execute() {
        Console.clear();
        showBanner();
        Console.clear();
        setBoard();
        showBoard();
        play();
        Console.clear();
        declareWinner();
        Console.clear();
        restartGame();
    }

    private void restartGame() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\n\n\n\n\nWould you like to play again [y/n]?\n");
            String playAgain = scanner.nextLine().trim();
            if (playAgain.matches("y|n")) {
                if (playAgain.equalsIgnoreCase("y")) {
                    Console.clear();
                    execute();
                } else {
                    Console.clear();
                    endBanner();
                }
                validInput = true;
            }
        }
    }

    private void play() {
        board.startPlay();
    }

    private void showBoard() {
        board.printBoard();
    }

    private void declareWinner() {
        board.winner();
        Console.pause(2000);
    }

    private void showBanner() {
        try {
            Files.lines(Path.of("resources", "myBanner.txt"))
                    .forEach(line -> {
                        System.out.println("\033[33m" + line + "\033[0m");
                    });
            Console.pause(3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void endBanner() {
        try {
            Files.lines(Path.of("resources", "endBanner.txt"))
                    .forEach(line -> {
                        System.out.println(line);
                    });
            Console.pause(3000);
            Console.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // GETTERS & SETTERS

    private void setBoard() {
        this.board = Board.getInstance();
    }

    @Override
    public String toString() {
        return "Controller{" +
                "player1='" + +'\'' +
                ", player2='" + +'\'' +
                '}';
    }
}