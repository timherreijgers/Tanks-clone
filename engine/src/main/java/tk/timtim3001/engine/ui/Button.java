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

public class Button extends UIElement {

    private String text;

    public Button(int x, int y, String text) {
        super(x, y, 0, 0);
        calculateBoundries(text);
        this.text = text;
    }

    private void calculateBoundries(String text){
        Window window = WindowManager.getInstance().getWindow();
        Graphics2D g = window.getCorrectGraphics();
        FontRenderContext fontRenderContext = g.getFontRenderContext();
        GlyphVector gv = g.getFont().createGlyphVector(fontRenderContext, text);
        Shape outline = gv.getOutline();
        width = (int) outline.getBounds().getWidth() + 10;
        height = (int) outline.getBounds().getHeight() + 6;
    }

    @Override
    protected void draw(Graphics2D g) {
        g.draw(new Rectangle2D.Double(x, y, width, height));
        g.drawString(text, x + 5, y + height - 4);
    }
}
