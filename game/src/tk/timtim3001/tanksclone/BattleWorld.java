package tk.timtim3001.tanksclone;

import tk.timtim3001.engine.components.Sprite;
import tk.timtim3001.engine.components.TerrainComponent;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.engine.terrain.TerrainGenerator;
import tk.timtim3001.engine.ui.Button;
import tk.timtim3001.engine.ui.UICanvas;
import tk.timtim3001.engine.ui.UIElement;
import tk.timtim3001.engine.ui.UIManager;
import tk.timtim3001.engine.window.WindowManager;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;

public class BattleWorld {

    public BattleWorld() {
        try {
            Engine engine = Engine.getInstance();

            GameObject mario = new GameObject();
            URL url = getClass().getResource("/images/mario.png");
            Sprite sprite = new Sprite(1, ImageIO.read(url));
            mario.addComponent(sprite);
            mario.addComponent(new DebugComponent());
            mario.setPosition(400, 200);

            GameObject terrain = new GameObject();
            TerrainComponent terrainComponent = new TerrainComponent(2,
                    TerrainGenerator.generateTerrain(2000, 100));
            terrain.addComponent(terrainComponent);
            terrain.setPosition(-1, WindowManager.getInstance().getWindow().getHeight() - 100);

            UICanvas uiCanvas = new UICanvas(0, 100, 500, 500);
            uiCanvas.setBackgroundColor(Color.CYAN);
            uiCanvas.addElement(new TestUIElement(10, 10, "Dit is een knop"));
            uiCanvas.addElement(new UIElement(400, 100, 50, 200));

            UICanvas mainUI = new UICanvas(0, 0, 1280, 100);
            mainUI.setBackgroundColor(Color.RED);
            Button button = new Button(10, 10, "Open menu");
            button.addOnClickListener(() -> UIManager.displayCanvas("test"));
            mainUI.addElement(button);

            engine.addGameObject(mario);
            engine.addGameObject(terrain);

            UIManager.registerCanvas("main", mainUI);
            UIManager.registerCanvas("test", uiCanvas);

            UIManager.displayCanvas("main");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
