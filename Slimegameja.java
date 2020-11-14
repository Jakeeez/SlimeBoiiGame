package slimegameja;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author DKDoo
 */
public class Slimegameja extends JFrame implements ActionListener{
    
    Page1 p1 = new Page1();
    Page2 p2 = new Page2();
    
    public Slimegameja(){
        this.setSize(1270,720);
        this.add(p1);
        p1.StartBT.addActionListener(this);
        p1.ExitBT.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == p1.StartBT){
            this.setLocationRelativeTo(null);
            this.remove(p1);
            this.setSize(1270,720);
            this.add(p2);
            p2.requestFocusInWindow();
            p2.timestart1 = false;
            p2.scor = 0;
            p2.times1 = 100;
            p2.timestart1 = false;
        }
        else if(e.getSource()== p1.ExitBT){
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
    public static void main(String[] args) {
        JFrame st = new Slimegameja();
        st.setTitle("Slime Boii");
        st.setSize(1270,720);
        st.setDefaultCloseOperation(EXIT_ON_CLOSE);
        st.setVisible(true);
        st.setLocationRelativeTo(null);
    }
}
