import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class ButtonCount extends Applet{
int x;
Button b1 , b2;
public void init(){
b1 = new Button("Increment");
b1.addActionListener(new MyButtonListener());
add(b1);

b2 = new Button("Decrement");
b2.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent ev){
x--;
repaint() ;
}
});
add(b2);

}
public void paint(Graphics g){
g.drawString("Click Count is:"+ x, 50, 200);
}
class MyButtonListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
	x++ ;
	repaint() ;
   }
 }
 
 
}

