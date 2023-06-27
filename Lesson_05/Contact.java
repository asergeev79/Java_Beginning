package Lesson_05;

import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<Integer> phones;

    public Contact(String name_str, Integer phone_num) {
        this(name_str);
        this.phones.add(phone_num);
    }

    public Contact(String name_str) {
        this.name = name_str;
        this.phones = new ArrayList<>();
    }

    public Contact() {
        this("");
    }

    public void add(Integer phone_num) {
        this.phones.add(phone_num);        
    }

    public String toString() {
        return this.name + ": " + this.phones.toString();        
    }
}
