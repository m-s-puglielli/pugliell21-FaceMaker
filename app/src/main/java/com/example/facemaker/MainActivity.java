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

		FaceView SurfaceViewFace = (FaceView) findViewById(R.id.FaceView);
		Button ButtonRandomize = (Button) findViewById(R.id.ButtonRandomize);
		SeekBar SeekBarRed = (SeekBar) findViewById(R.id.SeekBarRed);
		SeekBar SeekBarGreen = (SeekBar) findViewById(R.id.SeekBarGreen);
		SeekBar SeekBarBlue = (SeekBar) findViewById(R.id.SeekBarBlue);
		Spinner SpinnerHairStyle = (Spinner) findViewById(R.id.SpinnerStyles);
		RadioGroup RadioGroupAttributes = (RadioGroup) findViewById(R.id.RadioGroupHES);

		ArrayAdapter AdapterHairStyle = ArrayAdapter.createFromResource(this, R.array.styles, android.R.layout.simple_spinner_dropdown_item);
		AdapterHairStyle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		SpinnerHairStyle.setAdapter(AdapterHairStyle);

		FaceController controller = new FaceController(SurfaceViewFace, SeekBarRed, SeekBarGreen, SeekBarBlue, RadioGroupAttributes);
		ButtonRandomize.setOnClickListener(controller);
		SeekBarRed.setOnSeekBarChangeListener(controller);
		SeekBarGreen.setOnSeekBarChangeListener(controller);
		SeekBarBlue.setOnSeekBarChangeListener(controller);
		RadioGroupAttributes.setOnCheckedChangeListener(controller);
	}
}
