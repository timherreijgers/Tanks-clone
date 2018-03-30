package tk.timtim3001.engine.input;

import tk.timtim3001.engine.ui.UIManager;
import tk.timtim3001.engine.window.WindowManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public class Input extends MouseAdapter implements KeyListener {

    private static Input instance;

    private Set<Integer> currentlyPressed;

    public static Input getInstance(){
        if(instance == null)
            instance = new Input();
        return instance;
    }

    private Input(){
        currentlyPressed = new HashSet<>();
        WindowManager.getInstance().getWindow().addKeyListener(this);
        WindowManager.getInstance().getWindow().addMouseListener(this);
    }

    public boolean isKeyDown(int keycode){
        return currentlyPressed.contains(keycode);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentlyPressed.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentlyPressed.remove(e.getKeyCode());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        UIManager.onMouseClickEvent(e);
    }
}
