package cn.dream.tank;

/**
 * @author dream
 * @className TankApp
 * @description
 * @date 2020/12/6
 **/
public class TankMain {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tankFrame = new TankFrame();

        while (true) {
            Thread.sleep(100);
            tankFrame.repaint();
        }

    }
}
