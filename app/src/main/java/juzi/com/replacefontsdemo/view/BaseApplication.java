package juzi.com.replacefontsdemo.view;

import android.app.Application;

import juzi.com.replacefontsdemo.view.global.Global;

/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Global.init(getApplicationContext());
    }
}
