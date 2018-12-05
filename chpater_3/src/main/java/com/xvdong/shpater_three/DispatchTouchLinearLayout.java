package com.xvdong.shpater_three;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by xvDong on 2018/11/27.
 */
public class DispatchTouchLinearLayout extends LinearLayout {

    private final String TAG = this.getClass().getSimpleName();

    public DispatchTouchLinearLayout(Context context) {
        super(context);
    }

    public DispatchTouchLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 如果事件能够传递给当前view,那么该方法一定调用,返回结果
     * 受当前View的onTouchEvent和下级View的dispatchTouchEvent
     * 方法的影响,表示是否消耗当前事件
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: ");
//        return true;
//        return false;
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 用来判断是否拦截某个事件,如果当前View拦截了某个事件,那么再
     * 同一个事件序列当中,此方法不会被再次调用,返回的结果表示是否
     * 拦截当前事件
     */

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: +返回值" + super.onInterceptTouchEvent(ev));
//        return true;
//        return false;
        return super.onInterceptTouchEvent(ev);
    }

    /**
     * 在dispatchTouchEvent种调用,用来处理点击事件,返回结果表示是否
     * 消耗当前事件,如果不消耗,则在同一个事件序列中,当前的View无法再次接收到事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: +返回值" + super.onTouchEvent(event));
//        return true;
//        return false;
        return super.onTouchEvent(event);
    }
}
