package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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
	}
}
