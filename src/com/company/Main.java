package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Spliterators;

public class Main{
    // Очки
    static int score = 0;

    // Ценность руд (Сколько дают очков)
    static int coalOre = 1 ;
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

    //Разница между имеющимися очками(Score) и priceOre("Цены" улучшения руд)
    static int diffPrcCoal = priceCoal - score;
    static int diffPrcIron = priceIron - score;
    static int diffPrcGold = priceGold - score;
    static int diffPrcDiamond = priceDiamond - score;

    // Проверка наличии кирки
    static boolean StonePickaxe = false;
    static boolean IronPickaxe = false;
    static boolean SuperPickaxe = false;

    static boolean open = false;//открыт ли магазин
    static boolean open1 = true;//???



    public static void main(String[] args) {
        // Создание окна
        JFrame frame = new JFrame("Clicker");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(300, 100, 1000,720);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        // Создание кнопок руды
        JButton buttonCoal = new JButton("Coal");
        buttonCoal.setBounds(150,290,140,40);

        JButton buttonIron = new JButton("Iron");
        buttonIron.setBounds(323,290,140,40);

        JButton buttonGold = new JButton("Gold");
        buttonGold.setBounds(496,290,140,40);

        JButton buttonDiamond = new JButton("Diamond");
        buttonDiamond.setBounds(669,290,140,40);
        // Создание кнопок апгрейда
        JButton buttonUpCoal = new JButton("Upgrade Coal");
        buttonUpCoal.setBounds(150,333,140,40);

        JButton buttonUpIronOre = new JButton("Upgrade IronOre");
        buttonUpIronOre.setBounds(323,333,140,40);

        JButton buttonUpGoldOre = new JButton("Upgrade GoldOre");
        buttonUpGoldOre.setBounds(496,333,140,40);

        JButton buttonUpDiamondOre = new JButton("Up. DiamondOre");
        buttonUpDiamondOre.setBounds(669,333,140,40);
        //Кирки
        JButton buttonStonePickaxe = new JButton("Buy :Stone Pickaxe");
        buttonStonePickaxe.setBounds(171,470,140,40);

        JButton buttonIronPickaxe = new JButton("Buy :Iron Pickaxe");
        buttonIronPickaxe.setBounds(343,470,140,40);

        JButton buttonSuperPickaxe = new JButton("Buy :Super Pickaxe");
        buttonSuperPickaxe.setBounds(513,470,140,40);

        JButton autoCoal = new JButton("Auto Уголь");
        autoCoal.setBounds(171,370,140,40);

        JButton autoIron = new JButton("Auto Железо");
        autoIron.setBounds(321,370,140,40);

        JButton autoGold = new JButton("Auto Золото");
        autoGold.setBounds(471,370,140,40);

        JButton autoDiamond = new JButton("Auto Алмазы");
        autoDiamond.setBounds(621,370,140,40);

        JButton magas = new JButton("Магаз");
        magas.setBounds(629,570,140,40);

        JButton back = new JButton("Назад");
        back.setBounds(629,570,140,40);

        JButton lootbox = new JButton("Лутбокс");
        lootbox.setBounds(621,470,140,40);
        // Создание строк
        JLabel label = new JLabel("Score:"+score);
        label.setBounds(820,570,100,15);
        JLabel labelLvl = new JLabel("Lvl :"+lvl);
        labelLvl.setBounds(5,2,100,15);
        JLabel labelExp = new JLabel("Exp :"+exp);
        labelExp.setBounds(60,2,100,15);

        JLabel labelDiffLvl = new JLabel("Осталось опыта :"+diffLvl);
        labelDiffLvl.setBounds(5,20,200,15);
        JLabel labelDiffPrcCoal = new JLabel("Осталось очков :"+diffPrcCoal);
        labelDiffPrcCoal.setBounds(150,400,200,15);
        JLabel labelDiffPrcIron = new JLabel("Осталось очков :"+diffPrcIron);
        labelDiffPrcIron.setBounds(323,400,200,15);
        JLabel labelDiffPrcGold = new JLabel("Осталось очков :"+diffPrcGold);
        labelDiffPrcGold.setBounds(496,400,200,15);
        JLabel labelDiffPrcDiamond= new JLabel("Осталось очков :"+diffPrcDiamond);
        labelDiffPrcDiamond.setBounds(669,400,200,15);

        JLabel labelScoreCoal = new JLabel("+"+coalOre);
        labelScoreCoal.setBounds(194,250,140,40);
        JLabel labelScoreIron = new JLabel("+"+ironOre);
        labelScoreIron.setBounds(387,250,140,40);
        JLabel labelScoreGold = new JLabel("+"+goldOre);
        labelScoreGold.setBounds(540,250,140,40);
        JLabel labelScoreDiamond = new JLabel("+"+diamondOre);
        labelScoreDiamond.setBounds(713,250,140,40);


        // ------------------------------ Функции кнопок ------------------------------
        // -------------------- Уголь --------------------
        // ----- Функция угля -----
        buttonCoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score += coalOre;
                diffLvl -= coalOre;
                diffPrcCoal -= coalOre;
                label.setText("Score :" + score);
                labelDiffLvl.setText("Требуется опыта :" + diffLvl);
                labelDiffPrcCoal.setText("Осталось очков :" + diffPrcCoal);
                if (score >= priceCoal) labelDiffPrcCoal.setText("Доступно улучшение!");
            }
        });
        // ----- Апгрейд Угля -----
        buttonUpCoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (score >= priceCoal) {
                    coalOre++;
                    diffPrcCoal = coalOre;
                    label.setText("Score :" + (score - priceCoal));
                    int score1 = score - priceCoal;
                    score = score1;
                    int price1 = (priceCoal * 2);
                    priceCoal = price1;
                    int diffPrcCoalExp1 = price1 - score1;
                    diffPrcCoal = diffPrcCoalExp1;
                    labelDiffPrcCoal.setText(("Осталось очков :"+diffPrcCoal));
                    labelScoreCoal.setText("+"+ coalOre);
                }
            }
        });
        // ----- Опыт Угля -----
        buttonCoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exp += coalOre;
                labelExp.setText("Exp :" + exp);
                if(exp >= priceLvl){
                    lvl += 1;
                    labelLvl.setText("Lvl :" + lvl);
                    int exp1 = (exp - exp);
                    exp = exp1;
                    int exp2 = ((priceLvl + 75) * 2);
                    priceLvl = exp2;
                    int diffLvl1= exp2-exp1;
                    diffLvl = diffLvl1;
                    labelDiffLvl.setText("Требуется опыта :"+ diffLvl);
                }
            }
        });
        // -------------------- Железо --------------------
        //-------- Кирка для железа -----------
        buttonStonePickaxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (lvl >=10 && score >= 1000 && StonePickaxe == false) {
                    StonePickaxe = true;
                    label.setText("Score :" + (score - 1000));
                    int score1 = score - 1000;
                    score = score1;
                    buttonStonePickaxe.setVisible(false);
                }
            }
        });
        // ----- Функция Железа -----
        buttonIron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StonePickaxe==true) {
                    score += ironOre;
                    diffLvl-= ironOre;
                    label.setText("Score :" + score);
                    labelDiffLvl.setText("Требуется опыта :"+ diffLvl);
                }
            }
        });
        // ----- Апгрейд Железа -----
        buttonUpIronOre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StonePickaxe==true){
                    if(score >= priceIron) {
                        if (score >= priceIron) {
                            ironOre++;
                            label.setText("Score :" + (score - priceIron));
                            int score1 = score - priceIron;
                            score = score1;
                            int price1 = (priceIron * 2);
                            priceIron = price1;
                        }
                    }
                }
            }
        });
        // ----- Опыт Железа -----
        buttonIron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(StonePickaxe==true){
                    exp += ironOre/2;
                    labelExp.setText("Exp :" + exp);
                    if (exp >= priceLvl) {
                        lvl += 1;
                        labelLvl.setText("Lvl :" + lvl);
                        int exp1 = (exp - exp);
                        exp = exp1;
                        int exp2 = ((priceLvl + 75) * 2 );
                        priceLvl = exp2;
                        int diffLvl1= exp2-exp1;
                        diffLvl = diffLvl1;
                        labelDiffLvl.setText("Требуется опыта :"+ diffLvl);
                    }
                }
            }
        });
        // -------------------- Золото --------------------
        //-------- Кирка для золота -----------
        buttonIronPickaxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (lvl >=25 && score >= 5000 && IronPickaxe == false) {
                    IronPickaxe = true;
                    label.setText("Score :" + (score - 5000));
                    int score1 = score - 5000;
                    score = score1;
                    buttonIronPickaxe.setVisible(false);
                }
            }
        });
        // ----- Функция Золота -----
        buttonGold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(IronPickaxe==true){
                    if(lvl>=25) {
                        score += goldOre;
                        diffLvl-= goldOre;
                        label.setText("Score :" + score);
                        labelDiffLvl.setText("Требуется опыта :"+ diffLvl);
                    }
                }
            }
        });
        // ----- Апгрейд Золота -----
        buttonUpGoldOre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(IronPickaxe==true){
                    if(lvl>=25) {
                        if (score >= priceGold) {
                            goldOre++;
                            score++;
                            label.setText("Score :" + (score - priceGold));
                            int score1 = score - priceGold;
                            score = score1;
                            int price1 = (priceGold * 2);
                            priceGold = price1;
                        }
                    }
                }
            }
        });
        // ----- Опыт Золота -----
        buttonGold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(IronPickaxe==true){
                    if(lvl>=25) {
                        exp += goldOre/2;
                        labelExp.setText("Exp :" + exp);
                        if (exp >= priceLvl) {
                            lvl += 1;
                            labelLvl.setText("Lvl :" + lvl);
                            int exp1 = (exp - exp);
                            exp = exp1;
                            int exp2 = ((priceLvl + 75) * 2 );
                            priceLvl = exp2;
                            int diffLvl1= exp2-exp1;
                            diffLvl = diffLvl1;
                            labelDiffLvl.setText("Требуется опыта :"+ diffLvl);
                        }
                    }
                }
            }
        });
        // -------------------- Алмазы --------------------
        //-------- Кирка для алмазов -----------
        buttonSuperPickaxe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (lvl >=75 && score >= 10000 && SuperPickaxe == false) {
                    SuperPickaxe = true;
                    label.setText("Score :" + (score - 10000));
                    int score1 = score - 10000;
                    score = score1;
                    buttonSuperPickaxe.setVisible(false);
                }
            }
        });
        // ----- Функция Алмазов -----
        buttonDiamond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SuperPickaxe==true){
                    if(lvl>=75) {
                        score += diamondOre;
                        diffLvl-= diamondOre;
                        label.setText("Score :" + score);
                        labelDiffLvl.setText("Требуется опыта :"+ diffLvl);
                        labelDiffPrcDiamond.setText("Осталось очков :" + diffPrcDiamond);
                    }
                }
            }
        });
        // ----- Апгрейд Алмазов -----
        buttonUpDiamondOre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SuperPickaxe==true){
                    if(lvl>=75) {
                        if (score >= priceDiamond) {
                            diamondOre++;
                            label.setText("Score :" + (score - priceDiamond));
                            int score1 = score - priceDiamond;
                            score = score1;
                            int price1 = (priceDiamond * 3);
                            priceDiamond = price1;
                        }
                    }
                }
            }
        });
        // ----- Опыт Алмазов -----
        buttonDiamond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(SuperPickaxe==true){
                    if(lvl>=75) {
                        exp += diamondOre/2;
                        labelExp.setText("Exp :"  +  exp);
                        if (exp >=   priceLvl) {
                            lvl += 1;
                            labelLvl.setText("Lvl :"  +  lvl);
                            int exp1 =  (exp - exp);
                            exp = exp1;
                            int exp2 = ((priceLvl + 75) * 2 );
                            priceLvl = exp2;
                            int diffLvl1= exp2-exp1;
                            diffLvl = diffLvl1;
                            labelDiffLvl.setText("Требуется опыта :"+ diffLvl);
                        }
                    }
                }
            }
        });


        //----------------------автодобывалки------------------------
//для угля
        autoCoal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(score>=100) {
                    label.setText("Score :" + (score - 100));
                    int score1 = score - 100;
                    score = score1;
                    Timer autoC = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            score += coalOre;
                            diffLvl -= coalOre;
                            diffPrcCoal -= coalOre;
                            label.setText("Score :" + score);
                            labelDiffLvl.setText("Требуется опыта :" + diffLvl);
                            labelDiffPrcCoal.setText("Осталось очков :" + diffPrcCoal);
                            if (score >= priceCoal) {
                                labelDiffPrcCoal.setText("Доступно улучшение!");
                                exp += coalOre;
                                labelExp.setText("Exp :" + exp);
                                if(exp >= priceLvl) {
                                    lvl += 1;
                                    labelLvl.setText("Lvl :" + lvl);
                                    int exp1 = (exp - exp);
                                    exp = exp1;
                                    int exp2 = ((priceLvl + 75) * 2);
                                    priceLvl = exp2;
                                    int diffLvl1 = exp2 - exp1;
                                    diffLvl = diffLvl1;
                                }
                            }

                        }
                    });
                    autoC.start();
                }
            }
        });
        //для железа
        autoIron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(score>=2500&StonePickaxe==true) {
                    label.setText("Score :" + (score - 2500));
                    int score1 = score - 2500;
                    score = score1;
                    Timer autoI = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            score += ironOre;
                            diffLvl -= ironOre;
                            label.setText("Score :" + score);
                            labelDiffLvl.setText("Требуется опыта :" + diffLvl);
                            exp += ironOre / 2;
                            labelExp.setText("Exp :" + exp);
                            if (exp >= priceLvl) {
                                lvl += 1;
                                labelLvl.setText("Lvl :" + lvl);
                                int exp1 = (exp - exp);
                                exp = exp1;
                                int exp2 = ((priceLvl + 75) * 2);
                                priceLvl = exp2;
                                int diffLvl1 = exp2 - exp1;
                                diffLvl = diffLvl1;
                            }
                        }

                    });
                    autoI.start();
                }
            }
        });
        //для золота
        autoGold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                if (score >= 10000&IronPickaxe == true) {
                    label.setText("Score :" + (score - 10000));
                    int score1 = score - 10000;
                    score = score1;

                    Timer autoG = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            score += goldOre;
                            diffLvl -= goldOre;
                            label.setText("Score :" + score);
                            exp += goldOre / 2;
                            labelExp.setText("Exp :" + exp);

                            if (exp >= priceLvl) {
                                lvl += 1;
                                labelLvl.setText("Lvl :" + lvl);
                                int exp1 = (exp - exp);
                                exp = exp1;
                                int exp2 = ((priceLvl + 75) * 2);
                                priceLvl = exp2;
                                int diffLvl1 = exp2 - exp1;
                                diffLvl = diffLvl1;
                                labelDiffLvl.setText("Требуется опыта :" + diffLvl);
                            }
                        }
                    });
                    autoG.start();
                }
            }
        });
        //для алмазов
        autoDiamond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (score >= 100000 & SuperPickaxe == true) {
                    label.setText("Score :" + (score - 100000));
                    int score1 = score - 100000;
                    score = score1;
                    Timer autoD = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            score += diamondOre;
                            diffLvl -= diamondOre;
                            label.setText("Score :" + score);
                            labelDiffLvl.setText("Требуется опыта :" + diffLvl);
                            labelDiffPrcDiamond.setText("Осталось очков :" + diffPrcDiamond);
                            exp += diamondOre / 2;
                            labelExp.setText("Exp :" + exp);
                            if (exp >= priceLvl) {
                                lvl += 1;
                                labelLvl.setText("Lvl :" + lvl);
                                int exp1 = (exp - exp);
                                exp = exp1;
                                int exp2 = ((priceLvl + 75) * 2);
                                priceLvl = exp2;
                                int diffLvl1 = exp2 - exp1;
                                diffLvl = diffLvl1;
                                labelDiffLvl.setText("Требуется опыта :" + diffLvl);
                            }
                        }
                    });
                    autoD.start();
                }
            }
        });
        //-------------просто так добавлю это------------------------
//------------------------------Магаз--------------------------
        magas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(open==false) {
                    buttonCoal.setVisible(false);
                    buttonIron.setVisible(false);
                    buttonGold.setVisible(false);
                    buttonDiamond.setVisible(false);

                    buttonUpCoal.setVisible(false);
                    buttonUpIronOre.setVisible(false);
                    buttonUpGoldOre.setVisible(false);
                    buttonUpDiamondOre.setVisible(false);
                    if(StonePickaxe) {
                        buttonStonePickaxe.setVisible(false);
                    }
                    else {
                        buttonStonePickaxe.setVisible(true);
                    }
                    if(IronPickaxe) {
                        buttonIronPickaxe.setVisible(false);
                    }
                    else{
                        buttonIronPickaxe.setVisible(true);
                    }
                    if(SuperPickaxe) {
                        buttonSuperPickaxe.setVisible(false);
                    }
                    else{
                        buttonSuperPickaxe.setVisible(true);
                    }
                    labelDiffLvl.setVisible(false);
                    labelDiffPrcCoal.setVisible(false);
                    labelDiffPrcIron.setVisible(false);
                    labelDiffPrcGold.setVisible(false);
                    labelDiffPrcDiamond.setVisible(false);

                    labelScoreCoal.setVisible(false);
                    labelScoreIron.setVisible(false);
                    labelScoreGold .setVisible(false);
                    labelScoreDiamond.setVisible(false);

                    autoCoal.setVisible(true);
                    autoIron.setVisible(true);
                    autoGold.setVisible(true);
                    autoDiamond.setVisible(true);

                    back.setVisible(open1);
                    magas.setVisible(open);
                }
                open = true;
                open1 = false;

            }
        });

//----------------------------------назад из магаза---------------------------
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (open=true) {
                    buttonCoal.setVisible(true);
                    buttonIron.setVisible(true);
                    buttonGold.setVisible(true);
                    buttonDiamond.setVisible(true);

                    buttonUpCoal.setVisible(true);
                    buttonUpIronOre.setVisible(true);
                    buttonUpGoldOre.setVisible(true);
                    buttonUpDiamondOre.setVisible(true);

                    buttonStonePickaxe.setVisible(false);
                    buttonIronPickaxe.setVisible(false);
                    buttonSuperPickaxe.setVisible(false);

                    labelDiffLvl.setVisible(true);
                    labelDiffPrcCoal.setVisible(true);
                    labelDiffPrcIron.setVisible(true);
                    labelDiffPrcGold.setVisible(true);
                    labelDiffPrcDiamond.setVisible(true);

                    labelScoreCoal.setVisible(true);
                    labelScoreIron.setVisible(true);
                    labelScoreGold .setVisible(true);
                    labelScoreDiamond.setVisible(true);

                    autoCoal.setVisible(false);
                    autoIron.setVisible(false);
                    autoGold.setVisible(false);
                    autoDiamond.setVisible(false);

                    back.setVisible(open1);
                    magas.setVisible(open);
                }
                open = false;
                open1 = true;
            }
        });
        //--------------кирки вне магаза--------------
        buttonStonePickaxe.setVisible(false);
        buttonIronPickaxe.setVisible(false);
        buttonSuperPickaxe.setVisible(false);

        autoCoal.setVisible(false);
        autoIron.setVisible(false);
        autoGold.setVisible(false);
        autoDiamond.setVisible(false);

        back.setVisible(open);
        magas.setVisible(open1);
        // Добавляем всё на панельку
        panel.add(label);

        panel.add(buttonCoal);
        panel.add(buttonIron);
        panel.add(buttonGold);
        panel.add(buttonDiamond);

        panel.add(buttonUpCoal);
        panel.add(buttonUpIronOre);
        panel.add(buttonUpGoldOre);
        panel.add(buttonUpDiamondOre);

        panel.add(labelLvl);
        panel.add(labelExp);
        panel.add(labelDiffLvl);
        panel.add(labelDiffPrcCoal);
        panel.add(labelDiffPrcIron);
        panel.add(labelDiffPrcGold);
        panel.add(labelDiffPrcDiamond);

        panel.add(labelScoreCoal);
        panel.add(labelScoreIron);
        panel.add(labelScoreGold);
        panel.add(labelScoreDiamond);

        panel.add(buttonStonePickaxe);
        panel.add(buttonIronPickaxe);
        panel.add(buttonSuperPickaxe);

        panel.add(magas);
        panel.add(back);

        panel.add(autoCoal);
        panel.add(autoIron);
        panel.add(autoGold);
        panel.add(autoDiamond);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}