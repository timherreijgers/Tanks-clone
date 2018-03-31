package tk.timtim3001.engine.physics.colliders;

import org.dyn4j.dynamics.BodyFixture;

public interface Collider {

    BodyFixture getBodyFixture();
    int getWidth();
    int getHeight();

}
