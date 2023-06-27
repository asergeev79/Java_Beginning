package Lesson_05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

//import Lesson_05.Phone;

public class Task_01 {
    /*
     * Задание
     * Реализуйте структуру телефонной книги с помощью HashMap.
     * Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
     * их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
     * Пример ввода:
     * Ivanov 234234
     * Ivanov 32523
     * Ivanov 5687
     * Иванов: 234234, 32523, 5687
     * 
     * Petrov 123
     * 
     * Варианты Map:
     * Map<String, ArrayList>
     * Map<String, String>
     * 
     * Пример меню:
     * 1. Добавить контакт
     * 2. Вывести всех
     * 3. Выход
     */
    public static void main(String[] args) {

        HashMap<String,Contact> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        String[] rec_fields;
        int punkt = 0;
        do {
            System.out.println("1. Добавить контакт");
            System.out.println("2. Прочитать из файла");
            System.out.println("3. Вывести всех");
            System.out.println("4. Выход");
            System.out.print("Введите пункт:");

            punkt = sc.nextInt();
            switch (punkt) {
                case 1:
                    sc.nextLine();
                    System.out.println("Введите новый контакт:");
                    String record = sc.nextLine();
                    rec_fields = record.split(" ");
                    phoneBook.putIfAbsent(rec_fields[0], new Contact(rec_fields[0]));
                    phoneBook.get(rec_fields[0]).add(Integer.parseInt(rec_fields[1]));
                    break;

                case 2:
                    try {
                        File file = new File("Lesson_05\\contacts.txt");
                        FileReader fr = new FileReader(file);
                        BufferedReader reader = new BufferedReader(fr);
                        String line = reader.readLine();
                        while (line != null) {
                            rec_fields = line.split(" ");
                            phoneBook.putIfAbsent(rec_fields[0], new Contact(rec_fields[0]));
                            phoneBook.get(rec_fields[0]).add(Integer.parseInt(rec_fields[1]));
                            line = reader.readLine();
                        }
                        reader.close();;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            
                case 3:
                    for (Contact item : Collections.sort(phoneBook.values(), Comparator);) {
                        System.out.println(item);
                    }
                    break;
            
                case 4:
                    break;
            
                default:
                    System.out.println("Такого пункта нет");
                    break;
            }

        } while ( punkt != 4);

        sc.close();
    }
}
