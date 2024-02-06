package finalprojectjavaiti;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends Shapes {

    public Rectangle(int x, int y, int width, int height, Color color , boolean SolidShape,boolean DottedShape ,int seq) {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.c=color;
        this.fill=SolidShape;
        this.dot=DottedShape;
        this.Shape_Sequence=seq;
              
    }

    public int getShape_Sequence() {
        return Shape_Sequence;
    }
    
    
    

 /*   @Override
    public void Draw(Graphics g) {
        g.setColor(c);
        if(fill==false)
       g.drawRect(x, y, width, height);
        else
            g.fillRect(x, y, width, height);
    }
    
    

}*/
    
public void Draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        

        if (dot) {
            float[] dashPattern = {5, 5}; // Adjust the pattern as needed
            BasicStroke dottedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, dashPattern, 0);
            g2d.setStroke(dottedStroke);
        } else {
            g2d.setStroke(new BasicStroke()); // Use default stroke
            g2d.drawRect(x, y, width, height);
        }

        if (fill) {
            g2d.fillRect(x, y, width, height);
        } else {
            g2d.drawRect(x, y, width, height);
        }
    }
}


