package com.example.facemaker;

import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener
{
	private FaceView view;
	private FaceModel model;

	private SeekBar red;
	private SeekBar green;
	private SeekBar blue;

	private RadioGroup radio_group;

	private Attribute selected_attribute = Attribute.HAIR;


	public FaceController(FaceView view, SeekBar red, SeekBar green, SeekBar blue, RadioGroup radio_group)
	{
		this.view = view;
		model = view.get_face_model();

		this.red = red;
		this.green = green;
		this.blue = blue;

		this.radio_group = radio_group;
	}

	public void onClick(View v)
	{
		view.get_face().randomize();
		view.invalidate();
	}

	public void onProgressChanged(SeekBar sb, int progress, boolean fromUser)
	{
		if(fromUser)
		{
			switch(selected_attribute)
			{
				case HAIR:
					model.set_hair_paint( FaceModel.compile_color(red.getProgress(), green.getProgress(), blue.getProgress()) );
					break;
				case EYES:
					model.set_eye_paint( FaceModel.compile_color(red.getProgress(), green.getProgress(), blue.getProgress()) );
					break;
				case SKIN:
					model.set_skin_paint( FaceModel.compile_color(red.getProgress(), green.getProgress(), blue.getProgress()) );
					break;
				default:
					Log.d("FaceController.java:47", "ERROR ENUM selected_attribute CORRUPTED");
					break;
			}
			view.invalidate();
		}
	}
	public void onStartTrackingTouch(SeekBar sb) {}
	public void onStopTrackingTouch(SeekBar sb) {}

	public void onCheckedChanged(RadioGroup group, int checkedId)
	{
		switch(checkedId)
		{
			case R.id.RadioButtonHair:
				selected_attribute = Attribute.HAIR;
				break;

			case R.id.RadioButtonEyes:
				selected_attribute = Attribute.EYES;
				break;

			case R.id.RadioButtonSkin:
				selected_attribute = Attribute.SKIN;
				break;

			default:
				Log.d("FaceController.java:82", "ERROR R.id checkedId CORRUPTED");
				break;
		}
	}
}
