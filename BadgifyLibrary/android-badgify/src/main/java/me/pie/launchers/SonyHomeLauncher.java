package me.pie.launchers;

import android.content.Context;
import android.content.Intent;

import me.pie.badgify.Badgify;

/**
 * Created by pie on 24/02/2016.
 */
public class SonyHomeLauncher implements Launcher {

    @Override
    public void setBadge(Context context, int count) {
        Intent intent = new Intent();
        intent.setAction(Badgify.IntentExtras.SonyIntentExtras.INTENT_ACTION);
        intent.putExtra(Badgify.IntentExtras.SonyIntentExtras.INTENT_EXTRA_ACTIVITY_NAME, Badgify.getLauncherClassName(context));
        intent.putExtra(Badgify.IntentExtras.SonyIntentExtras.INTENT_EXTRA_SHOW_MESSAGE, count > 0);
        intent.putExtra(Badgify.IntentExtras.SonyIntentExtras.INTENT_EXTRA_MESSAGE, String.valueOf(count));
        intent.putExtra(Badgify.IntentExtras.SonyIntentExtras.INTENT_EXTRA_PACKAGE_NAME, context.getPackageName());
    }

    @Override
    public void removeBadge(Context context) {
        setBadge(context, 0);
    }
}
