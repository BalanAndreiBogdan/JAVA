package View;

import Controller.Load;
import Controller.Reset;
import Controller.Save;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class ControlPanel extends JPanel {
    JButton loadB, saveB, resetB;
    transient BufferedImage img;
    Canvas canvas;
    DrawingFrame frame;
    public ControlPanel(BufferedImage img, Canvas canvas, DrawingFrame frame){
        this.img = img;
        this.canvas = canvas;
        this.frame = frame;
        init();
    }

    private void init(){
        loadB = new JButton("LOAD");
        saveB = new JButton("SAVE");
        resetB = new JButton("RESET");
        this.add(loadB);
        this.add(saveB);
        this.add(resetB);
        resetB.addActionListener(new Reset(img, canvas, frame));
        saveB.addActionListener(new Save(frame));
        loadB.addActionListener(new Load(frame));
    }
}
