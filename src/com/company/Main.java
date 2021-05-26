package com.company;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
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
        NoteDAO noteDAO = new NoteDAO();
        noteDAO.delete_all();
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.delete_all();
        MateriiDAO materieDAO = new MateriiDAO();
        materieDAO.delete_all();
        GrupaDAO grupaDAO = new GrupaDAO();
        grupaDAO.delete_all();

        ArrayList<Materie> materii= Cititor.getInstance().read("A:\\tema\\src\\com\\company\\Materie.csv");
        int j=101;

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
            m.setID(j++);
            materieDAO.add(m);
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

        int i=51;
        for (Grupa g:grupe)
        {
            serie.adauga_grupa(g);
            g.setID(i++);
            grupaDAO.add(g);
        }
        CatalogService.getInstance().get_profesor("Fojica").adauga_serie(serie);
        CatalogService.getInstance().get_profesor("Fojica").get_serie(25).get_grupa(2).adauga_student(CatalogService.getInstance().get_student("Luca")).adauga_student(CatalogService.getInstance().get_student("Stamate"));
        System.out.println(CatalogService.getInstance().get_profesor("Fojica").get_serie(25).get_grupa(2));
        /*System.out.println(CatalogService.getInstance().get_student("Luca"));
        System.out.println(CatalogService.getInstance().get_student("Stamate"));
        System.out.println(CatalogService.getInstance().get_student("Mantu"));
        System.out.println(CatalogService.getInstance().getStudenti());*/

        studentDAO.add(CatalogService.getInstance().get_student("Stamate"), 51);
        studentDAO.add(CatalogService.getInstance().get_student("Luca"), 52);
        studentDAO.add(CatalogService.getInstance().get_student("Mantu"), 53);


        CatalogService.getInstance().get_student(3).setVarsta(21);
        studentDAO.update(CatalogService.getInstance().get_student(3));
        //studentDAO.delete(2);
        System.out.println(studentDAO.getStudent(2));
        for (Student s:studentDAO.getStudents())
        {
            System.out.println(s);
        }
        //System.out.println(grupaDAO.getGrupa(53));
        for (Grupa g:grupaDAO.getGrupe())
        {
            System.out.println(g);
        }
        grupe.get(1).setAn(2);
        grupaDAO.update(grupe.get(1));
        System.out.println(materieDAO.getMaterie(101));
        for (Materie m:materieDAO.getMaterii())
        {
            System.out.println(m);
        }
        materii.get(1).setDenumire("istorie");
        materieDAO.update(materii.get(1));


        int k=151;
        noteDAO.add(new Nota(10, k++), 1, 101);
        noteDAO.add(new Nota(9, k++), 1, 102);
        noteDAO.add(new Nota(8, k++), 2, 101);
        noteDAO.add(new Nota(9, k++), 2, 103);
        noteDAO.add(new Nota(7, k++), 3, 103);
        noteDAO.add(new Nota(5, k++), 3, 102);

        System.out.println(noteDAO.getNote());
        noteDAO.update(new Nota(10, 156));
    }
}
