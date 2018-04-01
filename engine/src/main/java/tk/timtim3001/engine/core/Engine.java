package tk.timtim3001.engine.core;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import tk.timtim3001.engine.exceptions.WorldNotInitializedException;
import tk.timtim3001.engine.input.Input;
import tk.timtim3001.engine.window.Window;
import tk.timtim3001.engine.window.WindowDimension;
import tk.timtim3001.engine.window.WindowManager;

import java.util.HashMap;
import java.util.Map;

public class Engine {

    public static final float PPM = 100.0f;

    private WindowManager windowManager;
    private GameLoop gameLoop;
    private Map<String, GameWorld> worldMap;
    private GameWorld activeWorld;

    private static Engine instance;

    public static Engine getInstance(){
        if(instance == null) {
            instance = new Engine();
            instance.start();
        }
        return instance;
    }

    private Engine(){
        worldMap = new HashMap<>();
        windowManager = WindowManager.getInstance();
    }

    private void start(){
        windowManager.createWindow(WindowDimension.DIMENSION_720P, "Tanks");
        Window window = windowManager.getWindow();
        gameLoop = new GameLoop(window);
        Input.getInstance();

        gameLoop.start();
    }

    public void setGameWorld(String name){
        if(activeWorld != null)
            activeWorld.pause();

        if(!worldMap.keySet().contains(name))
            worldMap.put(name, new GameWorld());

        activeWorld = worldMap.get(name);
        activeWorld.resume();
    }

    public void addGameObject(GameObject object){
        if(activeWorld == null) {
            throw new WorldNotInitializedException("You have to initialize the world using setGameWorld.");
        }

        activeWorld.addGameObject(object);
    }

    public void removeObject(GameObject object){
        if(activeWorld == null) {
            throw new WorldNotInitializedException("You have to initialize the world using setGameWorld.");
        }

        activeWorld.removeGameObject(object);
    }

    public void addPhysicsObject(Body body){
        if(activeWorld == null) {
            throw new WorldNotInitializedException("You have to initialize the world using setGameWorld.");
        }

        activeWorld.addPhysicsBody(body);
    }

    public void removePhysicsObject(Body body){
        if(activeWorld == null) {
            throw new WorldNotInitializedException("You have to initialize the world using setGameWorld.");
        }

        activeWorld.removePhysicsBody(body);
    }

    public void sync(int fps){
        if(fps < 0)
            throw new RuntimeException("Fps should be greater then 0");
        Time.setTargetFps(fps);
    }

    public World getPhysicsWorld(){
        if(activeWorld == null) {
            return null;
        }

        return activeWorld.getPhysicsWorld();
    }

    GameWorld getActiveGameWorld(){
        return activeWorld;
    }

    int getTargetFps() {
        return Time.getTargetFps();
    }

    public double getFps(){
        return gameLoop.getFps();
    }
}
