package me.pie.launchers;

import android.content.Context;

/**
 * Created by pie on 24/02/2016.
 */
public interface Launcher {
    public void setBadge(Context context, int count);

    public void removeBadge(Context context);
}
