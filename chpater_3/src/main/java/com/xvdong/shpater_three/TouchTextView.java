package com.xvdong.shpater_three;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.Scroller;

/**
 * Created by xvDong on 2018/11/26.
 */
public class TouchTextView extends AppCompatTextView implements GestureDetector.OnGestureListener{

    private GestureDetector mGestureDetector;
    private Scroller mScroller;

    public TouchTextView(Context context) {
        this(context ,null);
    }

    public TouchTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public TouchTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
        gestureDetector();
        //设置TextView内容可以滑动  需要Android:scrollbars="vertical"
        setMovementMethod(ScrollingMovementMethod.getInstance());
        /**
         * view滑动的三种方式
         *      1: view.scrollTo 移动到xy   view.scrollBy 再当前位置基础上移动
         *      2: view的属性动画实现
         *      3: 改变view的layoutParams
         */
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //当前view相对于左上角的坐标
                float x1 = event.getX();
                float y1 = event.getY();
                //相对于手机屏幕的坐标
                float rawX = event.getRawX();
                float rawY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                //速度追踪 手指滑动过程中的速度,包括水平方向和竖直方向
                VelocityTracker velocityTracker = VelocityTracker.obtain();
                velocityTracker.addMovement(event);
                //计算速度的事件间隔--时间段
                velocityTracker.computeCurrentVelocity(1000);
                //获取水平方向的速度   速度 = (终点位置 - 起点位置) / 时间段
                float xVelocity = velocityTracker.getXVelocity();
                //获取竖直方向的速度
                float yVelocity = velocityTracker.getYVelocity();
                //不再使用的时候需要释放掉
                velocityTracker.clear();
                velocityTracker.recycle();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        boolean gestureDetectortouchEvent = mGestureDetector.onTouchEvent(event);
        return gestureDetectortouchEvent;
    }


    /**
     * 平滑滚动到指定位置
     */
    public void smoothScrollerTo(int destX , int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        //1000ms 内划向destX , 平滑缓慢滑动 有动画
        mScroller.startScroll(scrollX,0,delta,0,500);
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
        }
    }

    private void gestureDetector (){
        mGestureDetector = new GestureDetector(this);
        //解决长安屏幕后无法拖动的现象 滑动和长按是互斥的
        mGestureDetector.setIsLongpressEnabled(false);
    }



    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
