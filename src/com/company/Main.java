package com.company;

public class Main {

    public static void main(String[] args) {
        //Persoana p = new Persoana();
        //System.out.println(p);
        //Grupa g=new Grupa(2,5,2);
        //System.out.println(g);
        Catalog.getInstance().adauga_profesor(new Profesor("Ionescu", "Gabriel", 60, 'M'));
        Catalog.getInstance().adauga_profesor(new Profesor("Popescu", "George", 55, 'M'));
        Catalog.getInstance().adauga_profesor(new Profesor("Fojica", "Eleonora", 80, 'F'));
        Catalog.getInstance().adauga_student(new Student("Luca", "Pavel", 20, 'M'));
        Catalog.getInstance().adauga_student(new Student("Stamate", "Andrei", 20, 'M'));
        Catalog.getInstance().adauga_student(new Student("Mantu", "David", 20, 'M'));
        /*Materie matematica=new Materie("matematica", 5, Catalog.getInstance().get_profesor("Fojica"));
        Materie romana=new Materie("romana", 4, Catalog.getInstance().get_profesor("Popescu"));
        Materie geografie=new Materie("geografie", 3, Catalog.getInstance().get_profesor("Ionescu"));*/
        Catalog.getInstance().get_student("Luca")
                .adauga_materie(new Materie("matematica", 5, Catalog.getInstance().get_profesor("Fojica")))
                .adauga_materie(new Materie("geografie", 3, Catalog.getInstance().get_profesor("Ionescu")))
                .adauga_materie(new Materie("romana", 4, Catalog.getInstance().get_profesor("Popescu")));
        Catalog.getInstance().get_student("Luca").get_materie("matematica")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(9))
                .adauga_nota(new Nota(10));
        Catalog.getInstance().get_student("Luca").get_materie("romana")
                .adauga_nota(new Nota(8))
                .adauga_nota(new Nota(7))
                .adauga_nota(new Nota(6));
        Catalog.getInstance().get_student("Luca").get_materie("geografie")
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10))
                .adauga_nota(new Nota(10));
        System.out.println(Catalog.getInstance().get_student("Luca").get_materie("matematica").calculeaza_media());
        System.out.println(Catalog.getInstance().get_student("Luca").calculeaza_media_generala());
        Catalog.getInstance().get_student("Stamate").adauga_materie(new Materie("romana", 4, Catalog.getInstance().get_profesor("Popescu")));
        Catalog.getInstance().get_student("Stamate").get_materie("romana").adauga_nota(new Nota(10));
        Catalog.getInstance().get_student("Stamate").get_materie("romana").adauga_nota(new Nota(9));
        Catalog.getInstance().get_student("Stamate").get_materie("romana").adauga_nota(new Nota(6));
        System.out.println(Catalog.getInstance().get_student("Stamate").calculeaza_media_generala());
        Catalog.getInstance().get_student("Mantu").adauga_materie(new Materie("geografie", 3, Catalog.getInstance().get_profesor("Ionescu")));
        Catalog.getInstance().get_student("Mantu").get_materie("geografie").adauga_nota(new Nota(4));
        Catalog.getInstance().get_student("Mantu").get_materie("geografie").adauga_nota(new Nota(5));
        Catalog.getInstance().get_student("Mantu").get_materie("geografie").adauga_nota(new Nota(5));
        System.out.println(Catalog.getInstance().calculeaza_media_grupei());
        System.out.println(Catalog.getInstance().get_student("Mantu").get_materie("geografie").calculeaza_media());
        if(Catalog.getInstance().get_student("Mantu").get_materie("geografie").promovat())
            System.out.println("Promovat");
        else
            System.out.println("Corigent");
        System.out.println(Catalog.getInstance().get_student("Mantu"));
    }
}
