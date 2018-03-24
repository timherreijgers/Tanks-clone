package tk.timtim3001.engine.core;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

public class Time {

    public static double deltaTime;
    private static long lastTime;
    private static long syncTime;
    private static int fps = 60;

    static void update(){
        long currentTime = System.currentTimeMillis();
        syncTime = currentTime + (1000 / fps);
        deltaTime = (currentTime - lastTime) / 1000d;
        if(deltaTime > 0.5)
            deltaTime = 0.5;
        lastTime = currentTime;
    }

    static void setFps(int fps){
        Time.fps = fps;
    }

    static int getFps(){
        return fps;
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
