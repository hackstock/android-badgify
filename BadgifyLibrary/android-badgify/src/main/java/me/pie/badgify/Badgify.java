package me.pie.badgify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;

import java.util.List;

/**
 * Created by pie on 23/02/2016.
 */
public final class Badgify {

    private static String getLauncherClassName(Context context) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentActivities(intent, 0);

        for (ResolveInfo resolveInfo : resolveInfos) {
            String packageName = resolveInfo.activityInfo.applicationInfo.packageName;
            if (packageName.equalsIgnoreCase(context.getPackageName())) {
                return resolveInfo.activityInfo.name;
            }
        }
        return null;
    }

    private static Manufacturer getDeviceManufacturer() {
        String manufacturer = Build.MANUFACTURER;
        if (manufacturer.equalsIgnoreCase(Manufacturer.SAMSUNG.getCommonName())) {
            return Manufacturer.SAMSUNG;
        } else if (manufacturer.equalsIgnoreCase(Manufacturer.LG.getCommonName())) {
            return Manufacturer.LG;
        }

        return null;
    }

    public static void setBadge(Context context, int count) {
        Manufacturer manufacturer = Badgify.getDeviceManufacturer();
        String launcherClassName = Badgify.getLauncherClassName(context);

        if (launcherClassName == null) {
            return;
        }

        Intent intent = null;

        if (manufacturer != null) {
            switch (manufacturer) {
                case SAMSUNG:
                    intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
                    intent.putExtra("badge_count", count);
                    intent.putExtra("badge_count_package_name", context.getPackageName());
                    intent.putExtra("badge_count_class_name", launcherClassName);
                    break;
                case SONY:
                    intent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", launcherClassName);
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(count));
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", context.getPackageName());
                    break;
            }

            if (intent != null) {
                context.sendBroadcast(intent);
            }
        }

    }


    public static void removeBadge(Context context) {
        Manufacturer manufacturer = Badgify.getDeviceManufacturer();
        String launcherClassName = Badgify.getLauncherClassName(context);

        if (launcherClassName == null) {
            return;
        }

        Intent intent = null;

        if (manufacturer != null) {
            switch (manufacturer) {
                case SAMSUNG:
                    break;
                case SONY:
                    intent = new Intent();
                    intent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", launcherClassName);
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(0));
                    intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", context.getPackageName());
                    ;
                    break;
            }

            if (intent != null) {
                context.sendBroadcast(intent);
            }
        }
    }
}
