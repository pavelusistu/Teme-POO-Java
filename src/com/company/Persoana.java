package com.company;

import java.util.ArrayList;

public class Persoana implements Comparable<Persoana>
{
    private String nume;
    private String prenume;
    private int varsta;
    private char sex;

    public Persoana()
    {
        this("noname", "noname", -1, 'N');
    }
    public Persoana(String nume, String prenume, int varsta, char sex) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Persoana{" + "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(Persoana o) {
        return this.nume.compareTo(o.nume);
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public char getSex() {
        return sex;
    }
}

class Student extends Persoana
{
    private ArrayList<Materie> materii;
    public Student()
    {
        materii=new ArrayList<Materie>();
    }

    public Student(String nume, String prenume, int varsta, char sex)
    {
        super(nume, prenume, varsta, sex);
        materii=new ArrayList<Materie>();
    }

    public Student adauga_materie(Materie materie)
    {
        materii.add(materie);
        return this;
    }

    public Materie get_materie(String denumire)
    {
        for(Materie m:materii)
        {
            if (m.getDenumire().equals(denumire))
                return m;
        }
        return new Materie();
    }

    @Override
    public String toString() {
        return "Student{" + "nume='" + getNume() + '\'' +
                ", prenume='" + getPrenume() + '\'' +
                ", varsta=" + getVarsta() +
                ", sex=" + getSex() +
                ", materii=" + materii +
                '}';
    }

    public float calculeaza_media_generala()
    {
        float suma1=0;
        for (Materie m:materii)
            suma1+=m.calculeaza_media();
        return (float)suma1/materii.size();
    }
}

class Profesor extends Persoana
{
    private ArrayList<Serie> serii;
    public Profesor()
    {
        serii=new ArrayList<Serie>();
    }

    public Profesor(String nume, String prenume, int varsta, char sex)
    {
        super(nume, prenume, varsta, sex);
        serii=new ArrayList<Serie>();
    }

    @Override
    public String toString() {
        return "Profesor{" + "nume='" + getNume() + '\'' +
                ", prenume='" + getPrenume() + '\'' +
                ", varsta=" + getVarsta() +
                ", sex=" + getSex() +
                '}';
    }

    public Profesor adauga_serie(Serie serie)
    {
        serii.add(serie);
        return this;
    }

    public Serie get_serie(int serie)
    {
        for(Serie s:serii)
        {
            if (s.getSerie()==(serie))
                return s;
        }
        return new Serie();
    }
}


