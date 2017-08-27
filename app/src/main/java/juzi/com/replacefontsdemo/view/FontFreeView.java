package juzi.com.replacefontsdemo.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import juzi.com.replacefontsdemo.view.global.Configs;
import juzi.com.replacefontsdemo.view.global.Global;
import juzi.com.replacefontsdemo.view.global.SPUtil;
import juzi.com.replacefontsdemo.view.global.Utils;


/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class FontFreeView extends View {
    Paint paint;
    private static Typeface typeface;
    protected static String fontAssetPath;
    public FontFreeView(Context context) {
        this(context, null);
    }
    public FontFreeView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }
    public FontFreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        //paint.setTextSize(Global.sp2px(16));
        //paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.MONOSPACE);

    }

    public void setFontPath(String fontAssetPath){
        if(typeface==null||this.fontAssetPath==null||!this.fontAssetPath.equals(fontAssetPath)) {
            typeface = Utils.getTypeface(fontAssetPath);
            this.fontAssetPath = fontAssetPath;
        }
        paint.setTypeface(typeface);
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawText("使用canvas绘制简体中文", getWidth()/2, getHeight() / 2, paint);
    }


}
