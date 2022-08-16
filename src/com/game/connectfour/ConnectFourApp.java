package com.game.connectfour;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class ConnectFourApp {
    // this is main

    // FIELDS
    private String p1 = "Player 1";
    private String p2 = "Player 2";
    private final Scanner scanner = new Scanner(System.in);
    private Board board;
    private String p1Token;
    private String p2Token;


    // CONSTRUCTOR
    public ConnectFourApp() {
        // how do we do setName() when we have player 1 and player 2?
    }


    // BUSINESS METHODS
    public void execute() {
        showBanner();
        showBoard();
        play();
        declareWinner();
        showWinP1();
        showWinP2();
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

    

    public void start() {

    }



    public void declareWinner() {
        board.winner();
    }

    public void showBanner() {
        try {
            String banner = Files.readString(Path.of("resources/myBanner.txt"));
            Files.lines(Path.of("resources", "myBanner.txt"))
                    .forEach(line -> {
                        System.out.println("\033[33m" + line +  "\033[0m");
//                        System.out.println("\033[31m" + line +  "\033[0m");
//                        System.out.println(line);


                    });
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



            public void showWinP1() {
                try {
                    String banner = Files.readString(Path.of("resources/P1Wins.txt"));
                    Files.lines(Path.of("resources", "P1Wins.txt"))
                            .forEach(line -> {
                                System.out.println("\033[36m" + line +  "\033[0m");
                            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showWinP2() {
        try {
            String banner = Files.readString(Path.of("resources/P2Wins.txt"));
            Files.lines(Path.of("resources", "P2Wins.txt"))
                    .forEach(line -> {
                        System.out.println("\033[31m" + line +  "\033[0m");
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // GETTERS & SETTERS

    public void setBoard() {
        this.board = Board.getInstance();
    }

    public String getP1Token() {
        return p1Token;
    }

    public void setP1Token(String p1Token) {
        this.p1Token = p1Token;
    }

    public String getP2Token() {
        return p2Token;
    }

    public void setP2Token(String p2Token) {
        this.p2Token = p2Token;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "player1='" + +'\'' +
                ", player2='" + +'\'' +
                '}';
    }


}
