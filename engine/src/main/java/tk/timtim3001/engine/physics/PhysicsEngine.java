package tk.timtim3001.engine.physics;

import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.exceptions.PhysicsEngineAlreadyInitializedException;

public class PhysicsEngine {

    private static Engine engine;
    private static float speedMultiplier = 1;

    public static void start(PhysicsEngineUpdateCallback callback){
        if(engine != null)
            throw new PhysicsEngineAlreadyInitializedException("Physics engine can only be initialized once");
        engine = Engine.getInstance();
        new Thread(() -> {
            long nextUpdateTime = System.currentTimeMillis() + 20;
            while(true) {
                callback.physicsUpdate();
                while(System.currentTimeMillis() < nextUpdateTime);
                nextUpdateTime = System.currentTimeMillis() + 20;
            }
        }).start();
    }

    public static void setSpeedMultiplier(float speedMultiplier){
        PhysicsEngine.speedMultiplier = speedMultiplier;
    }

    public static float getSpeedMultiplier() {
        return speedMultiplier;
    }

    public interface PhysicsEngineUpdateCallback{
        void physicsUpdate();
    }

}
