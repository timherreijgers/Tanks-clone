package tk.timtim3001.tanksclone.engine;

import tk.timtim3001.tanksclone.engine.renderer.Renderable;

import java.awt.*;
import java.awt.geom.Area;

public class Terrain extends Renderable{

    private Area terrain;

    public Terrain(Area terrain){
        this.terrain = terrain;
    }

    public void demolishShape(Shape shape){
        Area areaToDestroy = new Area(shape);
        terrain.subtract(areaToDestroy);
    }

    public void draw(Graphics2D g) {
        g.fill(terrain);
    }
}
