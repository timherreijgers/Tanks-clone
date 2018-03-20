package tk.timtim3001.tanksclone;

import tk.timtim3001.tanksclone.engine.Terrain;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {

    private Terrain terrain;

    public GamePanel(Area terrain) {
        this.terrain = new Terrain(terrain);
        this.terrain.demolishShape(new Rectangle2D.Double(100, 600, 10, 10));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        terrain.draw(graphics2D);
    }
}
