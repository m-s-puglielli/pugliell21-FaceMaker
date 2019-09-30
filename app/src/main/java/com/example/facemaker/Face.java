package com.example.facemaker;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.Random;

public class Face
{
	private Random gen = new Random();
	private FaceModel model;



	public Face(FaceModel model)
	{
		this.model = model;

		randomize();
	}

	public void randomize()
	{
		model.set_hair_paint(gen.nextInt(0x00ffffff));
		model.set_eye_paint(gen.nextInt(0x00ffffff));
		model.set_skin_paint(gen.nextInt(0x00ffffff));
	}

	public void draw(Canvas c)
	{
		Paint white_paint = new Paint();
		white_paint.setColor(0xffffffff);
		c.drawOval(100f, 200f, 200f, 300f, model.get_hair_paint());
		c.drawOval(200f, 300f, 300f, 400f, model.get_eye_paint());
		c.drawOval(300f, 400f, 400f, 500f, model.get_skin_paint());
	}
}
