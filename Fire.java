package slimegameja;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class Fire {
    
    public ImageIcon FB = new ImageIcon(this.getClass().getResource("fireball.png"));
    public int y;
    public int x;
    public int count=0;
     Fire(int x,int y){
            this.x=x;
            this.y=y;
    }
	
    public void move(){
	this.x+=7;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,80,80));
    }
}