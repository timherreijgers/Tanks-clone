package tk.timtim3001.engine.core;

import tk.timtim3001.engine.components.Component;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private Point2D position;
    private double scaleX;
    private double scaleY;
    private double rotation;

    private List<Component> components;

    public GameObject(){
        position = new Point2D.Double(0,0);
        scaleX = 1;
        scaleY = 1;
        rotation = 0;

        components = new ArrayList<>();
    }

    public void addComponent(Component component){
        components.add(component);
        component.start();
    }

    public void translate(int dx, int dy){
        position.setLocation(position.getX() + dx, position.getY() + dy);
    }

    public AffineTransform getTransform(){
        AffineTransform transform = new AffineTransform();
        transform.translate(position.getX(), position.getY());
        transform.scale(scaleX, scaleY);
        transform.rotate(rotation);
        return transform;
    }

    protected void start(){
        for(Component component : components){
            component.start();
        }
    }

    protected void resume(){
        for(Component component : components)
            component.resume();
    }

    protected void update(){
        for(Component component : components){
            component.update();
        }

        translate((int) Math.round(50 * Time.deltaTime), 0);
    }

    protected void pause(){
        for(Component component : components)
            component.pause();
    }

    protected void destroy(){

    }

}
