import java.applet.Applet;
import java.awt.*;
public class BallMove extends Applet implements Runnable{
Thread th;
int x=0;
int y = 0; 
boolean moveright = true;
boolean moveleft = false;
boolean movedown = true;
boolean moveup = false;
public void init(){
th = new Thread(this);
th.start();
}
public void paint(Graphics g){
g.setColor(Color.BLUE);
  g.fillOval(x,y,25,25);
}
public void run(){

while(true){
repaint();
if(x >= getWidth()-25){
	moveright = false;
	moveleft = true ;

}else if(x<25){
	moveright = true;
	moveleft = false ;
}
if(y >= getHeight()-25){
	moveup = true;
	movedown = false;
}else if(y<25){
	moveup = false;
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
