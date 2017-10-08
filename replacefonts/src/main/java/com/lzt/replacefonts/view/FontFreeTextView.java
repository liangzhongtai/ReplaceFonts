    package com.lzt.replacefonts.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lzt.replacefonts.view.global.Utils;


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
