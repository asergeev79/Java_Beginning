package Lesson_04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Task_01 {
    /*
     * Задание
     * Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
     * 1) Умножьте два числа и верните произведение в виде связанного списка.
     * 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа могут быть отрицательными.
     * 
     * Даны два Deque, цифры в обратном порядке.
     * [3,2,1] - пример Deque
     * [5,4,3]- пример второго Deque
     * 1) 123 * 345 = 42 435
     * Ответ всегда - связный список, в обычном порядке
     * [4,2,4,3,5] - пример ответа
     */
    public static void main(String[] args) {
        int x1 = -123;
        int x2 = 345;

        Deque<Integer> dq1 = toDeque(x1);
        Deque<Integer> dq2 = toDeque(x2);

        System.out.println("Исходные числа в виде Deque (последний элемент - знак числа):");
        System.out.println(dq1);
        System.out.println(dq2);

        // System.out.println(toInt(dq1));
        // System.out.println(toInt(dq2));
    
        // System.out.println(toInt(dq1) * toInt(dq2));
        // System.out.println(toInt(dq1) + toInt(dq2));

        System.out.println("Произведение двух чисел в виде связанного списка (первый элемент - знак числа):");
        System.out.println(toLinkedList(toInt(dq1) * toInt(dq2)));
        System.out.println("Сумма двух чисел в виде связанного списка (первый элемент - знак числа):");
        System.out.println(toLinkedList(toInt(dq1) + toInt(dq2)));
        
    }

    static Integer toInt(Deque<Integer> dq) {
        int sign = dq.removeLast();
        int number = 0;
        int digit = 1;
        for (int i : dq) {
            number += i * digit;
            digit *= 10;
        }
        dq.addLast(sign);
        return number * sign;
    }

    static Deque<Integer> toDeque(int num) {
        int sign = Integer.signum(num);
        int tmp_num = Math.abs(num);
        Deque<Integer> dq = new ArrayDeque<>();
        while (tmp_num != 0) {
            dq.addLast(tmp_num % 10);
            tmp_num /= 10;
        }
        dq.addLast(sign);
        return dq;
    }

    static LinkedList<Integer> toLinkedList(int num) {
        LinkedList<Integer> link = new LinkedList<Integer>();
        Deque<Integer> dq = toDeque(num);
        while (!dq.isEmpty()) {
            link.addFirst((dq.removeFirst()));
        }
        return link;
    }
}
