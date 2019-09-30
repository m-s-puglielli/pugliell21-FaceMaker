package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView
{
	private Face face;

	public FaceView(Context c, AttributeSet as)
	{
		super(c, as);
		setWillNotDraw(false);

		face = new Face();
	}

	public void onDraw(Canvas c)
	{
		face.draw(c);

		this.invalidate();
	}

	public Face get_face() { return this.face; }
}
