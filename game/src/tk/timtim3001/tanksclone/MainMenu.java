package tk.timtim3001.tanksclone;

import tk.timtim3001.engine.ui.Button;
import tk.timtim3001.engine.ui.ImageElement;
import tk.timtim3001.engine.ui.UICanvas;
import tk.timtim3001.engine.ui.UIManager;
import tk.timtim3001.engine.window.Window;
import tk.timtim3001.engine.window.WindowManager;

import javax.imageio.ImageIO;
import java.io.IOException;

public class MainMenu {

    private static final String UI_NAME = "MainMenu";
    
    public MainMenu(){
        Window window = WindowManager.getInstance().getWindow();

        int width =  window.getWidth();
        int height = window.getHeight();

        UICanvas uiCanvas = new UICanvas(0, 0, width, height);

        Button startButton = new Button(0,height / 3,"Start game");
        Button stopButton = new Button(0,height / 3 * 2,"Exit");
        startButton.setPosition(width / 2 - startButton.getWidth() / 2, height / 3);
        stopButton.setPosition(width / 2 - stopButton.getWidth() / 2, height / 3 + startButton.getHeight() * 3);

        startButton.addOnClickListener(()->{
            new BattleWorld();
            UIManager.stopDisplayingCanvas(UI_NAME);
        });
        stopButton.addOnClickListener(()->System.exit(0));
        
        try {
            ImageElement imageElement = new ImageElement(0, 0, width, height,
                    ImageIO.read(getClass().getResource("/images/titlescreen_background.jpg")));
            uiCanvas.addElement(imageElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        uiCanvas.addElement(startButton);
        uiCanvas.addElement(stopButton);

        UIManager.registerCanvas(UI_NAME, uiCanvas);
        UIManager.displayCanvas(UI_NAME);
    }

}
