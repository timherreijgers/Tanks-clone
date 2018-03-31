package tk.timtim3001.tanksclone;

import org.dyn4j.geometry.MassType;
import tk.timtim3001.engine.components.BodyComponent;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.engine.physics.colliders.BoxCollider;

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
        BodyComponent component1 = new BodyComponent(new BoxCollider(1000, 10), MassType.INFINITE);
        floor.addComponent(component1);

        GameObject block = new GameObject();
        block.translate(500, 0);
        BodyComponent component2 = new BodyComponent(new BoxCollider(10, 10), MassType.NORMAL);
        block.addComponent(component2);

        engine.addGameObject(floor);
        engine.addGameObject(block);
    }
}
