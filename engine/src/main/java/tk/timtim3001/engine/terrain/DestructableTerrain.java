package tk.timtim3001.engine.terrain;

import java.awt.geom.Area;

public class DestructableTerrain extends Terrain {

    DestructableTerrain(Area terrainArea) {
        super(terrainArea);
    }

    public void destroy(Area areaToDestroy){
        terrainArea.subtract(areaToDestroy);
        generateImage();
    }
}
