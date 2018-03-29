package tk.timtim3001.engine.terrain;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

public class Terrain {

    Area terrainArea;
    private BufferedImage image;

    Terrain(Area terrainArea){
        this.terrainArea = terrainArea;
        generateImage();
    }

    void generateImage(){
        image = new BufferedImage((int) terrainArea.getBounds().getWidth(), (int) terrainArea.getBounds().getHeight(),
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.draw(terrainArea);
        g.dispose();
    }

    public BufferedImage getImage(){
        return image;
    }
}
