package cn.dream.tank.pojo;

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

    private static final int WIDTH = 10, HEIGHT = 10;

    private int x, y;

    private Dir dir;

    private Boolean live = true;

    private TankFrame tankFrame;


    public void paint(Graphics g) {

        // 1.删除掉超出屏幕的子弹
        if (!live)
            tankFrame.getBullets().remove(this);

        // 2.设置子弹颜色
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
        if (x < 0 || y < 0 || x > Constant.FRAME_WIDTH || y > Constant.FRAME_HEIGHT)
            live = false;
    }// move


}// class
