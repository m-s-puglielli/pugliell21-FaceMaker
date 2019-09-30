package com.example.facemaker;

import android.view.View;

public class FaceController implements View.OnClickListener
{
	private FaceView view;
	FaceModel model;

	public FaceController(FaceView view)
	{
		this.view = view;
		model = view.get_face_model();
	}

	public void onClick(View v)
	{
		view.invalidate();
	}
}
