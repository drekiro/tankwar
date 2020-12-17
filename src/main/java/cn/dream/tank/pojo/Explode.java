package cn.dream.tank.pojo;

import cn.dream.tank.TankFrame;
import cn.dream.tank.common.Audio;
import cn.dream.tank.common.ResourceMgr;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * @author dream
 * @className Explode
 * @description
 * @date 2020/12/17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Explode {

    private int x, y;

    private boolean living = true;

    private TankFrame tankFrame;

    {
        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        int step = 0;
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            step = 0;
    }


}
