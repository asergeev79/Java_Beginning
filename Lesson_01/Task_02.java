package Lesson_01;

import java.util.Arrays;

public class Task_02 {
    public static void main(String[] args) {
        int num = 1000;
        boolean[] arr = new boolean[num];
        Arrays.fill(arr, true);
        for (int i = 2; i * i <= num; i++) {
            if (arr[i - 1]) {
                for (int j = i*i; j <= num; j += i)
                    arr[j - 1] = false;
            }
        }

        for (int i = 0; i < num; i++)
            if (arr[i])
                System.out.println(i + 1);
    }       
}