package com.lzt.replacefonts.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;


/**
 * Created by liangzhongtai on 2017/1/13.
 */
public class FontSystemToolBar extends Toolbar {
    public FontSystemToolBar(Context context) {
        this(context, null);
    }
    public FontSystemToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }
    public FontSystemToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int length = getChildCount();
        for(int i=0;i<length;i++){
            View view = getChildAt(i);
            if(view instanceof TextView){
                ((TextView)view).setTypeface(Typeface.MONOSPACE);
            }
        }

    }

}
