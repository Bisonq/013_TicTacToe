package game.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(){
        super();
        setSize(new Dimension(600, 580));
        setLocation(100,100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
