package juzi.com.replacefontsdemo.view.global;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class Utils {
    public static void restartApp(Activity  activity){
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.ECLAIR_MR1){
            Intent intent = activity.getBaseContext().getPackageManager().getLaunchIntentForPackage(activity
                    .getBaseContext().getPackageName());
            PendingIntent pendingIntent = PendingIntent.getActivity(Global.mContext, 0, intent,
                    PendingIntent.FLAG_ONE_SHOT);
            AlarmManager alarmManager = (AlarmManager) activity.getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC, System.currentTimeMillis()+250, pendingIntent);
            activity.finish();
            System.exit(0);
        }else {
            ActivityManager am = (ActivityManager) activity.getSystemService(activity.ACTIVITY_SERVICE);
            am.restartPackage(activity.getPackageName());
        }
    }


    public static Typeface getTypeface(String fontAssetPath){
        AssetManager assetManager= Global.mContext.getAssets();
        return  Typeface.createFromAsset(assetManager,fontAssetPath);
    }
}
