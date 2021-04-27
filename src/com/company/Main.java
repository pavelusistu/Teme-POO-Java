package com.company;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Profesor> profesori= Cititor.getInstance().read("A:\\tema\\src\\com\\company\\Profesor.csv");
        for (Profesor p:profesori)
        {
            CatalogService.getInstance().adauga_profesor(p);
        }
        ArrayList<Student> studenti= Cititor.getInstance().read("A:\\tema\\src\\com\\company\\Student.csv");
        for (Student s:studenti)
        {
            CatalogService.getInstance().adauga_student(s);
        }
        ArrayList<Materie> materii= Cititor.getInstance().read("A:\\tema\\src\\com\\company\\Materie.csv");
        for (Materie m:materii)
        {
            CatalogService.getInstance().get_student("Luca").adauga_materie(m);
        }
        materii= Cititor.getInstance().read("A:\\tema\\src\\com\\company\\Materie.csv");
        for (Materie m:materii)
        {
            CatalogService.getInstance().get_student("Stamate").adauga_materie(m);
        }
        materii= Cititor.getInstance().read("A:\\tema\\src\\com\\company\\Materie.csv");
        for (Materie m:materii)
        {
            CatalogService.getInstance().get_student("Mantu").adauga_materie(m);
        }

        CatalogService.getInstance().get_student("Luca").get_materie("matematica")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(9))
                .adauga_nota(new Nota(10));
        CatalogService.getInstance().get_student("Luca").get_materie("romana")
                .adauga_nota(new Nota(8))
                .adauga_nota(new Nota(7))
                .adauga_nota(new Nota(6));
        CatalogService.getInstance().get_student("Luca").get_materie("geografie")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10));
        CatalogService.getInstance().get_student("Luca").get_materie("franceza")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10));
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        Scriitor.getInstance().write("A:\\tema\\src\\com\\company\\Scriitor" + formatter.format(new Date(System.currentTimeMillis())) + ".csv", "I-am adaugat note lui Luca!");
        /*System.out.println(CatalogService.getInstance().get_student("Luca").get_materie("matematica").calculeaza_media());
        System.out.println(CatalogService.getInstance().get_student("Luca").get_materie("romana").calculeaza_media());
        System.out.println(CatalogService.getInstance().get_student("Luca").get_materie("geografie").calculeaza_media());*/
        System.out.println("Medie generala Luca: " + CatalogService.getInstance().get_student("Luca").calculeaza_media_generala());
        //Scriitor.getInstance().write("A:\\tema\\src\\com\\company\\Scriitor" + formatter.format(new Date(System.currentTimeMillis())) + ".csv", "A fost calculata media generala a lui Luca!");
        CatalogService.getInstance().get_student("Stamate").get_materie("matematica")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(9))
                .adauga_nota(new Nota(7));
        CatalogService.getInstance().get_student("Stamate").get_materie("romana")
                .adauga_nota(new Nota(8))
                .adauga_nota(new Nota(7))
                .adauga_nota(new Nota(7));
        CatalogService.getInstance().get_student("Stamate").get_materie("geografie")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(1));
        CatalogService.getInstance().get_student("Stamate").get_materie("franceza")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(6));
        System.out.println("Medie generala Stamate: " + CatalogService.getInstance().get_student("Stamate").calculeaza_media_generala());
        CatalogService.getInstance().get_student("Mantu").get_materie("matematica")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(9))
                .adauga_nota(new Nota(6));
        CatalogService.getInstance().get_student("Mantu").get_materie("romana")
                .adauga_nota(new Nota(8))
                .adauga_nota(new Nota(7))
                .adauga_nota(new Nota(4));
        CatalogService.getInstance().get_student("Mantu").get_materie("geografie")
                .adauga_nota(new Nota(7))
                .adauga_nota(new Nota(5))
                .adauga_nota(new Nota(1));
        CatalogService.getInstance().get_student("Mantu").get_materie("franceza")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(5));
        System.out.println("Medie generala Mantu: " + CatalogService.getInstance().get_student("Mantu").calculeaza_media_generala());
        System.out.println("Medie grupei este : " + CatalogService.getInstance().calculeaza_media_grupei());
        //System.out.println(CatalogService.getInstance().get_student("Mantu").get_materie("geografie").calculeaza_media());
        if(CatalogService.getInstance().get_student("Mantu").get_materie("geografie").promovat())
            System.out.println("Mantu a promovat");
        else
            System.out.println("Mantu este corigent");
        //System.out.println(CatalogService.getInstance().get_student("Mantu"));
        Serie serie=new Serie(25);
        //serie.adauga_grupa(new Grupa(2,5,1)).adauga_grupa(new Grupa(2,5,2)).adauga_grupa(new Grupa(2,5,3)).adauga_grupa(new Grupa(2,5,4));
        ArrayList<Grupa> grupe= Cititor.getInstance().read("A:\\tema\\src\\com\\company\\Grupa.csv");
        for (Grupa g:grupe)
        {
            serie.adauga_grupa(g);
        }
        CatalogService.getInstance().get_profesor("Fojica").adauga_serie(serie);
        CatalogService.getInstance().get_profesor("Fojica").get_serie(25).get_grupa(2).adauga_student(CatalogService.getInstance().get_student("Luca")).adauga_student(CatalogService.getInstance().get_student("Stamate"));
        System.out.println(CatalogService.getInstance().get_profesor("Fojica").get_serie(25).get_grupa(2));
        /*System.out.println(CatalogService.getInstance().get_student("Luca"));
        System.out.println(CatalogService.getInstance().get_student("Stamate"));
        System.out.println(CatalogService.getInstance().get_student("Mantu"));
        System.out.println(CatalogService.getInstance().get_student("Stoica"));
        System.out.println(CatalogService.getInstance().getStudenti());*/
    }
}
