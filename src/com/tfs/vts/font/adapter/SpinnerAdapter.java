package com.tfs.vts.font.adapter;

import com.tfs.vts.font.R;
import com.tfs.vts.font.util.LanguagePreferences;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SpinnerAdapter extends BaseAdapter {

	Context context;
	String[] strings;
	LanguagePreferences language;

	public SpinnerAdapter(Context context, String[] strings) {
		super();
		this.context = context;
		this.strings = strings;
		language = new LanguagePreferences(context);
	}

	public int getCount() {
		return strings.length;
	}

	public Object getItem(int position) {
		return strings[position];
	}

	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint({ "ViewHolder", "ResourceAsColor" })
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		String string = strings[position];
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.spinner_row, parent, false);
			holder = new ViewHolder();
			holder.text = (TextView) convertView.findViewById(R.id.language);
			convertView.setTag(holder);
		}

		else {
			holder = (ViewHolder) convertView.getTag();
		}
		Typeface tf = Typeface.createFromAsset(context.getAssets(),
				language.currentLanguage());
		holder.text.setTypeface(tf);
		holder.text.setText(string);
		return convertView;
	}

	static class ViewHolder {
		TextView text;
	}
}