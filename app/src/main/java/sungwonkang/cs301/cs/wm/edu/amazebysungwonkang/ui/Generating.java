package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.R;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.DataHolder;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.MazeController;

/**
 * Created by Sungwon Kang on 6/24/2016.
 */
public class Generating extends Title{
    private MazeController mazeController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating_amaze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Context generating = this;
        //DOESNT DO SHIT XDDDDDDDDDDDDDDDDDDDDD
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                int level = Integer.parseInt((String) bundle.get("level"));
                String generator = (String) bundle.get("generator");

                mazeController = new MazeController(generating, level, generator);
                DataHolder.getInstance().setMaze(mazeController);
                while(Integer.parseInt(mazeController.getPercentDone()) < 99) {
                }
                Intent newIntent = new Intent(generating, Play.class);
                startActivity(newIntent);
                finish();
            }
        }, 25);

    }

    @Override
    protected void onResume(){
        super.onResume();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int level = Integer.parseInt((String) bundle.get("level"));
        String generator = (String) bundle.get("generator");

        mazeController = new MazeController(this, level, generator);
        DataHolder.getInstance().setMaze(mazeController);

        while(Integer.parseInt(mazeController.getPercentDone()) < 99) {

        }
        Intent newIntent = new Intent(this, Play.class);
        startActivity(newIntent);
    }
    /**
     * When the Back button is pressed on Generating screen, the program sends
     * the user to the title screen
     */
    public void backOnClick(View view){
        Intent intent = new Intent(this, Title.class);
        Log.v("backOnClick", "BackOnClick");
        Toast.makeText(Generating.this, "back button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    //update progress from MazeController.updateProgress


    /**
     * When the Go To Play button is pressed on Generating screen, the program sends
     * the user to the Play screen.
     * This is just for the project 4. In project 5, the user will be sent to the Play
     * screen when the Progress bar hits 100% instead of by pressing the button.
     * When user put maze driver as manual, it runs the manual maze, but when
     * wallfollower is put, the program runs the play_robot class and runs the
     * robot maze
     */
    public void forwardOnClick(View view){
        while(Integer.parseInt(mazeController.getPercentDone()) < 99) {

        }
        Intent newIntent = new Intent(this, Play.class);
        startActivity(newIntent);
    }
}
