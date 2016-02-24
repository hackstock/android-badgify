package me.pie.launchers;

import android.content.Context;
import android.content.Intent;

import me.pie.badgify.Badgify;

/**
 * Created by pie on 24/02/2016.
 */
public class AsusHomeLauncher implements Launcher {

    @Override
    public void setBadge(Context context, int count) {
        Intent intent = new Intent(Badgify.IntentExtras.DefaultIntentExtras.INTENT_ACTION);
        intent.putExtra(Badgify.IntentExtras.DefaultIntentExtras.INTENT_EXTRA_BADGE_COUNT, count);
        intent.putExtra(Badgify.IntentExtras.DefaultIntentExtras.INTENT_EXTRA_PACKAGENAME, context.getPackageName());
        intent.putExtra(Badgify.IntentExtras.DefaultIntentExtras.INTENT_EXTRA_ACTIVITY_NAME, Badgify.getLauncherClassName(context));
        intent.putExtra(Badgify.IntentExtras.DefaultIntentExtras.INTENT_EXTRA_VIP_COUNT, 0);

        context.sendBroadcast(intent);
    }

    @Override
    public void removeBadge(Context context) {

    }
}
