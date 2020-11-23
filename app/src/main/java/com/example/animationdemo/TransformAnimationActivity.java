package com.example.animationdemo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 变换动画
 */
public class TransformAnimationActivity extends AppCompatActivity {
    private ImageView imgDoreamo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform_animation);
        imgDoreamo = findViewById(R.id.img_doraemo);

    }

    /**
     * 透明度动画
     *
     * @param view
     */
    public void onAlphaByXml(View view) {
        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        imgDoreamo.startAnimation(alphaAnimation);
    }

    public void onAlphaByCode(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(2000);//unit:ms,2秒
        alphaAnimation.setRepeatCount(2);//动画重复2次，共3次
        imgDoreamo.startAnimation(alphaAnimation);
    }

    /**
     * 旋转动画
     *
     * @param view
     */
    public void onRotateByXml(View view) {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imgDoreamo.startAnimation(rotateAnimation);
    }

    public void onRotateByCode(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.00f
                , Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);//负号表示逆时针旋转,X,Y轴以自己的50%为旋转中心
        rotateAnimation.setDuration(3000);
        imgDoreamo.startAnimation(rotateAnimation);

    }

    /**
     * 渐变尺寸缩放动画
     *
     * @param view
     */
    public void onScaleByXml(View view) {
        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
        imgDoreamo.startAnimation(scaleAnimation);
    }

    /**
     * 以图片中心为缩放中心，放大两倍
     *
     * @param view
     */
    public void onScaleByCode(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(3000);
        imgDoreamo.startAnimation(scaleAnimation);
    }


    public void onTranslationByXml(View view) {
        Animation translationAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
        imgDoreamo.startAnimation(translationAnimation);
    }

    public void onTranslationByCode(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 300.0f, 0.0f, 300.0f);
        translateAnimation.setDuration(3000);
        imgDoreamo.startAnimation(translateAnimation);

    }


    /**
     * 组合动画
     *
     * @param view
     */
    public void onComboAnimation(View view) {
        AnimationSet animationSet = new AnimationSet(true);//动画数组
        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setDuration(3000);
        animationSet.setStartOffset(2000);//2000ms后开启下一个动画，不设置的话两个动画将会同时进行
        imgDoreamo.startAnimation(animationSet);
    }
}