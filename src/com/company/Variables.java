package com.company;

public class Variables {
    // Очки
    public static long score = 0;
    // Ценность руд (Сколько дают очков)
    public static int coalOre = 1;
    public static int ironOre = 160;
    public static int goldOre = 1640;
    public static int diamondOre = 5600;
    // Стоимость апгрейда (Сколько нужно заплатить за прокачку)
    public static long priceCoal = 10;
    public static long priceIron = 2000;
    public static long priceGold = 150000;
    public static long priceDiamond = 2500000;
    // Lvl (Всё связанное с уровнем)
    public static int lvl = 1; // Уровень
    public static long exp = 0; // Опыт
    public static long priceLvl = 105; // Стоимость прокачки уровня
    public static long boostLvl = 47 * 2;
    public static long diffLvl = (priceLvl - exp);
    // Проверка наличии кирки
    public static boolean StonePickaxe = false;
    public static boolean IronPickaxe = false;
    public static boolean SuperPickaxe = false;
}
