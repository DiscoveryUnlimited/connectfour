package com.game.connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Brain{
    // FIELDS
    private final List<String> tokens = new ArrayList<>(Arrays.asList("O", "X"));

    // CONSTRUCTOR
    Brain() {
    }

    // BUSINESS METHODS
    boolean winCheck(List<List<String>> board){
        boolean win = false;
        // if any checks find a win return win
        if (horizontalCheck(board) || verticalCheck(board) || forwardDiagonalCheck(board) || backwardDiagonalCheck(board)){
            win = true;
        }
        return win;
    }


    boolean fullBoardCheck(List<List<String>> board){

        boolean full = false;

        List<List<String>> augmentedBoard = new ArrayList<>(Arrays.asList(board.get(0),board.get(2),board.get(4),
                board.get(6),board.get(8),board.get(10)));

        List<Integer> num = new ArrayList<>(0);
        for (List innerArray: augmentedBoard) {
            int frequency = Collections.frequency(innerArray, getTokens().get(0));
            int frequency2 = Collections.frequency(innerArray, getTokens().get(1));

            if (frequency+frequency2 == 7){
                num.add(1);
            }
        }

        if (num.size() == 6){
            full = true;
        }

        return full;
    }

    //Horizontal check
    private boolean horizontalCheck(List<List<String>> board){
        boolean win = false;


        // winning array
        List<List<Integer>> winArray = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 3,  5, 7 ),
                Arrays.asList(3, 5,  7, 9 ),
                Arrays.asList(5, 7,  9, 11),
                Arrays.asList(7, 9, 11, 13)
        ));

        // check for win
        win = internalChecker(board, winArray);

        return win;
    }


    //Vertical check
    private boolean verticalCheck(List<List<String>> board){
        boolean win = false;


        // winning array
        List<List<Integer>> winArray = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 2, 4, 6 ),
                Arrays.asList(2, 4, 6, 8 ),
                Arrays.asList(4, 6, 8, 10)
        ));

        //rotated array matrix
        List<List<String>> rotatedBoard = new ArrayList<>(0);
        for (int i=0; i < board.get(0).size(); i++) {
            List<String> column = new ArrayList<>(0);
            for (List row: board) {
                String element = (String) row.get(i);
                column.add(element);
            }
            rotatedBoard.add(column);
        }

        //check for win
        win = internalChecker(rotatedBoard, winArray);

        return win;
    }

    private boolean forwardDiagonalCheck(List<List<String>> board){
        boolean win = false;

        // winning array
        List<List<Integer>> winArray = new ArrayList<>(Arrays.asList(
                Arrays.asList(0, 1, 2, 3 ),
                Arrays.asList(1, 2, 3, 4 ),
                Arrays.asList(2, 3, 4, 5)
        ));

        //Rotate diagonal entries into array
        List<List<String>> forwardRotatedBoard = new ArrayList<>(
        Arrays.asList(
                Arrays.asList(board.get(6).get(1), board.get(4).get(3),board.get(2).get(5), board.get(0).get(7)),
                Arrays.asList(board.get(8).get(1), board.get(6).get(3),board.get(4).get(5), board.get(2).get(7), board.get(0).get(9)),
                Arrays.asList(board.get(10).get(1),board.get(8).get(3),board.get(6).get(5), board.get(4).get(7), board.get(2).get(9), board.get(0).get(11)),
                Arrays.asList(board.get(10).get(3),board.get(8).get(5),board.get(6).get(7), board.get(4).get(9), board.get(2).get(11),board.get(0).get(13)),
                Arrays.asList(board.get(10).get(5),board.get(8).get(7),board.get(6).get(9), board.get(4).get(11),board.get(2).get(13)),
                Arrays.asList(board.get(10).get(7),board.get(8).get(9),board.get(6).get(11),board.get(4).get(13))
                ));

        //check for win
        win = internalChecker(forwardRotatedBoard, winArray);

        return win;
    }


    private boolean backwardDiagonalCheck(List<List<String>> board){
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

        //check for win
        win = internalChecker(backRotatedBoard, winArray);

        return win;
    }
    // checks augmented game board against winning array matrix
    private boolean internalChecker(List<List<String>> augmentedBoard, List<List<Integer>> winArray){
        boolean win = false;
        for (String element: getTokens()) {
            for (List innerArray: augmentedBoard) {
                int frequency = Collections.frequency(innerArray, element);
                if (frequency >= 4){
                    // index positions
                    List<Integer> index = new ArrayList<>(0);
                    for (int i=0; i < innerArray.size(); i++) {
                        if (innerArray.get(i).equals(element)){
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
    private List<String> getTokens() {
        return tokens;
    }
}
