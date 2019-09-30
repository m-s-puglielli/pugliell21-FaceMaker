/**
 * @author Maximilian Puglielli
 */

package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class FaceView extends SurfaceView
{
	private Face face;
	private FaceModel model;

	/**
	 * This method is FaceView's constructor.
	 * @param c
	 * @param as
	 */
	public FaceView(Context c, AttributeSet as)
	{
		super(c, as);
		setWillNotDraw(false);

		// creates a FaceModel object
		this.model = new FaceModel();
		// creates a Face object, and passes the FaceModel object to the new Face object, through its constructor, so it can
		// read / edit FaceModel's variables.
		this.face = new Face(model);
	}

	/**
	 * This method is FaceView's onDraw method. It just calls face's draw method, becasue the Face
	 * class was setup to know how to draw itself.
	 * @param c
	 */
	public void onDraw(Canvas c) { face.draw(c); }

	public Face get_face() { return this.face; }
	public FaceModel get_face_model() { return this.model; }
}
