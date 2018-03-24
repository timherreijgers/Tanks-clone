package tk.timtim3001.engine.core;

import tk.timtim3001.engine.window.Window;

class GameLoop {

    private Window window;
    private Engine engine;
    private double fps;

    GameLoop(Window window){
        this.window = window;
        engine = Engine.getInstance();
    }

    void start(){
        Thread thread = new Thread(() -> {
            while(true) {
                Time.update();
                if (engine.getActiveGameWorld() != null)
                    engine.getActiveGameWorld().update();
                window.updateWindow();

                sync();
            }
        });
        thread.start();
    }

    private void sync(){
        Time.sync();
        long currentTime = Time.getCurrentTime();
        long lastTime = Time.getLastTime();
        long difference = (currentTime - lastTime);
        if(difference != 0)
            fps = 1000 / difference;
        else
            fps = 9999;
    }

    double getFps(){
        return fps;
    }
}
