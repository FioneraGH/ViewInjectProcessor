package com.fionera.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Locale;

/**
 * TestReceiver
 * Created by fionera on 17-8-14 in IocProcessor.
 */

public class TestReceiver
        extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("TestReceiver", String.format(Locale.CHINA, "Received:%s", intent.getAction()));
    }
}
