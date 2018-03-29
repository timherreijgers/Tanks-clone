package tk.timtim3001.tanksclone;

import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.components.TerrainComponent;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.engine.components.Sprite;
import tk.timtim3001.engine.terrain.Terrain;
import tk.timtim3001.engine.terrain.TerrainGenerator;
import tk.timtim3001.engine.window.WindowManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        new Main();
    }

    private Main(){
        try {
            Engine engine = Engine.getInstance();
            engine.sync(60);
            engine.setGameWorld("Main");

            GameObject mario = new GameObject();
            URL url = getClass().getResource("/images/mario.png");
            Sprite sprite = new Sprite(1, ImageIO.read(url));
            mario.addComponent(sprite);
            mario.setPosition(500, 200);

            GameObject terrain = new GameObject();
            TerrainComponent terrainComponent = new TerrainComponent(2,
                    TerrainGenerator.generateTerrain(2000, 100));
            terrain.addComponent(terrainComponent);
            terrain.setPosition(0, WindowManager.getInstance().getWindow().getHeight() - 100);

            engine.addGameObject(mario);
            engine.addGameObject(terrain);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
