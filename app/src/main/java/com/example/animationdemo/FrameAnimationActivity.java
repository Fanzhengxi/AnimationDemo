package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 帧动画
 */
public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView imgDoraemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        imgDoraemo=findViewById(R.id.img_doraemo);
    }

    public void onFrameAnimationByXml(View view) {
        imgDoraemo.setImageResource(R.drawable.frame_anim);//引入动画XML文件
        AnimationDrawable animationDrawable= (AnimationDrawable) imgDoraemo.getDrawable();//获取动画drawable
        animationDrawable.start();//开启动画
    }

    public void onFrameAnimationByCode(View view) {
        AnimationDrawable animationDrawable=new AnimationDrawable();
        for (int i=1;i<8;i++){
            int id=getResources().getIdentifier("wulingmini"+i,"mipmap",getPackageName());
            Drawable drawable=getResources().getDrawable(id);
            animationDrawable.addFrame(drawable,300);//依次添加drawable对象，每张图片的时长是300ms
        }
        //添加到view中
        animationDrawable.setOneShot(false);//动画循环播放
        imgDoraemo.setImageDrawable(animationDrawable);
        //启动动画
        animationDrawable.start();
    }
}