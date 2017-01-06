package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.R;

public class Title extends AppCompatActivity {
    String generator;
    String level;
    String robottype;

    /**
     * from the default HelloWorld code
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amaze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * from the default Hello World code
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_amaze, menu);
        return true;
    }

    /**
     * from the default Hello World code
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * sends level, generator, and robot type data to the maze generation process and
     * sends the user to the generating screen
     * For proj 4, it prints out the level, generator, and robot type data
     */
    public void exploreOnClick(View view){
        setGenerator();
        setLevel();
        setRobottype();
        Intent intent = new Intent(this, Generating.class);
        intent.putExtra("generator", generator);
        intent.putExtra("level", level);
        intent.putExtra("robottype", robottype);

        Log.v("generator", generator);
        Log.v("level", level);
        Log.v("robottype", robottype);        Log.v("exploreOnClick", "ExploreOnClick");

        //audio source: https://www.youtube.com/watch?v=E3_vGJrieiE
        final MediaPlayer audio1 = MediaPlayer.create(this, R.raw.audio1);
        Button audioTun = (Button) this.findViewById(R.id.ExploreButton);
        audio1.start();

        Toast.makeText(Title.this, "Please Wait. The maze is being generated", Toast.LENGTH_SHORT).show();

        startActivity(intent);

    }

    /**
     * sends the user to the play previous maze screen when Revisit button is pressed
     */
    public void revisitOnClick(View view){
        Intent intent = new Intent(this, Play_previous.class);
        Log.v("revisitOnClick", "RevisitOnClick");
        Toast.makeText(Title.this, "revisit button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    /**
     * gets user's Maze Generator input and assigns that to Generator
     */
    public void setGenerator(){
        Spinner mySpinner = (Spinner) findViewById(R.id.MazeGeneratorSpinner);
        try {
            generator = mySpinner.getSelectedItem().toString();
        }
        catch(Exception NullPointerException){
        }
    }

    /**
     * gets user's Skill Level input and assigns that to level
     */
    public void setLevel(){
        Spinner mySpinner = (Spinner) findViewById(R.id.levelSpinner);
        try {
            level = mySpinner.getSelectedItem().toString();
        }
        catch(Exception NullPointerException){
        }
    }

    /**
     * gets user's Maze Driver input and assigns that to robottype
     */
    public void setRobottype(){
        Spinner mySpinner = (Spinner) findViewById(R.id.MazeDriverSpinner);
        try {
            robottype = mySpinner.getSelectedItem().toString();
        }
        catch(Exception NullPointerException) {
        }
    }
}
