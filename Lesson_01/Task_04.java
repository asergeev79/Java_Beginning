package Lesson_01;

import java.util.Scanner;

public class Task_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите уравнение:\n");
        String equation = sc.nextLine();
        String[] operands = equation.split(" ");
        sc.close();
        int res = 0;
        for (int i = 0; i <= 9; i++) {
            int q = Integer.parseInt(operands[0].replace('?', Character.forDigit(i, 10)));
            int w = Integer.parseInt(operands[2].replace('?', Character.forDigit(i, 10)));
            int e = Integer.parseInt(operands[4].replace('?', Character.forDigit(i, 10)));
            if ((q + w) == e) {
                System.out.printf("%d + %d = %d\n", q, w, e);
                res++;
            }
        }
        if (res == 0) {
            System.out.print("Решения нет\n");
        }
    }
}
