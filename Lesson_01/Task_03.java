package Lesson_01;

import java.util.Scanner;

public class Task_03 {
    /* Реализовать простой калькулятор (+-/*) */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Реализация простейшего калькулятора для целых чисел\n");
        System.out.print("Введите первый аргумент: ");
        int num_1 = sc.nextInt();
        System.out.print("Введите второй аргумент: ");
        int num_2 = sc.nextInt();
        System.out.print("Введите операцию: ");
        String oper = sc.next();
        int res = 0;
        switch (oper) {
            case "+":
                res = num_1 + num_2;
                break;
            case "-":
                res = num_1 - num_2;
                break;
            case "/":
                res = num_1 / num_2;
                break;
            case "*":
                res = num_1 * num_2;
                break;
            default:
                System.out.print("Такая операция пока неизвестна\n");
                break;
        }
        System.out.printf("%d %s %d = %d\n", num_1, oper, num_2, res);
        sc.close();

    }
}
