package tk.timtim3001.engine.renderer;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Renderer {

    private static List<Renderer> rendererList = new ArrayList<>();

    protected Renderer(){
        rendererList.add(this);
    }

    public static void renderAll(Graphics2D g){
        for(Renderer renderer : rendererList)
            renderer.render(g);
    }

    public abstract void render(Graphics2D g);

}
