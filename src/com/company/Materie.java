package com.company;

import java.util.ArrayList;

public class Materie
{
    private String denumire;
    private int puncte_credit;
    private Profesor profesor;
    private ArrayList<Nota> note;
    private int ID;
    public Materie()
    {
        this.profesor=new Profesor();
        this.denumire="nodenumire";
        this.puncte_credit=-1;
    }
    public Materie(String denumire, int puncte_credit, Profesor profesor) {
        note=new ArrayList<Nota>();
        this.profesor= profesor;
        this.denumire = denumire;
        this.puncte_credit = puncte_credit;
    }

    @Override
    public String toString() {
        return "Materie{" +
                "denumire='" + denumire + '\'' +
                ", puncte_credit=" + puncte_credit +
                '}';
    }

    public Materie adauga_nota(Nota nota)
    {
        note.add(nota);
        return this;
    }

    public float calculeaza_media()
    {
        int suma=0;
        for(Nota n:note)
        {
            suma+=n.getNota();
        }
        return (float)suma/note.size();
    }

    public boolean promovat()
    {
        return calculeaza_media()>5;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getPuncte_credit() {
        return puncte_credit;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public ArrayList<Nota> getNote() {
        return note;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setPuncte_credit(int puncte_credit) {
        this.puncte_credit = puncte_credit;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setNote(ArrayList<Nota> note) {
        this.note = note;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


}
