package game.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {

    public GamePanel(){
        super();
        addMouseListener(this);
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

        int widthPoint  = 300;
        int heightPoint = 450;
        g2d.drawOval(widthPoint - (80 / 2), heightPoint - (80 / 2), 80, 80);

        widthPoint = 500;
        heightPoint = 450;
        g2d.drawOval(widthPoint - (80 / 2), heightPoint - (80 / 2), 80, 80);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
