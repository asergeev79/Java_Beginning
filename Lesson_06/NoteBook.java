package Lesson_06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoteBook {
    private int id;
    private Map<String, String> features;

    private static int count = 100000;
    private static Set<String> featureSet = new HashSet<>();;

    public NoteBook(Map<String,String> item) {
        this.id = ++count;
        this.features = new HashMap<>(item);
        featureSet.addAll(item.keySet());
    }

    public NoteBook(String vendor, String model) {
        this(Map.ofEntries(Map.entry("vendor", vendor), Map.entry("model", model)));
    }

    public NoteBook() {
        this("Noname", "somemodel");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Ноутбук %s %s", this.features.get("vendor"), this.features.get("model"));
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return this.id;
    }

    public boolean equals(NoteBook nb) {
        return (this.features.get("vendor") == nb.features.get("vendor")) && (this.features.get("model") == nb.features.get("model"));
    }

    public String getFeature(String str) {
        return this.features.get(str);        
    }

    public static int getCountLast() {
        return count;
    }

    public static String getFeatures() {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (String menuItem : featureSet) sb.append(index + " - " + menuItem + "\n");
        return sb.toString();        
    }
}
