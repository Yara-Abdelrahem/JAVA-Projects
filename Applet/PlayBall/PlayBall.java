import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class PlayBall extends Applet implements Runnable{
Thread th;
int check=0;
int x=150;
int y = 250; 
boolean moveleft = false;
boolean movedown = true;
Button b1 , b2;
public void init(){
th = new Thread(this);

b1 = new Button("start");
b1.addActionListener(new MyButtonListener());
add(b1);

b2 = new Button("stop");
b2.addActionListener(
new ActionListener(){
public void actionPerformed(ActionEvent ev){
th.suspend();
}
});
add(b2);
}
class MyButtonListener implements ActionListener{
public void actionPerformed(ActionEvent ev){
	if (check ==0){
		check++;
		th.start();
	}else{
		th.resume();
	}
   }
 }
public void paint(Graphics g){
g.setColor(Color.BLUE);
  g.fillOval(x,y,25,25);
}
public void run(){

while(true){
repaint();
if(x >= getWidth()-25){
	moveleft = true ;

}else if(x<25){
	moveleft = false ;
}
if(y >= getHeight()-25){
	movedown = false;
}else if(y<25){
	movedown = true;
}

if(moveleft==true)
	x-=20;
else
	x+=20;
if(movedown == true)
	y+=20;
else
	y-=20;

try{

Thread.sleep(50);
}catch(InterruptedException ie)
{ie.printStackTrace();}
}
}
}
