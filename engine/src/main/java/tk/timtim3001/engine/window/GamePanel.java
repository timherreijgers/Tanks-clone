package tk.timtim3001.engine.window;

import org.dyn4j.dynamics.World;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.renderer.DebugDraw;
import tk.timtim3001.engine.renderer.Renderer;
import tk.timtim3001.engine.renderer.SpriteRenderer;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class GamePanel extends JPanel {

    GamePanel(int width, int height){
        setPreferredSize(new Dimension(width, height));
        SpriteRenderer.getInstance();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Renderer.renderAll((Graphics2D) graphics);
        World world = Engine.getInstance().getPhysicsWorld();
        if(world != null)
            DebugDraw.draw((Graphics2D) graphics, world);
        tk.timtim3001.engine.ui.UIManager.draw((Graphics2D) graphics);

        Toolkit.getDefaultToolkit().sync();
    }
}
