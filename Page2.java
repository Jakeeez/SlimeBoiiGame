package slimegameja;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Page2 extends JPanel implements ActionListener {

    private ImageIcon feild1 = new ImageIcon(this.getClass().getResource("bg1.jpg"));
    private ImageIcon feild2 = new ImageIcon(this.getClass().getResource("bg2.jpg"));
    private ImageIcon feildover = new ImageIcon(this.getClass().getResource("over.jpg"));
    private ImageIcon gameover = new ImageIcon(this.getClass().getResource("over.jpg"));
    private ImageIcon gamewin = new ImageIcon(this.getClass().getResource("win.jpg"));
    public ImageIcon shut = new ImageIcon(this.getClass().getResource("exitbutton.png"));

    slime s = new slime();
    hed h = new hed();

    private JLabel score = new JLabel();
    public JButton Bshut = new JButton(shut);

    public ArrayList<jelly> jelly11 = new ArrayList<jelly>();
    public ArrayList<hed> hedbossder = new ArrayList<hed>();
    public ArrayList<Fire> fb1 = new ArrayList<Fire>();
    public ArrayList<Fire2> fb2 = new ArrayList<Fire2>();

    public int times1;
    public int HP;

    boolean timestart1 = true;
    boolean startwa = false;

    public int scor = 0;
    boolean paralyze1 = false;
    int time_paralyze = 5;

    Thread time1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }

                if (timestart1 == false) {
                    repaint();
                }
            }
        }
    });

    Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });

    Thread jelly22 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startwa == false) {
                        Thread.sleep((long) (Math.random() * 2000) + 2000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startwa == false) {
                    jelly11.add(new jelly());
                }
            }
        }
    });
    
    Thread hedboss = new Thread(new Runnable() {
            public void run() {
		while(true){
                    h.x -= 0.1;
                    if(h.x == 0){
			h.x += 2;
			h.y = 0;
                    }
                    try{
			hedboss.sleep(10);
                    }catch(InterruptedException e){
                    }
                }
            }
	});
 
    Thread paralyze = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (time_paralyze < 1) {
                    paralyze1 = false;
                    time_paralyze = 5;
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });
    
    Thread t1 = new Thread(new Runnable() {
        public void run() {
            while (true) {
                if (timestart1 == false) {
                    times1 = (times1 - 1);
                    if (paralyze1) {
                        time_paralyze--;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    Page2() {
        this.setFocusable(true);
        this.setLayout(null);
        Bshut.setBounds(950, 50, 230, 220);
        Bshut.setOpaque(false);
        Bshut.setBorderPainted(false);
        Bshut.setContentAreaFilled(false);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(h.hp>=1){
                    int a = e.getKeyCode();
                    if (a == KeyEvent.VK_LEFT) {
                        s.x -= 10;
                        s.count++;
                    } else if (a == KeyEvent.VK_RIGHT) {
                        s.x += 10;
                        s.count++;
                    }
                    if (s.count >= 4) {
                        s.count = 0;
                    }
                    }else{
                        int a = e.getKeyCode();
                        if (a == KeyEvent.VK_LEFT) {
                            s.x -= 10;
                            s.count++;
                        }else if (a == KeyEvent.VK_RIGHT) {
                            s.x += 10;
                            s.count++;
                        }
                        if (s.count >= 4) {
                            s.count = 0;
                        } 
                        else if (a == KeyEvent.VK_UP) {
                            s.count = 1;
                            fb2.add(new Fire2(s.x + 125, s.y));
                        }
                        else if (a == KeyEvent.VK_SPACE) {
                            s.count = 1;
                            fb1.add(new Fire(s.x + 125, s.y));
                        }
                    }
            }

            public void keyReleased(KeyEvent e) {
                s.count = s.count;
            }
        });

        s.x = 0;
        s.y = 480;
        time1.start();
        actor.start();
        t1.start();
        hedboss.start();
        jelly22.start();
        paralyze.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);              
        if(scor<=99){        
            if(times1<=0){
                this.setLayout(null);
                g.drawImage(gameover.getImage(), 0, 0, getWidth(), getHeight(), this);

            }else{ 
                if(times1<=100){            
                    g.drawImage(feild1.getImage(), 0, 0, getWidth(), getHeight(), this);
                    g.drawImage(s.im[s.count].getImage(), s.x, 430, 370, 300, this);
                    g.drawImage(h.img, h.x, 400, 370, 300, this);
                    g.setFont(new Font("Agency FB", Font.CENTER_BASELINE, 50));
                    g.setColor(Color.BLACK);
                    g.drawString("hed hp = " + h.hp, 1000, 200);
                    g.drawString("Slime hp = " + s.hp, 100, 200);
                    g.drawString("Time  = " + times1, 100, 100);
                    
                    if (Intersect(s.getbound(), h.getbound())) {
                        if(h.hp>=1){
                            h.hp -= 1;
                            scor += 10;
                        }
                        if(h.hp <=0){
                            h.img.flush();
                            h.x = 9999;
                            h.y = 9999;
                            times1=90;
                        }
                    }
                }
                    if(times1<=90){
                
                        if (s.hp<=0){
                            g.drawImage(gameover.getImage(), 0, 0, getWidth(), getHeight(), this);
                        }else{
                            g.drawImage(feild2.getImage(), 0, 0, getWidth(), getHeight(), this);
                            g.drawImage(s.im[s.count].getImage(), s.x, 430, 370, 300, this);this.setLayout(null);
                            g.drawString("Score = " + scor, 1000, 100);
                            g.drawString("Time  = " + times1, 100, 100);
                            g.drawString("Slime hp = " + s.hp, 100, 200);
                            g.drawString("Make score 100 to win!", 500, 100);
            
                            for (int i = 0; i < fb1.size(); i++) {
                                Fire etb = fb1.get(i);
                                g.drawImage(etb.FB.getImage(), etb.x, etb.y, 100, 100, null);
                                etb.move();
                                if (etb.x > 1270) {
                                    fb1.remove(i);
                                }
                            }
                            for (int i = 0; i < fb2.size(); i++) {
                                Fire2 etb2 = fb2.get(i);
                                g.drawImage(etb2.FH.getImage(), etb2.x, etb2.y, 100, 100, null);
                                etb2.move();
                                if (etb2.y < 150) {
                                    fb2.remove(i);
                                }
                            }
                            for (int i = 0; i < jelly11.size(); i++) {
                                g.drawImage(jelly11.get(i).getImage(), jelly11.get(i).getX(), jelly11.get(i).getY() - 100, 200, 150, this);
                                if (Intersect(jelly11.get(i).getbound(), s.getbound())) {
                                    s.hp -= 1;
                                    scor -= 10;
                                    jelly11.remove(i);
                                }
                            }
                
                            for (int i = 0; i < fb1.size(); i++) {
                                for (int j = 0; j < jelly11.size(); j++) {
                                    if (Intersect(fb1.get(i).getbound(), jelly11.get(j).getbound())) {
                                        jelly11.remove(j);
                                        fb1.remove(i);
                                        scor += 20;
                                    }
                                }
                            }
                            }
                    }
                }
        if (s.x < 0) {
            s.x = 0;
        } else if (s.x > 1000) {
            s.x = 1000;
        }
    }else{
        g.drawImage(gamewin.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
