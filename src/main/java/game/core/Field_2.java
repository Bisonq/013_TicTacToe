package game.core;

import game.gui.GamePanel;

import java.awt.*;

public class Field_2 extends Field{

    private GamePanel panel;

    public Field_2(GamePanel panel){
        setCenterPoint(new Point(300, 90));
        setSymbol_O(false);
        setSymbol_X(false);
        this.panel = panel;
    }

    @Override
    public void process(int x, int y, Symbol symbol) {
        if(x > 205 && x < 395 && y < 175){
            Field[] fields = panel.getFields();
            if(symbol.toString().equals("X")){
                if(fields[1] == null) {
                    setSymbol_X(true);
                    fields[1] = this;
                }
                panel.setFields(fields);
            }else{
                if(fields[1] == null) {
                    setSymbol_O(true);
                    fields[1] = this;
                    panel.setFields(fields);
                }
            }
        }else{
            getNextFieldInChain().process(x, y, symbol);
        }
    }
}
