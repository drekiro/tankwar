package cn.dream.tank.pojo;

import cn.dream.tank.constant.Dir;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * @author dream
 * @className Bullet
 * @description
 * @date 2020/12/13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bullet {

    private final static int SPEED = 5;

    private final static int WIDTH = 10, HEIGHT = 10;

    private int x, y;

    private Dir dir;


    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);

        move();
    }// paint

    private void move() {
        switch (dir) {
            case LEFT -> x -= SPEED;
            case UP -> y -= SPEED;
            case RIGHT -> x += SPEED;
            case DOWN -> y += SPEED;
        }
    }// move


}// class
