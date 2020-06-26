package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import static com.company.RefactorNew.score;
import static com.company.RefactorNew.lvl;
import static com.company.RefactorNew.exp;

public class SelectMenu extends BasicGameState {

    Image mainMenu;
    Image moneyVis;

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        mainMenu = new Image("/mainMenu.png");
        moneyVis = new Image("/moneyVis.png");
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
        }
    }
}