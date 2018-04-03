package tk.timtim3001.tanksclone.entities;

import tk.timtim3001.engine.components.Sprite;
import tk.timtim3001.engine.core.GameObject;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Barrel extends GameObject {

    public Barrel(double x, double y, double width, double height, double rotation) {
        super(x, y, width, height, rotation);
        try {
            addComponent(new Sprite(0, ImageIO.read(getClass().getResource("/images/tank_barrel.png"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
