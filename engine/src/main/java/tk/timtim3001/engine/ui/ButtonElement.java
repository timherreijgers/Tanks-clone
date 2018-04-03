package tk.timtim3001.engine.ui;

import org.w3c.dom.css.Rect;
import tk.timtim3001.engine.window.Window;
import tk.timtim3001.engine.window.WindowManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;

public class ButtonElement extends TextElement {

    public ButtonElement(int x, int y, String text) {
        super(x, y, text);
    }

    @Override
    protected void draw(Graphics2D g) {
        Color oldColor = g.getColor();

        g.setColor(new Color(190, 190, 190));
        g.fill(new Rectangle2D.Double(x, y, width, height));
        g.setColor(Color.BLACK);
        g.draw(new Rectangle2D.Double(x, y, width, height));

        g.setColor(oldColor);
        super.draw(g);
    }
}
