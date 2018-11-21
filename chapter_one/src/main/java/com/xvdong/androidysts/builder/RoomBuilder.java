package com.xvdong.androidysts.builder;

/**
 * Created by xvDong on 2018/11/21.
 */
public class RoomBuilder {

    private Room room = new Room(makeWindow(),makeDoor());

    public Room getRoom() {
        return room;
    }

    private Window makeWindow(){
        Window window = new Window();
        return window;
    }

    private Door makeDoor (){
        Door door = new Door();
        return door;

    }

    //还可以加钢筋水泥的其他方法,内部由工人来实现
}
