/*
 *  SamsungParts
 */

package com.eun9115.samsungparts;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.app.Fragment;
import androidx.preference.PreferenceFragment;
import androidx.preference.Preference;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import androidx.preference.TwoStatePreference;

import com.eun0115.samsungparts.settings.ScreenOffGestureSettings;
import com.eun0115.samsungparts.doze.DozeSettingsActivity;
import com.eun0115.samsungparts.vibration.VibratorStrengthPreference;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

import android.util.Log;
import android.os.SystemProperties;
import java.io.*;
import android.widget.Toast;

import com.eun0115.samsungparts.R;

public class SamsungParts extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    private static final boolean DEBUG = true;
    private static final String TAG = "SamsungParts";

    private Preference mDozePref;
    private Preference mGesturesPref;
    private Context mContext;
    private SharedPreferences mPreferences;
    private VibratorStrengthPreference mVibratorStrength;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.samsungparts, rootKey);
        mGesturesPref = findPreference("screen_gestures");
                mGesturesPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                     @Override
                     public boolean onPreferenceClick(Preference preference) {
                         Intent intent = new Intent(getContext(), ScreenOffGestureSettings.class);
                         startActivity(intent);
                         return true;
                     }
                });
	mDozePref = findPreference("doze");
               mDozePref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                     @Override
                     public boolean onPreferenceClick(Preference preference) {
                         Intent intent = new Intent(getContext(), DozeSettingsActivity.class);
                         startActivity(intent);
                         return true;
                     }
                });

        mVibratorStrength = (VibratorStrengthPreference) findPreference(VibratorStrengthPreference.KEY_VIBSTRENGTH);
        mVibratorStrength.setEnabled(VibratorStrengthPreference.isSupported());
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        return super.onPreferenceTreeClick(preference);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            return true;
        default:
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        final String key = preference.getKey();
        return true;
    }
}
