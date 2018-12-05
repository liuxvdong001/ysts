package com.xvdong.shpater_three;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by xvDong on 2018/11/27.
 */
public class DispatchTouchTextView extends AppCompatTextView {

    private final String TAG = "DispatchTouchTextView";

    public DispatchTouchTextView(Context context) {
        super(context);
    }

    public DispatchTouchTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 如果事件能够传递给当前view,那么该方法一定调用,返回结果
     * 受当前View的onTouchEvent和下级View的dispatchTouchEvent
     * 方法的影响,表示是否消耗当前事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        event.actionToString(event.getAction());
        Log.i(TAG, "dispatchTouchEvent: ");
        return true;
//        return false;
//        return super.dispatchTouchEvent(event);
    }
    /**
     * 在dispatchTouchEvent种调用,用来处理点击事件,返回结果表示是否
     * 消耗当前事件,如果不消耗,则在同一个事件序列中,当前的View无法再次接收到事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent: ");
//        return true;  //表示消耗触摸事件,不会调用父View的onTouchEvent方法.事件结束,但是会不断的有新的事件传递下来
//        return false;   //表示不消耗该触摸事件,会调用父View的onTouchEvent方法.事件向上传递
        return super.onTouchEvent(event);
    }
}
