/*
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Line{
    int pointX1 = -1, pointX2 = -1, pointY1 = -1, pointY2 = -1;
    public Line(int pointX1,int pointX2,int pointY1,int pointY2){
        this.pointX1 =pointX1;
        this.pointX2 =pointX2;
        this.pointY1 = pointY1;
        this.pointY2 =pointY2;
    }

}

public class DrawMultiLine extends Applet {
   
    MouseClass MouseObj;

    public void init() {
        MouseObj = new MouseClass();
        addMouseListener(MouseObj);
        addMouseMotionListener(MouseObj);
        
    }

    public void paint(Graphics g) {
        MouseObj.drawLines(g);
    }
    
 class MouseClass implements MouseListener, MouseMotionListener {
    int pointX1 = -1, pointX2 = -1, pointY1 = -1, pointY2 = -1;
    ArrayList<Line> lines = new ArrayList<>();
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
        repaint();
    }
    
    public void mouseReleased(MouseEvent e) {
   	pointX2 = e.getX();
        pointY2 = e.getY();
        isDrawn = true;
        lines.add(new Line(pointX1,pointX2,pointY1,pointY2));
        repaint();
    }
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void drawLines(Graphics g) {
            g.setColor(Color.BLUE);
            for(Line line : lines)
            g.drawLine(line.pointX1, line.pointY1, line.pointX2, line.pointY2);
        
    }
}

    
}
*/

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Line{
    int pointX1 = -1, pointX2 = -1, pointY1 = -1, pointY2 = -1;
    public Line(int pointX1,int pointX2,int pointY1,int pointY2){
        this.pointX1 =pointX1;
        this.pointX2 =pointX2;
        this.pointY1 = pointY1;
        this.pointY2 =pointY2;
    }

}

public class DrawMultiLine extends Applet {
   
    MouseClass MouseObj;

    public void init() {
        MouseObj = new MouseClass();
        addMouseListener(MouseObj);
        addMouseMotionListener(MouseObj);
        
    }

    public void paint(Graphics g) {
        MouseObj.drawLines(g);
    }
    
 class MouseClass implements MouseListener, MouseMotionListener {
    int pointX1 = -1, pointX2 = -1, pointY1 = -1, pointY2 = -1;
    Line[] x = {3};
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
        repaint();
    }
    
    public void mouseReleased(MouseEvent e) {
   	pointX2 = e.getX();
        pointY2 = e.getY();
        isDrawn = true;
        lines.add(new Line(pointX1,pointX2,pointY1,pointY2));
        repaint();
    }
    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public void drawLines(Graphics g) {
            g.setColor(Color.BLUE);
            for(Line line : lines)
            g.drawLine(line.pointX1, line.pointY1, line.pointX2, line.pointY2);
        
    }
}

    
}
