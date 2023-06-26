package com.example.MedicApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private float x1, x2, y1,y2;
    private static int MIN_DISTANCE = 150;
    private int count = 1;
    private GestureDetector gestureDetector;
    TextView cent_top_text;
    TextView cent_bottom_text;
    TextView top_text;
    ImageView cent_dots;
    ImageView bottom_img;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cent_top_text = (TextView) findViewById(R.id.centerText);
        cent_bottom_text = (TextView) findViewById(R.id.bottom_centerText);
        top_text = (TextView) findViewById(R.id.centerText);
        cent_dots = (ImageView) findViewById(R.id.dots);
        bottom_img = (ImageView) findViewById(R.id.bottomImg);
        close = (Button) findViewById(R.id.skipf_btn);
        close.setVisibility(View.VISIBLE);
        close.setBackgroundColor(Color.TRANSPARENT);

        this.gestureDetector = new GestureDetector(HomeActivity.this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            gestureDetector.onTouchEvent(event);
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    x1 = event.getX();
                    y1= event.getY();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    y2= event.getY();
                    float valueX = x2-x1;
                    float valueY = y2-y1;

                    if (Math.abs(valueX)>MIN_DISTANCE){
                        if (x2>x1&count>1){
                            //слева направо
                            count--;
                        }
                        else if (x2<x1&count<=3){
                            //справа налево
                            count++;
                        }
                        if (count==1){
                            cent_top_text.setText(R.string.analys);
                            cent_bottom_text.setText(R.string.analys_t);
                            cent_dots.setImageResource(R.drawable.z1);
                            bottom_img.setImageResource(R.drawable.iamge1);
                        }
                        else if (count==2){
                            cent_top_text.setText(R.string.notifs);
                            cent_bottom_text.setText(R.string.notifs_t);
                            cent_dots.setImageResource(R.drawable.z2);
                            bottom_img.setImageResource(R.drawable.iamge2);
                            top_text.setText(R.string.skip);
                        }
                        else {
                            cent_top_text.setText(R.string.monitor);
                            cent_bottom_text.setText(R.string.monitor_t);
                            cent_dots.setImageResource(R.drawable.z3);
                            bottom_img.setImageResource(R.drawable.iamge3);
                            top_text.setText(R.string.when_does_this_game_get_good);
                        }
                    }

            }

        return super.onTouchEvent(event);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}