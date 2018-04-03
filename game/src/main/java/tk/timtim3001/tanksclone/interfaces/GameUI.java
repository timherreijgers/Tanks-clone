package tk.timtim3001.tanksclone.interfaces;

import tk.timtim3001.engine.ui.ButtonElement;
import tk.timtim3001.engine.ui.TextElement;
import tk.timtim3001.engine.ui.UICanvas;
import tk.timtim3001.engine.ui.UIElement;
import tk.timtim3001.engine.ui.UIManager;
import tk.timtim3001.engine.window.Window;
import tk.timtim3001.engine.window.WindowManager;

public class GameUI {

    private static GameUI instance;

    public static GameUI getInstance(){
        if(instance == null)
            instance = new GameUI();
        return instance;
    }

    private static final String UI_NAME = "GAME_UI";

    private TextElement fuelMeter;
    private ButtonElement fire;
    private TextElement power;

    private GameUI(){
        Window window = WindowManager.getInstance().getWindow();

        int width =  window.getWidth();

        UICanvas uiCanvas = new UICanvas(0, 0, width, 50);

        fuelMeter = new TextElement(width / 4, 10, "Fuel level: 100");
        fire = new ButtonElement(width / 2 , 10, "Fire!");
        power = new TextElement(width / 4 * 3, 10, "Power: 0");

        uiCanvas.addElement(fuelMeter);
        uiCanvas.addElement(fire);
        uiCanvas.addElement(power);

        UIManager.registerCanvas(UI_NAME, uiCanvas);
        UIManager.displayCanvas(UI_NAME);
    }

    public void setFuelLevel(int level){
        fuelMeter.setText("Fuel level: " + level);
    }

    public void setPowerLevel(int level){
        power.setText("Power: " + level);
    }

    public void setOnButtonClickedListner(UIElement.OnClickListener listener){
        fire.addOnClickListener(listener);
    }
}
