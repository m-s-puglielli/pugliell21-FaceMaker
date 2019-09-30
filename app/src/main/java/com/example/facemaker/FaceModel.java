/**
 * @author Maximilian Puglielli
 */

package com.example.facemaker;

import android.graphics.Paint;
import android.util.Log;

public class FaceModel
{
	private int hair_color;
	private int eye_color;
	private int skin_color;
	private Paint hair_paint;
	private Paint eye_paint;
	private Paint skin_paint;

	private Attribute selected_attribute;
	private Style selected_style;

	/**
	 * This method is FaceModel's constructor.
	 */
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

		this.selected_attribute = Attribute.HAIR;
		this.selected_style = Style.MUSTACHE;
	}

	/**
	 * This method is static because its not a method, its a function, which is completely
	 * independent of the FaceModel object.
	 * This function just takes three integers for red, green, and blue color values, and it
	 * compiles a color integer which represents those rgb values together. That returned integer is used to
	 * set the paint variables of this class. For an example, see FaceController.java:74.
	 * @param red
	 * @param green
	 * @param blue
	 * @return
	 */
	public static int compile_color(int red, int green, int blue)
	{
		return ( (red * 256 * 256) | (green * 256) | blue );
	}

	/**
	 * This method is static because its not a method, its a function, which is completely
	 * independent of the FaceModel object.
	 * This function just takes a paint and a char, and it returns the red, green, or blue color
	 * value from that paints color integer, based on if the char was 'r', 'g', or 'b'.
	 * @param paint
	 * @param rgb
	 * @return
	 */
	public static int decompile_paint(Paint paint, char rgb)
	{
		switch(rgb)
		{
			case 'b':
				return 0xff & paint.getColor();

			case 'g':
				return 0xff & (paint.getColor() >> 8);

			case 'r':
				return 0xff & (paint.getColor() >> 16);

			default:
				Log.d("FaceModel.java:52", "ERROR: MISUSE OF decompile_paint()");
				return 0;
		}
	}

//	public int get_hair_color() { return this.hair_color; }
//	public int get_eye_color() { return this.eye_color; }
//	public int get_skin_color() { return this.skin_color; }
	public Paint get_hair_paint() { return this.hair_paint; }
	public Paint get_eye_paint() { return this.eye_paint; }
	public Paint get_skin_paint() { return this.skin_paint; }
	public Attribute get_selected_attribute() { return this.selected_attribute; }
	public Style get_selected_style() { return this.selected_style; }

	public void set_hair_paint(int hair_color)
	{
		// ensures that all colors' opacity (alpha value) is set to 100%
		this.hair_color = 0xff000000 | hair_color;

		this.hair_paint.setColor(this.hair_color);
	}
	public void set_eye_paint(int eye_color)
	{
		// ensures that all colors' opacity (alpha value) is set to 100%
		this.eye_color = 0xff000000 | eye_color;

		this.eye_paint.setColor(this.eye_color);
	}
	public void set_skin_paint(int skin_color)
	{
		// ensures that all colors' opacity (alpha value) is set to 100%
		this.skin_color = 0xff000000 | skin_color;

		this.skin_paint.setColor(this.skin_color);
	}
	public void set_selected_attribute(Attribute selected_attribute) { this.selected_attribute = selected_attribute; }
	public void set_selected_style(Style selected_style) { this.selected_style = selected_style; }
}
