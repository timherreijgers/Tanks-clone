package tk.timtim3001.tanksclone;

import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.engine.components.Sprite;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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
           // gameObject.addComponent(new DebugComponent());
            Engine engine = Engine.getInstance();
            engine.sync(60);
            engine.setGameWorld("Main");
            engine.addGameObject(gameObject);

            System.out.println(gameObject.getComponent(Sprite.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
