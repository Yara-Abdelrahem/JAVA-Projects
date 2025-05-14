import java.applet.Applet;
import java.awt.*;

public class Lamp extends Applet {
    public void paint(Graphics g) {
        // top oval of lamp 
        // filling oval with color abve
        g.setColor(Color.YELLOW);
        g.fillOval(200, 80, 150, 30);
    
	// the oval ouline color
	g.setColor(Color.BLACK);
        g.drawOval(200, 80, 150, 30);

        // lamp body 
        g.drawLine(200, 100, 150, 250);  
        g.drawLine(350, 100, 400, 250); 
		
        g.drawArc(150, 230, 250, 40, 0, -180); 

       // 3 ovals
        g.setColor(Color.YELLOW);
        g.fillOval(250, 140, 40, 60);
        g.fillOval(200, 160, 40, 40);
        g.fillOval(300, 160, 40, 40);
        
        g.setColor(Color.BLACK);
        g.drawOval(250, 140, 40, 60);
        g.drawOval(200, 160, 40, 40);
        g.drawOval(300, 160, 40, 40);
	
	// Lamp stand
        g.setColor(Color.BLACK);
        g.drawLine(270, 270, 250, 320);
        g.drawLine(280, 270, 300, 320);
     
       // Base
        g.drawRect(225, 320, 100, 20);
    }
}
