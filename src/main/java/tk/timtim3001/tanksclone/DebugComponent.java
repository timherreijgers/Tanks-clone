package tk.timtim3001.tanksclone;

import tk.timtim3001.engine.components.Component;
import tk.timtim3001.engine.core.Engine;

public class DebugComponent extends Component {

    private Engine engine;
    private double totalFps = 0;
    private int counter = 1;

    @Override
    public void start() {
        engine =  Engine.getInstance();
    }

    @Override
    public void update() {
        totalFps += engine.getFps();
        counter++;
        System.out.println("Average fps: " + totalFps / counter);
    }
}
