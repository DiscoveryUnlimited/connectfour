package com.game.connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Brain extends Board{
    // FIELDS
    private final List<String> tokens = new ArrayList<>(Arrays.asList("O", "X"));


    /*
     * Calculate when individual columns are full
     * Calculate when the board is full
     * Calculate when 4 cannot be connected
     */

    // BUSINESS METHODS
    public boolean winCheck(){
        boolean win = false;
        // if any checks find a win return win
        if (horizontalCheck() || verticalCheck() || forwardDiagonalCheck() || backwardDiagonalCheck()){
            win = true;
        }
        return win;
    }



    //Horizontal check
    private boolean horizontalCheck(){
        boolean win = false;


        // winning array
        List<List<Integer>> winArray = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 3,  5, 7 ),
                Arrays.asList(3, 5,  7, 9 ),
                Arrays.asList(5, 7,  9, 11),
                Arrays.asList(7, 9, 11, 13)
        ));
        //check each row if it contains 4 of a players tokens
        for (String element: getTokens()) {
            for (List array: board) {
                int frequency = Collections.frequency(array, element);
                if (frequency >= 4){
                    // index positions
                    List<Integer> index = new ArrayList<>(0);
                    for (int i=0; i < array.size(); i++) {
                        if (array.get(i).equals(element)){
                            index.add(i);// It's an occurrence, add to another list
                        }
                    }
                    //check if a winning array
                    for (List winCase: winArray) {
                        if (
                                index.contains(winCase.get(0)) &&
                                index.contains(winCase.get(1)) &&
                                index.contains(winCase.get(2)) &&
                                index.contains(winCase.get(3))) {
                            win = true;
                            break;
                        }

                    }
                }
            }
        }
        return win;
    }


    //Vertical check
    private boolean verticalCheck(){
        boolean win = false;


        // winning array
        List<List<Integer>> winArray = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 2, 4, 6 ),
                Arrays.asList(2, 4, 6, 8 ),
                Arrays.asList(4, 6, 8, 10)
        ));

        //rotated array
        List<List<String>> rotatedBoard = new ArrayList<>(0);
        for (int i=0; i < board.get(0).size(); i++) {
            List<String> column = new ArrayList<>(0);
            for (List row: board) {
                String element = (String) row.get(i);
                column.add(element);
            }
            rotatedBoard.add(column);
        }

        //check each row if it contains 4 of a players tokens
        for (String element: getTokens()) {
            for (List columnArray: rotatedBoard) {
                int frequency = Collections.frequency(columnArray, element);
                if (frequency >= 4){
                    // index positions
                    List<Integer> index = new ArrayList<>(0);
                    for (int i=0; i < columnArray.size(); i++) {
                        if (columnArray.get(i).equals(element)){
                            index.add(i);// It's an occurrence, add to another list
                        }
                    }
                    //check if a winning array
                    for (List winCase: winArray) {
                        if (
                                index.contains(winCase.get(0)) &&
                                index.contains(winCase.get(1)) &&
                                index.contains(winCase.get(2)) &&
                                index.contains(winCase.get(3))) {
                            win = true;
                            break;
                        }

                    }
                }
            }
        }
        return win;
    }

    private boolean forwardDiagonalCheck(){
        boolean win = false;

        // winning array
        List<List<Integer>> winArray = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 1, 2, 3 ),
                Arrays.asList(1, 2, 3, 4 ),
                Arrays.asList(2, 3, 4, 5)
        ));


        List<List<String>> forwardRotatedBoard = new ArrayList<>(
        Arrays.asList(
                Arrays.asList(board.get(6).get(1), board.get(4).get(3),board.get(2).get(5), board.get(0).get(7)),
                Arrays.asList(board.get(8).get(1), board.get(6).get(3),board.get(4).get(5), board.get(2).get(7), board.get(0).get(9)),
                Arrays.asList(board.get(10).get(1),board.get(8).get(3),board.get(6).get(5), board.get(4).get(7), board.get(2).get(9), board.get(0).get(11)),
                Arrays.asList(board.get(10).get(3),board.get(8).get(5),board.get(6).get(7), board.get(4).get(9), board.get(2).get(11),board.get(0).get(13)),
                Arrays.asList(board.get(10).get(5),board.get(8).get(7),board.get(6).get(9), board.get(4).get(11),board.get(2).get(13)),
                Arrays.asList(board.get(10).get(7),board.get(8).get(9),board.get(6).get(11),board.get(4).get(13))
                ));

        //check each row if it contains 4 of a players tokens
        for (String element: getTokens()) {
            for (List diagonalArray: forwardRotatedBoard) {
                int frequency = Collections.frequency(diagonalArray, element);
                if (frequency >= 4){
                    // index positions
                    List<Integer> index = new ArrayList<>(0);
                    for (int i=0; i < diagonalArray.size(); i++) {
                        if (diagonalArray.get(i).equals(element)){
                            index.add(i);// It's an occurrence, add to another list
                        }
                    }
                    //check if a winning array
                    for (List winCase: winArray) {
                        if (
                                index.contains(winCase.get(0)) &&
                                index.contains(winCase.get(1)) &&
                                index.contains(winCase.get(2)) &&
                                index.contains(winCase.get(3))) {
                            win = true;
                            break;
                        }

                    }
                }
            }
        }
        return win;



    }

    private boolean backwardDiagonalCheck(){
        boolean win = false;

        // winning array
        List<List<Integer>> winArray = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 1, 2, 3 ),
                Arrays.asList(1, 2, 3, 4 ),
                Arrays.asList(2, 3, 4, 5)
        ));


        List<List<String>> backRotatedBoard = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(board.get(4).get(1), board.get(6).get(3),board.get(8).get(5), board.get(10).get(7)),
                        Arrays.asList(board.get(2).get(1), board.get(4).get(3),board.get(6).get(5), board.get(8).get(7), board.get(10).get(9)),
                        Arrays.asList(board.get(0).get(1), board.get(2).get(3),board.get(4).get(5), board.get(6).get(7), board.get(8).get(9), board.get(10).get(11)),
                        Arrays.asList(board.get(0).get(3), board.get(2).get(5),board.get(4).get(7), board.get(6).get(9), board.get(8).get(11),board.get(10).get(13)),
                        Arrays.asList(board.get(0).get(5), board.get(2).get(7),board.get(4).get(9), board.get(6).get(11),board.get(8).get(13)),
                        Arrays.asList(board.get(0).get(7), board.get(2).get(9),board.get(4).get(11),board.get(6).get(13))
                ));

        //check each row if it contains 4 of a players tokens
        for (String element: getTokens()) {
            for (List diagonalArray: backRotatedBoard) {
                int frequency = Collections.frequency(diagonalArray, element);
                if (frequency >= 4){
                    // index positions
                    List<Integer> index = new ArrayList<>(0);
                    for (int i=0; i < diagonalArray.size(); i++) {
                        if (diagonalArray.get(i).equals(element)){
                            index.add(i);// It's an occurrence, add to another list
                        }
                    }
                    //check if a winning array
                    for (List winCase: winArray) {
                        if (
                                index.contains(winCase.get(0)) &&
                                index.contains(winCase.get(1)) &&
                                index.contains(winCase.get(2)) &&
                                index.contains(winCase.get(3))) {
                            win = true;
                            break;
                        }

                    }
                }
            }
        }
        return win;
    }



    // ACCESSOR METHODS
    public List<String> getTokens() {
        return tokens;
    }





}