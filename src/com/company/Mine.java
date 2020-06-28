package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


import static com.company.Variables.*;


public class Mine extends BasicGameState {
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
    //Sound click;

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        //--------------------- Вводим внешние файлы ---------------------------------------------
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
        //click = new Sound("/clickSound.ogg");

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
        graphics.drawString("Exp required :" + diffLvl, 10, 90);
        graphics.drawString("Score required :" + priceCoal, 460, 960);
        graphics.drawString("Score required :" + priceIron, 870, 960);
        graphics.drawString("Score required :" + priceGold, 1280, 960);

    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        var keyDown = container.getInput();
        if (keyDown.isKeyDown(Input.KEY_ESCAPE) == true) {
            stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }

        var inp = container.getInput();

        if (inp.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (inp.getMouseX() > container.getWidth() - 210 && inp.getMouseX() < container.getWidth() - 15) {
                if (inp.getMouseY() > 20 && inp.getMouseY() < 77 + 20) {
                    sound1.play();
                    stateBasedGame.enterState(1, new FadeOutTransition(), new FadeInTransition());
                }
            }


//------------------------------------------------ Функция угля -----------------------------------------------------

            if (inp.getMouseX() > container.getWidth() - 1615 && inp.getMouseX() < container.getWidth() - 1260) {

                if (inp.getMouseY() > 555 && inp.getMouseY() < 280 + 555) {
                    //click.play(0.0f,0.01f);
                    //click.play();
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
                        long exp1 = (exp - exp);
                        exp = exp1;
                        long exp2 = ((priceLvl + 47) * 2);
                        priceLvl = exp2;
                        long diffLvl1 = exp2 - exp1;
                        diffLvl = diffLvl1;
                    }
                }
            }

            //--------------------------- Апгрейт угля ---------------------------------------------------

            if (inp1.getMouseX() > container.getWidth() - 1560 && inp1.getMouseX() < container.getWidth() - 1170) {

                if (inp1.getMouseY() > 860 && inp1.getMouseY() < 77 + 860) {

                    if (score >= priceCoal) {
                        coalOre++;
                        score -= priceCoal;
                        priceCoal *= 2;
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
                            long exp1 = (exp - exp);
                            exp = exp1;
                            long exp2 = ((priceLvl + 47) * 2);
                            priceLvl = exp2;
                            long diffLvl1 = exp2 - exp1;
                            diffLvl = diffLvl1;
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
                            score -= priceIron;
                            priceIron *= 2;
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
                            long exp1 = (exp - exp);
                            exp = exp1;
                            long exp2 = ((priceLvl + 47) * 2);
                            priceLvl = exp2;
                            long diffLvl1 = exp2 - exp1;
                            diffLvl = diffLvl1;
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
                            score -= priceGold;
                            priceGold *= 2;
                        }
                    }
                }
            }
        }
    }
}

