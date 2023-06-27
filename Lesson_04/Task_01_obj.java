package Lesson_04;

public class Task_01_obj {
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
        numDeque x1 = new numDeque(111);
        numDeque x2 = new numDeque(5477);

        System.out.println(x1);
        System.out.println(x2);
        System.out.printf("%d + %d = %d\n", x1.toInt(), x2.toInt(), x1.toInt() + x2.toInt());
        System.out.println(numDeque.Summa(x1, x2));
        System.out.printf("%d * %d = %d\n", x1.toInt(), x2.toInt(), x1.toInt() * x2.toInt());
        System.out.println(numDeque.Multiply(x1, x2));

    }
}
