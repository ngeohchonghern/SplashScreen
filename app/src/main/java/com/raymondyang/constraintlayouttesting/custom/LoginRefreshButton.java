package com.raymondyang.constraintlayouttesting.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.raymondyang.constraintlayouttesting.PixelXLScreenResizeUtil;
import com.raymondyang.constraintlayouttesting.R;

import java.util.Arrays;

import androidx.core.content.ContextCompat;

public class LoginRefreshButton extends RefreshButton {

    private int mThemeColor;
    private int mRadii;
    private Paint mRefreshPaint;

    public LoginRefreshButton(Context context) {
        super(context);
        init(context);
    }

    public LoginRefreshButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoginRefreshButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){



        int btn_height = PixelXLScreenResizeUtil.getPxValue(86);
        mRadii = btn_height >> 1;

        mThemeColor = ContextCompat.getColor(context, R.color.colorPrimary);

        mRefreshPaint = new Paint();
        mRefreshPaint.setColor(mThemeColor);

        int activateColor = Color.WHITE;
        int pressedColor = Color.WHITE;

//        ColorStateList stateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed},
//                new int[]{android.R.attr.state_focused},
//                new int[]{android.R.attr.state_activated}}, new int[]{pressedColor, pressedColor, activateColor});
        ColorStateList stateList = new ColorStateList(new int[][]
                {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused},
                        new int[]{android.R.attr.state_activated},
                        new int[]{}}, new int[]{activateColor, pressedColor, pressedColor, activateColor});
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(mThemeColor);
        drawable.setCornerRadius(mRadii);
        RippleDrawable background = new RippleDrawable(stateList, drawable, null);
        setBackground(background);

//        float[] outerRadii = new float[8];
//        Arrays.fill(outerRadii, mRadii);
//        RoundRectShape r = new RoundRectShape(outerRadii, null, null);
//        ShapeDrawable shapeDrawable = new ShapeDrawable(r);
//        shapeDrawable.getPaint().setColor(mThemeColor);
//        setBackgroundDrawable(shapeDrawable);





    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        adjustBtnLayout();
    }

    public void adjustBtnLayout() {
        final int btn_height = PixelXLScreenResizeUtil.getPxValue(86);
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
        lp.height = btn_height;
        lp.width = PixelXLScreenResizeUtil.getPxValue(350);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(mThemeColor);
//        RectF rectF = new RectF(0,0,PixelXLScreenResizeUtil.getPxValue(350), PixelXLScreenResizeUtil.getPxValue(86));
//        canvas.drawRoundRect(rectF, mRadii, mRadii, mRefreshPaint);
        LocaleList localeList = new LocaleList();




    }
}


