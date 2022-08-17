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
        while (!validInput){
            System.out.println("Would you like to play again [y/n]?\n");
            String playAgain = scanner.nextLine().trim();
            if (playAgain.matches("y|n")){
                if (playAgain.equalsIgnoreCase("y")) {
                    execute();
                } else {
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

    public void declareWinner() {
        board.winner();
        Console.pause(2000);
    }

    public void showBanner() {
        try {
            String banner = Files.readString(Path.of("resources/myBanner.txt"));
            Files.lines(Path.of("resources", "myBanner.txt"))
                    .forEach(line -> {
                        System.out.println("\033[33m" + line +  "\033[0m");
                    });
            Console.pause(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endBanner() {
        try {
            String banner = Files.readString(Path.of("resources/endBanner.txt"));
            Files.lines(Path.of("resources", "endBanner.txt"))
                    .forEach(line -> {
                        System.out.println(line);
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    public void showWinP1() {
//        try {
//            String banner = Files.readString(Path.of("resources/P1Wins.txt"));
//            Files.lines(Path.of("resources", "P1Wins.txt"))
//                    .forEach(line -> {
//                        System.out.println("\033[36m" + line +  "\033[0m");
//                    });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public void showWinP2() {
//        try {
//            String banner = Files.readString(Path.of("resources/P2Wins.txt"));
//            Files.lines(Path.of("resources", "P2Wins.txt"))
//                    .forEach(line -> {
//                        System.out.println("\033[31m" + line +  "\033[0m");
//                    });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    // GETTERS & SETTERS

    public void setBoard() {
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