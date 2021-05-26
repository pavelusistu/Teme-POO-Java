package com.company;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class Nota
{
    private int nota;
    private Date data;
    private int ID;

    public Nota()
    {

    }
    public Nota(int nota, Date data)
    {
        this.nota = nota;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "nota=" + nota +
                ", data=" + data +
                '}';
    }

    public int getNota() {
        return nota;
    }

    public Date getData() {
        return data;
    }

    public Nota(int nota) {
        this.nota = nota;
        this.data = Date.valueOf(LocalDate.now());
    }

    public Nota(int nota, int ID) {
        this.nota = nota;
        this.data = Date.valueOf(LocalDate.now());
        this.ID = ID;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
