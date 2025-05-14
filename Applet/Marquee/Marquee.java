import java.applet.Applet;
import java.awt.Graphics;

public class Marquee extends Applet implements Runnable {
    Thread th;
    int x = 0; 


    public void init() {
        th = new Thread(this);
        th.start();
    }

    public void paint(Graphics g) {
        g.drawString("JAVA World", x, 100);
    }

    public void run() {
        while (true) {
            try {
                repaint();
                Thread.sleep(50); 
                x += 5; 

                if (x > getWidth()) {
                    x = 0; 
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
