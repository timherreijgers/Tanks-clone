package tk.timtim3001.engine.core;

import tk.timtim3001.engine.exceptions.WorldNotInitializedException;
import tk.timtim3001.engine.window.Window;
import tk.timtim3001.engine.window.WindowDimension;
import tk.timtim3001.engine.window.WindowManager;

import java.util.HashMap;
import java.util.Map;

public class Engine {

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
        System.setProperty("sun.java2d.opengl", "true");

        worldMap = new HashMap<>();
        windowManager = WindowManager.getInstance();
    }

    private void start(){
        windowManager.createWindow(WindowDimension.DIMENSION_720P, "Tanks");
        Window window = windowManager.getWindow();
        gameLoop = new GameLoop(window);

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

    public void sync(int fps){
        if(fps < 0)
            throw new RuntimeException("Fps should be greater then 0");
        Time.setFps(fps);
    }

    GameWorld getActiveGameWorld(){
        return activeWorld;
    }

    int getTargetFps() {
        return Time.getFps();
    }

    public double getFps(){
        return gameLoop.getFps();
    }
}
