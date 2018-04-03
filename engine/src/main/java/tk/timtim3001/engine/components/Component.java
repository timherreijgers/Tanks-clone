package tk.timtim3001.engine.components;

import tk.timtim3001.engine.core.GameObject;

public class Component {

    protected GameObject parent;

    public void setParent(GameObject parent){
        this.parent = parent;
    }

    public void start(){}

    public void resume(){}

    public void update(){}

    public void fixedUpdate(){}

    public void pause(){}

    public void destroy(){}

    public void onCollision(){

    }

    public GameObject getParent() {
        return parent;
    }

}
