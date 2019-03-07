package com.raymondyang.constraintlayouttesting.custom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

import com.raymondyang.constraintlayouttesting.HomeActivity;
import com.raymondyang.constraintlayouttesting.MainActivity;
import com.raymondyang.constraintlayouttesting.PixelXLScreenResizeUtil;
import com.raymondyang.constraintlayouttesting.SecondActivity;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RefreshButton extends AppCompatTextView {

    public static final String TAG = RefreshButton.class.getSimpleName();
    private Paint refreshPaint;
    private int arc_padding = 0;
    private float arc_ratio = 0;
    private boolean refreshing;
    private int btn_width = -1;
    private int btn_height = -1;
    private CharSequence text;
    private ObjectAnimator scaleAnimator;
    private ObjectAnimator refreshAnimator;
    private int DURATION = 500;
    private RectF rectF;


    public RefreshButton(Context context) {
        super(context);
        init(context);
    }

    public RefreshButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }



    public RefreshButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        refreshPaint = new Paint();
        refreshPaint.setStyle(Paint.Style.STROKE);
        refreshPaint.setStrokeWidth(PixelXLScreenResizeUtil.getPxValue(5));
        arc_padding = PixelXLScreenResizeUtil.getPxValue(20);
        setTextColor(ContextCompat.getColor(context, android.R.color.white));
        setGravity(Gravity.CENTER);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (refreshAnimator != null) {
            if (rectF ==null) {
                rectF = new RectF(arc_padding, arc_padding, btn_height - arc_padding, btn_height - arc_padding);
            } else {
                rectF.set(arc_padding, arc_padding, btn_height - arc_padding, btn_height - arc_padding);
            }
            canvas.rotate(360 * arc_ratio , btn_height >> 1, btn_height >> 1);
            canvas.drawArc(rectF, 0, 360, false, refreshPaint);
        }
    }

    public void startRefresh() {
        if (refreshing)
            return;
        setClickable(false);
        refreshing = true;
        if (btn_width < 0)
            btn_width = getWidth();
        if (btn_height < 0)
            btn_height = getHeight();
        if (text == null) {
            text = getText();
        }

        setText(null);
        if (refreshPaint.getShader() == null) {
            refreshPaint.setShader(new SweepGradient(btn_height/2, btn_height/2,
                    new int[]{0x00FFFFFF,
                    Color.WHITE}, null));
        }

        scaleAnimator = ObjectAnimator.ofFloat(this, "currentParams", 1, 0);
        scaleAnimator.setInterpolator(new AccelerateInterpolator(2));
        scaleAnimator.setDuration(DURATION << 1);
        scaleAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "onAnimationEnd: ");
//                scaleAnimator = null;
                startrefreshAnimate();

            }

            private void startrefreshAnimate() {
                refreshAnimator = ObjectAnimator.ofFloat(RefreshButton.this, "animRotationArc", 0, 1);
                refreshAnimator.setInterpolator(new LinearInterpolator());
                refreshAnimator.setDuration(DURATION);
                refreshAnimator.setRepeatMode(ObjectAnimator.RESTART);
                refreshAnimator.setRepeatCount(ObjectAnimator.INFINITE);
                refreshAnimator.start();



            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(TAG, "onAnimationCancel: ");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d(TAG, "onAnimationRepeat: ");
            }
        });
        scaleAnimator.start();
    }

    protected void setCurrentParams(float ratio) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
        lp.width = (int) (btn_height + (ratio * (btn_width - btn_height)));
        requestLayout();
    }

    protected void  setAnimRotationArc(float ratio) {
        arc_ratio = ratio;
        invalidate();
    }


}
