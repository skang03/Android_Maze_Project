package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.ui.Play;

import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.R;

/**
 * Created by Sungwon Kang on 6/24/2016.
 *
 * Finish screen will always display "Congratulations" because since finding the exit is the
 * only way to get the finish screen as energy is not implemented, "Failed" is not necessary.
 */
public class Finish extends Title {
    Play play = new Play();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_amaze);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle bundle = getIntent().getExtras();
        int pathlength = (int) bundle.get("pathlength");
        if(pathlength != 0) {
            String message = "Total Pathlength:  " + pathlength;
            TextView textView = (TextView) findViewById(R.id.PathLengthTextView);
            textView.setText(message);
        }
    }

    public void titleOnClick(View view) {
        Intent intent = new Intent(this, Title.class);
        Log.v("TitleOnClick", "TitleOnClick");
        Toast.makeText(Finish.this, "again button pressed", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}