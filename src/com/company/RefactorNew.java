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
    Image select;
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
        //--------------------- Вводим картинки ---------------------------------------------
        back = new Image("/фон2.png");
        select = new Image("/select.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        //-------------- Рисуем картинки и проставляем координаты ------------------------
        select.draw(0, 200);
        back.draw(0, 200);
        graphics.drawString("Score :" + score, 1650, 1100);
        graphics.drawString("Lvl :" + lvl, 10, 250);
        graphics.drawString("Exp :" + exp, 10, 270);
    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {

        var inp = container.getInput();
        if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
           // var mine = container.getInput();
           // if (mine.getMouseX() > container.getWidth() - 1500 && mine.getMouseX() < container.getWidth() - 1195){
             //   if (mine.getMouseY() > 800 && mine.getMouseY() < 305 + 800){
             //   }
           // }
//------------------------------------------------ Функция угля -----------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 1615 && inp.getMouseX() < container.getWidth() - 1260) {

                if (inp.getMouseY() > 855 && inp.getMouseY() < 360 + 855) {
                    score += coalOre;
                    diffLvl -= coalOre;
                }
            }
            //------------------------------------ Функция железа -------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 1109 && inp.getMouseX() < container.getWidth() - 779) {

                if (inp.getMouseY() > 856 && inp.getMouseY() < 330 + 856) {
                    score += ironOre;
                    diffLvl -= ironOre;
                }
            }
            //----------------------------------- Функция золота ------------------------------------------------
            if (inp.getMouseX() > container.getWidth() - 690 && inp.getMouseX() < container.getWidth() - 355) {

                if (inp.getMouseY() > 865 && inp.getMouseY() < 335 + 865) {
                    score += goldOre;
                    diffLvl -= goldOre;
                }
            }

        //__________________________________________ ОПЫТ ________________________________________________________

        var inp1 = container.getInput();
//------------------------------------------------ Опыт угля -----------------------------------------------------
            if (inp1.getMouseX() > container.getWidth() - 1615 && inp1.getMouseX() < container.getWidth() - 1260) {

                if (inp1.getMouseY() > 855 && inp1.getMouseY() < 360 + 855) {
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
                //------------------------------------ Опыт железа -------------------------------------------------
                if (inp1.getMouseX() > container.getWidth() - 1109 && inp1.getMouseX() < container.getWidth() - 779) {

                    if (inp1.getMouseY() > 856 && inp1.getMouseY() < 330 + 856) {
                        exp += ironOre / 2;
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
                    //----------------------------------- Опыт золота ------------------------------------------------
                    if (inp1.getMouseX() > container.getWidth() - 690 && inp1.getMouseX() < container.getWidth() - 355) {

                        if (inp1.getMouseY() > 865 && inp1.getMouseY() < 335 + 865) {
                            exp += goldOre / 2;
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
             var shop = container.getInput();
             if (shop.getMouseX() > container.getWidth() - 200 && shop.getMouseX() < container.getWidth() - 50){
                 if(shop.getMouseY() > 250 && shop.getMouseY() < 150 + 250){


                }
            }
        }
    }
}