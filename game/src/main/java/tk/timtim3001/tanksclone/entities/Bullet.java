package tk.timtim3001.tanksclone.entities;

import tk.timtim3001.engine.components.BodyComponent;
import tk.timtim3001.engine.components.ColliderComponent;
import tk.timtim3001.engine.components.Sprite;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.tanksclone.components.BulletComponent;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Bullet extends GameObject {

    public Bullet() {
        super(0, 0, 8, 8, 0);
        try {
            addComponent(new Sprite(0, ImageIO.read(getClass().getResource("/images/bullet.png"))));
            addComponent(new BodyComponent(BodyComponent.PhysicsMassType.MASS_TYPE_NORMAL));
            addComponent(new ColliderComponent(ColliderComponent.ColliderType.BOX));
            addComponent(new BulletComponent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBullet(float x, float y){
        setPosition(x, y);
        Engine.getInstance().addGameObject(this);
    }
}
