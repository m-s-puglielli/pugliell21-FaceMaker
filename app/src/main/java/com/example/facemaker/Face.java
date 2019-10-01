/**
 * @author Maximilian Puglielli
 */

package com.example.facemaker;

import android.graphics.Canvas;
import android.util.Log;

import java.util.Random;

public class Face
{
	Random gen = new Random();
	private FaceModel model;


	/**
	 * This method is Face's constructor.
	 * @param model
	 */
	public Face(FaceModel model)
	{
		this.model = model;

		// automatically calls randomize on creation
		randomize();
	}

	/**
	 * This method randomizes the colors of the paints used to draw the hair, eyes, and skin.
	 */
	public void randomize()
	{
		model.set_hair_paint(gen.nextInt(0x00ffffff));
		model.set_eye_paint(gen.nextInt(0x00ffffff));
		model.set_skin_paint(gen.nextInt(0x00ffffff));
		model.set_nose_paint(gen.nextInt(0x00ffffff));
	}

	/**
	 * This method actually draws the face.
	 * @param c
	 */
	public void draw(Canvas c)
	{
		float center_x = (float) (c.getWidth() / 2);
		float center_y = (float) (c.getHeight() / 2);
		float screen_ratio = (float) (c.getWidth() / c.getHeight());

		this.draw_face(c, center_x, center_y);
		this.draw_nose(c, center_x, center_y);
		this.draw_eyes(c, center_x, center_y, screen_ratio);
		this.draw_mouth(c, center_x, center_y);

		switch(model.get_selected_style())
		{
			case MUSTACHE:
				this.draw_mustache(c, center_x, center_y);
				break;

			case SOUL_PATCH:
				this.draw_soul_patch(c, center_x, center_y);
				break;

			case GOATEE:
//				this.draw_goatee(c, center_x, center_y);
				break;

			default:
				Log.d("Face.java:71", "ERROR: ENUM selected_style CORRUPTED");
				break;
		}
	}

	private void draw_face(Canvas c, float center_x, float center_y)
	{
		c.drawOval(center_x * 0.7f, center_y * 0.05f, center_x * 1.3f, center_y * 1.95f, model.get_skin_paint());
	}

	private void draw_nose(Canvas c, float center_x, float center_y)
	{
		c.drawOval(center_x * 0.98f, center_y * 0.9f, center_x * 1.02f, center_y * 1.1f, model.get_nose_paint());
		center_y *= 1.1f;
		c.drawOval(center_x * 0.95f, center_y * 0.98f, center_x * 1.05f, center_y * 1.02f, model.get_nose_paint());
	}

	private void draw_eyes(Canvas c, float center_x, float center_y, float screen_ratio)
	{
		float new_center_y = center_y * 0.75f;
		float new_center_x = center_x * 0.85f;
		float circle_radius_multiplyer = 0.05f;
		c.drawOval(new_center_x - (center_x * circle_radius_multiplyer), new_center_y - (center_y * circle_radius_multiplyer * screen_ratio),
				new_center_x + (center_x * circle_radius_multiplyer), new_center_y + (center_y * circle_radius_multiplyer * screen_ratio),
						model.WHITE_PAINT);
		circle_radius_multiplyer = 0.025f;
		c.drawOval(new_center_x - (center_x * circle_radius_multiplyer), new_center_y - (center_y * circle_radius_multiplyer * screen_ratio),
				new_center_x + (center_x * circle_radius_multiplyer), new_center_y + (center_y * circle_radius_multiplyer * screen_ratio),
				model.get_eye_paint());
		circle_radius_multiplyer = 0.0125f;
		c.drawOval(new_center_x - (center_x * circle_radius_multiplyer), new_center_y - (center_y * circle_radius_multiplyer * screen_ratio),
				new_center_x + (center_x * circle_radius_multiplyer), new_center_y + (center_y * circle_radius_multiplyer * screen_ratio),
				model.BLACK_PAINT);

		new_center_x = center_x * 1.15f;
		circle_radius_multiplyer = 0.05f;
		c.drawOval(new_center_x - (center_x * circle_radius_multiplyer), new_center_y - (center_y * circle_radius_multiplyer * screen_ratio),
				new_center_x + (center_x * circle_radius_multiplyer), new_center_y + (center_y * circle_radius_multiplyer * screen_ratio),
				model.WHITE_PAINT);
		circle_radius_multiplyer = 0.025f;
		c.drawOval(new_center_x - (center_x * circle_radius_multiplyer), new_center_y - (center_y * circle_radius_multiplyer * screen_ratio),
				new_center_x + (center_x * circle_radius_multiplyer), new_center_y + (center_y * circle_radius_multiplyer * screen_ratio),
				model.get_eye_paint());
		circle_radius_multiplyer = 0.0125f;
		c.drawOval(new_center_x - (center_x * circle_radius_multiplyer), new_center_y - (center_y * circle_radius_multiplyer * screen_ratio),
				new_center_x + (center_x * circle_radius_multiplyer), new_center_y + (center_y * circle_radius_multiplyer * screen_ratio),
				model.BLACK_PAINT);
	}
	
	private void draw_mouth(Canvas c, float center_x, float center_y)
	{
		float new_center_y = center_y * 1.50f;
		c.drawOval(center_x * 0.85f, new_center_y - (center_y * 0.05f), center_x * 1.15f, new_center_y + (center_y * 0.05f), model.RED_PAINT);
		c.drawLine(center_x * 0.85f, new_center_y, center_x * 1.15f, new_center_y, model.BLACK_PAINT);
	}

	private void draw_mustache(Canvas c, float center_x, float center_y)
	{
		float new_center_y = center_y * 1.25f;
		c.drawRect(center_x * 0.85f, new_center_y - (center_y * 0.05f), center_x * 1.15f, new_center_y + (center_y * 0.05f), model.BLACK_PAINT);
	}

	private void draw_soul_patch(Canvas c, float center_x, float center_y)
	{
		float new_center_y = center_y * 1.75f;
		c.drawRect(center_x * 0.85f, new_center_y - (center_y * 0.05f), center_x * 1.15f, new_center_y + (center_y * 0.05f), model.BLACK_PAINT);
	}
}
