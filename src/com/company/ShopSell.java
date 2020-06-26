package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class ShopSell extends BasicGameState {
    Image shopSell;
    Image shopMenu;
    Image back;

    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        shopMenu = new Image("shopMenu.png");
        shopSell = new Image("/shopSell.png");
        back = new Image("/back.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        shopMenu.draw(0, 0);
        shopSell.draw(160, 30);
        back.draw(gameContainer.getWidth() - 210, 20);
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
        }
    }
}