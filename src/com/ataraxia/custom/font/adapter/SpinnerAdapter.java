package com.ataraxia.custom.font.adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ataraxia.custom.font.R;

public class SpinnerAdapter extends BaseAdapter {

	Context context;
	String[] strings;
	String fontPath;
	List<String> pathlist;

	public SpinnerAdapter(Context context, String[] strings, String fontPath) {
		super();
		this.context = context;
		this.strings = strings;
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
				fontPath);
		holder.text.setTypeface(tf);
		holder.text.setText(string);
		return convertView;
	}

	static class ViewHolder {
		TextView text;
	}
}