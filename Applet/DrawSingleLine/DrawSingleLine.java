import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

class MouseClass implements MouseListener, MouseMotionListener {
    int pointX1 = -1, pointX2 = -1, pointY1 = -1, pointY2 = -1;
    boolean isDrawn = false; 


    public void mousePressed(MouseEvent e) {
    	pointX1 = e.getX();
        pointY1 = e.getY();
        isDrawn = false;
    }
    public void mouseDragged(MouseEvent e) {
    	pointX2 = e.getX();
        pointY2 = e.getY();
        isDrawn = true;
    }
    
    public void mouseReleased(MouseEvent e) {
   	pointX2 = e.getX();
        pointY2 = e.getY();
        isDrawn = true;
    }
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void drawLine(Graphics g) {
        if (isDrawn) {
            g.setColor(Color.BLUE);
            g.drawLine(pointX1, pointY1, pointX2, pointY2);
        }
    }
}

public class DrawSingleLine extends Applet implements Runnable {
    Thread th;
    MouseClass MouseObj;

    public void init() {
        th = new Thread(this);
        MouseObj = new MouseClass();
        addMouseListener(MouseObj);
        addMouseMotionListener(MouseObj);
        th.start();
    }

    public void paint(Graphics g) {
        MouseObj.drawLine(g);
    }

    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
