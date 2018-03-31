package tk.timtim3001.engine.components;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.Force;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.physics.colliders.Collider;

public class BodyComponent extends Component {

    private Body body;
    private Collider collider;
    private MassType massType;
    private Engine engine;

    public BodyComponent(Collider collider, MassType massType){
        this.collider = collider;
        this.massType = massType;
    }

    @Override
    public void start() {
        body = new Body();
        body.addFixture(collider.getBodyFixture());
        double x = parent.getTransform().getTranslateX() + collider.getWidth() / 2;
        double y = parent.getTransform().getTranslateY() + collider.getHeight() / 2;
        body.translate(x, y);
        body.rotate(parent.getRotation());
        body.setMass(massType);
    }

    @Override
    public void fixedUpdate() {
        int x = (int) Math.round(body.getTransform().getTranslationX());
        int y = (int) Math.round(body.getTransform().getTranslationY());
        double rotation = body.getTransform().getRotation();
        parent.setPosition(x, y);
        parent.setRotation(rotation);
    }

    public void addForce(Vector2 force){
        body.applyForce(force);
    }

    public void addForce(Vector2 force, Vector2 point){
        body.applyForce(force, point);
    }

    public void addForce(Force force){
        body.applyForce(force);
    }

    @Override
    public void resume() {
        engine = Engine.getInstance();
        engine.addPhysicsObject(body);
    }

    @Override
    public void pause() {
        engine.removePhysicsObject(body);
    }
}
