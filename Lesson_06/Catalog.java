package Lesson_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class Catalog {
    private int count;
    private List<NoteBook> nbList;
    private Map<String,String> searchMap;

    public Catalog(List<NoteBook> cat) {
        this.nbList = new ArrayList<>(cat);
        this.count = cat.size();
        this.searchMap = new HashMap<>();
    }

    public Catalog(String filename) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        this(readFromFile(filename));    
    }

    public Catalog() {
        this.nbList = new ArrayList<>();
        this.count = 0;
        this.searchMap = new HashMap<>();
    }

    public void add(NoteBook nb) {
        this.nbList.add(nb);
        this.count = this.nbList.size();
    }

    public void remove(NoteBook nb) {
        this.nbList.remove(nb);
        this.count = this.nbList.size();
    }

    public int size() {
        return this.count;        
    }

    public void search() {
        
    }

    private List<NoteBook> searchByFeature(String key, String value) {
        List<NoteBook> tmp = new ArrayList<>();
        for (NoteBook nb : this.nbList) {
            if (nb.getFeature(key).contains(value)) tmp.add(nb);
        }
        return tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NoteBook nb : this.nbList) {
            sb.append(nb + "\n");
        }
        return sb.toString();
    }

    private static List<NoteBook> readFromFile(String filename) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        JsonArray jarr = new Gson().fromJson(new FileReader(filename), JsonArray.class);
        NoteBook[] jobj_arr = new Gson().fromJson(jarr, new TypeToken<NoteBook[]>() {}.getType());
        return Arrays.asList(jobj_arr);
    }

    private String searchParam() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        printParams();
        return;                
    }
    private void printParams() {
        System.out.println(NoteBook.getFeatures());
    }
}
