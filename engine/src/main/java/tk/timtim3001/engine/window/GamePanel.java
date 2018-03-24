package tk.timtim3001.engine.window;

import tk.timtim3001.engine.renderer.SpriteRenderer;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel {

    private SpriteRenderer renderer;

    GamePanel(int width, int height){
        setPreferredSize(new Dimension(width, height));
        renderer = SpriteRenderer.getInstance();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        renderer.drawSprites((Graphics2D) graphics);
    }
}
