package com.example.android.badmintonscorekeeper;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int numberOfSet = 1;
    int scoreSet1PlayerA = 0;
    int scoreSet1PlayerB = 0;
    int scoreSet2PlayerA = 0;
    int scoreSet2PlayerB = 0;
    int scoreSet3PlayerA = 0;
    int scoreSet3PlayerB = 0;
    String winMessage = "The winner is ...";
    String gameWinnerMessage = "";

    TextView viewScorePlayerA;
    TextView viewScorePlayerB;
    TextView viewNumberOfSet;
    TextView viewScoreSet1PlayerA;
    TextView viewScoreSet1PlayerB;
    TextView viewScoreSet2PlayerA;
    TextView viewScoreSet2PlayerB;
    TextView viewScoreSet3PlayerA;
    TextView viewScoreSet3PlayerB;
    TextView setWinnerTextView;
    TextView gameWinnerTextView;
    Button buttonScoreA;
    Button buttonScoreB;
    Button setButton;
    Button resetButton;
    View backgroundImage;

    static final String SCORE_PlAYER_A ="scorePlayerA";
    static final String SCORE_PlAYER_B ="scorePlayerB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setWinnerTextView = findViewById(R.id.text_winner);
        gameWinnerTextView =  findViewById(R.id.game_winner);
        viewScorePlayerA = findViewById(R.id.player_a_score);
        viewScorePlayerB = findViewById(R.id.player_b_score);
        viewNumberOfSet= findViewById(R.id.text_2);
        viewScoreSet1PlayerA= findViewById(R.id.playerA_set1);
        viewScoreSet1PlayerB= findViewById(R.id.playerB_set1);
        viewScoreSet2PlayerA= findViewById(R.id.playerA_set2);
        viewScoreSet2PlayerB= findViewById(R.id.playerB_set2);
        viewScoreSet3PlayerA= findViewById(R.id.playerA_set3);
        viewScoreSet3PlayerB= findViewById(R.id.playerB_set3);
        buttonScoreA= findViewById(R.id.button_score_a);
        buttonScoreB= findViewById(R.id.button_score_b);
        setButton= findViewById(R.id.set_button);
        resetButton= findViewById(R.id.reset_button);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(SCORE_PlAYER_A, scorePlayerA);
        savedInstanceState.putInt(SCORE_PlAYER_B, scorePlayerB);
        savedInstanceState.putInt("numberOfSet", numberOfSet);
        savedInstanceState.putInt("scoreSet1PlayerA", scoreSet1PlayerA);
        savedInstanceState.putInt("scoreSet1PlayerB", scoreSet1PlayerB);
        savedInstanceState.putInt("scoreSet2PlayerA", scoreSet2PlayerA);
        savedInstanceState.putInt("scoreSet2PlayerB", scoreSet2PlayerB);
        savedInstanceState.putInt("scoreSet3PlayerA", scoreSet3PlayerA);
        savedInstanceState.putInt("scoreSet3PlayerB", scoreSet3PlayerB);
        savedInstanceState.putString("winMessage", winMessage);
        savedInstanceState.putString("gameWinnerMessage", gameWinnerMessage);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            scorePlayerA = savedInstanceState.getInt("scorePlayerA");
            scorePlayerB = savedInstanceState.getInt("scorePlayerB");
            numberOfSet = savedInstanceState.getInt("numberOfSet");
            scoreSet1PlayerA = savedInstanceState.getInt("scoreSet1PlayerA");
            scoreSet1PlayerB = savedInstanceState.getInt("scoreSet1PlayerB");
            scoreSet2PlayerA = savedInstanceState.getInt("scoreSet2PlayerA");
            scoreSet2PlayerB = savedInstanceState.getInt("scoreSet2PlayerB");
            scoreSet3PlayerA = savedInstanceState.getInt("scoreSet3PlayerA");
            scoreSet3PlayerB = savedInstanceState.getInt("scoreSet3PlayerB");
            winMessage = savedInstanceState.getString("winMessage");
            gameWinnerMessage = savedInstanceState.getString("gameWinnerMessage");
            displayForPlayerA(scorePlayerA);
            displayForPlayerB(scorePlayerB);
            displayNumberOfSets(numberOfSet);
            displaySet1ForPlayerA(scoreSet1PlayerA);
            displaySet1ForPlayerB(scoreSet1PlayerB);
            displaySet2ForPlayerA(scoreSet2PlayerA);
            displaySet2ForPlayerB(scoreSet2PlayerB);
            displaySet3ForPlayerA(scoreSet3PlayerA);
            displaySet3ForPlayerB(scoreSet3PlayerB);
            displayWinner(winMessage);
            displayGameWinner(gameWinnerMessage);
        }
    }

    /**
     * Displays the number of points in current set.
     */
    private void displayPoints (){
        if (numberOfSet == 1) {
            scoreSet1PlayerA = scorePlayerA;
            scoreSet1PlayerB = scorePlayerB;
        }
        if (numberOfSet == 2) {
            scoreSet2PlayerA = scorePlayerA;
            scoreSet2PlayerB = scorePlayerB;
        }
        if (numberOfSet == 3) {
            scoreSet3PlayerA = scorePlayerA;
            scoreSet3PlayerB = scorePlayerB;
        }
        displaySet1ForPlayerA(scoreSet1PlayerA);
        displaySet2ForPlayerA(scoreSet2PlayerA);
        displaySet3ForPlayerA(scoreSet3PlayerA);
        displaySet1ForPlayerB(scoreSet1PlayerB);
        displaySet2ForPlayerB(scoreSet2PlayerB);
        displaySet3ForPlayerB(scoreSet3PlayerB);
    }

    /**
     * Increase the number of sets, reset points of Player A and Player B, check if game is over (then increasing is impossible).
     */
    public void newSet(View view) {
        if (numberOfSet==1){
            if (winMessage == "The winner is ...") return;
        }
        if (numberOfSet == 2) {
            if (scoreSet1PlayerA>scoreSet1PlayerB && scoreSet2PlayerA>scoreSet2PlayerB || scoreSet1PlayerB>scoreSet1PlayerA && scoreSet2PlayerB>scoreSet2PlayerA){
                gameOver();
                return;
            }
        }
        if (numberOfSet>=3){
            return;
        }
        numberOfSet += 1;
        scorePlayerA = 0;
        scorePlayerB = 0;
        winMessage="The winner is ...";
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
        displayNumberOfSets(numberOfSet);
        displayWinner(winMessage);
    }
    /**
     * Reset variables, start new game
     */
    public void resetScore(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        numberOfSet = 1;
        scoreSet1PlayerA = 0;
        scoreSet1PlayerB = 0;
        scoreSet2PlayerA = 0;
        scoreSet2PlayerB = 0;
        scoreSet3PlayerA = 0;
        scoreSet3PlayerB = 0;
        winMessage = "The winner is ...";
        gameWinnerMessage="";
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
        displaySet1ForPlayerA(scoreSet1PlayerA);
        displaySet2ForPlayerA(scoreSet2PlayerA);
        displaySet3ForPlayerA(scoreSet3PlayerA);
        displaySet1ForPlayerB(scoreSet1PlayerB);
        displaySet2ForPlayerB(scoreSet2PlayerB);
        displaySet3ForPlayerB(scoreSet3PlayerB);
        displayNumberOfSets(numberOfSet);
        displayWinner(winMessage);
        displayGameWinner(gameWinnerMessage);
    }
    /**
     * Adding  score for Player A. The winner of the set is the player who first reach
     * 21 points. In case that two of the players have 20 points each, they are playing
     * until one of them reach 2 points more (when the result is 29:29 it's enough to get one
     * point more).
     */
    public void addOnePointA(View v) {
        if (winMessage == "The winner is ...") {
            scorePlayerA += 1;
            displayForPlayerA(scorePlayerA);
            if ((scorePlayerA == 21 && scorePlayerB < 20) || (scorePlayerA > 21 && scorePlayerA < 30 && scorePlayerA - scorePlayerB == 2)
                    || (scorePlayerA == 30)) {
                winMessage = "Player A is a winner of the set!";
                displayWinner(winMessage);
                displayPoints();
                gameOver();
            }
        }
    }
    /**
     * Adding  score for Player B.
     */
    public void addOnePointB(View v) {
        if (winMessage == "The winner is ...") {
            scorePlayerB += 1;
            displayForPlayerB(scorePlayerB);
        }
        if (((scorePlayerB == 21 && scorePlayerA < 20) || (scorePlayerB > 21 && scorePlayerB < 30 && scorePlayerB - scorePlayerA == 2)
                || (scorePlayerB == 30))) {
            winMessage = "Player B is a winner of the set!";
            displayWinner(winMessage);
            displayPoints();
            gameOver();
        }
    }

    /**
     * If  Player A or Player B wins 2 sets, the match is over.
     * Displays the winner in the Winner TextView.
     */
    private void gameOver (){

        if (scoreSet1PlayerA>scoreSet1PlayerB && scoreSet2PlayerA>scoreSet2PlayerB){
            gameWinnerMessage= "Player A is a winner of the game!";
            displayGameWinner(gameWinnerMessage);
        }
        if (scoreSet1PlayerB>scoreSet1PlayerA && scoreSet2PlayerB>scoreSet2PlayerA){
            gameWinnerMessage= "Player B is a winner of the game!";
            displayGameWinner(gameWinnerMessage);
        }
        if (scoreSet3PlayerA>scoreSet3PlayerB) {
            gameWinnerMessage= "Player A is a winner of the game!";
            displayGameWinner(gameWinnerMessage);
        }
        else if (scoreSet3PlayerA<scoreSet3PlayerB){
            gameWinnerMessage= "Player B is a winner of the game!";
            displayGameWinner(gameWinnerMessage);}
    }
    /**
     * Displays the given score for Player A.
     */
    private void displayForPlayerA(int score) {
        viewScorePlayerA.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Player A.
     */
    private void displayForPlayerB(int score) {
        viewScorePlayerB.setText(String.valueOf(score));
    }
    /**
     * Displays the number of set.
     */
    private void displayNumberOfSets(int score) {
        viewNumberOfSet.setText(String.valueOf(score));
    }
    /**
     * Displays winner of the set.
     */
    private void displayWinner(String winner) {
        setWinnerTextView.setText(winner);
    }
    /**
     * Displays winner of the game.
     */
    private void displayGameWinner(String winner) {
        gameWinnerTextView.setText(winner);
    }

    /**
     * Displays the given score for Player A in set 1.
     */
    private void displaySet1ForPlayerA (int score) {
        viewScoreSet1PlayerA.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Player A in set 2.
     */
    private void displaySet2ForPlayerA(int score) {
        viewScoreSet2PlayerA.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Player A in set 3.
     */
    private void displaySet3ForPlayerA(int score) {
        viewScoreSet3PlayerA.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Player B in set 1.
     */
    private void displaySet1ForPlayerB(int score) {
        viewScoreSet1PlayerB.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Player B in set 2.
     */
    private void displaySet2ForPlayerB(int score) {
        viewScoreSet2PlayerB.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Player B in set 3.
     */
    private void displaySet3ForPlayerB(int score) {
        viewScoreSet3PlayerB.setText(String.valueOf(score));
    }
}
