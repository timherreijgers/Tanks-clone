package tk.timtim3001.tanksclone;

import tk.timtim3001.engine.core.Engine;
import tk.timtim3001.tanksclone.interfaces.MainMenu;

public class Game {

    public Game(){
        Engine engine = Engine.getInstance();
        engine.sync(60);
        engine.setGameWorld("Main");

        new MainMenu();
    }

}
