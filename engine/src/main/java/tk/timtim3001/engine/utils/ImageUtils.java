package tk.timtim3001.engine.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageUtils {

    private ImageUtils(){}

    public static BufferedImage resize(BufferedImage img, double newW, double newH) {
        Image tmp = img.getScaledInstance((int) newW, (int) newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage((int) newW, (int) newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

}
