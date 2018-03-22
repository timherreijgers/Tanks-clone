package tk.timtim3001.tanksclone.engine;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<GameObject> gameObjects;

    public World(){
        gameObjects = new ArrayList<>();
    }

    public void update(){
        for(GameObject gameObject : gameObjects)
            gameObject.update();
    }

}
