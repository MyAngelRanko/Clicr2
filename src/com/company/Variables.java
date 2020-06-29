package com.company;

public class Variables {
    // Очки
    public static long score = 0;
    // Ценность руд (Сколько дают очков)
    public static int coalOre = 1;
    public static int ironOre = 111;
    public static int goldOre = 1111;
    public static int diamondOre = 11111;
    // Стоимость апгрейда (Сколько нужно заплатить за прокачку)
    public static long priceCoal = 20;
    public static long priceIron = 2000;
    public static long priceGold = 150000;
    public static long priceDiamond = 2500000;
    // Lvl (Всё связанное с уровнем)
    public static int lvl = 1; // Уровень
    public static double exp = 0; // Опыт
    public static double priceLvl = 20; // Стоимость прокачки уровня
    public static double diffLvl = priceLvl - exp; // Сколько осталось до следующего уровня
    public static double coefficient = 1.15; // Коэфициент, на который умножается priceLvl
    // Проверка наличии кирки
    public static boolean StonePickaxe = false;
    public static boolean IronPickaxe = false;
    public static boolean SuperPickaxe = false;
}
