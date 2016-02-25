# Android-Badgify
This is a library for adding badges to app icons on various devices. Below is an example of an app showing a badge (number) on it's app icons.

![enter image description here](https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSZggTI1u853w574t3Grnx6H-dIgH8ZDFo6G4T-sgvFBteqAd04)

# Setup
- Add compile 'me.pie:android-badgify:1.0.2' to build.gradle
- Click "Sync project with gradle files" in android studio

# Usage
## Setting Badges
Badgify.setBadge(Context context,int count);
## Removing Badges
Badgify.removeBadge(Context context);
## Getting Current Badge Value
Badgify.getCurrentBadgeValue();

## Required Permissions
Permission required are dependent on the manufacturer of the device. Be guided by the list of permissions below to know which one(s) to include in your AndroidManifest.xml.
### Generic Android Badge
    <uses-permission android:name="com.android.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.android.launcher.permission.WRITE_SETTINGS"/>
### Samsung Badge
    <uses-permission android:name="com.sec.android.provider.badge.permission.READ"/>
    <uses-permission android:name="com.sec.android.provider.badge.permission.WRITE"/>
### HTC Badge
    <uses-permission android:name="com.htc.launcher.permission.READ_SETTINGS"/>
    <uses-permission android:name="com.htc.launcher.permission.UPDATE_SHORTCUT"/>
### Sony Badge
    <uses-permission android:name="com.sonyericsson.home.permission.BROADCAST_BADGE"/>
### Apex Badge
    <uses-permission android:name="com.anddoes.launcher.permission.UPDATE_COUNT"/>
    
# Contact me for help on this library
-Email : hackstockpie@gmail.com
-Mobile : +233 200 662 782

  