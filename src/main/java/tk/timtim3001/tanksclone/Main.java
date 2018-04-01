package tk.timtim3001.tanksclone;

import org.dyn4j.geometry.MassType;
import tk.timtim3001.engine.components.BodyComponent;
import tk.timtim3001.engine.components.Sprite;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.engine.physics.colliders.BoxCollider;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Main {

    public static void main(String args[]){
        new Main();
    }

    private Main(){
        Engine engine = Engine.getInstance();
        engine.sync(60);
        engine.setGameWorld("Main");

        GameObject floor = new GameObject();
        floor.translate(0, 600);
        floor.rotate(Math.PI / 30);
        BodyComponent component1 = new BodyComponent(new BoxCollider(1000, 10), MassType.INFINITE);
        floor.addComponent(component1);

//        GameObject block = new GameObject();
//        block.translate(500, 0);
//        BodyComponent component2 = new BodyComponent(new BoxCollider(10, 10), MassType.NORMAL);
//        block.addComponent(component2);

//        GameObject test = new GameObject(100, 100, 640, 640, 0);
//        try {
//            test.addComponent(new Sprite(1, ImageIO.read(getClass().getResource("/images/test.png"))));
//            test.addComponent(new DebugComponent());
////            test.addComponent(new BodyComponent(new BoxCollider(64,64), MassType.NORMAL));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        engine.addGameObject(test);

        GameObject test2 = new GameObject(100, 100, 64, 64, 0);
        try {
            test2.addComponent(new Sprite(2, ImageIO.read(getClass().getResource("/images/test.png"))));
            test2.addComponent(new DebugComponent());
            test2.addComponent(new BodyComponent(new BoxCollider(test2.getWidth(),test2.getHeight()), MassType.NORMAL));
        } catch (IOException e) {
            e.printStackTrace();
        }
        engine.addGameObject(test2);

//        test.setPosition(200, 300);
        test2.setPosition(200, 300);

        engine.addGameObject(floor);
//        engine.addGameObject(block);
    }
}
