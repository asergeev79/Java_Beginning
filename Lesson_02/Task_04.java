package Lesson_02;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task_04 {
    /* Реализовать простой калькулятор (+-/*)
     * 4) К калькулятору из предыдущего ДЗ добавить логирование.
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Выполняем операцию:\n");

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
                sb.append(num_1 + oper + num_2 + " = " + res);
                break;
            case "-":
                res = num_1 - num_2;
                sb.append(num_1 + oper + num_2 + " = " + res);
                break;
            case "/":
                res = num_1 / num_2;
                sb.append(num_1 + oper + num_2 + " = " + res);
                break;
            case "*":
                res = num_1 * num_2;
                sb.append(num_1 + oper + num_2 + " = " + res);
                break;
            default:
                sb.append("Такая операция пока неизвестна\n");
                break;
        }

        Logger logger = Logger.getLogger("Task_04_Log");  
        FileHandler fh;

        try {
            fh = new FileHandler("Lesson_02\\Task_04.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);  
            logger.info(sb.toString());  
 
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

        sc.close();

    }
}
