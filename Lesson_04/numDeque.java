package Lesson_04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


public class numDeque {
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

     private Deque<Integer> dq;
     private int sign;

     public numDeque(int num) {
        this.sign = Integer.signum(num);
        this.dq = toDeque(Math.abs(num));
     }

     public numDeque() {
        this(0);
     }

    public Integer toInt() {
        int number = 0;
        int digit = 1;
        for (int i : this.dq) {
            number += i * digit;
            digit *= 10;
        }
        return number * this.sign;
    }

    @Override
    public String toString() {
        String str = this.dq.toString();
        if (this.sign == -1) str = "-" + str;
        return str;
    }

    private Deque<Integer> toDeque(int num) {
        Deque<Integer> dq = new ArrayDeque<>();
        while (num != 0) {
            dq.addLast(num % 10);
            num /= 10;
        }
        return dq;
    }

    private LinkedList<Integer> toLinkedList() {
        LinkedList<Integer> link = new LinkedList<Integer>();
        for (int i : this.dq) {
            link.addFirst(i);
        }
        link.set(0, link.peek() * this.sign);
        return link;
    }

    public void multiply(numDeque obj) {
        int mult = this.toInt() * obj.toInt();
        this.dq = toDeque(Math.abs(mult));
        this.sign = Integer.signum(mult);
    }

    public void sum(numDeque obj) {
        int sum = this.toInt() + obj.toInt();
        this.dq = toDeque(Math.abs(sum));
        this.sign = Integer.signum(sum);
    }

    public static LinkedList<Integer> Summa(numDeque dq1, numDeque dq2) {
        numDeque tmp = new numDeque(dq1.toInt());
        tmp.sum(dq2);
        return tmp.toLinkedList();
    }

    public static LinkedList<Integer> Multiply(numDeque dq1, numDeque dq2) {
        numDeque tmp = new numDeque(dq1.toInt());
        tmp.multiply(dq2);
        return tmp.toLinkedList();
    }

}
