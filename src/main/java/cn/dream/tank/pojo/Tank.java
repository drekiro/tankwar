package cn.dream.tank.pojo;

import cn.dream.tank.ResourceMgr;
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

    public static final int WIDTH = ResourceMgr.tankD.getWidth();

    public static final int HEIGHT = ResourceMgr.tankD.getWidth();

    private TankFrame tankFrame;


    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:  g.drawImage(ResourceMgr.tankL, x, y, null);
            case UP:  g.drawImage(ResourceMgr.tankU, x, y, null);
            case RIGHT:  g.drawImage(ResourceMgr.tankR, x, y, null);
            case DOWN:  g.drawImage(ResourceMgr.tankD, x, y, null);
        }
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
        int bulletX = this.x + Tank.WIDTH / 2 + Bullet.WIDTH / 2;
        int bulletY = this.y + Tank.HEIGHT / 2 + Bullet.HEIGHT / 2;
        tankFrame.getBullets().add(new Bullet(bulletX , bulletY, this.dir, true, tankFrame));
    }
}// class



