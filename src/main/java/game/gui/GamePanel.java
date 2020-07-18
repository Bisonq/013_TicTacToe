package game.gui;

import game.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {

    private Field[] fields;

    private Symbol symbol = Symbol.O;

    private boolean repaint = false;

    private Field field_1;

    public GamePanel(){
        super();
        addMouseListener(this);
        this.fields = new Field[9];
        setupChain();
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.repaint = true;
        this.fields = fields;
        repaint();
    }

    public void setupChain(){
        this.field_1 = new Field_1(this);
        Field field_2 = new Field_2(this);
        Field field_3 = new Field_3(this);

        field_1.setNextFieldInChain(field_2);
        field_2.setNextFieldInChain(field_3);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        g2d.drawLine(200,0, 200, 600);
        g2d.drawLine(400,0, 400, 600);

        g2d.drawLine(0, 180, 600, 180);
        g2d.drawLine(0,360, 600, 360);

        if(repaint) {
            for (Field f : fields) {
                if (f != null) {
                    int centerXPoint = (int) f.getCenterPoint().getX();
                    int centerYPoint = (int) f.getCenterPoint().getY();
                    if (f.isSymbol_O()) {
                        int ovalSize = 80;
                        g2d.drawOval(centerXPoint - (ovalSize / 2), centerYPoint - (ovalSize / 2), ovalSize, ovalSize);
                    } else if (f.isSymbol_X()) {
                        g2d.drawLine(centerXPoint - 20, centerYPoint, centerXPoint + 20, centerYPoint);
                    }
                }
                if (symbol.toString().equals("X"))
                    this.symbol = Symbol.O;
                else
                    this.symbol = Symbol.X;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        field_1.process(e.getX(), e.getY(), this.symbol);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
