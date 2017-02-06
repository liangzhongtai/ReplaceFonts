package juzi.com.replacefontsdemo.view.global;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class Global {
    public static Context mContext;
    public static float mScaledDensity;
    public static void init(Context context){
        mContext = context;
        DisplayMetrics dm = mContext.getResources().getDisplayMetrics();
        mScaledDensity = dm.scaledDensity;

    }

    public static int sp2px(int sp){
        return (int)(sp*mScaledDensity+0.5f);
    }
    public static float sp2px(float sp){
        return sp*mScaledDensity+0.5f;
    }

}
