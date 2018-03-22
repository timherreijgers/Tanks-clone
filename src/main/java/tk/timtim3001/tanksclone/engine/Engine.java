package tk.timtim3001.tanksclone.engine;

import tk.timtim3001.tanksclone.engine.window.Window;
import tk.timtim3001.tanksclone.engine.window.WindowDimension;
import tk.timtim3001.tanksclone.engine.window.WindowManager;


import java.util.ArrayList;
import java.util.List;

public class Engine {

    private WindowManager windowManager;
    private List<GameObject> gameObjects;

    private static Engine instance;

    public static Engine getInstance(){
        if(instance == null)
            instance = new Engine();
        return instance;
    }

    private Engine(){
        System.setProperty("sun.java2d.opengl", "true");

        gameObjects = new ArrayList<>();

        windowManager = WindowManager.getInstance();
        windowManager.createWindow(WindowDimension.DIMENSION_720P, "Tanks");
        Window window = windowManager.getWindow();

        new Thread(()->{
            while(true){
                for(GameObject gameObject : gameObjects){
                    gameObject.update();
                }
                window.updateWindow();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void addGameObject(GameObject object){
        gameObjects.add(object);
        object.start();
    }

    public void removeObject(GameObject object){
        gameObjects.remove(object);
    }

}
