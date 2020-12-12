package cn.dream.tank.pojo;

import cn.dream.tank.constant.Dir;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * @author dream
 * @className Tank
 * @description
 * @date 2020/12/10
 **/
public class Tank {

    private static final int SPEED = 10;

    private int x;

    private int y;

    private Dir dir = Dir.DOWN;

    private boolean moving = false;


    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }// paint

    private void move() {
        if (!moving)
            return;
        switch (dir) {
            case LEFT -> x -= SPEED;
            case UP -> y -= SPEED;
            case RIGHT -> x += SPEED;
            case DOWN -> y += SPEED;
        }
    }// move


    public Tank() {
    }

    public Tank(int x, int y, Dir dir, boolean moving) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.moving = moving;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}// class



