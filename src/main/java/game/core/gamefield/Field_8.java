package game.core.gamefield;

import game.core.Symbol;
import game.gui.GamePanel;

import java.awt.*;

public class Field_8 extends Field{

    private GamePanel panel;

    public Field_8(GamePanel panel){
        setCenterPoint(new Point(300, 450));
        setSymbol_O(false);
        setSymbol_X(false);
        this.panel = panel;
    }

    @Override
    public void process(int x, int y, Symbol symbol) {
        if(x > 205 && x < 395 && y >365){
            Field[] fields = panel.getFields();
            if(symbol.toString().equals("X")){
                if(fields[7] == null) {
                    setSymbol_X(true);
                    fields[7] = this;
                    panel.setFields(fields);
                }
            }else{
                if(fields[7] == null) {
                    setSymbol_O(true);
                    fields[7] = this;
                    panel.setFields(fields);
                }
            }
        }else{
            getNextFieldInChain().process(x, y, symbol);
        }
    }
}
