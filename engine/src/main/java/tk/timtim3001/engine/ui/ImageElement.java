package tk.timtim3001.engine.ui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageElement extends UIElement{

    private BufferedImage image;

    public ImageElement(int x, int y, int width, int height, BufferedImage image) {
        super(x, y, width, height);
        this.image = resize(image, width, height);
    }

    private BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    @Override
    protected void draw(Graphics2D g) {
        g.drawImage(image, null, null);
    }
}
