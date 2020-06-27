package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import javax.swing.*;

public class RefactorNew extends BasicGameState {
    Image coalUp;
    Image ironUp;
    Image goldUp;
    Image background;
    Image select;
    Image shopMenu;
    Image shopSell;
    Image moneyVis;
    Image back;

    Sound sound1;
    // Очки
    public static int score = 0;
    // Ценность руд (Сколько дают очков)
    static int coalOre = 1;
    static int ironOre = 160;
    static int goldOre = 1640;
    static int diamondOre = 5600;
    // Стоимость апгрейда (Сколько нужно заплатить за прокачку)
    public static int priceCoal = 10;
    public static int priceIron = 2000;
    public static int priceGold = 150000;
    public static int priceDiamond = 2500000;
    // Lvl (Всё связанное с уровнем)
    public static int lvl = 1; // Уровень
    public static int exp = 0; // Опыт
    public static int priceLvl = 175; // Стоимость прокачки уровня
    public static int diffLvl = (priceLvl - exp);// Разница между имеющимся опытом(exp) и priceLvl("Цены" уровня)

    // Разница между имеющимися очками(Score) и priceOre("Цены" улучшения руд)
    public static int diffPrcCoal = priceCoal - score;
    public static int diffPrcIron = priceIron - score;
    public static int diffPrcGold = priceGold - score;
    public static int diffPrcDiamond = priceDiamond - score;
    // Проверка наличии кирки
    public static boolean StonePickaxe = false;
    public static boolean IronPickaxe = false;
    public static boolean SuperPickaxe = false;

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        //--------------------- Вводим картинки ---------------------------------------------
        background = new Image("/фонШахты.png");
        select = new Image("/mainMenu.png");
        coalUp = new Image("/coalUp.png");
        shopMenu = new Image("/shopMenu.png");
        shopSell = new Image("/shopSell.png");
        ironUp = new Image("/ironUp.png");
        goldUp = new Image("/goldUp.png");
        moneyVis = new Image("/moneyVis.png");
        back = new Image("/back.png");

        sound1 = new Sound("/minecraft_click.ogg");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //-------------- Рисуем картинки и проставляем координаты ------------------------

        background.draw(0, 0);
        coalUp.draw(gameContainer.getWidth() - 1560, 860);
        ironUp.draw(gameContainer.getWidth() - 1170, 860);
        goldUp.draw(gameContainer.getWidth() - 780, 860);
        moneyVis.draw(1675, 830);
        back.draw(gameContainer.getWidth() - 210, 20);
        graphics.drawString(": " + score, 1740, 860);
        graphics.drawString("Lvl :" + lvl, 10, 50);
        graphics.drawString("Exp :" + exp, 10, 70);
        graphics.drawString("Exp required :"+ diffLvl, 10,90);

    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        var keyDown = container.getInput();
        if (keyDown.isKeyDown(Input.KEY_ESCAPE) == true){
            container.exit();
        }

        var inp = container.getInput();

        if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (inp.getMouseX() > container.getWidth() - 210 && inp.getMouseX() < container.getWidth() - 15) {
                if (inp.getMouseY() > 20 && inp.getMouseY() < 77 + 20) {
                    stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
                }
            }


//------------------------------------------------ Функция угля -----------------------------------------------------

            if (inp.getMouseX() > container.getWidth() - 1615 && inp.getMouseX() < container.getWidth() - 1260) {

                if (inp.getMouseY() > 555 && inp.getMouseY() < 280 + 555) {
                    score += coalOre;
                    diffLvl -= coalOre;
                }
            }

            var inp1 = container.getInput();

            //-------------------------------------- Опыт угля -----------------------------------------------------

            if (inp1.getMouseX() > container.getWidth() - 1615 && inp1.getMouseX() < container.getWidth() - 1260) {

                if (inp1.getMouseY() > 555 && inp1.getMouseY() < 280 + 555) {
                    exp += coalOre;
                    if (exp >= priceLvl) {
                        lvl += 1;
                        int exp1 = (exp - exp);
                        exp = exp1;
                        int exp2 = ((priceLvl + 47) * 2);
                        priceLvl = exp2;
                        int diffLvl1 = exp2 - exp1;
                        diffLvl = diffLvl1;
                    }
                }
            }

            //--------------------------- Апгрейт угля ---------------------------------------------------
            if (inp1.getMouseX() > container.getWidth() - 1560 && inp1.getMouseX() < container.getWidth() - 1170) {

                if (inp1.getMouseY() > 860 && inp1.getMouseY() < 77 + 860) {

                    if (score >= priceCoal) {
                        coalOre++;
                        diffPrcCoal = coalOre;
                        int score1 = score - priceCoal;
                        score = score1;
                        int price1 = (priceCoal * 2);
                        priceCoal = price1;
                    }
                }
            }

            //------------------------------------ Функция железа -------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 1109 && inp.getMouseX() < container.getWidth() - 855) {

                if (inp.getMouseY() > 556 && inp.getMouseY() < 285 + 556) {
                    if (StonePickaxe == true) {
                        score += ironOre;
                        diffLvl -= ironOre;
                    }
                }
            }


            //------------------------------------ Опыт железа -------------------------------------------------
            if (inp1.getMouseX() > container.getWidth() - 1109 && inp1.getMouseX() < container.getWidth() - 855) {

                if (inp1.getMouseY() > 556 && inp1.getMouseY() < 285 + 556) {
                    if (StonePickaxe == true) {
                        exp += ironOre / 2;
                        if (exp >= priceLvl) {
                            lvl += 1;
                            int exp1 = (exp - exp);
                            exp = exp1;
                            int exp2 = ((priceLvl + 75) * 2);
                            priceLvl = exp2;
                        }
                    }
                }
            }

            //------------------------------------------------ Апгрейт железа ----------------------------------------

            if (inp1.getMouseX() > container.getWidth() - 1170 && inp1.getMouseX() < container.getWidth() - 780) {

                if (inp1.getMouseY() > 860 && inp1.getMouseY() < 77 + 860) {
                    if (StonePickaxe == true) {
                        if (score >= priceIron) {
                            ironOre++;
                            int score1 = score - priceIron;
                            score = score1;
                            int price1 = (priceIron * 2);
                            priceIron = price1;
                        }
                    }
                }
            }

            //----------------------------------- Функция золота ------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 685 && inp.getMouseX() < container.getWidth() - 340) {

                if (inp.getMouseY() > 565 && inp.getMouseY() < 280 + 565) {
                    if (IronPickaxe == true) {
                        score += goldOre;
                        diffLvl -= goldOre;
                    }
                }
            }

            //----------------------------------- Опыт золота ------------------------------------------------
            if (inp1.getMouseX() > container.getWidth() - 685 && inp1.getMouseX() < container.getWidth() - 340) {

                if (inp1.getMouseY() > 565 && inp1.getMouseY() < 280 + 565) {
                    if (IronPickaxe == true) {
                        exp += goldOre / 2;
                        if (exp >= priceLvl) {
                            lvl += 1;
                            int exp1 = (exp - exp);
                            exp = exp1;
                            int exp2 = ((priceLvl + 75) * 2);
                            priceLvl = exp2;
                        }
                    }
                }
            }
            //------------------------------------------------ Апгрейт золота ----------------------------------------
            if (inp1.getMouseX() > container.getWidth() - 780 && inp1.getMouseX() < container.getWidth() - 390) {

                if (inp1.getMouseY() > 860 && inp1.getMouseY() < 77 + 860) {
                    if (IronPickaxe == true) {
                        if (score >= priceGold) {
                            goldOre++;
                            score++;
                            int score1 = score - priceGold;
                            score = score1;
                            int price1 = (priceGold * 2);
                            priceGold = price1;
                        }
                    }
                }
            }
        }
    }
}

