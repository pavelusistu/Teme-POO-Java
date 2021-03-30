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
        return "Grupa: " + an + serie + ordine;
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
}
