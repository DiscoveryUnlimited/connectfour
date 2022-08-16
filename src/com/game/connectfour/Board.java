package com.game.connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Board implements Cloneable {
    //Field
    private boolean player = false;
    private boolean endGame = false;
    int height = 10;
    private String symbol;
    private int numberInput;
    private int userInput;
    private String playAgain;
    private final Scanner scanner = new Scanner(System.in);
    List<List<String>> mainBoard = new ArrayList<>(List.of(
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "0"),
            Arrays.asList("|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "1"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "2"),
            Arrays.asList("|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "3"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "4"),
            Arrays.asList("|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "5"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "6"),
            Arrays.asList("|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "7"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "8"),
            Arrays.asList("|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "-", "|", "9"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "10"),
            List.of("|", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "|", "11"),
            List.of("", "1", " ", "2", " ", " 3", " ", "4", " ", "5", " ", "6", " ", "7", " ", "12")
    ));

    List<List<String>> board=new ArrayList<>(mainBoard);

//    List<List<String>> board;

//    @Override
//    public Board clone() throws CloneNotSupportedException {
//        return (Board) super.clone();
//    }
//
//    public void cloneCopy() throws CloneNotSupportedException {
//        try {
//            board = (Board) mainBoard.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new Error();
//        }
//    }

    //business For Main
     void printBoard() {
        System.out.println("\n\n");
        for (List<String> list : board) {
            System.out.println(list.toString()
                    .replace("[", "")
                    .replaceAll("]", "")
                    .replaceAll(",", ""));
        }
        System.out.println("Welcome to play Connect Four");
        System.out.println("board hashcode=" + board.hashCode());
        System.out.println("mainBoard hashcode=" + mainBoard.hashCode());
    }

    void startPlay() {
        while (!endGame) {
            System.out.println("Where would you like to put? (1-7)");
            userInput = scanner.nextInt();
            numberInput = userInput * 2 - 1;// convert 1-7 to array slot position
            playerTurn();
            dropToken(this.height, numberInput, symbol);
            endGame = Brain.winCheck(board);
            cls();
            printBoard();
            winner();
        }
        System.out.println("would you like to try again (y/n)?");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("y")) {
            tryAgain();
        } else {
            System.out.println("Thanks for playing");
        }
    }

     void winner() {
        if (endGame) {
            if (player) {
                System.out.println("player1 win");
            } else {
                System.out.println("player2 win");
            }
        }
    }


    private void tryAgain() {
        height = 10;
        endGame = false;
        printBoard();
    }

//    board=new ArrayList<>(mainBoard);

    //associated function with startPlay
    private void playerTurn() {
        player = !player;
        if (!player) {
            symbol = "X";
        } else {
            symbol = "O";
        }
    }


    private void dropToken(Integer height, Integer numberInput, String symbol) {
             if (board.get(height).get(numberInput).contains(" ")) {
                 board.get(height).set(numberInput, symbol);
             } else {
                 height--;
                 dropToken(height, numberInput, symbol);
             }
    }


    private static void cls() {
        try {
            new ProcessBuilder("clear", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public static Board getInstance() {
        return new Board();
    }

}
