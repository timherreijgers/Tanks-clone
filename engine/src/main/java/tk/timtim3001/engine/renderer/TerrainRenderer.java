package tk.timtim3001.engine.renderer;

import tk.timtim3001.engine.components.TerrainComponent;
import tk.timtim3001.engine.terrain.Terrain;

import java.awt.Graphics2D;
import java.util.HashSet;
import java.util.Set;

public class TerrainRenderer extends Renderer {

    private Set<TerrainComponent> terrains;

    private static TerrainRenderer instance;

    public static TerrainRenderer getInstance(){
        if(instance == null)
            instance = new TerrainRenderer();
        return instance;
    }

    private TerrainRenderer() {
        super();
        terrains = new HashSet<>();
    }

    public void addTerrain(TerrainComponent terrain){
        terrains.add(terrain);
    }

    public void removeTerrain(TerrainComponent terrain){
        terrains.remove(terrain);
    }

    @Override
    public void render(Graphics2D g) {
        Graphics2D graphics2D = (Graphics2D) g.create();
        for(TerrainComponent terrain : terrains){
            graphics2D.setTransform(terrain.getParent().getTransform());
            graphics2D.fill(terrain.getTerrain().getTerrainArea());
        }
    }
}
