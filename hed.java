package slimegameja;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

class hed {
    Image img;
    public int hp = 1;
    public int x = 1200;
    public int y = 500;
    public int count = 0;
    
    hed(){
        String imageLocation = "hedhed.gif";
        URL imageURL = this.getClass().getResource(imageLocation);
	img = Toolkit.getDefaultToolkit().getImage(imageURL);
	}
    
//	Thread hedboss = new Thread(new Runnable() {
//            public void run() {
//		while(true){
//                    x -= 0.1;
//                    if(x == 0){
//			x -= 2;
//			y = 0;
//                    }
//                    try{
//			hedboss.sleep(10);
//                    }catch(InterruptedException e){
//                    }
//                }
//            }
//	});
	
	public Image getImage(){
            return img;
	}
	
	public int getX(){
            return x;
	}
	public int getY(){
            return y;
	}
	public Rectangle2D getbound(){
    	    return (new Rectangle2D.Double(x,y,80,80));
	}

}

