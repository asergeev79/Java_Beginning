package Lesson_04;

public class Task_01_obj {
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
