package tk.timtim3001.tanksclone.components;

import tk.timtim3001.engine.components.BodyComponent;
import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.engine.input.Input;
import tk.timtim3001.tanksclone.entities.Barrel;
import tk.timtim3001.tanksclone.interfaces.GameUI;

import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public class PlayerComponent extends Component {

    private BodyComponent bodyComponent;
    private float fuelLevel = 100;
    private float powerLevel = 0;
    private GameUI gameUI;
    private Barrel barrel;
    private double barrelTilt = -90;

    @Override
    public void start() {
        bodyComponent = parent.getComponent(BodyComponent.class);
        bodyComponent.setRestitution(0.0);
        bodyComponent.setFriction(2);
        gameUI = GameUI.getInstance();
        gameUI.setOnButtonClickedListner(()->fire());

        barrel = new Barrel(parent.getPosition().getX() + parent.getWidth() / 2
                + (Math.sin(Math.toRadians(barrelTilt)) * 16f),
                parent.getPosition().getY() + (Math.cos(Math.toRadians(barrelTilt)) * 16f),
                16, 8, 0);
        Engine.getInstance().addGameObject(barrel);
    }

    @Override
    public void update() {
        gameUI.setFuelLevel((int) fuelLevel);
        gameUI.setPowerLevel((int) powerLevel);

        if(Input.getInstance().isKeyDown(KeyEvent.VK_SHIFT) && powerLevel < 100)
            powerLevel += 0.5f;
        if(Input.getInstance().isKeyDown(KeyEvent.VK_CONTROL) && powerLevel > 0)
            powerLevel -= 0.5f;
        if(Input.getInstance().isKeyDown(KeyEvent.VK_S) && barrelTilt < 0)
            barrelTilt += 0.5f;
        if(Input.getInstance().isKeyDown(KeyEvent.VK_W) && barrelTilt > -180)
            barrelTilt -= 0.5f;

        barrel.setPosition((float) (parent.getPosition().getX() + parent.getWidth() / 2
                        + (Math.cos(Math.toRadians(barrelTilt)) * 16f)),
                (float) (parent.getPosition().getY()));

        System.out.println("Xpos parent: " + parent.getPosition().getX() + parent.getWidth() / 2 +
                ", xPos barrel: "+ (parent.getPosition().getX() + parent.getWidth() / 2
                + (Math.cos(Math.toRadians(barrelTilt)) * 16f)));
        barrel.setRotation(Math.toRadians(barrelTilt));
    }

    @Override
    public void fixedUpdate() {
        if(Input.getInstance().isKeyDown(KeyEvent.VK_A) && fuelLevel > 0) {
            bodyComponent.setFriction(2);
            bodyComponent.setForce(new Point2D.Double(-1, 0));
            fuelLevel -= 1f;
        } else if (Input.getInstance().isKeyDown(KeyEvent.VK_D) && fuelLevel > 0) {
            bodyComponent.setFriction(2);
            bodyComponent.setForce(new Point2D.Double(1, 0));
            fuelLevel -= 1f;
        }else{
            bodyComponent.setFriction(1000);
        }
    }

    private void fire(){
        System.out.println("Fire has to be done here!");
    }
}
