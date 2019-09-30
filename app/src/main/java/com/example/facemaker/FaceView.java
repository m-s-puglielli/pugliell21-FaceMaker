package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView
{
	private Face face;
	private FaceModel model;

	public FaceView(Context c, AttributeSet as)
	{
		super(c, as);
		setWillNotDraw(false);

		this.model = new FaceModel();
		this.face = new Face(model);
	}

	public void onDraw(Canvas c)
	{
		face.draw(c);
	}

	public Face get_face() { return this.face; }
	public FaceModel get_face_model() { return this.model; }
}
