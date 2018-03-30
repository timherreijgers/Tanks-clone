package tk.timtim3001.engine.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UICanvas {

    private int width;
    private int height;
    private int x;
    private int y;
    private Color backgroundColor;

    private Set<UIElement> elements;

    public UICanvas(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = new Color(0,0,0,0);

        elements = new HashSet<>();
    }

    public void addElement(UIElement element){
        element.setParent(this);
        elements.add(element);
    }

    public void removeElement(UIElement element){
        elements.remove(element);
    }

    void draw(Graphics2D graphics2D){

        AffineTransform oldTransform = graphics2D.getTransform();
        Color oldColor = graphics2D.getColor();

        graphics2D.setColor(backgroundColor);
        graphics2D.fill(new Rectangle2D.Double(x, y, width,  height));
        graphics2D.setColor(oldColor);

        AffineTransform transform = new AffineTransform();
        transform.translate(x, y);
        graphics2D.setTransform(transform);

        for(UIElement element : elements){
            element.draw(graphics2D);
        }

        graphics2D.setTransform(oldTransform);
    }

    void onMouseClickEvent(MouseEvent e){
        for(Object element : elements.toArray()) {
            int x = e.getX() - this.x;
            int y = e.getY() - this.y;
            ((UIElement) element).onMouseClickEvent(x, y);
        }
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
