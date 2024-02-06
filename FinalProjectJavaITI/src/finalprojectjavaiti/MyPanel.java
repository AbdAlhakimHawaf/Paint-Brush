package finalprojectjavaiti;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    int x1, y1;
    int width, height;
    int x2, y2;
    static int No_Shapes = 0;
    ArrayList<Rectangle> Rectangles = new ArrayList<>();
    ArrayList<Oval> Ovals = new ArrayList<>();
    ArrayList<Line> Lines = new ArrayList<>();
    ArrayList<FreeHand> FreeHands = new ArrayList<>();
    Color currentColor = Color.BLACK;
    String currentShape = "Line";
    boolean SolidShape = false;
    boolean DottedShape = false;
    public ArrayList<Integer> x_Points = new ArrayList<>();
    public ArrayList<Integer> y_Points = new ArrayList<>();
    //ArrayList<Point> freeHandPoints = new ArrayList<>();
    boolean eraseMode = false;
    int eraseSize = 10;

    JButton Red_Button;
    JButton Green_Button;
    JButton Blue_Button;
    JButton Line_Button;
    JButton Rect_Button;
    JButton Oval_Button;
    JButton Erase_Button;
    JButton Erase_Button_Increase;
    JButton Erase_Button_Decrease;
    JButton EraseAll_Button;
    JButton FreeHand_Button;
    JCheckBox Solid_CheckBox;
    JCheckBox Dotted_CheckBox;
    JLabel Functions_Label;
    JLabel Colors_Label;
    JButton Undo_Button;

    public MyPanel() {
        Red_Button = new JButton("Red");
        Green_Button = new JButton("Green");
        Blue_Button = new JButton("Blue");
        Line_Button = new JButton("Line");
        Rect_Button = new JButton("Rectangle");
        Oval_Button = new JButton("Oval");
        Erase_Button = new JButton("Erase");
        Erase_Button_Increase = new JButton("Erase Size +");
        Erase_Button_Decrease = new JButton("Erase Size -");
        EraseAll_Button = new JButton("Erase All");
        FreeHand_Button = new JButton("Free Hand");
        Solid_CheckBox = new JCheckBox("Solid");
        Dotted_CheckBox = new JCheckBox("Dotted");
        Functions_Label = new JLabel("Functions :");
        Colors_Label = new JLabel("Colors :");
        Undo_Button = new JButton("Undo");

        Red_Button.setBackground(Color.RED);
        Green_Button.setBackground(Color.GREEN);
        Blue_Button.setBackground(Color.BLUE);

        this.add(Colors_Label);
        this.add(Red_Button);
        this.add(Green_Button);
        this.add(Blue_Button);
        this.add(Functions_Label);
        this.add(FreeHand_Button);
        this.add(Line_Button);
        this.add(Rect_Button);
        this.add(Oval_Button);
        this.add(Erase_Button);
        this.add(Erase_Button_Increase);
        this.add(Erase_Button_Decrease);
        this.add(EraseAll_Button);
        this.add(Solid_CheckBox);
        this.add(Dotted_CheckBox);
        this.add(Undo_Button);

        EraseAll_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Lines.clear();
                Rectangles.clear();
                Ovals.clear();
                FreeHands.clear();
                repaint();

            }

        });
        EraseAll_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Lines.clear();
                Rectangles.clear();
                Ovals.clear();
                FreeHands.clear();
                repaint();

            }

        });

        Erase_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setCurrentShape("Erase");
                setEraseMode(true);
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

            }

        });
        Erase_Button_Increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (eraseSize <= 100) {
                    eraseSize += 20;
                } else {
                    eraseSize = eraseSize;
                }

            }

        });
        Erase_Button_Decrease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (eraseSize >= 30) {
                    eraseSize -= 20;
                } else {
                    eraseSize = eraseSize;
                }

            }

        });
        Green_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setCurrentColor(Color.GREEN);

            }

        });
        Blue_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setCurrentColor(Color.BLUE);

            }

        });
        Red_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setCurrentColor(Color.RED);

            }

        });

        Rect_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                x_Points.clear();
                y_Points.clear();
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                setCurrentShape("Rectangle");
                //repaint();
            }

        });
        Line_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                x_Points.clear();
                y_Points.clear();
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                setCurrentShape("Line");
                // repaint();
            }

        });
        Oval_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                x_Points.clear();
                y_Points.clear();
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                setCurrentShape("Oval");
                //  repaint();
            }

        });
        FreeHand_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                x_Points.clear();
                y_Points.clear();
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                setCurrentShape("FreeHand");
                // repaint();
            }

        });
        Solid_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Fill_UnFill();
            }

        });
        Dotted_CheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dotted_UnDotted();
            }

        });
        Undo_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(No_Shapes);
                undoLastStep();
                repaint();
                --No_Shapes;
                repaint();
                System.out.println(No_Shapes);
            }
        });

        this.setBackground(Color.white);

        setFocusable(true);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {

            }

            @Override
            public void mousePressed(MouseEvent me) {
                x_Points.clear();
                y_Points.clear();
                x_Points.add(me.getX());
                y_Points.add(me.getY());
                if ("Erase".equals(currentShape)) {
                    No_Shapes++;
                    eraseAtPoint(me.getX(), me.getY(), No_Shapes);
                }
                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent me) {
                repaint();
                No_Shapes++;
                if ("Rectangle".equals(currentShape)) {
                    width = Math.abs(me.getX() - x_Points.get(0));
                    height = Math.abs(me.getY() - y_Points.get(0));
                    x1 = Math.min(x_Points.get(0), me.getX());
                    y1 = Math.min(y_Points.get(0), me.getY());
                    Rectangles.add(new Rectangle(x1, y1, width, height, currentColor, SolidShape, DottedShape, No_Shapes));
                    repaint();
                } else if ("Oval".equals(currentShape)) {
                    width = Math.abs(me.getX() - x_Points.get(0));
                    height = Math.abs(me.getY() - y_Points.get(0));
                    x1 = Math.min(x_Points.get(0), me.getX());
                    y1 = Math.min(y_Points.get(0), me.getY());
                    Ovals.add(new Oval(x1, y1, width, height, currentColor, SolidShape, DottedShape, No_Shapes));
                    repaint();
                } else if ("Line".equals(currentShape)) {
                    x2 = me.getX();
                    y2 = me.getY();
                    x1 = x_Points.get(0);
                    y1 = y_Points.get(0);
                    Lines.add(new Line(x1, y1, x2, y2, currentColor, DottedShape, No_Shapes));
                    repaint();
                } else if ("FreeHand".equals(currentShape)) {
//                    x2 = me.getX();
//                    y2 = me.getY();
//                    x1 = x_Points.get(x_Points.size() - 1);
//                    y1 = y_Points.get(y_Points.size() - 1);
                    for (int i = 0; i < x_Points.size(); i++) {
                        No_Shapes++;
                        FreeHands.add(new FreeHand(x_Points.get(i), y_Points.get(i), x_Points.get(i + 1), y_Points.get(i + 1), currentColor, DottedShape, No_Shapes));
                        repaint();
                    }
                    x_Points.clear();
                    y_Points.clear();

                }

                x_Points.clear();
                y_Points.clear();

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                System.out.println("***");
            }

            @Override
            public void mouseExited(MouseEvent me) {
                System.out.println("***");
            }

        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                x_Points.add(me.getX());
                y_Points.add(me.getY());
                if ("Erase".equals(currentShape)) {
                    No_Shapes++;
                    eraseAtPoint(me.getX(), me.getY(), No_Shapes);
                } else {
                    repaint(); // Repaint the panel to show real-time drawing
                }

            }

            @Override
            public void mouseMoved(MouseEvent me) {
                System.out.println("***");
            }

        });

    }

    private void eraseAtPoint(int x, int y, int seq) {
        if (eraseMode) {
            int halfSize = eraseSize / 2;
            x1 = x - halfSize;
            y1 = y - halfSize;
            width = eraseSize;
            height = eraseSize;
            Rectangles.add(new Rectangle(x1, y1, width, height, Color.WHITE, true, false, seq));
            repaint();
        }
    }

    private void setEraseMode(boolean erase) {
        eraseMode = erase;
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void setCurrentShape(String shape) {
        currentShape = shape;
    }

    public void Fill_UnFill() {
        SolidShape = !SolidShape;
    }

    public void Dotted_UnDotted() {
        DottedShape = !DottedShape;
    }

    private void undoLastStep() {

        for (Rectangle rec : Rectangles) {
            if (No_Shapes == rec.getShape_Sequence()) {
                Rectangles.remove(Rectangles.size() - 1);
                repaint();
            }
        }
        for (Line l : Lines) {
            if (No_Shapes == l.getShape_Sequence()) {
                Lines.remove(Lines.size() - 1);
                repaint();                
            }
        }
        for (FreeHand f : FreeHands) {
            //if (No_Shapes == f.getShape_Sequence()) {
                
             while(No_Shapes == f.getShape_Sequence()) {
                FreeHands.remove(FreeHands.size() - 1);
               No_Shapes--;
                repaint();                
            }
        }
        for (Oval o : Ovals) {
            if (No_Shapes == o.getShape_Sequence()) {
                Ovals.remove(Ovals.size() - 1);
                repaint();
            }

        }
        // --No_Shapes;
        repaint();
    }

    /* private void undoLastStep() {
        if (!FreeHands.isEmpty()) {
            FreeHands.remove(FreeHands.size() - 1);
        } else if (!Ovals.isEmpty()) {
            Ovals.remove(Ovals.size() - 1);
        } else if (!Rectangles.isEmpty()) {
            Rectangles.remove(Rectangles.size() - 1);
        } else if (!Lines.isEmpty()) {
            Lines.remove(Lines.size() - 1);
        }
        No_Shapes--;
        repaint();
        }*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);

        /* for(int i =0 ; i<Lines.size();i++){
        Lines.get(i).Draw(g);
        }*/
        for (int i = 1; i <= No_Shapes; i++) {
            for (Rectangle rec : Rectangles) {
                if (i == rec.getShape_Sequence()) {
                    rec.Draw(g);
                    repaint();
                }
            }
            for (Line l : Lines) {
                if (i == l.getShape_Sequence()) {
                    l.Draw(g);
                    repaint();
                }
            }
            for (FreeHand f : FreeHands) {
                if (i == f.getShape_Sequence()) {
                    f.Draw(g);
                    repaint();
                }
            }
            for (Oval o : Ovals) {
                if (i == o.getShape_Sequence()) {
                    o.Draw(g);
                    repaint();
                }
            }

        }

        if ("FreeHand".equals(currentShape)) {
            g.setColor(currentColor);
            for (int i = 0; i < x_Points.size() - 1; i++) {
                g.drawLine(x_Points.get(i), y_Points.get(i), x_Points.get(i + 1), y_Points.get(i + 1));
            }
        } else if ("Rectangle".equals(currentShape) && x_Points.size() > 0) {
            g.setColor(currentColor);
            width = Math.abs(x_Points.get(x_Points.size() - 1) - x_Points.get(0));
            height = Math.abs(y_Points.get(y_Points.size() - 1) - y_Points.get(0));
            x1 = Math.min(x_Points.get(0), x_Points.get(x_Points.size() - 1));
            y1 = Math.min(y_Points.get(0), y_Points.get(y_Points.size() - 1));
            if (!SolidShape) {
                g.drawRect(x1, y1, width, height);
            } else {
                g.fillRect(x1, y1, width, height);
            }
        } else if ("Oval".equals(currentShape) && x_Points.size() > 0) {
            g.setColor(currentColor);
            width = Math.abs(x_Points.get(x_Points.size() - 1) - x_Points.get(0));
            height = Math.abs(y_Points.get(y_Points.size() - 1) - y_Points.get(0));
            x1 = Math.min(x_Points.get(0), x_Points.get(x_Points.size() - 1));
            y1 = Math.min(y_Points.get(0), y_Points.get(y_Points.size() - 1));
            if (!SolidShape) {
                g.drawOval(x1, y1, width, height);
            } else {
                g.fillOval(x1, y1, width, height);
            }
        } else if ("Line".equals(currentShape) && x_Points.size() > 0) {
            g.setColor(currentColor);
            int s_x = x_Points.get(0);
            int s_y = y_Points.get(0);
            int e_x = x_Points.get(x_Points.size() - 1);
            int e_y;
            e_y = y_Points.get(y_Points.size() - 1);
            g.drawLine(s_x, s_y, e_x, e_y);
        }

        //g.dispose();
    }
}
