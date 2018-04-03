package tk.timtim3001.engine.ui;

import tk.timtim3001.engine.window.Window;
import tk.timtim3001.engine.window.WindowManager;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class TextElement extends UIElement {

    String text;

    public TextElement(int x, int y, String text) {
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
        Color oldColor = g.getColor();
        g.drawString(text, x + 5, y + height - 4);
        g.setColor(oldColor);
    }

    public void setText(String text){
        this.text = text;
    }
}
