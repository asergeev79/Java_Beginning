package Lesson_02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task_02 {
    /*
     * 2) Реализуйте алгоритм сортировки пузырьком числового массива, 
     * результат после каждой итерации запишите в лог-файл.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int arr_size = sc.nextInt();
        sc.close();

        int[] arr = fill_arr(arr_size);
        System.out.println(Arrays.toString(arr));
        sort_array(arr);
    }

    static int[] fill_arr(int size) {
        int[] new_arr = new int[size];
        int min = 0;
        int max = 100;

        for (int i = 0; i < size; i++) {
            new_arr[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }

        return new_arr;
    }

    static void sort_array(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println(Arrays.toString(array));
                    
                }
            }
        }

    }
}
