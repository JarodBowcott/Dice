package com.example.jarod.dice;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView resultTextView;
    Boolean isRolling;

    public void rollDice(View view){

        if (isRolling == false){
            isRolling = true;
            // Getting the number rolled
            Random random = new Random();

            int diceRoll = random.nextInt(6)+1;


            resultTextView.setText("You rolled a " + String.valueOf(diceRoll));

            // Animating the results
            resultTextView.setTranslationY(-1200);
            resultTextView.animate().translationYBy(1200).setDuration(300);

            // Changes the dice image
            ImageView diceImageView = (ImageView) findViewById(R.id.diceImageView);

            diceImageView.setTranslationX(-1200);
            diceImageView.setRotation(0);
            diceImageView.animate().translationXBy(1200).rotation(1080).setDuration(300);

            if (diceRoll == 1){
                diceImageView.setImageResource(R.drawable.diceone);
            } else if (diceRoll == 2){
                diceImageView.setImageResource(R.drawable.dicetwo);
            } else if (diceRoll == 3){
                diceImageView.setImageResource(R.drawable.dicethree);
            } else if (diceRoll == 4){
                diceImageView.setImageResource(R.drawable.dicefour);
            } else if (diceRoll == 5){
                diceImageView.setImageResource(R.drawable.dicefive);
            } else if (diceRoll == 6){
                diceImageView.setImageResource(R.drawable.dicesix);
            } else {
                Log.i("ERROR", "diceRoll variable is out of range : " + String.valueOf(diceRoll));
            }

            // Plays sounds
            MediaPlayer mediaPlayer;
            mediaPlayer = MediaPlayer.create(this, R.raw.roll);
            mediaPlayer.start();
            // Resets mediaplayer to prevent it from breaking
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    isRolling = false;
                    mp.reset();
                }
            });
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        resultTextView = (TextView) findViewById(R.id.resultTextView);

        isRolling = false;

    }

}
