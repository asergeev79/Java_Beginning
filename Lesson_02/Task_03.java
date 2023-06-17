package Lesson_02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Task_03 {
    /*
     * 3) Дана json-строка (можно сохранить в файл и читать из файла)
     * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
     * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: 
     * Студент [фамилия] получил [оценка] по предмету [предмет].
     * Пример вывода:
     * Студент Иванов получил 5 по предмету Математика.
     * Студент Петрова получил 4 по предмету Информатика.
     * Студент Краснов получил 5 по предмету Физика.
     */
    public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        JsonArray jarr = new Gson().fromJson(new FileReader("Lesson_02\\Task_03_in.json"), JsonArray.class);
        Map<String, String>[] jobj_arr = new Gson().fromJson(jarr, new TypeToken<Map<String, String>[]>() {}.getType());
            
        for (int i = 0; i < jarr.size(); i++) {
            StringBuilder sb = new StringBuilder("");
            sb.append("Студент ");
            sb.append(jobj_arr[i].get("фамилия"));
            sb.append(" получил ");
            sb.append(jobj_arr[i].get("оценка"));
            sb.append(" по предмету ");
            sb.append(jobj_arr[i].get("предмет"));
            System.out.println(sb);
        }
    }
}
