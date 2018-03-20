package tk.timtim3001.tanksclone.engine.renderer;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Renderable {

    private Point2D position;

    public void update(){

    }

    public abstract void draw(Graphics2D g);

}
