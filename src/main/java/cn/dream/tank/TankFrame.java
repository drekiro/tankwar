package cn.dream.tank;

import cn.dream.tank.constant.Dir;
import cn.dream.tank.pojo.Bullet;
import cn.dream.tank.pojo.Tank;
import lombok.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author dream
 * @className TankFrame
 * @description
 * @date 2020/12/6
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TankFrame extends Frame {

    private final static int FRAME_WIDTH = 800, FRAME_HEIGHT = 600;

    private final Tank myTank = new Tank(200, 200, Dir.DOWN, false, this);

    private Bullet bullet = new Bullet(300, 300, Dir.DOWN);

    private Image offScreenImage = null;

    {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("Tank War");
        this.setVisible(true);

        // 添加窗口关闭功能
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 添加键盘监听
        this.addKeyListener(new MyKeyListener());
    }// 构造代码块


    /**
     * 窗口初始化和重新设置时自动调用
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        bullet.paint(g);
    }// paint


    /**
     * 用来处理屏幕闪烁
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(FRAME_WIDTH, FRAME_HEIGHT);
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0 ,0, null);
    }// update


    /**
     * 内部类
     */
    class MyKeyListener extends KeyAdapter {

        boolean left = false;
        boolean up = false;
        boolean right = false;
        boolean down = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT -> left = true;
                case KeyEvent.VK_UP -> up = true;
                case KeyEvent.VK_RIGHT -> right = true;
                case KeyEvent.VK_DOWN -> down = true;
            }
            setMainTankDir();
        }


        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT -> left = false;
                case KeyEvent.VK_UP -> up = false;
                case KeyEvent.VK_RIGHT -> right = false;
                case KeyEvent.VK_DOWN -> down = false;
                case KeyEvent.VK_CONTROL -> myTank.fire();
            }// switch
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!left && !up && !right && !down)
                myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (left)
                    myTank.setDir(Dir.LEFT);
                if (up)
                    myTank.setDir(Dir.UP);
                if (right)
                    myTank.setDir(Dir.RIGHT);
                if (down)
                    myTank.setDir(Dir.DOWN);
            }// if
        }// setMainTankDir

    }// MyKeyListener


}// class
