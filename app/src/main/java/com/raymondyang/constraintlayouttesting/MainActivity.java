package com.raymondyang.constraintlayouttesting;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.widget.AnimatedSvgView;
import com.kelin.translucentbar.library.TranslucentBarManager;
import com.raymondyang.constraintlayouttesting.custom.LoginRefreshButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = MainActivity.class.getSimpleName();
    ImageView mImageView2;
    @BindView(R.id.svg_google)
    AnimatedSvgView mAnimatedSvgView;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.editText5)
    TextInputLayout editText5;
    @BindView(R.id.editText6)
    TextInputLayout editText6;
    @BindView(R.id.editText7)
    TextInputLayout editText7;
    @BindView(R.id.view4)
    View view4;
    @BindView(R.id.constraint_login)
    ConstraintLayout constraintLogin;
    @BindView(R.id.cardview_login)
    CardView cardviewLogin;
    @BindView(R.id.cardview)
    CardView cardView;
    @BindView(R.id.constraint)
    ConstraintLayout constraint;
//    @BindView(R.id.svg_text_logo)
//    AnimatedSvgView svgTextLogo;
    @BindView(R.id.imageButton)
    LoginRefreshButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TranslucentBarManager manager = new TranslucentBarManager(this);
        manager.transparent(this);
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getSupportActionBar().hide();

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            WindowManager.LayoutParams winParams = window.getAttributes();
//            winParams.flags &= ~WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            window.setAttributes(winParams);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        } else {
//            getSupportActionBar().hide();
//        }


        mImageView2 = findViewById(R.id.imageView2);

        ButterKnife.bind(this);
        imageButton.setOnClickListener(this);
        imageButton.adjustBtnLayout();
        mAnimatedSvgView.start();
//        svgTextLogo.start();


        PixelXLScreenResizeUtil.adjustCardCorner(cardView);
        PixelXLScreenResizeUtil.adjustCardCorner(cardviewLogin);


        Log.d(TAG, "onClick: " + mAnimatedSvgView.getWidth() + "before" + mAnimatedSvgView.getHeight());
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable.timer(3000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        ConstraintSet oldConstraint = new ConstraintSet();
                        ConstraintSet currentConstraint = new ConstraintSet();

                        ConstraintLayout constraintLayout = findViewById(R.id.constraint);
                        int cardMargin = PixelXLScreenResizeUtil.getSvgCardMargin();

                        //adjustButtonWidthHeight


                        currentConstraint.clone(constraintLayout);
                        currentConstraint.connect(cardviewLogin.getId(), ConstraintSet.TOP, R.id.svg_google, ConstraintSet.BOTTOM, cardMargin);

                        //adjustButtonWidthHeight
//                        currentConstraint.setDimensionRatio(imageButton.getId(), "h,1:1");
//                        currentConstraint.constrainWidth(imageButton.getId(), PixelXLScreenResizeUtil.getPxValue(338));
//                        currentConstraint.constrainHeight(imageButton.getId(), PixelXLScreenResizeUtil.getPxValue(90));


                        currentConstraint.setDimensionRatio(cardView.getId(), "h,1:1");
                        currentConstraint.connect(cardView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, cardMargin);
                        currentConstraint.connect(cardView.getId(), ConstraintSet.START, R.id.guideline_svg_vertical, ConstraintSet.START);
                        currentConstraint.connect(cardView.getId(), ConstraintSet.END, R.id.guideline_svg_vertical_end, ConstraintSet.END);
//

                        currentConstraint.connect(mAnimatedSvgView.getId(), ConstraintSet.TOP, cardView.getId(), ConstraintSet.TOP);
                        currentConstraint.connect(mAnimatedSvgView.getId(), ConstraintSet.START, cardView.getId(), ConstraintSet.START);
                        currentConstraint.connect(mAnimatedSvgView.getId(), ConstraintSet.END, cardView.getId(), ConstraintSet.END);
                        currentConstraint.connect(mAnimatedSvgView.getId(), ConstraintSet.BOTTOM, cardView.getId(), ConstraintSet.BOTTOM);
//


//                        currentConstraint.connect(svgTextLogo.getId(), ConstraintSet.TOP, cardView.getId(), ConstraintSet.TOP);
//                        currentConstraint.connect(svgTextLogo.getId(), ConstraintSet.START, cardView.getId(), ConstraintSet.START);
//
                        TransitionManager.beginDelayedTransition(constraintLayout, new AutoTransition().setDuration(3000));

                        currentConstraint.applyTo(constraintLayout);


                        Log.d(TAG, "onClick: " + mAnimatedSvgView.getWidth() + "after" + mAnimatedSvgView.getHeight());

                        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
                        alphaAnimation.setDuration(3000);
                        alphaAnimation.setFillAfter(true);
//                        svgTextLogo.setAnimation(alphaAnimation);


                        compositeDisposable.dispose();


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        int cardSvgMargin = pxToDp(PixelXLScreenResizeUtil.getSvgCardMargin(), 560);

//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                imageButton.setAnimation("data2.json");
//                imageButton.playAnimation();
//
//            }
//        });
//


    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onClick: " + mAnimatedSvgView.getWidth() + " " + mAnimatedSvgView.getHeight());
    }

    public int pxToDp(int px, int dpi) {

//        int px = dp * dpi / 160;
        int dp = px * 160 / dpi;

        return px;
    }

    public void clickOnButton(View view) {

//        imageButton.setImageResource(R.drawable.rect_to_circle);
//
//        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) imageButton.getDrawable();
//        animatedVectorDrawable.start();

//        Drawable drawable = LottieDrawable.createFromPath("/Users/raymondyang/Downloads/ConstraintLayoutTesting/app/src/main/assets");
//        imageButton.setImageDrawable(drawable);


    }


    private void login() {
        imageButton.startRefresh();
        final CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private boolean validate() {
        boolean validate = true;

//        if (TextUtils.isEmpty(editText5.getText())) {
//            validate = false;
//        }
//
//        if (TextUtils.isEmpty(editText6.getText())) {
//            validate = false;
//        }
//
//        if (TextUtils.isEmpty(editText7.getText())) {
//            validate = false;
//        }


        return validate;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                if (validate()) {
                    login();
                }
                break;
        }
    }

//    @OnClick(R.id.imageButton)
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.imageButton:
//                if (validate()) {
//                    login();
//                }
//                break;
//        }
//
//    }
}
