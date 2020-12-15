package cn.dream.tank;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author dream
 * @className ImageTest
 * @description
 * @date 2020/12/13
 **/
public class ImageTest {

    @Test
    public void loadImage() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("images/0.gif");
        assert is != null;
    }

}
