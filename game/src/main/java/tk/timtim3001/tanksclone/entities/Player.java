package tk.timtim3001.tanksclone.entities;

import tk.timtim3001.engine.components.BodyComponent;
import tk.timtim3001.engine.components.ColliderComponent;
import tk.timtim3001.engine.components.Sprite;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.tanksclone.components.PlayerComponent;

import javax.imageio.ImageIO;
import java.io.IOException;

import static tk.timtim3001.engine.components.BodyComponent.PhysicsMassType.MASS_TYPE_FIXED_ANGULAR_VELOCITY;

public class Player extends GameObject {

    public Player(double x, double y, double width, double height) {
        super(x, y, width, height, 0);
        try {
            addComponent(new Sprite(1, ImageIO.read(getClass().getResource("/images/tank_base.png"))));
            addComponent(new ColliderComponent(ColliderComponent.ColliderType.BOX));
            addComponent(new BodyComponent(MASS_TYPE_FIXED_ANGULAR_VELOCITY));
            addComponent(new PlayerComponent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
