package tk.timtim3001.tanksclone.components;

import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;

public class BulletComponent extends Component {

    @Override
    public void onCollision(GameObject other) {
        if(other.getTag().equals("Terrain"))
            Engine.getInstance().removeObject(parent);
    }
}
