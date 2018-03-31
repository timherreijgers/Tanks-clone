package tk.timtim3001.engine.window;

import org.dyn4j.dynamics.World;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.renderer.DebugDraw;
import tk.timtim3001.engine.renderer.SpriteRenderer;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class GamePanel extends JPanel {

    private SpriteRenderer renderer;

    GamePanel(int width, int height){
        setPreferredSize(new Dimension(width, height));
        renderer = SpriteRenderer.getInstance();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
//        renderer.render((Graphics2D) graphics);
        World world = Engine.getInstance().getPhysicsWorld();
        if(world != null)
            DebugDraw.draw((Graphics2D) graphics, world, 1);
        tk.timtim3001.engine.ui.UIManager.draw((Graphics2D) graphics);

        Toolkit.getDefaultToolkit().sync();
    }
}
