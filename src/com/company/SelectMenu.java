package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import static com.company.Variables.*;

public class SelectMenu extends BasicGameState {

    Image mainMenu;
    Image moneyVis;

    Sound sound1;

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        mainMenu = new Image("/mainMenu.png");
        moneyVis = new Image("/moneyVis.png");

        sound1 = new Sound("/minecraft_click.ogg");
        sound1.play(1.0f, 1.0f);
        sound1.play();


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        mainMenu.draw(0, 0);
        moneyVis.draw(1675, 830);
        graphics.drawString(": " + score, 1740, 860);
        graphics.drawString("Lvl :" + lvl, 10, 50);
        graphics.drawString("Exp :" + exp, 10, 70);

    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        var inp = container.getInput();
        if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (inp.getMouseX() > container.getWidth() - 1590 && inp.getMouseX() < container.getWidth() - 1270) {
                if (inp.getMouseY() > 470 && inp.getMouseY() < 203 + 470) {
                    stateBasedGame.enterState(2, new FadeOutTransition(), new FadeInTransition());
                }
            }
            if (inp.getMouseX() > container.getWidth() - 712 && inp.getMouseX() < container.getWidth() - 100) {
                if (inp.getMouseY() > 356 && inp.getMouseY() < 497 + 356) {
                    stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
                }
            }
            if (inp.getMouseX() > container.getWidth() - 1970 && inp.getMouseX() < container.getWidth() - 1770) {
                if (inp.getMouseY() > 470 && inp.getMouseY() < 303 + 470) {
                    stateBasedGame.enterState(5, new FadeOutTransition(), new FadeInTransition());
                }
            }
        }
        var key = container.getInput();
        if (key.isKeyPressed(Input.KEY_ESCAPE)) {
            stateBasedGame.enterState(0, new FadeOutTransition(), new FadeInTransition());
        }
    }
}