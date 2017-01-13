package juzi.com.replacefontsdemo.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import juzi.com.replacefontsdemo.view.global.Global;


/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class FontFreeFangView extends View {
    private Paint paint;
    private static Typeface typeface;
    public FontFreeFangView(Context context) {
        this(context, null);
    }
    public FontFreeFangView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }
    public FontFreeFangView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(Global.sp2px(16));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.MONOSPACE);
    }

    public void setFontPath(String fontAssetPath){
        typeface = getTypeface(fontAssetPath);
        paint.setTypeface(typeface);
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("使用canvas繪製繁體中文", getWidth()/2, getHeight() / 2, paint);
    }

    public Typeface getTypeface(String fontAssetPath){
        AssetManager assetManager= Global.mContext.getAssets();
        return  Typeface.createFromAsset(assetManager,fontAssetPath);
    }
}
