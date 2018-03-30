package tk.timtim3001.engine.ui;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UIManager {

    private static Map<String, UICanvas> canvasMap = new HashMap<>();
    private static Set<UICanvas> displayedCanvases = new HashSet<>();

    public static void registerCanvas(String name, UICanvas canvas){
        canvasMap.put(name, canvas);
    }

    public static void removeCanvas(String name){
        canvasMap.remove(name);
    }

    public static void draw(Graphics2D g){
        for(UICanvas canvas : displayedCanvases){
            canvas.draw(g);
        }
    }

    public static UICanvas displayCanvas(String name){
        UICanvas canvas = canvasMap.get(name);
        if(canvas == null)
            return null;
        displayedCanvases.add(canvas);
        return canvas;
    }

    public static void stopDisplayingCanvas(String name){
        UICanvas canvas = canvasMap.get(name);
        if(canvas == null)
            return;
        displayedCanvases.remove(canvas);
    }

    public static void onMouseClickEvent(MouseEvent e){
        for(Object canvas : displayedCanvases.toArray())
            ((UICanvas) canvas).onMouseClickEvent(e);
    }
}
