package com.silmood.tictactoe;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TicTacToeTest {
    @Test
    public void horizontal_adjacent() {
        TicTacToe game = new TicTacToe();

        ArrayList<int[]> result = game.getHorizontalAdjacent(new int[]{0,1});

        StringBuilder textResult = new StringBuilder();
        for (int[] position: result) {
            textResult.append(Arrays.toString(position));
        }

        Assert.assertEquals("[0, 0][0, 2]", textResult.toString());
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void vertical_adjacent() {
        TicTacToe game = new TicTacToe();

        ArrayList<int[]> result = game.getVerticalAdjacent(new int[]{0,1});

        StringBuilder textResult = new StringBuilder();
        for (int[] position: result) {
            textResult.append(Arrays.toString(position));
        }

        Assert.assertEquals("[1, 1][2, 1]", textResult.toString());
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void diagonals_adjacent() {
        TicTacToe game = new TicTacToe();

        ArrayList<int[]> result = game.getDiagonalAdjacent(new int[]{1,1},
                TicTacToe.RIGHT,
                TicTacToe.UP);

        StringBuilder textResult = new StringBuilder();
        for (int[] position: result) {
            textResult.append(Arrays.toString(position));
        }

        Assert.assertEquals("[0, 2]", textResult.toString());
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void x_horizontal_wins() {
        TicTacToe game = new TicTacToe();
        game.startGame();

        Assert.assertFalse(game.turn(new int[]{0,0}));
        Assert.assertFalse(game.turn(new int[]{2,0}));
        Assert.assertFalse(game.turn(new int[]{0,1}));
        Assert.assertFalse(game.turn(new int[]{2,1}));
        Assert.assertTrue(game.turn(new int[]{0,2}));
    }

    @Test
    public void x_vertical_wins() {
        TicTacToe game = new TicTacToe();
        game.startGame();

        Assert.assertFalse(game.turn(new int[]{0,0}));
        Assert.assertFalse(game.turn(new int[]{0,1}));
        Assert.assertFalse(game.turn(new int[]{1,0}));
        Assert.assertFalse(game.turn(new int[]{1,1}));
        Assert.assertTrue(game.turn(new int[]{2,0}));
    }

    @Test
    public void x_diagonal_wins() {
        TicTacToe game = new TicTacToe();
        game.startGame();

        Assert.assertFalse(game.turn(new int[]{0,0}));
        Assert.assertFalse(game.turn(new int[]{2,0}));
        Assert.assertFalse(game.turn(new int[]{1,1}));
        Assert.assertFalse(game.turn(new int[]{0,2}));
        Assert.assertTrue(game.turn(new int[]{2,2}));
    }
}
