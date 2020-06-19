package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import javax.swing.*;

public class RefactorNew extends BasicGameState {
    Image coalIm;
    Image ironIm;
    Image goldIm;
    Image back;
    Image shop;
    // Очки
    static int score = 0;
    // Ценность руд (Сколько дают очков)
    static int coalOre = 1;
    static int ironOre = 160;
    static int goldOre = 1640;
    static int diamondOre = 5600;
    // Стоимость апгрейда (Сколько нужно заплатить за прокачку)
    static int priceCoal = 10;
    static int priceIron = 2000;
    static int priceGold = 150000;
    static int priceDiamond = 2500000;
    // Lvl (Всё связанное с уровнем)
    static int lvl = 1; // Уровень
    static int exp = 0; // Опыт
    static int priceLvl = 175; // Стоимость прокачки уровня
    static int diffLvl = (priceLvl - exp);// Разница между имеющимся опытом(exp) и priceLvl("Цены" уровня)

    // Разница между имеющимися очками(Score) и priceOre("Цены" улучшения руд)
    static int diffPrcCoal = priceCoal - score;
    static int diffPrcIron = priceIron - score;
    static int diffPrcGold = priceGold - score;
    static int diffPrcDiamond = priceDiamond - score;
    // Проверка наличии кирки
    static boolean StonePickaxe = false;
    static boolean IronPickaxe = false;
    static boolean SuperPickaxe = false;
    //открыт ли магазин
    static boolean open = false;
    static boolean open1 = true;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        coalIm = new Image("/Угольная_руда.png");
        ironIm = new Image("/Железная_руда.png");
        goldIm = new Image("/Золотая_руда.png");
        back = new Image("/фон.jpg");
        shop = new Image("/shop.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        back.draw(0, 200);
        graphics.drawString("Score :" + score, 50, 600);
        graphics.drawString("Lvl :" + lvl, 250, 600);
        graphics.drawString("Exp :" + exp, 250, 650);
        shop.draw(1600, 250);
        coalIm.draw(gameContainer.getWidth() - 1620, 700);
        ironIm.draw(gameContainer.getWidth() - 1120, 700);
        goldIm.draw(gameContainer.getWidth() - 620, 700);

    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        var inp = container.getInput();
        if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
//--------------------------- Функция угля -----------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 1620 && inp.getMouseX() < container.getWidth() - 1300) {

                if (inp.getMouseY() > 700 && inp.getMouseY() < 320 + 700) {
                    score += coalOre;
                    diffLvl -= coalOre;
                    diffPrcCoal -= coalOre;
                }
            }
            //------------------------------------ Функция железа -------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 1120 && inp.getMouseX() < container.getWidth() - 800) {

                if (inp.getMouseY() > 700 && inp.getMouseY() < 320 + 700) {
                    score += ironOre;
                    diffLvl -= ironOre;
                }
            }
            //----------------------------------- Функция золота ------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 620 && inp.getMouseX() < container.getWidth() - 300) {

                if (inp.getMouseY() > 700 && inp.getMouseY() < 320 + 700) {
                    score += goldOre;
                    diffLvl -= goldOre;
                }
            }
        //__________________________________________ ОПЫТ ________________________________________________________
        var inp1 = container.getInput();
//------------------------------------------------ Опыт угля -----------------------------------------------------
            if (inp1.getMouseX() > container.getWidth() - 1620 && inp1.getMouseX() < container.getWidth() - 1300) {

                if (inp1.getMouseY() > 700 && inp1.getMouseY() < 320 + 700) {
                    exp += coalOre;
                    if (exp >= priceLvl) {
                        lvl += 1;
                        int exp1 = (exp - exp);
                        exp = exp1;
                        int exp2 = ((priceLvl + 75) * 2);
                        priceLvl = exp2;
                        int diffLvl1 = exp2 - exp1;
                        diffLvl = diffLvl1;
                    }
                }
            }
                //------------------------------------ Опыт железа -------------------------------------------------
                if (inp1.getMouseX() > container.getWidth() - 1120 && inp1.getMouseX() < container.getWidth() - 800) {

                    if (inp.getMouseY() > 700 && inp1.getMouseY() < 320 + 700) {
                        exp += ironOre / 2;
                        if (exp >= priceLvl) {
                            lvl += 1;
                            int exp1 = (exp - exp);
                            exp = exp1;
                            int exp2 = ((priceLvl + 75) * 2);
                            priceLvl = exp2;
                            int diffLvl1 = exp2 - exp1;
                            diffLvl = diffLvl1;
                        }
                    }
                }
                    //----------------------------------- Опыт золота ------------------------------------------------
                    if (inp1.getMouseX() > container.getWidth() - 620 && inp1.getMouseX() < container.getWidth() - 300) {

                        if (inp1.getMouseY() > 700 && inp1.getMouseY() < 320 + 700) {
                            exp += goldOre / 2;
                            if (exp >= priceLvl) {
                                lvl += 1;
                                int exp1 = (exp - exp);
                                exp = exp1;
                                int exp2 = ((priceLvl + 75) * 2);
                                priceLvl = exp2;
                                int diffLvl1 = exp2 - exp1;
                                diffLvl = diffLvl1;
                    }
                }
            }
        }
    }
}