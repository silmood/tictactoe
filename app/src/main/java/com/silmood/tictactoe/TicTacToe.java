package com.silmood.tictactoe;


import java.util.ArrayList;

public class TicTacToe {
    public static final int LIMIT = 2;
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char RIGHT = 'R';
    public static final char LEFT = 'L';


    public ArrayList<int[]> getHorizontalAdjacent(int[] position) {
        ArrayList<int[]> adjacent = new ArrayList<>();
        adjacent.addAll(getPositions(position, LEFT));
        adjacent.addAll(getPositions(position, RIGHT));

        return adjacent;
    }

    public ArrayList<int[]> getVerticalAdjacent(int[] position) {
        ArrayList<int[]> adjacent = new ArrayList<>();
        adjacent.addAll(getPositions(position, UP));
        adjacent.addAll(getPositions(position, DOWN));

        return adjacent;
    }

    private ArrayList<int[]> getPositions(int[] position, char direction) {
        int row = position[0];
        int col = position[1];
        ArrayList<int[]> adjacent = new ArrayList<>();

        int variable = direction == UP || direction == DOWN ? row : col;

        for (int i = (commitOperation(variable, direction));
             commitEvaluation(i, direction) ;
             i = commitOperation(i, direction)) {

            if (direction == UP || direction == DOWN) {
                adjacent.add(new int[]{i, col});
            } else {
                adjacent.add(new int[]{row, i});
            }
        }

        return adjacent;
    }

    public ArrayList<int[]> getDiagonalAdjacent(int[] position, char horizontal, char vertical) {
        int row = position[0];
        int col = position[1];
        ArrayList<int[]> adjacent = new ArrayList<>();


        for (int i = (commitOperation(row, vertical)),
                j = (commitOperation(col, horizontal));
             commitEvaluation(i, vertical) && commitEvaluation(j, horizontal);
             i = commitOperation(i, vertical) , j = commitOperation(j, horizontal)) {
                adjacent.add(new int[]{i, j});
        }

        return adjacent;
    }

    private int commitOperation(int value, char operation) {
        switch (operation) {
            case UP:
                return (value - 1);
            case LEFT:
                return (value - 1);
            case DOWN:
                return (value + 1);
            case RIGHT:
                return (value + 1);
            default:
                return value;
        }
    }

    private boolean commitEvaluation(int value, char operation) {
        switch (operation) {
            case UP:
                return value >= 0;
            case LEFT:
                return value >= 0;
            case DOWN:
                return value <= LIMIT;
            case RIGHT:
                return value <= LIMIT;
            default:
                return false;
        }
    }

}
