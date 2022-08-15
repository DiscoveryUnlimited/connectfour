package com.game.connectfour;

import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
import java.util.Scanner;

class Controller {

    // this is main

    // FIELDS
    private String p1 = "Player 1";
    private String p2 = "Player 2";
    private final Scanner scanner = new Scanner(System.in);
    private final Board board = Board.getInstance();
    private String p1Token;
    private String p2Token;


    // CONSTRUCTOR
    public Controller() {
        // how do we do setName() when we have player 1 and player 2?
    }



    // BUSINESS METHODS


    public void execute (){
        banner();
        startGame();
        //      selectToken();
        declareWinner();

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



    //   FIXME : We have this in BOARD.java
    //    public void selectColumn() {
    //
    //    }



    public void selectToken() {
        boolean validInput = false;
        Scanner scanner;
        String input = scanner.nextLine().trim().toUpperCase();
        while(!validInput) {
            System.out.println("Player 1, please choose to play as (X)s or (O)s: ");

            if (input != "x" | input != "o") {
                System.out.println("Invalid choice. Please select either (X) or (O). ");
                continue;
                if (input == "X"){
                    setP1Token("X");
                    setP2Token("O");
                }
                else if (input == "O") {
                    setP1Token("O");
                    setP2Token("X");
                }
                else{
                    System.out.println( "Invalid input. Error.");
                }
            }
        }
    }

    public void declareWinner(Winner winner) {

        if (winner = "full") {
            System.out.println("The board is full. No more moves available. Game is a draw.");
        }
        else {
            System.out.println("The winner is: " + winner);
        }
    }



    public void banner() {
        System.out.println();

        System.out.println("    __   ___   ____   ____     ___    __ ______      _____   ___   __ __  ____  \n" +
                "   /  ] /   \\ |    \\ |    \\   /  _]  /  ]      |    |     | /   \\ |  |  ||    \\ \n" +
                "  /  / |     ||  _  ||  _  | /  [_  /  /|      |    |   __||     ||  |  ||  D  )\n" +
                " /  /  |  O  ||  |  ||  |  ||    _]/  / |_|  |_|    |  |_  |  O  ||  |  ||    / \n" +
                "/   \\_ |     ||  |  ||  |  ||   [_/   \\_  |  |      |   _] |     ||  :  ||    \\ \n" +
                "\\     ||     ||  |  ||  |  ||     \\     | |  |      |  |   |     ||     ||  .  \\\n" +
                " \\____| \\___/ |__|__||__|__||_____|\\____| |__|      |__|    \\___/  \\__,_||__|\\_");

        System.out.println(" _____                             _    ______               \n" +
                "/  __ \\                           | |   |  ___|              \n" +
                "| /  \\/ ___  _ __  _ __   ___  ___| |_  | |_ ___  _   _ _ __ \n" +
                "| |    / _ \\| '_ \\| '_ \\ / _ \\/ __| __| |  _/ _ \\| | | | '__|\n" +
                "| \\__/\\ (_) | | | | | | |  __/ (__| |_  | || (_) | |_| | |   \n" +
                " \\____/\\___/|_| |_|_| |_|\\___|\\___|\\__| \\_| \\___/ \\__,_|_|");



        // blocks
        System.out.println(" .----------------.  .----------------.  .-----------------. .-----------------. .----------------.  .----------------.  .----------------.   .----------------.  .----------------.  .----------------.  .----------------. ");
        System.out.println("| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. | | .--------------. || .--------------. || .--------------. || .--------------. |");
        System.out.println("| |     ______   | || |     ____     | || | ____  _____  | || | ____  _____  | || |  _________   | || |     ______   | || |  _________   | | | |  _________   | || |     ____     | || | _____  _____ | || |  _______     | |");
        System.out.println("| |   .' ___  |  | || |   .'    `.   | || ||_   \\|_   _| | || ||_   \\|_   _| | || | |_   ___  |  | || |   .' ___  |  | || | |  _   _  |  | | | | |_   ___  |  | || |   .'    `.   | || ||_   _||_   _|| || | |_   __ \\    | |");
        System.out.println("| |  / .'   \\_|  | || |  /  .--.  \\  | || |  |   \\ | |   | || |  |   \\ | |   | || |   | |_  \\_|  | || |  / .'   \\_|  | || | |_/ | | \\_|  | | | |   | |_  \\_|  | || |  /  .--.  \\  | || |  | |    | |  | || |   | |__) |   | |");
        System.out.println("| |  | |         | || |  | |    | |  | || |  | |\\ \\| |   | || |  | |\\ \\| |   | || |   |  _|  _   | || |  | |         | || |     | |      | | | |   |  _|      | || |  | |    | |  | || |  | '    ' |  | || |   |  __ /    | |");
        System.out.println("| |  \\ `.___.'\\  | || |  \\  `--'  /  | || | _| |_\\   |_  | || | _| |_\\   |_  | || |  _| |___/ |  | || |  \\ `.___.'\\  | || |    _| |_     | | | |  _| |_       | || |  \\  `--'  /  | || |   \\ `--' /   | || |  _| |  \\ \\_  | |");
        System.out.println("| |   `._____.'  | || |   `.____.'   | || ||_____|\\____| | || ||_____|\\____| | || | |_________|  | || |   `._____.'  | || |   |_____|    | | | | |_____|      | || |   `.____.'   | || |    `.__.'    | || | |____| |___| | |");
        System.out.println("| |              | || |              | || |              | || |              | || |              | || |              | || |              | | | |              | || |              | || |              | || |              | |");
        System.out.println("| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' | | '--------------' || '--------------' || '--------------' || '--------------' |");
        System.out.println(" '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   '----------------'  '----------------'  '----------------'  '----------------'");

        // GETTERS & SETTERS

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
                "player1='" +  + '\'' +
                ", player2='" +  + '\'' +
                '}';
    }
}
     