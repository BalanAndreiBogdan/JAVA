package Controller;

import View.Canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Draw implements ActionListener{
    BufferedImage img;
    Canvas canvas;

    public Draw(BufferedImage img, Canvas canvas){
        this.img = img;
        this.canvas = canvas;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new ExecuteDrawing(img, canvas,false, 0, 0).run();
    }
}
