package com.example.valerijborodaev.numbergame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends Activity {

    private Integer currentScore = 0;
    private Integer leftNum = 0;
    private Integer rightNum = 0;

    TextView leftNumberText;
    TextView rightNumberText;
    TextView scoreText;

    Button lessBtn;
    Button equalBtn;
    Button moreBtn;


    private void check(int userAnswer) {
        Integer answer = this.leftNum.compareTo(this.rightNum);
        if(answer == userAnswer) {
            this.currentScore += 1;
        } else {
            this.currentScore -= 1;
        }

        if(this.currentScore < 0) {
          startActivity(new Intent(GameActivity.this, MainActivity.class));
        }

        this.scoreText.setText(this.currentScore.toString());
        this.init();
    }

    private void init() {
        this.leftNum = new Random().nextInt(100 - 1) + 1;
        this.rightNum = new Random().nextInt(100 - 1) + 1;
        this.leftNumberText.setText(this.leftNum.toString());
        this.rightNumberText.setText(this.rightNum.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        leftNumberText = findViewById(R.id.leftNumber);
        rightNumberText = findViewById(R.id.rightNumber);
        scoreText = findViewById(R.id.score);

        lessBtn = findViewById(R.id.lessBtn);
        equalBtn = findViewById(R.id.equalBtn);
        moreBtn = findViewById(R.id.moreBtn);


        lessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(-1);
            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(0);
            }
        });

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(1);
            }
        });

        this.init();
    }


}
