package tk.timtim3001.engine.core;

import tk.timtim3001.engine.components.Component;

import java.util.ArrayList;
import java.util.List;

class GameWorld {

    private List<GameObject> gameObjects;

    GameWorld(){
        gameObjects = new ArrayList<>();
    }

    void update(){
        for(GameObject gameObject : gameObjects)
            gameObject.update();
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

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }
}
