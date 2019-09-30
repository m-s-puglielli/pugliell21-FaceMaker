/**
 * @author Maximilian Puglielli
 */

package com.example.facemaker;

/**
 * This ENUM class is associated with the spinner widget SpinnerStyle. This ENUM has been given a variable
 * position : int, because the onItemSelected() method in FaceController, associated with the
 * AdapterView.OnItemSelectedListener interface, has a parameter position : int, which is 0 if
 * Mustache is selected, 1 if Soul Patch is selected, and 2 if Goatee is selected. Therefore, this
 * ENUM class reflects that feature of the API.
 */
public enum Style
{
	MUSTACHE(0), SOUL_PATCH(1), GOATEE(2);

	public int position;
	Style(int position) { this.position = position; }
}
