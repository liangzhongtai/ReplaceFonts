package juzi.com.replacefontsdemo.view;

import android.app.Application;

import juzi.com.replacefontsdemo.view.global.Configs;
import juzi.com.replacefontsdemo.view.global.FontUtil;
import juzi.com.replacefontsdemo.view.global.Global;
import juzi.com.replacefontsdemo.view.global.SPUtil;

/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Global.init(getApplicationContext());
        FontUtil.getInstance().replaceSystemDefaultFontFromAsset(this,
                SPUtil.getString(SPUtil.FONT_PATH_SYSTEM, Configs.FONTS_XHJ));
    }
}
