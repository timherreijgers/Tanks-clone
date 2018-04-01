package tk.timtim3001.engine.physics.colliders;

import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.geometry.Geometry;
import tk.timtim3001.engine.core.Engine;

public class BoxCollider implements Collider{

    private BodyFixture bodyFixture;
    private float width;
    private float height;

    public BoxCollider(double width, double height){
        bodyFixture = new BodyFixture(Geometry.createRectangle(width / Engine.PPM, height / Engine.PPM));
        bodyFixture.setRestitution(0.25);
        this.width = (float) width / Engine.PPM;
        this.height = (float) height / Engine.PPM;
    }

    @Override
    public BodyFixture getBodyFixture() {
        return bodyFixture;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }
}
