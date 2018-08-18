package com.silmood.tictactoe;


import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

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
}
