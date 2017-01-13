package juzi.com.replacefontsdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import juzi.com.replacefontsdemo.view.global.Global;


/**
 * Created by liangzhongtai on 2017/1/12.
 */
public class FontSystemView extends View {
    private Paint paint;
    public FontSystemView(Context context) {
        this(context, null);
    }
    public FontSystemView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }
    public FontSystemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(Global.sp2px(16));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTypeface(Typeface.MONOSPACE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("使用canvas绘制简体中文",getWidth()/2,getHeight()/2,paint);
    }
}
