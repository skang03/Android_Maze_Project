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
public class Play_robot extends Title {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_robot_amaze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Goes to finish screen when finish button is pressed.
     * @param view
     */
    public void finishRobotOnClick(View view){
        Intent intent = new Intent(this, Finish.class);
        Log.v("finishOnClick", "FinishOnClick");
        Toast.makeText(Play_robot.this, "finish button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    /**
     * goes to the title screen when back button is pressed
     * @param view
     */
    public void titleScreenRobotOnClick(View view){
        Intent intent = new Intent(this, Title.class);
        Log.v("backOnClick", "BackOnClick");
        Toast.makeText(Play_robot.this, "back button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    /**
     * prints up when up button is pressed
     * @param view
     */
    public void upRobotOnClick(View view){
        Log.v("up", "UP");
        Toast.makeText(Play_robot.this, "up button pressed", Toast.LENGTH_SHORT).show();
    }


    /**
     * prints down when down button is pressed
     * @param view
     */
    public void downRobotOnClick(View view){
        Log.v("down", "DOWN");
        Toast.makeText(Play_robot.this, "down button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints left when left button is pressed
     * @param view
     */
    public void leftRobotOnClick(View view){
        Log.v("left", "LEFT");
        Toast.makeText(Play_robot.this, "left button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints right when right button is presed
     * @param view
     */
    public void rightRobotOnClick(View view){
        Log.v("right", "RIGHT");
        Toast.makeText(Play_robot.this, "right button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints SHOW WALLS when show walls button is pressed
     * @param view
     */
    public void showRobotWallsOnClick(View view){
        Log.v("show walls", "SHOW WALLS");
        Toast.makeText(Play_robot.this, "wall button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints FULL MAZE when full maze button is pressed
     * @param view
     */
    public void showRobotFullMazeOnClick(View view){
        Log.v("full maze", "FULL MAZE");
        Toast.makeText(Play_robot.this, "full maze button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints SHOW SOLUTION when solution button is pressed
     * @param view
     */
    public void showRobotSolutionOnClick(View view){
        Log.v("show solution", "SHOW SOLUTION");
        Toast.makeText(Play_robot.this, "solution button pressed", Toast.LENGTH_SHORT).show();
    }

    /**
     * prints Pause when pause button is pressed
     * @param view
     */
    public void pauseRobotOnClick(View view){
        Log.v("pause", "Pause");
        Toast.makeText(Play_robot.this, "pause button pressed", Toast.LENGTH_SHORT).show();
    }


}
