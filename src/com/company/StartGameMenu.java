package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class StartGameMenu extends BasicGameState {

    Image gameSelect;
    Image startGame;
    Image exitGame;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        gameSelect = new Image("/gameStartMenu.png");
        startGame = new Image("startGame.png");
        exitGame = new Image("exitGame.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        gameSelect.draw(0, 0);
        startGame.draw(gameContainer.getWidth() - 1150, 500);
        exitGame.draw(gameContainer.getWidth() - 1150, 590);
    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        var inp = container.getInput();
        if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (inp.getMouseX() > container.getWidth() - 1150 && inp.getMouseX() < container.getWidth() - 760) {
                if (inp.getMouseY() > 500 && inp.getMouseY() < 77 + 500) {
                    stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
                }
            }
            if (inp.getMouseX() > container.getWidth() - 1150 && inp.getMouseX() < container.getWidth() - 760) {
                if (inp.getMouseY() > 590 && inp.getMouseY() < 77 + 590) {
                    System.exit(0);
                }
            }
        }
    }
}
