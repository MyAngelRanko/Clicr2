package com.company;

public class FormulaCalculator{
    public static double coefficient = 1.06;                                                                         // Коэффициент
    public static double exp = 832000f;                                                                              // Максимальнное количество опыта
    public static void main(String[] args){
        int i = 1;                                                                                                   // не трогай
        int n = 21;                                                                                                   // через какое количество уровней коэффициент будет меняться
        System.out.println(Math.round(exp));                                                                         // просто вывод максимального опыта
        while(i <= 99) {
            if (i % n == 0){
                coefficient += 0.01;                                                                                 // На сколько коэффициент будет увеличиваться каждые "n" уровней
            }
            double nextLvl = exp / coefficient;                                                                      // Деление опыта на коэффициент (Сколько опыта нужно на следущем уровне (Точнее на предыдущем, ведь всё в обратную сторону))
            double diff = exp - nextLvl;
            System.out.println(Math.round(diff) + " - " + Math.round(nextLvl) + " - coefficient = " + coefficient);  // Вывод всех данных (не трогай)
            exp = nextLvl;                                                                                           // Приравнивание нынешнего уровня к следующему
            i++;                                                                                                     // не трогай
        }
    }
}
