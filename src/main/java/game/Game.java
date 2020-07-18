package game;

import game.gui.Frame;
import game.gui.GamePanel;

public class Game {

    private static final Game game = new Game();

    private Game() {
    }

    public static Game getInstance() {
        return game;
    }

    public void startGame() {
        Frame frame = new Frame(new GamePanel());
    }
}
