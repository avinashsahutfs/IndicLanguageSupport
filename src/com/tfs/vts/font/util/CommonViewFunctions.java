package com.tfs.vts.font.util;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tfs.vts.font.R;

@TargetApi(Build.VERSION_CODES.FROYO)
public class CommonViewFunctions {

	Context context;
	LanguagePreferences preferences;

	/**
	 * @param context
	 *            Context of calling activity
	 */
	public CommonViewFunctions(Context context) {
		this.context = context;
		preferences = new LanguagePreferences(context);
	}

	/**
	 * Shows custom dialog with custom font
	 * 
	 * @param listner
	 *            Dialog OK button click listener
	 * @param title
	 *            Title text for dialog box
	 * @param message
	 *            Message text for dialog box
	 * @param buttonText
	 *            OK button text
	 */
	public void showDailog(final DialogOkClickListner listner, String title,
			String message, String buttonText) {
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.dialog_layout);
		LinearLayout ll1 = (LinearLayout) dialog.findViewById(R.id.ll1);
		LinearLayout ll2 = (LinearLayout) dialog.findViewById(R.id.ll2);
		RelativeLayout ll3 = (RelativeLayout) dialog.findViewById(R.id.rl1);
		ll1.setBackgroundColor(Color.BLACK);
		ll2.setBackgroundColor(Color.WHITE);
		ll3.setBackgroundColor(Color.BLACK);
		TextView titleText = (TextView) dialog.findViewById(R.id.title);
		TextView messageText = (TextView) dialog.findViewById(R.id.message);
		Button okButton = (Button) dialog.findViewById(R.id.ok);
		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				preferences.currentLanguage());

		titleText.setTypeface(tf);
		messageText.setTypeface(tf);
		okButton.setTypeface(tf);

		messageText.setTextColor(Color.BLACK);

		titleText.setTextSize(20);
		messageText.setTextSize(20);
		okButton.setTextSize(20);

		titleText.setText(title);
		messageText.setText(message);
		okButton.setText(buttonText);

		dialog.show();
		Window window = dialog.getWindow();
		window.setLayout(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		okButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				listner.onOkClick();
				dialog.dismiss();
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
	public void showToast(String text, int duration) {
		Toast toast = Toast.makeText(context, text, duration);
		LinearLayout toastLayout = (LinearLayout) toast.getView();
		toastLayout.setBackgroundColor(Color.YELLOW);
		TextView toastTV = (TextView) toastLayout.getChildAt(0);
		toastTV.setTextColor(Color.BLACK);
		toastTV.setTextSize(20);
		toastTV.setTypeface(Typeface.createFromAsset(context.getAssets(),
				preferences.currentLanguage()));
		toast.show();
	}

	/**
	 * Show custom Progress dialog with custom fonts
	 * 
	 * @param title
	 *            Title of progress dialog
	 * @param message
	 *            Progress Dialog Message
	 * @param indeterminate
	 * @param cancelable
	 * @param cancelableOnTouchOutSide
	 * @param cancelListener
	 * @return ProgressDialog with custom fonts
	 */
	public ProgressDialog showProgressDialog(final String title, final String message,
			boolean indeterminate, boolean cancelable, boolean cancelableOnTouchOutSide) {
		ProgressDialog pDialog = new ProgressDialog(context);
		pDialog.setTitle(title);
		pDialog.setIndeterminate(indeterminate);
		pDialog.setCancelable(cancelable);
		pDialog.setCanceledOnTouchOutside(cancelableOnTouchOutSide);
		pDialog.setMessage(message);
		((AlertDialog) pDialog)
				.setOnShowListener(new DialogInterface.OnShowListener() {
					public void onShow(DialogInterface dialog) {
						final int idAlertTitle = context.getResources().getIdentifier("alertTitle", "id", "android");
						TextView textMessage = (TextView) ((AlertDialog) dialog).findViewById(android.R.id.message);
						TextView textTitle = (TextView) ((AlertDialog) dialog).findViewById(idAlertTitle);
						textMessage.setTypeface(Typeface.createFromAsset(context.getAssets(),preferences.currentLanguage()));
						textTitle.setTypeface(Typeface.createFromAsset(context.getAssets(),preferences.currentLanguage()));
					}
				});
		return pDialog;

	}

	
}
