package com.game.connectfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Brain extends Board{
    private final List<String> tokens = new ArrayList<>(Arrays.asList("O", "X"));

    public Brain(List<List<String>> board) {
        super(board);
    }
    /*
     * Calculate when individual columns are full
     * Calculate when the board is full
     * Calculate when 4 are connected
     * Calculate when 4 cannot be connected
     */

    public void winCheck(){
    }
    //Calculate when 4 are connected
    public boolean horizontalCheck(){
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
                    for (List array2: winArray) {
                        if(
                                index.contains(array2.get(0)) &&
                                index.contains(array2.get(1)) &&
                                index.contains(array2.get(2)) &&
                                index.contains(array2.get(3)));{
                            win = true;
                        }

                    }
                }
            }
        }
        return win;
    }

    public List<String> getTokens() {
        return tokens;
    }
}