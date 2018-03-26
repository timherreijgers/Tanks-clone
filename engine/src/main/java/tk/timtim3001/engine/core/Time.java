package tk.timtim3001.engine.core;

public class Time {

    public static double deltaTime;
    private static long lastTime;
    private static long syncTime;
    private static int targetFps = 60;

    static void update(){
        long currentTime = System.currentTimeMillis();
        syncTime = currentTime + (1000 / targetFps);
        deltaTime = (currentTime - lastTime) / 1000d;
        if(deltaTime > 0.5)
            deltaTime = 0.5;
        lastTime = currentTime;
    }

    static void setTargetFps(int targetFps){
        Time.targetFps = targetFps;
    }

    static int getTargetFps(){
        return targetFps;
    }

    //TODO: Make this spot on the framerate instead of like 2 higher
    static void sync(){
        long currentTime = System.currentTimeMillis();
        while(currentTime < syncTime){
            currentTime = System.currentTimeMillis();
        }
    }

    static long getCurrentTime(){
        return System.currentTimeMillis();
    }

    static long getLastTime(){
        return lastTime;
    }
}
