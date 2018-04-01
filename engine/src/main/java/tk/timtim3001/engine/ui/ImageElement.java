package tk.timtim3001.engine.ui;

import tk.timtim3001.engine.utils.ImageUtils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class ImageElement extends UIElement{

    private BufferedImage image;

    public ImageElement(int x, int y, int width, int height, BufferedImage image) {
        super(x, y, width, height);
        this.image = ImageUtils.resize(image, width, height);
    }

    @Override
    protected void draw(Graphics2D g) {
        g.drawImage(image, null, null);
    }
}
