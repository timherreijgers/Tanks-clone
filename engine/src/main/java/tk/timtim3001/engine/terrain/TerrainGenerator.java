package tk.timtim3001.engine.terrain;

import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class TerrainGenerator {

    public static Terrain generateTerrain(int width, int height){
        Terrain terrain = new Terrain(generateArea(width, height));
        return terrain;
    }

    public static DestructableTerrain generateDestructableTerrain(int width, int height){
        DestructableTerrain terrain = new DestructableTerrain(generateArea(width, height));
        return terrain;
    }

    private static Area generateArea(int width, int height){
        Area area = new Area(new Rectangle2D.Double(0, 0, width, height));
        return area;
    }
}
