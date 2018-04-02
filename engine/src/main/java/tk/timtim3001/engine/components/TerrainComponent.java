package tk.timtim3001.engine.components;

import tk.timtim3001.engine.terrain.Terrain;
import tk.timtim3001.engine.terrain.TerrainGenerator;

import java.awt.image.BufferedImage;

public class TerrainComponent extends Component {

    private Terrain terrain;
    private TerrainType terrainType;

    public TerrainComponent(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    @Override
    public void resume() {
        switch (terrainType){
            case NORMAL:
                this.terrain = TerrainGenerator.generateTerrain((int) parent.getWidth(), (int) parent.getHeight());
                break;
            case DESTRUCTABLE:
                this.terrain = TerrainGenerator.generateDestructableTerrain((int) parent.getWidth(), (int) parent.getHeight());
                break;
        }
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public enum TerrainType{
        NORMAL, DESTRUCTABLE
    }
}
