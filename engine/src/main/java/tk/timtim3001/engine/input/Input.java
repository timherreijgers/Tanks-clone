package tk.timtim3001.engine.input;

import tk.timtim3001.engine.window.WindowManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Input implements KeyListener {

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
}
