package com.example.facemaker;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.Random;

public class Face
{
	private Random gen = new Random();

	private int skin_color;
	private int eye_color;
	private int hair_color;
	private Paint skin_paint;
	private Paint eye_paint;
	private Paint hair_paint;

	private int hair_style;

	private FaceModel model;



	public Face(FaceModel model)
	{
		this.model = model;

		this.skin_paint = new Paint();
		this.eye_paint = new Paint();
		this.hair_paint = new Paint();

		this.hair_style = 0;

		randomize();
	}

	public void randomize()
	{
		this.skin_color = gen.nextInt(0x00ffffff);
		this.skin_color |= 0xff000000;
		this.skin_paint.setColor(skin_color);

		this.eye_color = gen.nextInt(0x00ffffff);
		this.eye_color |= 0xff000000;
		this.eye_paint.setColor(eye_color);

		this.hair_color = gen.nextInt(0x00ffffff);
		this.hair_color |= 0xff000000;
		this.hair_paint.setColor(hair_color);
	}

	public void draw(Canvas c)
	{
		model.x_pos = (float) gen.nextInt(300) + 200;
		model.y_pos = (float) gen.nextInt(300) + 200;
		c.drawOval(model.x_pos, model.y_pos, model.x_pos + 100.0f, model.y_pos + 100.0f, skin_paint);
	}
}
