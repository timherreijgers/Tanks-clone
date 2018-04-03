package tk.timtim3001.tanksclone.interfaces;

import tk.timtim3001.engine.ui.ButtonElement;
import tk.timtim3001.engine.ui.ImageElement;
import tk.timtim3001.engine.ui.UICanvas;
import tk.timtim3001.engine.ui.UIManager;
import tk.timtim3001.engine.window.Window;
import tk.timtim3001.engine.window.WindowManager;
import tk.timtim3001.tanksclone.worlds.BattleWorld;

import javax.imageio.ImageIO;
import java.io.IOException;

public class MainMenu {

    private static final String UI_NAME = "MainMenu";
    
    public MainMenu(){
        Window window = WindowManager.getInstance().getWindow();

        int width =  window.getWidth();
        int height = window.getHeight();

        UICanvas uiCanvas = new UICanvas(0, 0, width, height);

        ButtonElement startButtonElement = new ButtonElement(0,height / 3,"Start game");
        ButtonElement stopButtonElement = new ButtonElement(0,height / 3 * 2,"Exit");
        startButtonElement.setPosition(width / 2 - startButtonElement.getWidth() / 2, height / 3);
        stopButtonElement.setPosition(width / 2 - stopButtonElement.getWidth() / 2, height / 3 + startButtonElement.getHeight() * 3);

        startButtonElement.addOnClickListener(()->{
            new BattleWorld();
            UIManager.stopDisplayingCanvas(UI_NAME);
        });
        stopButtonElement.addOnClickListener(()->System.exit(0));
        
        try {
            ImageElement imageElement = new ImageElement(0, 0, width, height,
                    ImageIO.read(getClass().getResource("/images/titlescreen_background.jpg")));
            uiCanvas.addElement(imageElement);
        } catch (IOException e) {
            e.printStackTrace();
        }

        uiCanvas.addElement(startButtonElement);
        uiCanvas.addElement(stopButtonElement);

        UIManager.registerCanvas(UI_NAME, uiCanvas);
        UIManager.displayCanvas(UI_NAME);
    }

}
