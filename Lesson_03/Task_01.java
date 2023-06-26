package Lesson_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task_01 {
    /*
     * Задание
     * Пусть дан произвольный список целых чисел.
     * 1) Нужно удалить из него чётные числа
     * 2) Найти минимальное значение
     * 3) Найти максимальное значение
     * 4) Найти среднее ариф. значение
     */
    public static void main(String[] args) {
        Integer size = 20;
        Integer bound = 100;

        List<Integer> randList = create_random_list(size, bound);

        System.out.println("Исходный список:");
        System.out.println(randList);

        System.out.println("Минимальное значение списка:");
        System.out.println(min_list(randList));

        System.out.println("Максимальное значение списка:");
        System.out.println(max_list(randList));

        System.out.println("Среднее арифметическое значение списка:");
        System.out.println(avg_list(randList));

        System.out.println("Список после удаления чётных элементов:");
        even_del_list(randList);
        System.out.println(randList);

    }

    static List<Integer> create_random_list(int n, int b) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i < n; i++) {
            list.add(rand.nextInt(b));
        }
        return list;
    }

    static Integer min_list(List<Integer> list) {
        int min = list.get(0);
        for (int i : list) if (i < min) min = i;
        return min;
    }

    static Integer max_list(List<Integer> list) {
        int max = list.get(0);
        for (int i : list) if (i > max) max = i;
        return max;
    }

    static Double avg_list(List<Integer> list) {
        int sum = 0;
        for (int i : list) sum += i;
        return (double) sum / list.size();
    }

    static void even_del_list(List<Integer> list) {
        list.removeIf(i -> (i % 2 == 0));
    }
}
