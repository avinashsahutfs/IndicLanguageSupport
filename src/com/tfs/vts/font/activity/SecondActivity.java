package com.tfs.vts.font.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.tfs.vts.font.R;
import com.tfs.vts.font.util.FontHelper;
import com.tfs.vts.font.util.Preferences;

public class SecondActivity extends Activity {

	TextView textView;
	Preferences language;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		language = new Preferences(this);
		FontHelper.applyFont(this, findViewById(R.id.activity_main_root),
				language.currentLanguage());
		textView = (TextView) findViewById(R.id.textView);
		textView.setText(getString(R.string.hello));
		String[] strings = { "ખાતરી ", "કરો કે ", "માટે ", "ટેક્સી", "યાહૂ ",
				"સેમસંગ" };
		Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
		mySpinner
				.setAdapter(new com.tfs.vts.font.adapter.SpinnerAdapter(
						this, strings));

	}

}
