/**
 * @author Maximilian Puglielli
 */

package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);



		/******************************************************************************************
		 * This block of code creates various objects, and connects them to the widgets from the
		 * app's layout.
		 */
		FaceView SurfaceViewFace = (FaceView) findViewById(R.id.FaceView);
		Button ButtonRandomize = (Button) findViewById(R.id.ButtonRandomize);
		SeekBar SeekBarRed = (SeekBar) findViewById(R.id.SeekBarRed);
		SeekBar SeekBarGreen = (SeekBar) findViewById(R.id.SeekBarGreen);
		SeekBar SeekBarBlue = (SeekBar) findViewById(R.id.SeekBarBlue);

		// This code creates a Spinner object (SpinnerStyles), and connects it to the Spinner widget
		// from the layout (SpinnerStyles).
		Spinner SpinnerStyles = (Spinner) findViewById(R.id.SpinnerStyles);
		// This code connects the styles array from strings.xml to SpinnerStyles such that it shows
		// the various dropdown options (Mustache, Soul Patch, & Goatee) from the styles array.
		// It also uses a predefined spinner layout: simple_spinner_dropdown_item.
		/**
		 * EXTERNAL CITATION
		 * 	Date:		29 September 2019
		 * 	Problem:	I had absolutely no idea how to setup a spinner widget.
		 * 	Resource:	https://www.youtube.com/watch?v=on_OrrX7Nw4
		 * 	Solution:	I used the example code from this youtube video, and learned about
		 * 		 		how it works. Its a pretty good video, and this guy has more android studio
		 * 		 		tutorials on his channel.
		 */
		ArrayAdapter<CharSequence> AdapterStyle = ArrayAdapter.createFromResource(
				this, R.array.styles, android.R.layout.simple_spinner_item);
		AdapterStyle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		SpinnerStyles.setAdapter(AdapterStyle);

		RadioGroup RadioGroupHES = (RadioGroup) findViewById(R.id.RadioGroupHES);
		/*****************************************************************************************/



		/******************************************************************************************
		 * This block of code creates a FaceController object (controller), and passes the
		 * previously created SurfaceView, SeekBar, & RadioGroup objects to it, such that it can
		 * keep track of them.
		 * Then, it turns on all the listeners by passing controller, which implements all the
		 * listening interfaces, to the various listening widgets objects.
		 */
		FaceController controller = new FaceController(	SurfaceViewFace, SeekBarRed, SeekBarGreen,
														SeekBarBlue, RadioGroupHES, SpinnerStyles);
		ButtonRandomize.setOnClickListener(controller);
		SeekBarRed.setOnSeekBarChangeListener(controller);
		SeekBarGreen.setOnSeekBarChangeListener(controller);
		SeekBarBlue.setOnSeekBarChangeListener(controller);
		SpinnerStyles.setOnItemSelectedListener(controller);
		RadioGroupHES.setOnCheckedChangeListener(controller);
		/*****************************************************************************************/
	}
}
