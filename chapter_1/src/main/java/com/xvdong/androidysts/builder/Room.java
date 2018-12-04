package com.xvdong.androidysts.builder;


/**
 * Created by xvDong on 2018/11/21.
 */
public class Room {
    private Window window;
    private Door door;

    public Room(Window window, Door door) {
        this.window = window;
        this.door = door;
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}
