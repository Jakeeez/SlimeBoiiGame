package slimegameja;

import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

public class slime {
    
    public ImageIcon[] im = new ImageIcon[3];
    public int hp = 10;
    public int x;
    public int y;
    public int count = 0;
    
    slime(){
        for(int i=0;i<im.length;i++){
            im[i] = new ImageIcon(this.getClass().getResource((i+1)+".png"));
	}
    }
    public Rectangle2D getbound() {
        return (new Rectangle2D.Double(x, y, 370, 300));
    }
}
