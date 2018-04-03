package tk.timtim3001.engine.core;

import org.dyn4j.collision.manifold.Manifold;
import org.dyn4j.collision.narrowphase.Penetration;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.CollisionAdapter;
import org.dyn4j.dynamics.World;
import org.dyn4j.dynamics.contact.ContactConstraint;
import org.dyn4j.geometry.Vector2;
import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.physics.PhysicsEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GameWorld {

    private List<GameObject> gameObjects;
    private World world;
    private CollisionListener listener;

    GameWorld(){
        gameObjects = new ArrayList<>();
        world = new World();
        world.setGravity(new Vector2(0, 9.8));

        listener = new CollisionListener();
        world.addListener(listener);
    }

    void update(){
        for(Object gameObject : gameObjects.toArray())
            ((GameObject) gameObject).update();
        listener.update();
    }

    void physicsUpdate(){
        double timeElapsed = Time.deltaTime * PhysicsEngine.getSpeedMultiplier();
        world.update(timeElapsed);
        for(Object gameObject : gameObjects.toArray())
            ((GameObject) gameObject).fixedUpdate();
    }

    void pause(){
        for(GameObject gameObject : gameObjects)
            gameObject.pause();
    }

    void resume(){
        for(GameObject gameObject : gameObjects)
            gameObject.resume();
    }

    void addGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
        gameObject.start();
        gameObject.resume();
    }

    void removeGameObject(GameObject gameObject){
        gameObjects.remove(gameObject);
        gameObject.destroy();
    }

    void addPhysicsBody(Body body, GameObject parent){
        world.addBody(body);
        listener.addCollisionBody(body, parent);
    }

    void removePhysicsBody(Body body){
        world.removeBody(body);
        listener.removeCollisionBody(body);
    }

    public World getPhysicsWorld() {
        return world;
    }

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }
}
