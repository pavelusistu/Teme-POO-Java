package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Scriitor {
    private static Scriitor obj = null;
    // lasam constructorul clasei privat pentru a nu fi accesat din exterior
    private Scriitor() {

    }
    // metoda prin care se creaza unica instanta a clasei
    public static Scriitor getInstance() {
        // daca clasa nu a fost instantiata inainte, o facem acum
        if (obj == null)
            obj = new Scriitor();
        return obj;
    }
    public void write(String path, String nume_actiune){
        try {
            FileWriter myWriter = new FileWriter(path,true);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            myWriter.write( nume_actiune  +","  +formatter.format(new Date(System.currentTimeMillis())) + "\n");
            myWriter.close();
            System.out.println("S-a scris in fisier cu succes!");
        } catch (IOException e) {
            System.out.println("A avut loc o eroare!");
            e.printStackTrace();
        }

    }
}
