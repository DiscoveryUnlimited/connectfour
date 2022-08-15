package com.game.connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Board {
    //Field
        private boolean player=false;
        private boolean endGame = false;
        int height = 10;
        private String symbol;
        private int numberInput;
        private int userInput;
//        private Board(){};
//        private static Board showBoard=null;
        private final Scanner scanner = new Scanner(System.in);
        List<List<String>> board=new ArrayList<>(List.of(
                Arrays.asList("|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|","0"),
            Arrays.asList("|","-","|","-","|","-","|","-","|","-","|","-","|","-","|","1"),
            Arrays.asList("|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|","2"),
            Arrays.asList("|","-","|","-","|","-","|","-","|","-","|","-","|","-","|","3"),
            Arrays.asList("|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|","4"),
            Arrays.asList("|","-","|","-","|","-","|","-","|","-","|","-","|","-","|","5"),
            Arrays.asList("|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|","6"),
            Arrays.asList("|","-","|","-","|","-","|","-","|","-","|","-","|","-","|","7"),
            Arrays.asList("|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|","8"),
            Arrays.asList("|","-","|","-","|","-","|","-","|","-","|","-","|","-","|","9"),
            Arrays.asList("|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|","10"),
                List.of("|","-","-","-","-","-","-","-","-","-","-","-","-","-","|","11"),
                List.of("","1"," ","2"," "," 3"," ","4"," ","5"," ","6"," ","7"," ","12")
        ));

        //business For Main
    public void printBoard(){
        System.out.println("\n\n");
        for(List<String> list:board){
            System.out.println(list.toString()
                    .replace("[","")
                    .replaceAll("]","")
                    .replaceAll(",",""));
        }
        System.out.println("Welcome to play Connect Four");
    }

    public void startPlay() {
        while (!endGame) {
            System.out.println("Where would you like to put? (1-7)");
            userInput = scanner.nextInt();
            numberInput=userInput*2-1;// convert 1-7 to array slot position
            playerTurn();
            dropToken(height, numberInput, symbol);
            cls();
            printBoard();
        }scanner.close();
    }
    //associated function with startPlay
    private void playerTurn() {
        player=!player;
        if(!player){
            symbol="X";
        }else{
            symbol="O";
        }
    }
    //default class----deal with Brain
    void dropToken(Integer height,Integer numberInput,String symbol) {
        if (board.get(height).get(numberInput).contains(" ")) {
            board.get(height).set(numberInput,symbol );
        }else{
            height--;
            dropToken(height,numberInput,symbol);
        }
    }

    private static void cls(){
        try{
            new ProcessBuilder("clear","cls").inheritIO().start().waitFor();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
