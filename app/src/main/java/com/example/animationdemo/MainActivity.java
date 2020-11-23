package com.example.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toTransformActivity(View view) {
        startActivity(new Intent(MainActivity.this, TransformAnimationActivity.class));
    }

    public void toFrameActivity(View view) {
        startActivity(new Intent(MainActivity.this,FrameAnimationActivity.class));
    }

    public void toLayoutAnimationActivity(View view) {
        startActivity(new Intent(MainActivity.this,LayoutAnimationActivity.class));
    }

    public void toPropertyAnimationActivity(View view) {
        startActivity(new Intent(MainActivity.this, PropertyAnimationActivity.class));
    }
}