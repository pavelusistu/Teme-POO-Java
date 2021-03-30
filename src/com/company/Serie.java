package com.company;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.TreeSet;

class Grupa
{
    private int an;
    private int serie;
    private int ordine;
    private TreeSet<Student> studenti;
    public Grupa()
    {

    }

    public Grupa(int an, int serie, int ordine) {
        studenti=new TreeSet<Student>();
        this.an = an;
        this.serie = serie;
        this.ordine = ordine;
    }

    @Override
    public String toString() {
        return "Grupa: " + an + serie + ordine + "\n" + "Studenti: " + studenti;
    }
    public Grupa adauga_student(Student student)
    {
        studenti.add(student);
        return this;
    }

    public int getAn() {
        return an;
    }

    public int getSerie() {
        return serie;
    }

    public int getOrdine() {
        return ordine;
    }

    public TreeSet<Student> getStudenti() {
        return studenti;
    }
}

public class Serie
{
    private ArrayList<Grupa> grupe;
    private int serie;
    public Serie()
    {

    }
    public Serie(int serie) {
        grupe=new ArrayList<Grupa>();
        this.serie = serie;
    }
    public Serie adauga_grupa(Grupa grupa)
    {
        grupe.add(grupa);
        return this;
    }

    public ArrayList<Grupa> getGrupe() {
        return grupe;
    }

    public int getSerie() {
        return serie;
    }

    public Grupa get_grupa(int ordine)
    {
        for(Grupa g:grupe)
        {
            if (g.getOrdine()==(ordine))
                return g;
        }
        return new Grupa();
    }
}
