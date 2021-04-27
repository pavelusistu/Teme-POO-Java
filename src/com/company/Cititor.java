package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Cititor {
    private static Cititor obj = null;
    // lasam constructorul clasei privat pentru a nu fi accesat din exterior
    private Cititor() {

    }
    // metoda prin care se creaza unica instanta a clasei
    public static Cititor getInstance() {
        // daca clasa nu a fost instantiata inainte, o facem acum
        if (obj == null)
            obj = new Cititor();
        return obj;
    }
    public <T> ArrayList<T> read (String path) throws IOException {
        ArrayList <T> obiecte=new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        if(path.contains("Student")) {
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                obiecte.add((T) new Student(data[0], data[1], Integer.parseInt(data[2]), data[3].charAt(0)));
            }
            csvReader.close();
        }
        else if (path.contains("Profesor")) {
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                obiecte.add((T) new Profesor(data[0], data[1], Integer.parseInt(data[2]), data[3].charAt(0)));
            }
            csvReader.close();
        }
        else if (path.contains("Materie")){
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                obiecte.add((T) new Materie(data[0], Integer.parseInt(data[1]), CatalogService.getInstance().get_profesor(data[2])));
            }
            csvReader.close();
        }
        else if (path.contains("Grupa")){
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                obiecte.add((T) new Grupa(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            }
            csvReader.close();
        }
            return obiecte;
    }
}
