package tk.timtim3001.engine.components;

import tk.timtim3001.engine.terrain.Terrain;

import java.awt.image.BufferedImage;

public class TerrainComponent extends Sprite {

    private Terrain terrain;

    public TerrainComponent(int layer, Terrain terrain) {
        super(layer);
        this.terrain = terrain;
    }

    @Override
    public BufferedImage getImage() {
        return terrain.getImage();
    }

    public Terrain getTerrain() {
        return terrain;
    }
}
