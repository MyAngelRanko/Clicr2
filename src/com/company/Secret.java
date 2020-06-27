package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Secret extends BasicGameState {
    Image secret;
    Image back;


    @Override
    public int getID() { return 5; }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        secret = new Image("/Secret.png");
        back = new Image("/back.png");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        secret.draw(0,0);
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
            if (inp.getMouseX() > container.getWidth() - 875 && inp.getMouseX() < container.getWidth() - 850) {
                if (inp.getMouseY() > 1000 && inp.getMouseY() < 28+1000) {
                    stateBasedGame.enterState(6, new FadeOutTransition(), new FadeInTransition());
                }
            }
        }
    }
}
