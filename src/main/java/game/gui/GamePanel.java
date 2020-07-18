package game.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(){
        super();
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
    }
}
