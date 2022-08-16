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
    private final Board board = Board.getInstance();
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
    }

    private void play() {
        board.startPlay();
    }

    private void showBoard() {
        board.printBoard();
    }

    // TODO
    //    public void startGame() {
    //        boolean startGame = false;
    //        while(!startGame) {
    //            System.out.println("Would you like to play a new game? [Y/N]:  ");
    //            Scanner scanner;
    //            String input = scanner.nextLine().trim().toUpperCase();
    //            if (input != "Y" | input != "O") {
    //                System.out.println("Invalid choice. Please select either (Y) or (N). ");
    //            }
    //            else {
    //                if (input == "Y") {
    //                    startGame = true;
    //                }
    //                dropToken();
    //            }
    //        }
    //    }

    public void start() {

    }


//        public void selectToken() {
//            boolean validInput = false;
//            Scanner scanner;
//            String input = scanner.nextLine().trim().toUpperCase();
//            while(!validInput) {
//                System.out.println("Player 1, please choose to play as (X)s or (O)s: ");
//
//                if (input != "x" | input != "o") {
//                    System.out.println("Invalid choice. Please select either (X) or (O). ");
//                    continue;
//                    if (input == "X"){
//                        setP1Token("X");
//                        setP2Token("O");
//                    }
//                    else if (input == "O") {
//                        setP1Token("O");
//                        setP2Token("X");
//                    }
//                    else{
//                        System.out.println( "Invalid input. Error.");
//                    }
//                }
//            }
//        }

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
