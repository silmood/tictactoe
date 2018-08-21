package com.silmood.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{

    public static final int ROWS = 5;
    public static final int COLS = 5;

    private LinearLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        setupMatrix();
    }

    private void setupMatrix() {
        for (int i = 0; i < ROWS; i++) {
            LinearLayout row = buildRow();

            for (int j = 0; j < COLS; j++) {
                Button box = buildButton(new int[]{i, j});
                row.addView(box);
            }

            container.addView(row);
        }
    }

    private LinearLayout buildRow() {
        LinearLayout row = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1.0f/ROWS);
        params.setMargins(10, 10, 10, 10);

        row.setLayoutParams(params);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setWeightSum(1.0f);

        return row;
    }

    private Button buildButton(int[] position) {
        Button box = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT, 1f/COLS);
        params.setMargins(10, 10, 10, 10);

        box.setLayoutParams(params);
        box.setTag(position);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getTag();

            }
        });

        return box;
    }

    private void evaluatePosition(int[] position) {

    }
}
