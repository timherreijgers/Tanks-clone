package tk.timtim3001.engine.window;

import javax.swing.*;

public class Window extends JFrame {

    private GamePanel panel;

    Window(WindowDimension dimension, String title, boolean mainWindow){
        super(title);

        if(mainWindow)
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        else
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        panel = new GamePanel(dimension.getWidth(), dimension.getHeight());
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void updateWindow(){
        panel.repaint();
    }

}
