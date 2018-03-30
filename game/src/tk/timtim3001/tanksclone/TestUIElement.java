package tk.timtim3001.tanksclone;

import tk.timtim3001.engine.ui.Button;
import tk.timtim3001.engine.ui.UIManager;

public class TestUIElement extends Button {

    public TestUIElement(int x, int y, String text) {
        super(x, y, text);
        addOnClickListener(()-> {
            UIManager.stopDisplayingCanvas("test");
        });
    }
}
