package com.xvdong.androidysts.builder;

/**
 * Created by xvDong on 2018/11/21.
 */
public class Demo {

    // 我需要一个房子
    public void needRoom() {
        Window window = new Window();
        Door door = new Door();
        //如果有无数的其他条件,例如,钢筋,水泥等等,这里很复杂
        Room room = new Room(window, door);
    }
}

