package tk.timtim3001.engine.renderer;

import tk.timtim3001.engine.components.Sprite;


import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpriteRenderer extends Renderer{

    private Map<Integer, ArrayList<Sprite>> layerMap;
    private Integer[] layerOrder;

    private static SpriteRenderer instance;

    public static SpriteRenderer getInstance(){
        if(instance == null)
            instance = new SpriteRenderer();
        return instance;
    }

    private SpriteRenderer(){
        super();
        layerMap = new HashMap<>();
        layerOrder = new Integer[0];
    }

    private boolean doesMapContainKey(Integer integer){
        return layerMap.keySet().contains(integer);
    }

    private void addKeyToMap(Integer key){
        layerMap.put(key, new ArrayList<>());
        Set<Integer> keys = layerMap.keySet();
        Integer[] integers = new Integer[keys.size()];
        integers = keys.toArray(integers);

        Arrays.sort(integers);
        this.layerOrder = integers;
    }

    public void addSpriteToRenderer(Sprite sprite){
        if(!doesMapContainKey(sprite.getLayer())){
            addKeyToMap(sprite.getLayer());
        }
        layerMap.get(sprite.getLayer()).add(sprite);
    }

    public void removeSpriteFromRenderer(Sprite sprite){
        layerMap.get(sprite.getLayer()).remove(sprite);
    }

    @Override
    public void render(Graphics2D graphics2D){
        for(int i : layerOrder){
            List<Sprite> sprites = layerMap.get(i);
            for(Sprite sprite : sprites){
                graphics2D.drawImage(sprite.getImage(), sprite.getParent().getTransform(), null);
            }
        }
    }
}
