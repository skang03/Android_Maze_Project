package sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;
import android.graphics.drawable.*;

import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.R;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.ui.Play;
import sungwonkang.cs301.cs.wm.edu.amazebysungwonkang.falstad.DataHolder;
/**
 * Handles maze graphics.
 */
public class MazePanel extends View {
	Bitmap bmp;
	Canvas canvas;

	// TODO: please check http://developer.android.com/guide/topics/graphics/2d-graphics.html
	// on how to implement your own View class
	//
	/**
	 * Constructor with one context parameter.
	 */
	public MazePanel(Context context) {
		super(context);
		bmp = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
		DataHolder.getInstance().setBmp(bmp);
		canvas = new Canvas(bmp);
		setFocusable(true);
}
	/**
	 * Constructor with two parameters: context and attributes.
	 */
	public MazePanel(Context context, AttributeSet app) {
		super(context);
		bmp = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
		canvas = new Canvas(bmp);
		setFocusable(true);
	}
	/**
	 * Draws given canvas.
	 */
	@Override
	public void onDraw(Canvas c) {
		if (bmp == null){
			bmp = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
			canvas = new Canvas(bmp);
		}
		bmp = DataHolder.getInstance().getBmp();
		c.drawBitmap(bmp, 0, 0, null);
		invalidate();
	}

	/**
	 * Updates maze graphics.
	 */
	public void update() {
		invalidate();
	}

	/**
	 * Measures the view and its content to determine the measured width and the measured height.
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int desiredWidth = 800;
		int desiredHeight = 800;

		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		int width;
		int height;

		//Measure Width
		if (widthMode == MeasureSpec.EXACTLY) {
			//Must be this size
			width = widthSize;
		} else if (widthMode == MeasureSpec.AT_MOST) {
			//Can't be bigger than...
			width = Math.min(desiredWidth, widthSize);
		} else {
			//Be whatever you want
			width = desiredWidth;
		}

		//Measure Height
		if (heightMode == MeasureSpec.EXACTLY) {
			//Must be this size
			height = heightSize;
		} else if (heightMode == MeasureSpec.AT_MOST) {
			//Can't be bigger than...
			height = Math.min(desiredHeight, heightSize);
		} else {
			//Be whatever you want
			height = desiredHeight;
		}

		//MUST CALL THIS
		setMeasuredDimension(width, height);
	}


	/**
	 * Takes in color string, sets paint color to corresponding color.
	 */
	public void setColor(String c) {
		// TODO: same as setColor(int) but for string parameters
	}

	/**
	 * Sets paint object color attribute to given color
	 */
	public void setColor(int color) {
		// TODO: set the current color
	}

	/**
	 * Takes in color integer values [0-255], returns corresponding color-int value.
	 */
	public static int getColorEncoding(int red, int green, int blue) {
		// TODO: provide rgb color encoding
		return 1;
	}

	/**
	 * Returns the RGB value representing the current color.
	 */
	public int getColor() {
		// TODO return the current color setting
		return 1;
	}

	/**
	 * Takes in rectangle params, fills rectangle in canvas based on these.
	 */
	public void fillRect(int x, int y, int width, int height) {
		// draw a filled rectangle on the canvas, requires decision on its color
	}

	/**
	 * Takes in polygon params, fills polygon in canvas based on these.
	 * Paint is always that for corn.
	 */
	public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints){
		// translate the points into a path
		// draw a path on the canvas
	}

	/**
	 * Takes in line params, draws line in canvas based on these.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		// TODO: draw a line on the canvas
	}

	/**
	 * Takes in oval params, fills oval in canvas based on these.
	 */
	public void fillOval(int x, int y, int width, int height) {
		// TODO: draw an oval on the canvas
	}

}