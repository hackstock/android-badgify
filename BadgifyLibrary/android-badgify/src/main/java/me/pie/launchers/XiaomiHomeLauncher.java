package me.pie.launchers;

import android.content.Context;
import android.content.Intent;

import java.lang.reflect.Field;

import me.pie.badgify.Badgify;

/**
 * Created by pie on 24/02/2016.
 */
public class XiaomiHomeLauncher implements Launcher {

    public static final String INTENT_ACTION = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
    public static final String EXTRA_UPDATE_APP_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
    public static final String EXTRA_UPDATE_APP_MSG_TEXT = "android.intent.extra.update_application_message_text";

    @Override
    public void setBadge(Context context, int count) {
        try {
            Class miuiNotificationClass = Class.forName("android.app.MiuiNotification");
            Object miuiNotification = miuiNotificationClass.newInstance();
            Field field = miuiNotification.getClass().getDeclaredField("messageCount");
            field.setAccessible(true);
            field.set(miuiNotification, String.valueOf(count == 0 ? "" : count));
        } catch (Exception e) {
            Intent localIntent = new Intent(
                    INTENT_ACTION);
            localIntent.putExtra(EXTRA_UPDATE_APP_COMPONENT_NAME, context.getPackageName() + "/" + Badgify.getLauncherClassName(context));
            localIntent.putExtra(EXTRA_UPDATE_APP_MSG_TEXT, String.valueOf(count == 0 ? "" : count));
            context.sendBroadcast(localIntent);
        }
    }

    @Override
    public void removeBadge(Context context) {

    }
}
