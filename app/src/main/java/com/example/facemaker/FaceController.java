package com.example.facemaker;

import android.view.MotionEvent;
import android.view.View;

public class FaceController implements View.OnTouchListener
{
	private FaceView face;
	private FaceModel model;

	public FaceController(FaceView face)
	{
		this.face = face;
		model = face.get_face().get_face_model();
	}

	public boolean onTouch(View v, MotionEvent e)
	{
		model.x_pos = e.getX();
		model.y_pos = e.getY();

		face.invalidate();

		return true;
	}
}
