package tk.timtim3001.tanksclone;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class Frame extends JFrame {

    public Frame() {
        super("Tanks");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setContentPane(new GamePanel(new Area(new Rectangle2D.Double(0, 520, 1280, 200))));
        setVisible(true);
    }
}
