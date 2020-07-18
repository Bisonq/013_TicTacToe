package game.core.gamefield;

import game.core.Symbol;
import game.gui.GamePanel;

import java.awt.*;

public class Field_9 extends Field {

    private GamePanel panel;

    public Field_9(GamePanel panel) {
        setCenterPoint(new Point(500, 450));
        setSymbol_O(false);
        setSymbol_X(false);
        this.panel = panel;
    }

    @Override
    public void process(int x, int y, Symbol symbol) {
        if (x > 405 && y > 365) {
            Field[] fields = panel.getFields();
            if (symbol.toString().equals("X")) {
                if (fields[8] == null) {
                    setSymbol_X(true);
                    fields[8] = this;
                    panel.setFields(fields);
                }
            } else {
                if (fields[8] == null) {
                    setSymbol_O(true);
                    fields[8] = this;
                    panel.setFields(fields);
                }
            }
        }
    }
}
