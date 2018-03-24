package tk.timtim3001.engine.components;

import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.engine.renderer.SpriteRenderer;

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
    public void resume() {
        SpriteRenderer.getInstance().addSpriteToRenderer(this);
    }

    @Override
    public void pause() {
        SpriteRenderer.getInstance().removeSpriteFromRenderer(this);
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
