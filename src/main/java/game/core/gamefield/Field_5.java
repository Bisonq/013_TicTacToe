package game.core.gamefield;

import game.core.Symbol;
import game.gui.GamePanel;

import java.awt.*;

public class Field_5 extends Field{

    private GamePanel panel;

    public Field_5(GamePanel panel){
        setCenterPoint(new Point(300, 270));
        setSymbol_O(false);
        setSymbol_X(false);
        this.panel = panel;
    }

    @Override
    public void process(int x, int y, Symbol symbol) {
        if(x > 205 && x < 395 && y > 185 && y < 355){
            Field[] fields = panel.getFields();
            if(symbol.toString().equals("X")){
                if(fields[4] == null) {
                    setSymbol_X(true);
                    fields[4] = this;
                    panel.setFields(fields);
                }
            }else{
                if(fields[4] == null) {
                    setSymbol_O(true);
                    fields[4] = this;
                    panel.setFields(fields);
                }
            }
        }else{
            getNextFieldInChain().process(x, y, symbol);
        }
    }
}
