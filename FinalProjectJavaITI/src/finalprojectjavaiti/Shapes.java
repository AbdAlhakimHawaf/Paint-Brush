package finalprojectjavaiti;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shapes {

    Color c;
    int x, y, width, height;
    boolean fill = false;
    boolean dot = false;
    
    int Shape_Sequence; 

    public abstract void Draw(Graphics g);

    

}
