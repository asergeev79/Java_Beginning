package Lesson_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NoteBook {
    private int id;
    private Map<String, String> features;

    public NoteBook(int idItem, Map<String,String> item) {
        this.id = idItem;
        this.features = new HashMap<>(item);
    }

    public NoteBook(int idItem, String vendor, String model) {
        this(idItem, Map.ofEntries(Map.entry("vendor", vendor), Map.entry("model", model)));
    }

    public NoteBook() {
        this(0, "Noname", "somemodel");
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

    public Set<String> getFeatures() {
        return this.features.keySet();        
    }

}
