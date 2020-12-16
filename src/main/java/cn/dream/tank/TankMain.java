package cn.dream.tank;

import cn.dream.tank.common.Dir;
import cn.dream.tank.pojo.Tank;

/**
 * @author dream
 * @className TankApp
 * @description
 * @date 2020/12/6
 **/
public class TankMain {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tankFrame = new TankFrame();

        // 初始化地方坦克
        for (int i = 0; i < 5; i++) {
            tankFrame.getTanks().add(new Tank(50 + i * 80, 400, Dir.DOWN, false, true, tankFrame));
        }

        while (true) {
            Thread.sleep(100);
            tankFrame.repaint();
        }

    }

}
