import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit ;
import java.awt.Font ;
import java.awt.GraphicsEnvironment;

public class FontApplet2 extends Applet{
	String[] font_style ;
	public void  init( ){
	GraphicsEnvironment graphicsEnvironment =GraphicsEnvironment.getLocalGraphicsEnvironment();
	font_style = graphicsEnvironment.getAvailableFontFamilyNames();
	}
	public void paint(Graphics g){
		int yposistion = 50;
		for(String name : font_style){
            		Font font = new Font(name, Font.PLAIN, 20);
			g.drawString(name , 50 , yposistion);
			yposistion+=20;
		}

	}
}
