package finalprojectjavaiti;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Shapes {
    int x2,y2;

    public Line(int x1, int y1, int x2, int y2, Color color ,boolean DottedShape,int seq) {
        this.x = x1;
        this.y = y1;
        this.x2 = x2 ;
        this.y2 = y2 ;
        this.c = color;
        this.dot=DottedShape;
        this.Shape_Sequence=seq;
        
    }
    public int getShape_Sequence() {
        return Shape_Sequence;
    }

   /* @Override
    public void Draw(Graphics g) {
        g.setColor(c);
        g.drawLine(x, y, x2, y2);

    }
}*/
   /* public void Draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);
        

        if (dot) {
            float[] dashPattern = {5, 5}; // Adjust the pattern as needed
            BasicStroke dottedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, dashPattern, 0);
            g2d.setStroke(dottedStroke);
        } else {
            g2d.setStroke(new BasicStroke()); // Use default stroke
            g2d.drawLine(x, y, width, height);
        }

        
    }
}*/
    @Override
    public void Draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(c);

        if (dot) {
            float[] dashPattern = {5, 5}; // Adjust the pattern as needed
            BasicStroke dottedStroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0, dashPattern, 0);
            g2d.setStroke(dottedStroke);
            g2d.drawLine(x, y, x2, y2); // Draw the dotted line
        } else {
            g2d.setStroke(new BasicStroke()); // Use default stroke
            g2d.drawLine(x, y, x2, y2); // Draw the regular line
        }
    }
}


