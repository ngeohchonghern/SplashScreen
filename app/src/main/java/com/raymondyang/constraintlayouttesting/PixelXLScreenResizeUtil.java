package com.raymondyang.constraintlayouttesting;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import androidx.cardview.widget.CardView;

public class PixelXLScreenResizeUtil {
    private static short currentScreenWidth, currentScreenHeight;

    private static float verticalRatio = 1f;
    private static float horizontalRatio = 1f;
    private static int svgCardMargin = 0;
    private static  int commonCardCornerRadius = 0;


    public static void install() {
        final float pixelXLScreenWidth = 720f;
        final float pixelXLScreenHeight = 1280f;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        currentScreenWidth = (short) displayMetrics.widthPixels;
        currentScreenHeight = (short) displayMetrics.heightPixels;

        verticalRatio = (float) currentScreenHeight / pixelXLScreenHeight;
        horizontalRatio = (float) currentScreenWidth / pixelXLScreenWidth;

    }

    public static int getSvgCardMargin() {
        if (svgCardMargin == 0)
            svgCardMargin = (int) (74 * verticalRatio);
        return svgCardMargin;
    }


    public static int getPxValue(float pxValue) {
        return (int) (pxValue * horizontalRatio);
    }

    public static void adjustCardCorner(CardView cardView) {
        if (commonCardCornerRadius == 0)
            commonCardCornerRadius = getPxValue(20);
        cardView.setRadius(commonCardCornerRadius);
    }

}

