package Lesson_01;

import java.util.Scanner;

public class Task_01 {
    /*Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
1 + 2 + 3 1*2*3 */
    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.printf("Треугольное число - %d\n", triangle_number(num));
        System.out.printf("Факториал - %d\n", factorial(num));
    }
    public static int triangle_number(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i;
        return sum;
    }
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++)
            fact *= i;
        return fact;
    }
}
