package com.game.connectfour;
import java.util.*;
import com.apps.util.Console;


public class Board {
    //Field
    private final Brain brain=new Brain();
    private boolean player = false;
    private boolean endGame = false;
    private int height = 10;
    private String symbol;
    private int numberInput;
    private String userInput;
    private final Scanner scanner = new Scanner(System.in);
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
        System.out.println("Welcome to play Connect Four");
    }

    void startPlay(){
        while (!endGame) {
            promptForSlot();
            playerTurn();
            dropToken(height, numberInput, symbol,player);
            endGame = brain.winCheck(board);
            Console.clear();
            printBoard();
            winner();
        }
    }

    private void promptForSlot() {
        boolean validInput=false;
        while(!validInput){
        System.out.println("Where would you like to put? (1-7)");
        userInput = scanner.nextLine();
        if(userInput.matches("\\d{1}")) {
            numberInput = Integer.parseInt(userInput) * 2 - 1;// convert 1-7 to array slot position
            if(numberInput>=1&&numberInput<=14){
                validInput=true;
            }else{
                System.out.println("please enter correct range number");
            }
        }}
    }

    private void playerTurn() {
        player = !player;
        if (!player) {
            symbol = "X";
        } else {
            symbol = "O";
        }
    }

    private void dropToken(Integer height, Integer numberInput, String symbol,boolean player) {
        try {
            if (board.get(height).get(numberInput).contains(" ")) {
                board.get(height).set(numberInput, symbol);
            } else {
                height--;
                dropToken(height, numberInput, symbol,player);
            }
        }catch(IndexOutOfBoundsException e){
            this.player=!player;
            System.out.println("This column is full, please choose another column to drop");
            Console.pause(5000);
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

    static Board getInstance() {
        return new Board(); //private ctor
    }

}
