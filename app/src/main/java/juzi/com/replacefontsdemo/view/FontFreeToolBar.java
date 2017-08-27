package juzi.com.replacefontsdemo.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import juzi.com.replacefontsdemo.view.global.Utils;

/**
 * Created by liangzhongtai on 2017/1/13.
 */
public class FontFreeToolBar extends Toolbar {
    private static Typeface typeface;
    public static String fontAssetPath = Configs.FONTS_XHJ;
    public FontFreeToolBar(Context context) {
        this(context, null);
    }
    public FontFreeToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }
    public FontFreeToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setFontPath(String fontAssetPath){
        if(typeface==null||this.fontAssetPath==null||!this.fontAssetPath.equals(fontAssetPath)) {
            typeface = Utils.getTypeface(fontAssetPath);
            this.fontAssetPath = fontAssetPath;
        }
        int length = getChildCount();
        for(int i=0;i<length;i++){
            View view = getChildAt(i);
            if(view.getClass() == TextView.class){
                ((TextView)view).setTypeface(typeface);
            }
        }
        invalidate();
    }

}
