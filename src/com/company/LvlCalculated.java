package com.company;

import java.util.ArrayList;

public class LvlCalculated {
    public static ArrayList<Double> list = new ArrayList<Double>();
    public static int g = 98; // Индекс списка, который берётся для приравнивания к priceLvl (Используется в Mine)
    public static void lvlCalculated() {
        int t = 1; // Какое количество раз запуститься цикл
        int n = 21; // Через какое количество уровней коэффициент повышается на
        int h = 0; // Индекс списка, в который записывается опыт
        double nextLvl; // Следущий уровень
        double coefficient = 1.06; // Коэффициент
        double expMax = 4160000f; // Максимальнное количество опыта
        while (t <= 99) {
            if (t % n == 0) {
                coefficient += 0.01; // На сколько коэффициент будет увеличиваться каждые "n" уровней
            }
            nextLvl = Math.round(expMax / coefficient); // Деление опыта на коэффициент (Сколько опыта нужно на следущем уровне (Точнее на предыдущем, ведь всё в обратную сторону))
            expMax = nextLvl; // Приравнивание нынешнего уровня к следующему
            // Умножение опыта для каждой стадии
            if (t > 80){
                nextLvl = nextLvl * 10;
            }
            if (t < 81 && t > 56){
                nextLvl = nextLvl * 100;
            }
            if (t < 57 && t > 21){
                nextLvl = nextLvl * 1000;
            }
            if (t < 22){
                nextLvl = nextLvl * 10000;
            }
            list.add(h, nextLvl); // Добавление следущего уровня в список
            t++;
            h++;
        }
    }
}