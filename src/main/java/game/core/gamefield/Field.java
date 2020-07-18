package game.core.gamefield;

import game.core.Symbol;

import java.awt.*;

public abstract class Field {
    private Field nextFieldInChain;
    private boolean isSymbol_X;
    private boolean isSymbol_O;
    private Point centerPoint;

    public abstract void process(int x, int y, Symbol symbol);

    public Field getNextFieldInChain() {
        return nextFieldInChain;
    }

    public void setNextFieldInChain(Field nextFieldInChain) {
        this.nextFieldInChain = nextFieldInChain;
    }

    public void setSymbol_X(boolean symbol_X) {
        isSymbol_X = symbol_X;
    }

    public void setSymbol_O(boolean symbol_O) {
        isSymbol_O = symbol_O;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;
    }

    public boolean isSymbol_X() {
        return isSymbol_X;
    }

    public boolean isSymbol_O() {
        return isSymbol_O;
    }

    public Point getCenterPoint() {
        return centerPoint;
    }
}
