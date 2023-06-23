package Lesson_02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

// from gson-2.10.1.jar
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Task_01 {
    /*
    1) Дана строка sql-запроса "select * from students where ". 
    Сформируйте часть WHERE этого запроса, используя StringBuilder. 
    Данные для фильтрации приведены ниже в виде json-строки.
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
    Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".
    */
    public static void main(String[] args) {
        Gson gson = new Gson();

        String req_tmpl = "select * from students where ";
        //String req_value = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        //Map<String, String> map = gson.fromJson(req_value, new TypeToken<Map<String, String>>() {}.getType());
        
        Map<String, String> map;
        try {
            map = gson.fromJson(new FileReader("Lesson_02\\Task_01_in.json"), new TypeToken<Map<String, String>>() {}.getType());
            StringBuilder sb = new StringBuilder(req_tmpl);

            for (String key : map.keySet()) {
                if (!map.get(key).equals("null")) {
                    // System.out.println(map.get(key) + " " + map.get(key).getClass());
                    sb.append(key + " = " + map.get(key) + " AND ");
                }
            }
            sb.delete(sb.length()-5, sb.length());
            System.out.println(sb);
        } catch (JsonIOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
