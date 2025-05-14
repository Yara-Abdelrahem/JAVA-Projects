import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit ;
import java.awt.Font ;
public class FontApplet extends Applet{
	String[] font_style ;
	public void  init( ){
		Toolkit t= Toolkit.getDefaultToolkit();
		font_style = t.getFontList();
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
