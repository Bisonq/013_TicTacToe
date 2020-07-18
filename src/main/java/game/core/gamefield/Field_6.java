package game.core.gamefield;

import game.core.Symbol;
import game.gui.GamePanel;

import java.awt.*;

public class Field_6 extends Field{

    private GamePanel panel;

    public Field_6(GamePanel panel){
        setCenterPoint(new Point(500, 270));
        setSymbol_O(false);
        setSymbol_X(false);
        this.panel = panel;
    }

    @Override
    public void process(int x, int y, Symbol symbol) {
        if(x > 405 && y > 185 && y < 355){
            Field[] fields = panel.getFields();
            if(symbol.toString().equals("X")){
                if(fields[5] == null) {
                    setSymbol_X(true);
                    fields[5] = this;
                    panel.setFields(fields);
                }
            }else{
                if(fields[5] == null) {
                    setSymbol_O(true);
                    fields[5] = this;
                    panel.setFields(fields);
                }
            }
        }else{
            getNextFieldInChain().process(x, y, symbol);
        }
    }
}
