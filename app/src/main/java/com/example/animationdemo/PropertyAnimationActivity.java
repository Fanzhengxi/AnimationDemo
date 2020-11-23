package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性动画
 */
public class PropertyAnimationActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private ListView listView;
    private List<String> stringList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ImageView imgDoraemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        listView = findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, R.layout.listview_item, stringList);//引入listView的item
        listView.setAdapter(adapter);

        imgDoraemo = findViewById(R.id.img_doraemo3);
    }

    /**
     * 0到20在100ms内平滑变化
     *
     * @param view
     */
    public void onInt(View view) {
        stringList.clear();
//        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,20);
//        valueAnimator.setDuration(100);
//        valueAnimator.start();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 20);
        valueAnimator.setDuration(100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                stringList.add("value" + currentValue);
                adapter.notifyDataSetChanged();
            }
        });
        valueAnimator.start();
    }

    public void onFloat(View view) {
        stringList.clear();
//        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,20);
//        valueAnimator.setDuration(100);
//        valueAnimator.start();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 20);
        valueAnimator.setDuration(100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                stringList.add("value" + currentValue);
                adapter.notifyDataSetChanged();
            }
        });
        valueAnimator.start();
    }


    /**
     * 透明度渐变
     *
     * @param view
     */
    public void onAlphaAnimation(View view) {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(imgDoraemo, "alpha", 0.1f, 1.0f);
        alphaAnimator.setDuration(2000);
        alphaAnimator.start();
    }

    /**
     * 旋转
     *
     * @param view
     */
    public void onRotateAnimation(View view) {
        final int[] repeatTimes = {0};
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(imgDoraemo, "rotation", 0f, 360f);
        //必须override 所有方法
        rotationAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(TAG, "哆啦A梦开始了");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "哆啦A梦结束了");

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(TAG, "哆啦A梦取消播放了");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                repeatTimes[0]++;
                Log.d(TAG, "哆啦A梦重复播放了" + repeatTimes[0] + "次");
            }
        });
        //可以选择要override的方法
        rotationAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.d(TAG, "哆啦A梦结束了！！！！");
            }
        });
        rotationAnimator.setDuration(2000);
        rotationAnimator.setRepeatCount(3);
        rotationAnimator.start();
    }

    /**
     * 由原图的1倍放大到3倍，再到2倍
     *
     * @param view
     */
    public void onScaleAnimation(View view) {
        ObjectAnimator.ofFloat(imgDoraemo, "scaleX", 1f, 3f, 2f).setDuration(2000).start();
        ObjectAnimator.ofFloat(imgDoraemo, "scaleY", 1f, 3f, 2f).setDuration(2000).start();
    }

    /**
     * (0,0)
     *
     * @param view
     */
    public void onTranslationAnimator(View view) {
        ObjectAnimator.ofFloat(imgDoraemo, "translationX", 0f, 300f, 0f).setDuration(1000).start();
        ObjectAnimator.ofFloat(imgDoraemo, "translationY", 0f, 300f, 0f).setDuration(1000).start();
    }

    /**
     * 组合动画
     *
     * @param view
     */
    public void onComboAnimation(View view) {
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imgDoraemo, "alpha", 0.1f, 1.0f);
        ObjectAnimator rotation = ObjectAnimator.ofFloat(imgDoraemo, "rotation", 0f, 360f);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(imgDoraemo, "scaleX", 1f, 3f, 2f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(imgDoraemo, "scaleY", 1f, 3f, 2f);
        AnimatorSet animatorSet = new AnimatorSet();
        //先旋转，后同时执行alpha和缩放
        animatorSet.play(alpha).with(scaleX).with(scaleY).after(rotation);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
}