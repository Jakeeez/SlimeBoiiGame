package slimegameja;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

class Page1 extends JPanel {
    
    private ImageIcon startp = new ImageIcon(this.getClass().getResource("p1.jpg"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("playbutton.png"));
    private ImageIcon exits = new ImageIcon(this.getClass().getResource("exitbutton.png"));
    
    public JButton StartBT = new JButton(starts);
    public JButton ExitBT = new JButton(exits);

    
    Page1(){
        setLayout(null);
        StartBT.setBounds(500,300,370,300);
        add(StartBT);
        StartBT.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        StartBT.setBackground(Color.WHITE);
        ExitBT.setBounds(900,300,100,100);
        add(ExitBT);
        ExitBT.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        ExitBT.setBackground(Color.WHITE);
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(startp.getImage(),0,0,1270,720,this);
    }
    
}
