package tk.timtim3001.tanksclone.engine.renderer;

import tk.timtim3001.tanksclone.engine.Component;
import tk.timtim3001.tanksclone.engine.GameObject;

import java.awt.image.BufferedImage;

public class Sprite extends Component {

    private int layer;
    private BufferedImage image;
    private GameObject parent;

    public Sprite(int layer, BufferedImage image, GameObject parent) {
        this.layer = layer;
        this.image = image;
        this.parent = parent;
    }

    @Override
    public void start() {
        SpriteRenderer.getInstance().addSpriteToRenderer(this);
    }

    public int getLayer() {
        return layer;
    }

    public BufferedImage getImage() {
        return image;
    }

    public GameObject getParent() {
        return parent;
    }
}
