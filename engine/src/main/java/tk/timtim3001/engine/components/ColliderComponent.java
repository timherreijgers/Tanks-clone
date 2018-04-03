package tk.timtim3001.engine.components;

import tk.timtim3001.engine.physics.colliders.BoxCollider;
import tk.timtim3001.engine.physics.colliders.Collider;
import tk.timtim3001.engine.physics.colliders.TerrainCollider;
import tk.timtim3001.engine.renderer.TerrainRenderer;

import java.awt.geom.PathIterator;

public class ColliderComponent extends Component {

    private Collider collider;
    private ColliderType colliderType;

    public ColliderComponent(ColliderType colliderType){
        this.colliderType = colliderType;
    }

    @Override
    public void start() {
        switch (colliderType) {
            case BOX:
                this.collider = new BoxCollider(parent.getWidth(), parent.getHeight());
                break;
            case TERRAIN:
                this.collider = new TerrainCollider(parent.getWidth(), parent.getHeight());
                break;
        }
    }

    public Collider getCollider(){
        return collider;
    }

    public enum ColliderType{
        BOX, TERRAIN
    }

}
