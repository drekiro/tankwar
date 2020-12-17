package cn.dream.tank.pojo;

import cn.dream.tank.common.Group;
import cn.dream.tank.common.ResourceMgr;
import cn.dream.tank.TankFrame;
import cn.dream.tank.common.Constant;
import cn.dream.tank.common.Dir;
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

    private static final int SPEED = 5;

    private int x, y;

    private Dir dir;

    private Boolean living = true;

    private Group group = Group.BAD;

    private TankFrame tankFrame;


    public void paint(Graphics g) {

        // 1.删除掉超出屏幕的子弹
        if (!living)
            tankFrame.getBullets().remove(this);

        // 2.画子弹
        switch (dir) {
            case LEFT:  g.drawImage(ResourceMgr.bulletL, x, y, null);
            case UP:  g.drawImage(ResourceMgr.bulletU, x, y, null);
            case RIGHT:  g.drawImage(ResourceMgr.bulletR, x, y, null);
            case DOWN:  g.drawImage(ResourceMgr.bulletD, x, y, null);
        }
        move();
    }// paint

    private void move() {
        switch (dir) {
            case LEFT -> x -= SPEED;
            case UP -> y -= SPEED;
            case RIGHT -> x += SPEED;
            case DOWN -> y += SPEED;
        }
        if (x < 0 || y < 0 || x > Constant.FRAME_WIDTH || y > Constant.FRAME_HEIGHT)
            living = false;
    }// move


    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup())
            return;
        // todo 用一个rect来记录位置
        Rectangle rectBullet = new Rectangle(this.x, this.y, Constant.BULLET_WIDTH, Constant.BULLET_HEIGHT);
        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(), Constant.TANK_WIDTH, Constant.TANK_HEIGHT);
        if (rectBullet.intersects(rectTank)) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}// class
