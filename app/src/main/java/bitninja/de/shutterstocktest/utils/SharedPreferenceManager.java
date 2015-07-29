package bitninja.de.shutterstocktest.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by dgrigutsch on 28.07.15.
 */
public class SharedPreferenceManager {

    public static final int DEFAULT_NUMBER_VALUE = 0;
    public static final String DEFAULT_STRING_VALUE = "";
    public static final boolean DEFAULT_BOOLEAN_VALUE = false;
    private SharedPreferences preferences;

    public SharedPreferenceManager(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public String getString(String key, String defaultValue) {
        return getPreferences().getString(key, defaultValue);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor e = getPreferences().edit();
        e.putString(key, value);
        e.apply();
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return getPreferences().getBoolean(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor e = getPreferences().edit();
        e.putBoolean(key, value);
        e.apply();
    }

    public long getLong(String key, long defaultValue) {
        return getPreferences().getLong(key, defaultValue);
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor e = getPreferences().edit();
        e.putLong(key, value);
        e.apply();
    }

    public int getInt(String key, int defaultValue) {
        return getPreferences().getInt(key, defaultValue);
    }

    public void putInt(String key, int value) {
        SharedPreferences.Editor e = getPreferences().edit();
        e.putInt(key, value);
        e.apply();
    }

    public void remove(String key) {
        SharedPreferences.Editor e = getPreferences().edit();
        e.remove(key);
        e.apply();
    }
}
