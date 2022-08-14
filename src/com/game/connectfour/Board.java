package com.game.connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Board {
    //Field
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

    boolean player=false;
        //business
    public void printBoard(){
        System.out.println("\n\n");
        for(List<String> list:board){
            System.out.println(list.toString()
                    .replace("[","")
                    .replaceAll("]","")
                    .replaceAll(",",""));
        }
    }

    public void dropToken() {
        printBoard();
        System.out.println("Welcome to play Connect Four");
        int height = 10;
        boolean endGame = false;
        String symbol;
        int numberInput;



        while (!endGame) {
            printBoard();
            System.out.println("Where would you like to put? (1-7)");
            Scanner scanner = new Scanner(System.in);
            int userInput = scanner.nextInt();
            player=!player;
            if(!player){
                symbol="X";
            }else{
                symbol="O";
            }
            numberInput=userInput*2-1;
            if (board.get(height).get(numberInput).contains(" ")) {
                board.get(height).set(numberInput, symbol);
            } else {
                recurssion(height,numberInput,symbol);

            }
        }
    }
    public void recurssion(Integer height,Integer numberInput,String symbol) {
            height--;
        if (board.get(height).get(numberInput).contains(" ")) {
            board.get(height).set(numberInput,symbol );
        }else{
            recurssion(height,numberInput,symbol);
        }
    }
}
