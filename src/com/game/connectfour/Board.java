package com.game.connectfour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.apps.util.*;


class Board {
    //Field
    private final Brain brain = new Brain();
    private boolean player = false;
    private boolean endGame = false;
    private int height = 10;
    private String symbol;
    private int numberInput;
    private String userInput;
    private final Scanner scanner = new Scanner(System.in);

    private Board() {
    }

    List<List<String>> board = new ArrayList<>(List.of(
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"),
            Arrays.asList("|", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "|"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"),
            Arrays.asList("|", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "|"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"),
            Arrays.asList("|", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "|"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"),
            Arrays.asList("|", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "|"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"),
            Arrays.asList("|", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "|"),
            Arrays.asList("|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|"),
            List.of("|", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "|"),
            List.of(" ", "1", " ", "2", " ", "3", " ", "4", " ", "5", " ", "6", " ", "7", " ")

    ));

    //business For Main
    void printBoard() {
        System.out.println("\n\n");
        for (List<String> list : board) {
            System.out.println(list.toString()
                    .replace("[", "")
                    .replaceAll("]", "")
                    .replaceAll(",", ""));
        }
        System.out.println("Welcome to Connect Four!");
    }

    void startPlay() {
        while (!endGame) {
            promptForSlot();
            playerTurn();
            dropToken(height, numberInput, symbol, player);
            endGame = brain.winCheck(board)|| brain.fullBoardCheck(board);
            System.out.println(brain.fullBoardCheck(board));
            Console.clear();
            printBoard();
            winner();
        }
    }

    private void promptForSlot() {
        boolean validInput = false;
        while (!validInput) {
            if (!player) {
                System.out.println("Player 1's Turn:");
            } else {
                System.out.println("Player 2's Turn:");
            }
            System.out.println("Which column would you like to drop your token in? (1-7)");
            userInput = scanner.nextLine();
            if (userInput.matches("\\d{1}")) {
                numberInput = Integer.parseInt(userInput) * 2 - 1;// convert 1-7 to array slot position
                if (numberInput >= 1 && numberInput <= 14) {
                    validInput = true;
                } else {
                    System.out.println("Please pick a column number from 1 to 7.");
                }
            }
        }
    }

    private void playerTurn() {
        player = !player;
        if (!player) {
            symbol = "X";
        } else {
            symbol = "O";
        }
    }

    private void dropToken(Integer height, Integer numberInput, String symbol, boolean player) {
        try {
            if (board.get(height).get(numberInput).contains(" ")) {
                board.get(height).set(numberInput, symbol);
            } else {
                height--;
                dropToken(height, numberInput, symbol, player);
            }
        } catch (IndexOutOfBoundsException e) {
            this.player = !player;
            System.out.println("This column is full, please choose a different column.");
            Console.pause(5000);
        }
    }

    void winner() {
        if (endGame) {
            if(brain.fullBoardCheck(board)){
                try {
                    String banner = Files.readString(Path.of("resources/P2Wins.txt"));
                    Files.lines(Path.of("resources", "P2Wins.txt"))
                            .forEach(line -> {
                                System.out.println("\033[33m" + line +  "\033[0m");
                            });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (player) {
                    try {
                        String banner = Files.readString(Path.of("resources/P1Wins.txt"));
                        Files.lines(Path.of("resources", "P1Wins.txt"))
                                .forEach(line -> {
                                    System.out.println("\033[36m" + line +  "\033[0m");
                                });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            } else {
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
        }
    }

    static Board getInstance() {
        return new Board();
    }

}
