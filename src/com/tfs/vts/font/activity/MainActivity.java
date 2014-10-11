package com.tfs.vts.font.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tfs.vts.font.R;
import com.tfs.vts.font.preference.LanguagePreferences;

/**
 * Activity class to manage UI screen with demonstration of custom font usage.
 * 
 * @author Avinash Sahu
 * 
 */
public class MainActivity extends Activity {
	LanguagePreferences language;
	Dialog dialog;
	Bundle savedInstanceState;
	public static int count = 0;
	final CharSequence[] languages = { "English", "Hindi", "Gujarati" };
	final int[] langids = { 0, 1, 2 };

	final String[] fontpath = { "DEFAULT",
			"fonts/notosansdevanagariregular.ttf",
			"fonts/NotoSansGujarati-Regular.ttf" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		language = new LanguagePreferences(this);
		this.savedInstanceState = savedInstanceState;
		if (count == 0)
			showLanguageChooser(langids, fontpath);
	}

	private void showLanguageChooser(final int[] ids, final String[] paths) {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a language");
		builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
			}
		});

		builder.setSingleChoiceItems(languages, -1,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						if (languages[ids[0]].equals(languages[which])) {
							language.saveLanguage("lang", fontpath[0]);
						} else if (languages[ids[1]].equals(languages[which])) {
							language.saveLanguage("lang", paths[1]);
							onCreate(savedInstanceState);
						} else if (languages[ids[2]].equals(languages[which])) {
							language.saveLanguage("lang", fontpath[2]);
							onCreate(savedInstanceState);
						}
					}
				});
		builder.show();
		count++;
	}

	public void nextActivity(View v) {

		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		startActivity(intent);

	}
}