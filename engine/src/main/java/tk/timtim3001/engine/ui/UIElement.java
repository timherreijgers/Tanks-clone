package tk.timtim3001.engine.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public class UIElement {

    protected int x, y, width, height;
    private OnClickListener onClickListener;
    private UICanvas parent;

    public UIElement(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    protected void draw(Graphics2D g){

    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setSize(Dimension dimension){
        setSize((int) dimension.getWidth(), (int) dimension.getHeight());
    }

    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void addOnClickListener(OnClickListener listener){
        onClickListener = listener;
    }

    public UICanvas getParent(){
        return parent;
    }

    void onMouseClickEvent(int x, int y){
        if(onClickListener != null)
            if(new Rectangle(this.x, this.y, width, height).contains(x , y))
                onClickListener.onClick();
    }

    void setParent(UICanvas parent){
        this.parent = parent;
    }

    public interface OnClickListener{
        void onClick();
    }
}