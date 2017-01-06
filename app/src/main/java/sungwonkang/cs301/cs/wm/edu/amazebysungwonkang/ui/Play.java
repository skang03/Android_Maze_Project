package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.R;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.DataHolder;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.MazeController;

/**
 * Created by Sungwon Kang on 6/24/2016.
 */
public class Play extends Title{

    MazeController mazecontroller = DataHolder.getInstance().getMaze();
    int pathlength;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_amaze);
        pathlength = 0;
        mazecontroller = DataHolder.getInstance().getMaze();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * lead the user to the finish screen when FINISH SCREEN button is pressed
     * @param view
     */
    public void finishOnClick(View view){
        Intent intent = new Intent(this, Finish.class);
        Log.v("finishOnClick", "FinishOnClick");
        Toast.makeText(Play.this, "finish button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    /**
     * direct user to the title page when BACK button is pressed
     * @param view
     */
    public void titleScreenOnClick(View view){
        Intent intent = new Intent(this, Title.class);
        Log.v("titleOnClick", "TitleOnClick");
        Toast.makeText(Play.this, "back button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    /**
     * prints up when up button is pressed
     * move forward when up button is pressed
     * @param view
     */
    public void upOnClick(View view){
        //audio source: http://jpolito.zlique.org/server/sound/player/pl_tile2.wav
        final MediaPlayer audio3 = MediaPlayer.create(this, R.raw.audio3);
        ImageView audioClap = (ImageView) this.findViewById(R.id.imageView);
        audio3.start();

        mazecontroller.walk(1);
        pathlength = pathlength + 1;
        Log.v("up", "UP");
        int[] pos = mazecontroller.getCurrentPosition();
        int x = pos[0];
        int y = pos[1];

        if (mazecontroller.isOutside(x, y)) {
            Intent intent = new Intent(this, Finish.class);
            intent.putExtra("pathlength", pathlength);
            Log.v("finish", "Finish");

            //audio credit to: https://www.youtube.com/watch?v=D59aDWwU6Vs
            final MediaPlayer audio2 = MediaPlayer.create(this, R.raw.audio2);
            audioClap = (ImageView) this.findViewById(R.id.imageView);
            audio2.start();
            startActivity(intent);
        }
    }

    /**
     * prints down when down button is presed
     * move backward when down button is pressed
     * @param view
     */
    public void downOnClick(View view){
        //audio source: http://jpolito.zlique.org/server/sound/player/pl_tile2.wav
        final MediaPlayer audio3 = MediaPlayer.create(this, R.raw.audio3);
        ImageView audioClap = (ImageView) this.findViewById(R.id.imageView5);
        audio3.start();

        mazecontroller.walk(-1);
        pathlength = pathlength + 1;
        Log.v("down", "DOWN");
        int[] pos = mazecontroller.getCurrentPosition();
        int x = pos[0];
        int y = pos[1];

        if (mazecontroller.isOutside(x, y)) {
            Intent intent = new Intent(this, Finish.class);
            intent.putExtra("pathlength", pathlength);
            Log.v("finish", "Finish");

            //audio credit to: https://www.youtube.com/watch?v=D59aDWwU6Vs
            final MediaPlayer audio2 = MediaPlayer.create(this, R.raw.audio2);
            audioClap = (ImageView) this.findViewById(R.id.imageView5);
            audio2.start();
            startActivity(intent);
        }
    }

    /**
     * prints left when left button is pressed
     * turns left when left button is pressed
     * @param view
     */
    public void leftOnClick(View view){
        mazecontroller.rotate(1);
        Log.v("left", "LEFT");
    }

    /**
     * prints right when right button is pressed
     * turns right when right button is pressed
     * @param view
     */
    public void rightOnClick(View view){
        mazecontroller.rotate(-1);
        Log.v("right", "RIGHT");
    }

    /**
     * prints shows wall when show wall button is pressed
     * shows wall when wall button is pressed
     * @param view
     */
    public void showWallsOnClick(View view){
        mazecontroller.toggleWalls();
        Log.v("show walls", "SHOW WALLS");
    }

    /**
     * prints full maze when full maze button is pressed
     * shows full maze when full maze button is pressed
     * @param view
     */
    public void showFullMazeOnClick(View view){
        mazecontroller.toggleFullMaze();
        Log.v("full maze", "FULL MAZE");
    }

    /**
     * prints SHOW sOLUTION when solution button is pressed
     * shows solution when solution button is pressed
     * @param view
     */
    public void showSolutionOnClick(View view){
        mazecontroller.toggleSolution();
        Log.v("show solution", "SHOW SOLUTION");
    }
}

