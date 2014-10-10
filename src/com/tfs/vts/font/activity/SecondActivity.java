package com.tfs.vts.font.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tfs.vts.font.R;
import com.tfs.vts.font.util.CommonViewFunctions;
import com.tfs.vts.font.util.DialogOkClickListner;
import com.tfs.vts.font.util.FontHelper;
import com.tfs.vts.font.util.LanguagePreferences;

public class SecondActivity extends Activity {

	TextView textView;
	LanguagePreferences language;
	CommonViewFunctions commonViews;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		language = new LanguagePreferences(this);
		FontHelper.applyFont(this, findViewById(R.id.activity_main_root),
				language.currentLanguage());
		textView = (TextView) findViewById(R.id.textView);
		Button button = (Button) findViewById(R.id.button);
		commonViews = new CommonViewFunctions(this);
		
		AsyncTask<Void, Void, Void> task = new MyAsyncTask();
		task.execute();
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				commonViews.showDailog(new DialogOkClickListner() {

					public void onOkClick() {
						commonViews.showToast("ખાતરી " + "કરો કે " + "માટે "
								+ "ટેક્સી" + "યાહૂ ", Toast.LENGTH_LONG);
					}
				}, "TaxiForSure", "કેટલાક લાંબા લખાણ અનુવાદ લખાણ ", "બરાબર ");
			}
		});
		textView.setText(getString(R.string.hello));
		String[] strings = { "ખાતરી ", "કરો કે ", "માટે ", "ટેક્સી", "યાહૂ ",
				"સેમસંગ" };
		Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
		mySpinner.setAdapter(new com.tfs.vts.font.adapter.SpinnerAdapter(this,
				strings));

	}
	public class MyAsyncTask extends AsyncTask<Void, Void, Void>{
		ProgressDialog dialog = commonViews.showProgressDialog("શીર્ષક",
				"સંદેશ", true, true, false);
		@Override
		protected void onPreExecute() {
			dialog.show();
			super.onPreExecute();
		}
		@Override
		protected Void doInBackground(Void... params) {
			 try {
				    int time = Integer.parseInt("5000");    
				    Thread.sleep(time);
				   } catch (InterruptedException e) {
				    e.printStackTrace();
				   } catch (Exception e) {
				    e.printStackTrace();
				   }
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			dialog.dismiss();
		}

	}


}
