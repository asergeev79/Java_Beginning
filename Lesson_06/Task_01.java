package Lesson_06;

import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Task_01 {
    /*
     * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
     * Создать множество ноутбуков.
     * Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
     * NoteBook notebook1 = new NoteBook
     * NoteBook notebook2 = new NoteBook
     * NoteBook notebook3 = new NoteBook
     * NoteBook notebook4 = new NoteBook
     * NoteBook notebook5 = new NoteBook
     * 
     * Например: “Введите цифру, соответствующую необходимому критерию:
     * 1 - ОЗУ
     * 2 - Объем ЖД
     * 3 - Операционная система
     * 4 - Цвет
     * 
     * Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
     * Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
     * 
     * Класс сделать в отдельном файле
     * приветствие
     * Выбор параметра
     * выбор конкретнее
     * вывод подходящих
     */
    public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        Catalog nbCatalog = new Catalog("Lesson_06\\notebooks.json");
        System.out.println(nbCatalog.toString());
        System.out.println(nbCatalog.search());
    }
}
