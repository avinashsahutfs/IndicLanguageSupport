package com.tfs.vts.font.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tfs.vts.font.R;

public class CommonViewFunctions {

	Context context;
	LanguagePreferences preferences;

	public CommonViewFunctions(Context context) {
		this.context = context;
		preferences = new LanguagePreferences(context);
	}

	/**
	 * Shows custom dialog with custom font
	 * 
	 * @param context
	 *            Context of calling activity
	 * @param listner
	 *            Dialog OK button click listener
	 * @param title
	 *            Title text for dialog box
	 * @param message
	 *            Message text for dialog box
	 * @param buttonText
	 *            OK button text
	 */
	public void showDailog(Context context, final DialogOkClickListner listner,
			String title, String message, String buttonText) {
		Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.dialog_layout);
		TextView titleText = (TextView) dialog.findViewById(R.id.title);
		TextView messageText = (TextView) dialog.findViewById(R.id.message);
		Button okButton = (Button) dialog.findViewById(R.id.ok);
		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				preferences.currentLanguage());
		titleText.setTypeface(tf);
		messageText.setTypeface(tf);
		okButton.setTypeface(tf);
		titleText.setText(title);
		messageText.setText(message);
		okButton.setText(buttonText);
		dialog.show();
		okButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				listner.onOkClick();
			}
		});
	}

	/**
	 * Displays custom toast message with custom font and custom font size
	 * 
	 * @param context
	 *            Context of calling activity
	 * @param text
	 *            Text to be displayed as toast message
	 * @param duration
	 *            Duration of message in milliseconds e.g. Toast.LENGTH_LONG or
	 *            3000
	 */
	public void showToast(Context context, String text, int duration) {
		Toast toast = Toast.makeText(context, text, duration);
		LinearLayout toastLayout = (LinearLayout) toast.getView();
		TextView toastTV = (TextView) toastLayout.getChildAt(0);
		toastTV.setTextSize(20);
		toastTV.setTypeface(Typeface.createFromAsset(context.getAssets(),
				preferences.currentLanguage()));
		toast.show();
	}
}
