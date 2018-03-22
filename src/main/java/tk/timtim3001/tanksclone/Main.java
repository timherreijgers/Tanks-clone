package tk.timtim3001.tanksclone;

import tk.timtim3001.tanksclone.engine.Engine;
import tk.timtim3001.tanksclone.engine.GameObject;
import tk.timtim3001.tanksclone.engine.renderer.Sprite;
import tk.timtim3001.tanksclone.engine.renderer.SpriteRenderer;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String args[]){
        new Main();
    }

    private Main(){
        try {
            GameObject gameObject = new GameObject();
            gameObject.translate(100, 200);
            Sprite sprite = new Sprite(1, ImageIO.read(getClass().getResource("/images/mario.png")), gameObject);
            gameObject.addComponent(sprite);
            Engine engine = Engine.getInstance();
            engine.addGameObject(gameObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
