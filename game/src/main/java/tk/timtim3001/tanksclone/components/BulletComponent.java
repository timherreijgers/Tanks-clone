package tk.timtim3001.tanksclone.components;

import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.components.TerrainComponent;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.core.GameObject;
import tk.timtim3001.engine.terrain.DestructableTerrain;

import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;

public class BulletComponent extends Component {

    @Override
    public void onCollision(GameObject other) {
        if(other.getTag().equals("Terrain")) {
            ((DestructableTerrain) other.getComponent(TerrainComponent.class).getTerrain())
                    .destroy(new Area(new Ellipse2D.Double(parent.getTransform().getTranslateX() - 50,
                            parent.getTransform().getTranslateY() - other.getTransform().getTranslateY() - 50,
                            100, 100)));
            Engine.getInstance().removeObject(parent);

            Area area = new Area();
            PathIterator pathIterator = area.getPathIterator(null);
        }
    }
}
