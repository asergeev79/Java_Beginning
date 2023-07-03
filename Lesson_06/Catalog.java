package Lesson_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
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
    private List<String> featuresList;
    private Map<String,String> searchMap;

    public Catalog(List<NoteBook> cat) {
        this.nbList = new ArrayList<>(cat);
        this.count = cat.size();
        this.featuresList = new ArrayList<>();
        for (NoteBook item : this.nbList) this.generateFeatureList(item);
    }

    public Catalog(String filename) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        this(readFromFile(filename));    
    }

    public Catalog() {
        this.nbList = new ArrayList<>();
        this.count = 0;
        this.featuresList = new ArrayList<>();
    }

    public void add(NoteBook nb) {
        this.nbList.add(nb);
        this.count = this.nbList.size();
        this.generateFeatureList(nb);
    }

    public void remove(NoteBook nb) {
        this.nbList.remove(nb);
        this.count = this.nbList.size();
    }

    public int size() {
        return this.count;        
    }

    private void initSearchMap() {
        Scanner sc = new Scanner(System.in);
        this.searchMap = new HashMap<>();
        int indexParam = 0;
        do {
            System.out.println(this.searchMap);
            indexParam = this.searchParam(sc);
            if (indexParam != 0) {
                this.searchMap.put(this.featuresList.get(indexParam - 1), this.readParam(sc));
            }
        } while (indexParam != 0);
        sc.close();
    }

    public List<NoteBook> search() {
        List<NoteBook> res = new ArrayList<>(this.nbList);
        this.initSearchMap();
        for (String item : this.searchMap.keySet()) {
            res = searchByFeature(res, item, this.searchMap.get(item));
        }
        return res;
    }

    private List<NoteBook> searchByFeature(List<NoteBook> nblist, String key, String value) {
        List<NoteBook> tmp = new ArrayList<>();
        for (NoteBook nb : nblist) {
            if (nb.getFeature(key) != null)
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
        List<NoteBook> newList = new ArrayList<>();
        JsonArray jarr = new Gson().fromJson(new FileReader(filename), JsonArray.class);
        Map<String, String>[] jobj_arr = new Gson().fromJson(jarr, new TypeToken<Map<String, String>[]>() {}.getType());
        for (int i = 0; i < jobj_arr.length; i++) {
            newList.add(new NoteBook(i + 1, jobj_arr[i]));
        }
        return newList;
    }

    private int searchParam(Scanner sc) {
        int indexParam = 0;
        System.out.print("Выберите характеристику для поиска: ");
        this.printParams();
        System.out.println("0 - Конец выбора");
        indexParam = sc.nextInt();
        return indexParam;
    }

    private String readParam(Scanner sc) {
        sc.nextLine();
        System.out.print("Введите строку для поиска: ");
        return sc.nextLine();
    }

    private void printParams() {
        int indexParam = 1;
        for (String item : this.featuresList) System.out.printf("%d - %s\n", indexParam++, item);
    }

    private void generateFeatureList(NoteBook nb) {
        for (String item : nb.getFeatures()) {
            if (!this.featuresList.contains(item)) this.featuresList.add(item);
        }
    }
}
