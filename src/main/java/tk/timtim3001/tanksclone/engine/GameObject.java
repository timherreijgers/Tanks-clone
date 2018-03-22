package tk.timtim3001.tanksclone.engine;

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

    public void start(){
        for(Component component : components){
            component.start();
        }
    }

    public void update(){
        for(Component component : components){
            component.update();
        }

        translate(50, 0);
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

}
