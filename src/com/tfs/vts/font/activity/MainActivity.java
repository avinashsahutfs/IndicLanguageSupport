package com.tfs.vts.font.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tfs.vts.font.R;
import com.tfs.vts.font.util.FontHelper;
import com.tfs.vts.font.util.LanguagePreferences;

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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		language = new LanguagePreferences(this);
		this.savedInstanceState = savedInstanceState;
	}

	public void nextActivity(View v) {

		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
		startActivity(intent);

	}

	public void showDialog(View v) {
		final CharSequence[] items = { "English", "Hindi", "Gujarati",
				"Kannada", "Malayalam", "Marathi", "Oriya", "Telugu", "Tamil",
				"Bengali" };
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Pick a language");
		builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int which) {
			}
		});

		builder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						if ("English".equals(items[which])) {
							FontHelper.applyFont(MainActivity.this,
									findViewById(R.id.activity_main_root),
									"fonts/stylish.ttf");
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_HINDI);
							onCreate(savedInstanceState);
						} else if ("Hindi".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_HINDI);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_HINDI);
							onCreate(savedInstanceState);
						} else if ("Gujarati".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_GUJRATI);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_GUJRATI);
							onCreate(savedInstanceState);
						} else if ("Kannada".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_KANNADA);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_KANNADA);
							onCreate(savedInstanceState);
						} else if ("Malayalam".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_MALAYALAM);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_MALAYALAM);
							onCreate(savedInstanceState);
						} else if ("Marathi".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_MARATHI);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_MARATHI);
							onCreate(savedInstanceState);
						} else if ("Oriya".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_ORIYA);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_ORIYA);
							onCreate(savedInstanceState);
						} else if ("Telugu".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_TELUGU);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_TELUGU);
							onCreate(savedInstanceState);
						} else if ("Tamil".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_TAMIL);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_TAMIL);
							onCreate(savedInstanceState);
						} else if ("Bengali".equals(items[which])) {
							FontHelper
									.applyFont(
											MainActivity.this,
											findViewById(R.id.activity_main_root),
											com.tfs.vts.font.util.Constants.FONT_BENGALI);
							language.saveLanguage(
									"lang",
									com.tfs.vts.font.util.Constants.FONT_BENGALI);
							onCreate(savedInstanceState);
						}

					}
				});
		builder.show();

	}
}