package com.tictactoe.sunil.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int activePlayer=0;     //0=green, 1=red
    boolean gameIsActive=true;
    int[] gamestate={2, 2, 2, 2, 2, 2, 2, 2, 2};    //2 means unplayed
    int[][] winningPos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};  //winningpos

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int tappedcounter = Integer.parseInt(counter.getTag().toString());

        if (gamestate[tappedcounter] == 2 && gameIsActive) {
            gamestate[tappedcounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.green);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(3600).setDuration(600);
            for (int[] winnigposition : winningPos) {
                if (gamestate[winnigposition[0]] == gamestate[winnigposition[1]] &&
                        gamestate[winnigposition[1]] == gamestate[winnigposition[2]]
                        && gamestate[winnigposition[0]] != 2) {

                    //someone has won
                    gameIsActive = false;

                    String winner = "Red";
                    if (gamestate[winnigposition[0]] == 0) {
                        winner = "Green";
                    }
                    TextView winnermessage = (TextView) findViewById(R.id.winnerMessage);
                    winnermessage.setText(winner+" has won!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);


                } else
                    {
                    boolean gameIsOver = true;
                    for (int counterState : gamestate) {
                        if (counterState == 2)
                            gameIsOver = false;
                    }
                    if (gameIsOver) {
                        TextView winnermessage = (TextView) findViewById(R.id.winnerMessage);
                        winnermessage.setText("It's a DRAW!!");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }
    public void buttonClick(View view){
        //Log.i("button tapped","true");
            gameIsActive = true;
            LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
            layout.setVisibility(View.INVISIBLE);
            activePlayer = 0;

            for (int i = 0; i < gamestate.length; i++) {
                gamestate[i] = 2;
            }
            GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
            /*for (int i = 0; i <gridLayout.getChildCount(); i++) {
              ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);    // not working
            }*/

     ImageView i1= (ImageView)findViewById(R.id.imageView);
     i1.setImageResource(0);
        ImageView i2= (ImageView)findViewById(R.id.imageView2);
        i2.setImageResource(0);
        ImageView i3= (ImageView)findViewById(R.id.imageView3);
        i3.setImageResource(0);
        ImageView i4= (ImageView)findViewById(R.id.imageView4);
        i4.setImageResource(0);
        ImageView i5= (ImageView)findViewById(R.id.imageView5);
        i5.setImageResource(0);
        ImageView i6= (ImageView)findViewById(R.id.imageView6);
        i6.setImageResource(0);
        ImageView i7= (ImageView)findViewById(R.id.imageView7);
        i7.setImageResource(0);
        ImageView i8= (ImageView)findViewById(R.id.imageView8);
        i8.setImageResource(0);
        ImageView i9= (ImageView)findViewById(R.id.imageView9);
        i9.setImageResource(0);

    }


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
