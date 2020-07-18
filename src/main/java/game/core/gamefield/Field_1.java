package game.core.gamefield;

import game.core.Symbol;
import game.gui.GamePanel;

import java.awt.*;

public class Field_1 extends Field {

    private GamePanel panel;

    public Field_1(GamePanel panel) {
        setCenterPoint(new Point(100, 90));
        setSymbol_O(false);
        setSymbol_X(false);
        this.panel = panel;
    }

    @Override
    public void process(int x, int y, Symbol symbol) {
        if (x < 195 && y < 175) {
            Field[] fields = panel.getFields();
            if (symbol.toString().equals("X")) {
                if (fields[0] == null) {
                    setSymbol_X(true);
                    fields[0] = this;
                    panel.setFields(fields);
                }
            } else {
                if (fields[0] == null) {
                    setSymbol_O(true);
                    fields[0] = this;
                    panel.setFields(fields);
                }
            }
        } else {
            getNextFieldInChain().process(x, y, symbol);
        }
    }
}
