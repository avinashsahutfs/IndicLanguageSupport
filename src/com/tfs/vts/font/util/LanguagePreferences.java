package com.tfs.vts.font.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LanguagePreferences {
    SharedPreferences pref;
    Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "LanguagePref";
    public static final String KEY_LANGUAGE = "lang";

    public LanguagePreferences(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        editor.commit();
    }
     
    /**
     * Store current language
     * */
    public void saveLanguage(String name, String language){
        // Storing language in pref
        editor.putString(KEY_LANGUAGE, language);
        // commit changes
        editor.commit();
    }  
    /**
     * Quick check for current language
     * **/
    // Get current language 
    public String currentLanguage(){
    	String lang =pref.getString(KEY_LANGUAGE, "DEFAULT");
        return lang;
    }
	
}
