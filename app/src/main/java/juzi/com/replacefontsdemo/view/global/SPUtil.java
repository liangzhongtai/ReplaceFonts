package juzi.com.replacefontsdemo.view.global;

import android.content.Context;
import android.content.SharedPreferences;

import com.lzt.replacefonts.view.global.Global;

/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class SPUtil {
    private static SharedPreferences sp;
    public static String CONFIG = "config";
    public final static String FONT_PATH_SYSTEM = "font_path_system";
    public final static String FONT_PATH_FREE = "font_path_free";


    /**
     * 获取Config缓存文件
     * */
    private static SharedPreferences getConfigShareDpreference(Context context){
        if(sp==null){
            sp = context.getSharedPreferences(CONFIG, Context.MODE_PRIVATE);
            return sp;
        }else{
            return sp;
        }
    }
    /**
     * boolean
     * */
    public static String getString(String key,String defValue){
        sp = getConfigShareDpreference(Global.mContext);
        return sp.getString(key, defValue);
    }

    public static void setString(String key,String value){
        sp = getConfigShareDpreference(Global.mContext);
        sp.edit().putString(key, value).commit();
    }


}
