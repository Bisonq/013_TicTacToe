package game.gui;

import game.core.Symbol;
import game.core.gamefield.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

public class GamePanel extends JPanel implements MouseListener {

    private Field[] fields;

    private Symbol symbol = Symbol.O;

    private boolean repaint = false;

    private Field field_1;

    private Line2D slashLine;

    private boolean gameOver = false;

    public GamePanel() {
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
        checkWin();
        repaint();
    }

    public void resetGame() {
        this.slashLine = null;
        this.repaint = false;
        for (Field f : fields) {
            if (f != null) {
                f.setSymbol_O(false);
                f.setSymbol_X(false);
            }
        }
        fields = new Field[9];
        repaint();
        JOptionPane.showMessageDialog(this, "GAME OVER !");
        gameOver = false;
    }

    public void checkWin() {

        //upright
        checkStrike(0, 3, 6, new Line2D.Double(100, 0, 100, 580));
        checkStrike(1, 4, 7, new Line2D.Double(300, 0, 300, 580));
        checkStrike(2, 5, 8, new Line2D.Double(500, 0, 500, 580));

        //horizontally
        checkStrike(0, 1, 2, new Line2D.Double(0, 90, 600, 90));
        checkStrike(3, 4, 5, new Line2D.Double(0, 270, 600, 270));
        checkStrike(6, 7, 8, new Line2D.Double(0, 450, 600, 450));

        //slant
        checkStrike(0, 4, 8, new Line2D.Double(0, 0, 600, 555));
        checkStrike(2, 4, 6, new Line2D.Double(585, 0, 0, 545));


    }

    public boolean checkNoMovesEnd() {
        for (Field f : fields)
            if (f == null)
                return false;
        return true;
    }

    private void checkStrike(int i, int i2, int i3, Line2D line2D) {
        if (fields[i] != null && fields[i2] != null && fields[i3] != null) {
            if (fields[i].isSymbol_O() && fields[i2].isSymbol_O() && fields[i3].isSymbol_O()) {
                this.slashLine = line2D;
                gameOver = true;
            } else if (fields[i].isSymbol_X() && fields[i2].isSymbol_X() && fields[i3].isSymbol_X()) {
                this.slashLine = line2D;
                gameOver = true;
            }
        }
    }

    public void setupChain() {
        this.field_1 = new Field_1(this);
        Field field_2 = new Field_2(this);
        Field field_3 = new Field_3(this);
        Field field_4 = new Field_4(this);
        Field field_5 = new Field_5(this);
        Field field_6 = new Field_6(this);
        Field field_7 = new Field_7(this);
        Field field_8 = new Field_8(this);
        Field field_9 = new Field_9(this);

        field_1.setNextFieldInChain(field_2);
        field_2.setNextFieldInChain(field_3);
        field_3.setNextFieldInChain(field_4);
        field_4.setNextFieldInChain(field_5);
        field_5.setNextFieldInChain(field_6);
        field_6.setNextFieldInChain(field_7);
        field_7.setNextFieldInChain(field_8);
        field_8.setNextFieldInChain(field_9);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));

        g2d.drawLine(200, 0, 200, 600);
        g2d.drawLine(400, 0, 400, 600);

        g2d.drawLine(0, 180, 600, 180);
        g2d.drawLine(0, 360, 600, 360);

        if (repaint) {
            for (Field f : fields) {
                if (f != null) {
                    int centerXPoint = (int) f.getCenterPoint().getX();
                    int centerYPoint = (int) f.getCenterPoint().getY();
                    g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
                    if (f.isSymbol_O()) {
                        int ovalSize = 80;
                        g2d.drawOval(centerXPoint - (ovalSize / 2), centerYPoint - (ovalSize / 2), ovalSize, ovalSize);
                    } else if (f.isSymbol_X()) {
                        int sharpSize = 40;

                        g2d.drawLine(centerXPoint - sharpSize, centerYPoint + sharpSize, centerXPoint + sharpSize, centerYPoint - sharpSize);
                        g2d.drawLine(centerXPoint - sharpSize, centerYPoint - sharpSize, centerXPoint + sharpSize, centerYPoint + sharpSize);
                    }
                }
                if (symbol.toString().equals("X"))
                    this.symbol = Symbol.O;
                else
                    this.symbol = Symbol.X;
            }
        }
        if (slashLine != null) {
            g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
            g2d.draw(this.slashLine);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameOver)
            resetGame();
        else if (checkNoMovesEnd())
            resetGame();
        else
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
