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
    private static int CURRENT_BADGE_VALUE = 0;

    public static String getLauncherClassName(Context context) {
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

    public static Manufacturer getDeviceManufacturer() {
        String manufacturer = Build.MANUFACTURER;
        if (manufacturer.equalsIgnoreCase(Manufacturer.SAMSUNG.getCommonName())) {
            return Manufacturer.SAMSUNG;
        } else if (manufacturer.equalsIgnoreCase(Manufacturer.LG.getCommonName())) {
            return Manufacturer.LG;
        } else if (manufacturer.equalsIgnoreCase(Manufacturer.SONY.getCommonName())) {
            return Manufacturer.SONY;
        } else if (manufacturer.equalsIgnoreCase(Manufacturer.HTC.getCommonName())) {
            return Manufacturer.HTC;
        } else if (manufacturer.equalsIgnoreCase(Manufacturer.XIAOMI.getCommonName())) {
            return Manufacturer.XIAOMI;
        }

        return Manufacturer.UNKNOWN;
    }

    public static void setBadge(Context context, int count) {
        Manufacturer manufacturer = Badgify.getDeviceManufacturer();

        LauncherFactory.getLauncher(manufacturer).setBadge(context, count);
        Badgify.CURRENT_BADGE_VALUE = count;
    }


    public static void removeBadge(Context context) {
        Manufacturer manufacturer = Badgify.getDeviceManufacturer();

        LauncherFactory.getLauncher(manufacturer).removeBadge(context);
        Badgify.CURRENT_BADGE_VALUE = 0;
    }

    public static int getCurrentBadgeValue() {
        return Badgify.CURRENT_BADGE_VALUE;
    }

    public static class IntentExtras {
        public static class DefaultIntentExtras {
            public static final String INTENT_ACTION = "android.intent.action.BADGE_COUNT_UPDATE";
            public static final String INTENT_EXTRA_BADGE_COUNT = "badge_count";
            public static final String INTENT_EXTRA_PACKAGENAME = "badge_count_package_name";
            public static final String INTENT_EXTRA_ACTIVITY_NAME = "badge_count_class_name";
            public static final String INTENT_EXTRA_VIP_COUNT = "badge_vip_count";
        }

        public static class SonyIntentExtras {
            public static final String INTENT_ACTION = "com.sonyericsson.home.action.UPDATE_BADGE";
            public static final String INTENT_EXTRA_PACKAGE_NAME = "com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME";
            public static final String INTENT_EXTRA_ACTIVITY_NAME = "com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME";
            public static final String INTENT_EXTRA_MESSAGE = "com.sonyericsson.home.intent.extra.badge.MESSAGE";
            public static final String INTENT_EXTRA_SHOW_MESSAGE = "com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE";
        }
    }

}
