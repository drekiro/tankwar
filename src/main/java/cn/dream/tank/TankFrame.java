package cn.dream.tank;

import cn.dream.tank.constant.Dir;
import cn.dream.tank.pojo.Tank;

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
public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Dir.DOWN, false);


    public TankFrame() throws HeadlessException {
        this.setSize(800, 600);
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

    }// TankFrame


    /**
     * 窗口初始化和重新设置时自动调用
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }// paint


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
            }
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
