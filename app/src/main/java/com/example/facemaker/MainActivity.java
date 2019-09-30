package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Spinner SpinnerHairStyle = (Spinner) findViewById(R.id.SpinnerHairStyle);
		ArrayAdapter AdapterHairStyle = ArrayAdapter.createFromResource(this, R.array.hair_styles, android.R.layout.simple_spinner_dropdown_item);
		AdapterHairStyle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		SpinnerHairStyle.setAdapter(AdapterHairStyle);

		FaceView SurfaceViewFace = (FaceView) findViewById(R.id.FaceView);
		FaceController controller = new FaceController(SurfaceViewFace);

		Button ButtonRandomize = (Button) findViewById(R.id.ButtonRandomize);
		ButtonRandomize.setOnClickListener(controller);
	}
}
