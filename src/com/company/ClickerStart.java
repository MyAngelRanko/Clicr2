package com.company;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ClickerStart extends StateBasedGame {

    public ClickerStart(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {

        this.addState(new StartGameMenu());
        this.addState(new SelectMenu());
        this.addState(new Shop());
        this.addState(new ShopSell());
        this.addState(new Mine());
        this.addState(new Secret());
        this.addState(new Developer_Room());


        container.setTargetFrameRate(144);
        container.setAlwaysRender(true);
    }


    public static void main(String[] args) throws SlickException {
        LvlCalculated.lvlCalculated(); // Запуск калькулятора уровней
        AppGameContainer container = new AppGameContainer(new ClickerStart("Clicker"));
        container.setDisplayMode(1920, 1080, false);
        container.start();
    }
}
