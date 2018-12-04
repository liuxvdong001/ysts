package com.xvdong.chpater_two;

import android.app.Application;

/**
 * YSTS第二章
 * 进程间通信
 *      1:Bundle
 *      2:message
 *      3:ContentProvider
 *      4:AIDL
 *      5:文件共享
 *      6:Scoket
 */
public class IntroductionApplication extends Application {

    private final String TAG = this.getClass().getSimpleName();
    /**
     * 同一个应用
     * process 创建不同的进程可能会造成的问题
     *      1: 静态成员和单例模式完全失效
     *      2: 线程同步机制完全失效
     *      3: SP的可靠性降低
     *      4: Application会多次创建
     */

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
