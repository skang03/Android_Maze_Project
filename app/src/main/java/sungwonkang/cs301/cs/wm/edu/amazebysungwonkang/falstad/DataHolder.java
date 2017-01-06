package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad;

import android.graphics.Bitmap;

/**
 * Created by Sungwon Kang on 7/1/2016.
 */
public class DataHolder {
    private MazeController maze;
    private Bitmap bmp;

    public MazeController getMaze(){
        return maze;
    }
    public void setMaze(MazeController maze){
        this.maze = maze;
        this.maze.init();
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance(){
        return holder;
    }
}

