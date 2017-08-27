    package juzi.com.replacefontsdemo.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import juzi.com.replacefontsdemo.view.global.Global;
import juzi.com.replacefontsdemo.view.global.Utils;


/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class FontFreeTextView extends TextView {
    protected static Typeface typeface;
    public static String fontAssetPath;
    public FontFreeTextView(Context context) {
        this(context, null);
    }
    public FontFreeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }
    public FontFreeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setFontPath(String fontAssetPath){
        if(typeface==null||this.fontAssetPath==null||!this.fontAssetPath.equals(fontAssetPath)) {
            typeface = Utils.getTypeface(fontAssetPath);
            this.fontAssetPath = fontAssetPath;
        }
        setTypeface(typeface);
        invalidate();
    }

}
