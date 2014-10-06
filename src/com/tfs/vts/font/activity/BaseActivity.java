package com.tfs.vts.font.activity;

import com.tfs.vts.font.R;
import com.tfs.vts.font.util.FontHelper;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FontHelper.applyFont(this, findViewById(R.id.activity_main_root),
				"fonts/stylish.ttf");
	}
}
