package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.BlobbyTransition;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Shop extends BasicGameState {
    Image shopMenu;
    Image back;
    Image openSell;

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        shopMenu = new Image("/shopMenu.png");
        back = new Image("/back.png");
        openSell = new Image("/openSell.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        shopMenu.draw(0, 0);
        back.draw(gameContainer.getWidth() - 210, 20);
        openSell.draw(gameContainer.getWidth() - 1170, 427);
    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        var inp = container.getInput();
        if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (inp.getMouseX() > container.getWidth() - 210 && inp.getMouseX() < container.getWidth() - 15) {
                if (inp.getMouseY() > 20 && inp.getMouseY() < 77 + 20) {
                    stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
                }
            }
            if (inp.getMouseX() > container.getWidth() - 1170 && inp.getMouseX() < container.getWidth() - 837) {
                if (inp.getMouseY() > 427 && inp.getMouseY() < 388 + 427) {
                    stateBasedGame.enterState(4, new FadeOutTransition(), new FadeInTransition());
                }
            }
        }
    }
}
