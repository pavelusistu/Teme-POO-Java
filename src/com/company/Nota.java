package com.company;

import java.time.LocalDate;

public class Nota
{
    private int nota;
    private LocalDate data;

    public Nota()
    {

    }
    public Nota(int nota, LocalDate data)
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

    public LocalDate getData() {
        return data;
    }

    public Nota(int nota) {
        this.nota = nota;
        this.data = LocalDate.now();
    }
}
