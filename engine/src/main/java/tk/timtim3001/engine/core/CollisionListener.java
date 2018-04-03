package tk.timtim3001.engine.core;

import org.dyn4j.collision.manifold.Manifold;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.BodyFixture;
import org.dyn4j.dynamics.CollisionAdapter;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CollisionListener extends CollisionAdapter {

    private Map<Body, GameObject> bodyGameObjectMap = new HashMap<>();
    private Set<Collision> lastCollisions = new HashSet<>();
    private Set<Collision> newCollisions = new HashSet<>();

    public void update(){
        Iterator<Collision> iterator = newCollisions.iterator();
        while(iterator.hasNext()){
            Collision next = iterator.next();
            if(!lastCollisions.contains(next)){
                GameObject gameObject1 = bodyGameObjectMap.get(next.body1);
                GameObject gameObject2 = bodyGameObjectMap.get(next.body2);

                gameObject1.onCollision(gameObject2);
                gameObject2.onCollision(gameObject1);
            }
        }
        lastCollisions.clear();
        lastCollisions.addAll(newCollisions);
        newCollisions.clear();
    }

    public void addCollisionBody(Body body, GameObject parent){
        this.bodyGameObjectMap.put(body, parent);
    }

    public void removeCollisionBody(Body body){
        this.bodyGameObjectMap.remove(body);
    }

    @Override
    public boolean collision(Body body1, BodyFixture fixture1, Body body2, BodyFixture fixture2, Manifold manifold) {
        newCollisions.add(new Collision(body1, body2));
        return true;
    }

    private class Collision{
        private Body body1;
        private Body body2;

        public Collision(Body body1, Body body2) {
            this.body1 = body1;
            this.body2 = body2;
        }

        public Body getBody1() {
            return body1;
        }

        public Body getBody2() {
            return body2;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Collision))
                return false;

            Collision other = (Collision) o;
            return body1.equals(other.body1) && body2.equals(other.body2);
        }
    }

}
