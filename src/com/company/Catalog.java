package com.company;

import java.util.ArrayList;
import java.util.TreeSet;

public class Catalog
{
    private TreeSet<Student> studenti;
    private TreeSet<Profesor> profesori;

    @Override
    public String toString() {
        return "Catalog{" +
                "studenti=" + studenti +
                ", profesori=" + profesori +
                '}';
    }

        /*
        la inceput, inainte de prima si singura instantiere a clasei Catalog
        va avea valoarea null
        */
        private static Catalog obj = null;
        // lasam constructorul clasei privat pentru a nu fi accesat din exterior
        private Catalog() {
            studenti=new TreeSet<Student>();
            profesori=new TreeSet<Profesor>();
        }
        // metoda prin care se creaza unica instanta a clasei
        public static Catalog getInstance() {
            // daca clasa nu a fost instantiata inainte, o facem acum
            if (obj == null)
                obj = new Catalog();
            return obj;
        }

        public void adauga_student(Student student)
        {
            studenti.add(student);
        }
        public void adauga_profesor(Profesor profesor)
        {
            profesori.add(profesor);
        }

        public Student get_student(String nume)
        {
            for(Student s:studenti)
            {
                if (s.getNume().equals(nume))
                    return s;
            }
            return new Student();
        }

    public Profesor get_profesor(String nume)
    {
        for(Profesor p:profesori)
        {
            if (p.getNume().equals(nume))
                return p;
        }
        return new Profesor();
    }

    public float calculeaza_media_grupei()
    {
        float suma2=0;
        for(Student s:studenti)
            suma2+=s.calculeaza_media_generala();
        return (float)suma2/studenti.size();
    }

}

