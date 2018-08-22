package com.silmood.tictactoe;


import java.util.ArrayList;
import java.util.Random;

public class TicTacToe {
    private static final int LIMIT = 2;
    public static final char UP = 'U';
    public static final char DOWN = 'D';
    public static final char RIGHT = 'R';
    public static final char LEFT = 'L';

    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private char currentPlayer;

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void startGame() {
        resetBoard();
        int player = new Random().nextInt(1);
        this.currentPlayer = player == 0 ? 'X' : 'O';
    }

    private void resetBoard() {
        this.board = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    public boolean turn(int[] position) {
        setBox(position, this.currentPlayer);
        boolean result = hasWin(position, this.currentPlayer);
        this.currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
        return result;
    }

    private void setBox(int[] position, char player) {
        int row = position[0];
        int col = position[1];

        this.board[row][col] = player;
    }

    public boolean hasWin(int[] position, char player) {
        ArrayList<int[]> horizontal = getHorizontalAdjacent(position);
        ArrayList<int[]> vertical = getVerticalAdjacent(position);

        ArrayList<int[]> firstDiagonal = getDiagonalAdjacent(position, LEFT, UP);
        firstDiagonal.addAll(getDiagonalAdjacent(position, RIGHT, DOWN));

        ArrayList<int[]> secondDiagonal = getDiagonalAdjacent(position, RIGHT, UP);
        secondDiagonal.addAll(getDiagonalAdjacent(position, LEFT, DOWN));

        return validateLine(horizontal, player)
                || validateLine(vertical, player)
                || validateLine(firstDiagonal, player)
                || validateLine(secondDiagonal, player);

    }

    public boolean validateLine(ArrayList<int[]> toValidate, char player){
        if (toValidate.size() == 2) {
            boolean result = true;
            for (int[] position :
                    toValidate) {
                int row = position[0];
                int col = position[1];

                result = result && (board[row][col] == player);
            }
            return  result;
        } else {
            return false;
        }
    }


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
