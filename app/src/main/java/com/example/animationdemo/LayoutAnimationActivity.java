package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 布局动画
 */
public class LayoutAnimationActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        listView=findViewById(R.id.list_view);
        List<String> list =new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add("五菱迷你ev");
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.listview_item,list);
        listView.setAdapter(adapter);
    }
    public void starAnimation(View view) {
        //添加动画
        LayoutAnimationController controller=new LayoutAnimationController(AnimationUtils.loadAnimation(this,R.anim.item_anim));
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);//设置listView的Item显示顺序
        listView.setLayoutAnimation(controller);
        listView.startLayoutAnimation();
    }
}