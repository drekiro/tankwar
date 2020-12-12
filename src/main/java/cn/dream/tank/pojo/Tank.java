package cn.dream.tank.pojo;

import cn.dream.tank.TankFrame;
import cn.dream.tank.common.Dir;
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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tank {

    private static final int SPEED = 5;

    private int x;

    private int y;

    private Dir dir = Dir.DOWN;

    private boolean moving = false;

    private TankFrame tankFrame;


    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.CYAN);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);

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


    public void fire() {
        tankFrame.getBullets().add(new Bullet(this.x , this.y, this.dir, true, tankFrame));
    }
}// class



