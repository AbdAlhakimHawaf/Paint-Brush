
package finalprojectjavaiti;
/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;*/
import javax.swing.JFrame;

public class FinalProjectJavaITI {
    

    public static void main(String[] args) {
        JFrame f = new JFrame();
        MyPanel Panel = new MyPanel();
        f.setTitle("Paint_ITI");
        f.setSize(1300, 800);
        f.setContentPane(Panel);
        f.setVisible(true);
      
    }
    
}
