package Controller;
import View.Canvas;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ExecuteDrawing{
     BufferedImage img;
     JPanel canvas;
    boolean clicked;
    int ex, ey;
    public ExecuteDrawing(BufferedImage img, Canvas canvas, boolean clicked, int ex, int ey) {
        this.img = img;
        this.canvas = canvas;
        this.clicked = clicked;
        this.ex = ex;
        this.ey = ey;
    }
    public void run() {
        Random rand = new Random();
        if(clicked){
            Graphics2D g = img.createGraphics();
            int x0 = ex;
            int y0 = ey;
            Stroke strk = new BasicStroke(rand.nextInt(6));
            g.setStroke(strk);
            g.setColor(new Color(rand.nextInt(200) + 50, rand.nextInt(200) + 50, rand.nextInt(200) + 50, rand.nextInt(128) + 50));
            g.fill(new RegularPolygon(x0, y0, rand.nextInt(40) + 5, rand.nextInt(20) + 2));
            g.dispose();
            canvas.repaint();
        }
    }
}