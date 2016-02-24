package me.pie.badgify;

import me.pie.launchers.AsusHomeLauncher;
import me.pie.launchers.DefaultHomeLauncher;
import me.pie.launchers.Launcher;
import me.pie.launchers.SamsungHomeLauncher;
import me.pie.launchers.SonyHomeLauncher;

/**
 * Created by pie on 24/02/2016.
 */
public class LauncherFactory {

    public static Launcher getLauncher(Manufacturer manufacturer) {
        Launcher launcher = null;
        switch (manufacturer) {
            case SAMSUNG:
                launcher = new SamsungHomeLauncher();
                break;
            case SONY:
                launcher = new SonyHomeLauncher();
                break;
            case ASUS:
                launcher = new AsusHomeLauncher();
                break;
            default:
                launcher = new DefaultHomeLauncher();
                break;
        }

        return launcher;
    }
}
