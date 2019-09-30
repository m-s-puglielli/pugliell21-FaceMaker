package com.example.facemaker;

import android.graphics.Paint;

public class FaceModel
{
	private int hair_color;
	private int eye_color;
	private int skin_color;
	private Paint hair_paint;
	private Paint eye_paint;
	private Paint skin_paint;

	public FaceModel()
	{
		this.hair_color = 0xffffffff;
		this.eye_color = 0xffffffff;
		this.skin_color = 0xffffffff;

		this.hair_paint = new Paint();
		this.eye_paint = new Paint();
		this.skin_paint = new Paint();

		this.set_hair_paint(this.hair_color);
		this.set_eye_paint(this.eye_color);
		this.set_skin_paint(this.skin_color);
	}

	public static int compile_color(int red, int green, int blue)
	{
		return ( (red * 256 * 256) | (green * 256) | blue );
	}

	public Paint get_hair_paint() { return this.hair_paint; }
	public Paint get_eye_paint() { return this.eye_paint; }
	public Paint get_skin_paint() { return this.skin_paint; }

	public void set_hair_paint(int hair_color)
	{
		this.hair_color = 0xff000000 | hair_color;
		this.hair_paint.setColor(this.hair_color);
	}

	public void set_eye_paint(int eye_color)
	{
		this.eye_color = 0xff000000 | eye_color;
		this.eye_paint.setColor(this.eye_color);
	}

	public void set_skin_paint(int skin_color)
	{
		this.skin_color = 0xff000000 | skin_color;
		this.skin_paint.setColor(this.skin_color);
	}
}
