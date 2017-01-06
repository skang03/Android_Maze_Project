package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.R;
/**
 * Created by Sungwon Kang on 6/24/2016.
 */
public class Play_previous extends Title {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_previous_amaze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    /**
     * go to title page when back button is pressed
     * @param view
     */
    public void titleScreenPreviousOnClick(View view){
        Intent intent = new Intent(this, Title.class);
        Log.v("backOnClick", "BackOnClick");
        Toast.makeText(Play_previous.this, "back button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    /**
     * prints up when up button is pressed
     * moves forward when the button is pressed
     * @param view
     */
    public void upPreviousOnClick(View view){
        Log.v("up", "UP");
        Toast.makeText(Play_previous.this, "up button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints down when down button is pressed
     * moves backward when the button is pressed
     * @param view
     */
    public void downPreviousOnClick(View view){
        Log.v("down", "DOWN");
        Toast.makeText(Play_previous.this, "down button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints left when left button is presed
     * turns left when the button is pressed
     * @param view
     */
    public void leftPreviousOnClick(View view){
        Log.v("left", "LEFT");
        Toast.makeText(Play_previous.this, "left button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints right when right button is pressed
     * turns right when the button is pressed
     * @param view
     */
    public void rightPreviousOnClick(View view){
        Log.v("right", "RIGHT");
        Toast.makeText(Play_previous.this, "right button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints show walls when wall button is pressed
     * shows wall when the button is pressed
     * @param view
     */
    public void showWallsPreviousOnClick(View view){
        Log.v("show walls", "SHOW WALLS");
        Toast.makeText(Play_previous.this, "wall button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints full maze when full maze button is pressed
     * shows full maze when the button is pressed
     * @param view
     */
    public void showFullMazePreviousOnClick(View view){
        Log.v("full maze", "FULL MAZE");
        Toast.makeText(Play_previous.this, "full maze button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints SHOW SOLUTION when solution button is pressed
     * shows solution when the button is pressed
     * @param view
     */
    public void showSolutionPreviousOnClick(View view){
        Log.v("show solution", "SHOW SOLUTION");
        Toast.makeText(Play_previous.this, "solution button pressed", Toast.LENGTH_SHORT).show();
    }



}
