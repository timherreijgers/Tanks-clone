package tk.timtim3001.engine.core;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Vector2;
import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.physics.PhysicsEngine;

import java.util.ArrayList;
import java.util.List;

class GameWorld {

    private List<GameObject> gameObjects;
    private World world;

    GameWorld(){
        gameObjects = new ArrayList<>();
        world = new World();
        world.setGravity(new Vector2(0, 9.8));
    }

    void update(){
        for(GameObject gameObject : gameObjects)
            gameObject.update();
    }

    void physicsUpdate(){
        double timeElapsed = Time.deltaTime * PhysicsEngine.getSpeedMultiplier() * 100000;
        System.out.println(timeElapsed);
        world.update(timeElapsed);
        for(GameObject gameObject : gameObjects)
            gameObject.fixedUpdate();
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

    void addPhysicsBody(Body body){
        world.addBody(body);
    }

    void removePhysicsBody(Body body){
        world.removeBody(body);
    }

    public World getPhysicsWorld() {
        return world;
    }

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }
}
