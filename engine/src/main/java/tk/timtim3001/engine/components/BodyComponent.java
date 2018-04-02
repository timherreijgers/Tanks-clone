package tk.timtim3001.engine.components;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.Force;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.exceptions.MissingComponentException;
import tk.timtim3001.engine.physics.colliders.Collider;

public class BodyComponent extends Component {

    private Body body;
    private Collider collider;
    private MassType massType;
    private Engine engine;

    public BodyComponent(PhysicsMassType massType){
        switch (massType){
            case MASS_TYPE_NORMAL:
                this.massType = MassType.NORMAL;
                break;
            case MASS_TYPE_INFINITE:
                this.massType = MassType.INFINITE;
                break;
            case MASS_TYPE_FIXED_ANGULAR_VELOCITY:
                this.massType = MassType.FIXED_ANGULAR_VELOCITY;
                break;
            case MASS_TYPENORMAL_FIXED_LINEAR_VELOCITY:
                this.massType = MassType.FIXED_LINEAR_VELOCITY;
                break;
        }
    }

    @Override
    public void start() {
        ColliderComponent colliderComponent = parent.getComponent(ColliderComponent.class);
        if(colliderComponent == null)
            throw new MissingComponentException("BodyComponent needs a ColliderComponent to be attached to the GameObject");

        this.collider = colliderComponent.getCollider();

        body = new Body();
        body.addFixture(collider.getBodyFixture());
        double x = parent.getPhysicsTransform().getTranslateX();
        double y = parent.getPhysicsTransform().getTranslateY();
        body.translate(x, y);
        body.rotate(parent.getRotation());
        body.setMass(massType);
    }

    @Override
    public void fixedUpdate() {
        float x = (float) body.getTransform().getTranslationX();
        float y = (float) body.getTransform().getTranslationY();
        double rotation = body.getTransform().getRotation();
        parent.setPosition(x * Engine.PPM, y * Engine.PPM);
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

    public enum PhysicsMassType{
        MASS_TYPE_NORMAL,
        MASS_TYPE_INFINITE,
        MASS_TYPE_FIXED_ANGULAR_VELOCITY,
        MASS_TYPENORMAL_FIXED_LINEAR_VELOCITY
    }
}
