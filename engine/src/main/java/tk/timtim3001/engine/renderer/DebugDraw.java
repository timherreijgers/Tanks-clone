package tk.timtim3001.engine.renderer;

import org.dyn4j.collision.Fixture;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Circle;
import org.dyn4j.geometry.Convex;
import org.dyn4j.geometry.Polygon;
import org.dyn4j.geometry.Rectangle;
import org.dyn4j.geometry.Vector2;
import tk.timtim3001.engine.core.Engine;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class DebugDraw {

    public static void draw(Graphics2D g2d, World world) {
        for(Body b : world.getBodies()) {
            AffineTransform originalTransform = g2d.getTransform();

            AffineTransform bodyTransform = new AffineTransform();
            bodyTransform.translate(b.getTransform().getTranslationX() * Engine.PPM, b.getTransform().getTranslationY() * Engine.PPM);
            bodyTransform.rotate(b.getTransform().getRotation());
            g2d.transform(bodyTransform);


            for(Fixture f : b.getFixtures())
                g2d.draw(AffineTransform.getScaleInstance(Engine.PPM, Engine.PPM).createTransformedShape(getShape(f.getShape())));


            g2d.setTransform(originalTransform);
        }
    }

    private static Shape getShape(Convex shape) {
        if(shape instanceof Polygon)
            return getShape((Polygon)shape);
        if(shape instanceof Circle)
            return getShape((Circle)shape);
        if(shape instanceof Rectangle)
            return getShape((Rectangle) shape);
        else
            System.out.println("Unsupported shape: " + shape);
        return null;
    }

    private static Shape getShape(Polygon shape) {
        GeneralPath path = new GeneralPath();
        Vector2[] vertices = shape.getVertices();
        path.moveTo(vertices[0].x, vertices[0].y);
        for(int i = 1; i < vertices.length; i++)
            path.lineTo(vertices[i].x, vertices[i].y);
        path.closePath();
        return path;
    }

    private static Shape getShape(Circle shape) {
        return new Ellipse2D.Double(shape.getCenter().x - shape.getRadius(),
                shape.getCenter().y - shape.getRadius(),
                shape.getRadius()*2,
                shape.getRadius()*2);
    }

    private static Shape getShape(Rectangle shape) {
        return new Rectangle2D.Double(shape.getCenter().x - shape.getWidth() / 2,
                shape.getCenter().y - shape.getHeight() / 2, shape.getWidth(), shape.getHeight());
    }
}
