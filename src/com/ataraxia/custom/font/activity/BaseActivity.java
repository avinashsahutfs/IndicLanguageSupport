package com.ataraxia.custom.font.activity;

import android.app.Activity;
import android.os.Bundle;

import com.ataraxia.custom.font.R;
import com.ataraxia.custom.font.helper.FontHelper;

public abstract class BaseActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FontHelper.applyFont(this, findViewById(R.id.activity_main_root),
				"fonts/stylish.ttf");
	}
}
