package com.xvdong.shpater_three;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView mTvGuolinView;
    private final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv_hello);
        mTvGuolinView = findViewById(R.id.tv_guolin_view);
        mTvGuolinView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ");
            }
        });

        mTvGuolinView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG, "onLongClick: ");
                return false;//返回true收到LongClick事件之后不回调onclick事件
            }
        });

        mTvGuolinView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, "onTouch: action = " + event.getAction());
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        return false;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;//返回true表示消耗该事件,则onClick无法收到事件
            }
        });

        /**
         *  view 的位置参数
         */
        //位置参数,上下左右,宽高
        int left = mTextView.getLeft();
        int right = mTextView.getRight();
        int top = mTextView.getTop();
        int bottom = mTextView.getBottom();
        int width = right - left;
        int height = bottom - top;

        //相对于父容器的坐标
        float x = mTextView.getX();
        float y = mTextView.getY();
        float translationX = mTextView.getTranslationX();
        float translationY = mTextView.getTranslationY();

        //TouchSlop 认为是滑动事件的最小距离
        int scaledTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
    }

  /*  @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.v(TAG, "dispatchTouchEvent: ");
//        return true;
//        return false;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.v(TAG, "onTouchEvent: ");
//        return true;
//        return false;
        return super.onTouchEvent(event);
    }*/
}
