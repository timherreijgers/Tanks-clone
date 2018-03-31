package tk.timtim3001.engine.physics.colliders;

import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Geometry;

public class BoxCollider implements Collider{

    private BodyFixture bodyFixture;
    private int width;
    private int height;

    public BoxCollider(int width, int height){
        bodyFixture = new BodyFixture(Geometry.createRectangle(width, height));
        bodyFixture.setRestitution(0.25);
        this.width = width;
        this.height = height;
    }

    @Override
    public BodyFixture getBodyFixture() {
        return bodyFixture;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
