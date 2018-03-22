package tk.timtim3001.tanksclone.engine.window;

import javax.swing.UIManager;

public class WindowManager {

    private Window window;

    private static WindowManager instance;

    public static WindowManager getInstance(){
        if(instance == null)
            instance = new WindowManager();
        return instance;
    }

    private WindowManager(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createWindow(WindowDimension dimension, String title){
        window = new Window(dimension, title, true);
    }

    public Window getWindow(){
        if(window == null)
            System.out.println("Engine: Window has to be initialized using createWindow first");
        return window;
    }

}
