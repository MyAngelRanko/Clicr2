package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import static com.company.Variables.*;

public class ShopSell extends BasicGameState {
    Image shopSell;
    Image shopMenu;
    Image back;
    Image stonePickaxe;
    Image ironPickaxe;
    Image buy;
    Image moneyVis;
    Image stonks;

    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        shopMenu = new Image("shopMenu.png");
        shopSell = new Image("/shopSell.png");
        back = new Image("/back.png");
        stonePickaxe = new Image("/stonePickaxe.png");
        ironPickaxe = new Image("/ironPickaxe.png");
        buy = new Image("/buy.png");
        moneyVis = new Image("/moneyVis.png");
        stonks = new Image("/stonks.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        shopMenu.draw(0, 0);
        shopSell.draw(160, 30);
        back.draw(gameContainer.getWidth() - 210, 20);
        stonePickaxe.draw(gameContainer.getWidth() - 1650, 630);
        ironPickaxe.draw(gameContainer.getWidth() - 1450, 630);
        buy.draw(gameContainer.getWidth() - 1650, 810);
        buy.draw(gameContainer.getWidth() - 1450, 810);
        moneyVis.draw(1675, 830);
        stonks.draw(gameContainer.getWidth() - 1630, 900);
        stonks.draw(gameContainer.getWidth() - 1430, 900);
        graphics.drawString("Cost:", 295, 920);
        graphics.drawString("Cost:", 495, 920);
        graphics.drawString(": " + score, 1740, 860);
        graphics.drawString("Lvl :" + lvl, 10, 50);
        graphics.drawString("Exp :" + exp, 10, 70);

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
            if (inp.getMouseX() > container.getWidth() - 1650 && inp.getMouseX() < container.getWidth() - 1490) {
                if (inp.getMouseY() > 810 && inp.getMouseY() < 77 + 810) {
                    if (lvl >= 2 && score >= 100 && StonePickaxe == false) {
                        StonePickaxe = true;
                        score -= 100;
                    }
                }
            }
            if (inp.getMouseX() > container.getWidth() - 1450 && inp.getMouseX() < container.getWidth() - 1290) {
                if (inp.getMouseY() > 810 && inp.getMouseY() < 77 + 810) {
                    if (lvl >= 2 && score >= 100 && IronPickaxe == false) {
                        IronPickaxe = true;
                        score -= 1000;
                    }
                }
            }
        }
    }
}