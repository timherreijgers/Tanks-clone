package tk.timtim3001.engine.core;

import tk.timtim3001.engine.components.Component;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private Point2D position;
    private double width;
    private double height;
    private double rotation;
    private double scaleX = 1;
    private double scaleY = 1;
    private boolean hasCollided;

    private List<Component> components;

    public GameObject(){
        position = new Point2D.Double(0,0);
        width = 1;
        height = 1;
        rotation = 0;

        components = new ArrayList<>();
    }

    public GameObject(double x, double y, double width, double height, double rotation){
        this.position = new Point2D.Double(x - width / 2, y - height / 2);
        this.width = width;
        this.height = height;
        this.rotation = rotation;

        components = new ArrayList<>();
    }

    public void addComponent(Component component){
        components.add(component);
        component.setParent(this);
    }

    public void translate(int dx, int dy){
        position.setLocation(position.getX() + dx, position.getY() + dy);
    }

    public void setPosition(float x, float y){
        setPosition(new Point2D.Double((x - width / 2), (y - height / 2)));
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setPosition(Point2D position){
        this.position = position;
    }

    public void rotate(double rotation){
        this.rotation += rotation;
    }

    public void setHasCollided(boolean hasCollided){
        this.hasCollided = hasCollided;
    }

    public AffineTransform getTransform(){
        AffineTransform transform = new AffineTransform();
        transform.translate(position.getX(), position.getY());
        transform.rotate(rotation, width / 2, height / 2);
        return transform;
    }

    public AffineTransform getPhysicsTransform(){
        AffineTransform transform = new AffineTransform();
        transform.translate((position.getX() + width / 2) / Engine.PPM, (position.getY() + height / 2) / Engine.PPM);
        transform.rotate(rotation);
        return transform;
    }

    @SuppressWarnings("unchecked")
    public <T> T getComponent(Class<T> component){
        for(Component c : components){
            if(component.isInstance(c))
                return (T) c;
        }
        return null;
    }

    public double getRotation() {
        return rotation;
    }

    public Point2D getPosition() {
        return position;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    protected void start(){
        for (Component component : components) {
            component.start();
        }
    }

    protected void resume(){
        for(Component component : components)
            component.resume();
    }

    protected void update(){
        if(hasCollided)
            onCollision();

        try {
            for (Component component : components) {
                component.update();
            }
        }catch (Exception e){
            System.out.println("NULLPOINTER!");
        }
    }

    protected void fixedUpdate(){
        for(Component component : components){
            component.fixedUpdate();
        }
    }

    protected void pause(){
        for(Component component : components)
            component.pause();
    }

    protected void onCollision(){
        for(Component component : components)
            component.onCollision();
    }

    protected void destroy(){

    }
}
