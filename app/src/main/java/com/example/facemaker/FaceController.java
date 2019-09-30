package com.example.facemaker;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class FaceController implements	View.OnClickListener,
										SeekBar.OnSeekBarChangeListener,
										RadioGroup.OnCheckedChangeListener,
										AdapterView.OnItemSelectedListener
{
	private FaceView view;
	private FaceModel model;

	private SeekBar red;
	private SeekBar green;
	private SeekBar blue;

	private RadioGroup radio_group;

	private Attribute selected_attribute = Attribute.HAIR;
	private Style selected_style = Style.MUSTACHE;


	public FaceController(FaceView view, SeekBar red, SeekBar green, SeekBar blue, RadioGroup radio_group)
	{
		this.view = view;
		model = view.get_face_model();

		this.red = red;
		this.green = green;
		this.blue = blue;

		this.radio_group = radio_group;

		this.onClick(view);
	}

	public void onClick(View v)
	{
		view.get_face().randomize();

		switch(this.selected_attribute)
		{
			case HAIR:
				this.onCheckedChanged(radio_group, R.id.RadioButtonHair);
				break;

			case EYES:
				this.onCheckedChanged(radio_group, R.id.RadioButtonEyes);
				break;

			case SKIN:
				this.onCheckedChanged(radio_group, R.id.RadioButtonSkin);
				break;

			default:
				Log.d("FaceController.java:52", "ERROR: ENUM selected_attribute CORRUPTED");
				break;
		}

		view.invalidate();
	}

	public void onProgressChanged(SeekBar sb, int progress, boolean fromUser)
	{
		if(fromUser)
		{
			switch(this.selected_attribute)
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
					Log.d("FaceController.java:47", "ERROR: ENUM selected_attribute CORRUPTED");
					break;
			}
			this.view.invalidate();
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
				red.setProgress( FaceModel.decompile_paint(model.get_hair_paint(), 'r') );
				green.setProgress( FaceModel.decompile_paint(model.get_hair_paint(), 'g') );
				blue.setProgress( FaceModel.decompile_paint(model.get_hair_paint(), 'b') );
				break;

			case R.id.RadioButtonEyes:
				selected_attribute = Attribute.EYES;
				red.setProgress( FaceModel.decompile_paint(model.get_eye_paint(), 'r') );
				green.setProgress( FaceModel.decompile_paint(model.get_eye_paint(), 'g') );
				blue.setProgress( FaceModel.decompile_paint(model.get_eye_paint(), 'b') );
				break;

			case R.id.RadioButtonSkin:
				selected_attribute = Attribute.SKIN;
				red.setProgress( FaceModel.decompile_paint(model.get_skin_paint(), 'r') );
				green.setProgress( FaceModel.decompile_paint(model.get_skin_paint(), 'g') );
				blue.setProgress( FaceModel.decompile_paint(model.get_skin_paint(), 'b') );
				break;

			default:
				Log.d("FaceController.java:82", "ERROR: R.id checkedId CORRUPTED");
				break;
		}
	}

	public void onItemSelected(AdapterView parent, View view, int position, long id)
	{
		switch(position)
		{
			case 0:
				selected_style = Style.MUSTACHE;
				break;

			case 1:
				selected_style = Style.SOUL_PATCH;
				break;

			case 2:
				selected_style = Style.GOATEE;
				break;

			default:
				Log.d("FaceController.java:140", "ERROR: INVALID ENUM position PASSED TO onItemSelected()");
		}
		this.view.invalidate();
	}
	public void onNothingSelected(AdapterView parent) {}
}
