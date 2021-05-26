package com.company;

import com.company.Student;

import com.company.StudentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Meniu {
    private final Scanner scanner = new Scanner(System.in);
    LocalDateTime data;

    public void AddStudent() throws SQLException {
        Student stud = new Student();
        StudentDAO studDao = new StudentDAO();
        int i = 4;
        Scanner in = new Scanner(System.in);
        System.out.println("Nume: ");
        String nume = in.next();
        System.out.println("Prenume: ");
        String prenume = in.next();
        System.out.println("Varsta: ");
        int varsta = in.nextInt();
        System.out.println("Sex: ");
        char sex = in.next().charAt(0);
        stud = new Student(nume,prenume,varsta,sex,i++);
        System.out.println("Grupa: ");
        int Gr = in.nextInt();
        studDao.add(stud, Gr);
    }
    public void SelectStudent() throws SQLException {
        StudentDAO studDao = new StudentDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul studentului:");
        int x = in.nextInt();
        Student e = studDao.getStudent(x);
        System.out.println(e.getID() + " "
                + e.getNume() + " " + e.getPrenume() + " "
                + e.getVarsta() + " " + e.getSex());
    }


    public void SelectAllStudents() throws SQLException {
        StudentDAO studDao = new StudentDAO();
        List<Student> ls = studDao.getStudents();
        for (Student allstud : ls) {
            System.out.println(allstud.getID() + " " + allstud.getNume() + " " + allstud.getPrenume() + " "
                    + allstud.getVarsta() + " " + allstud.getSex());
        }
    }

    public void UpdateStudent() throws SQLException {
        StudentDAO studDao = new StudentDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul studentului pe care doriti sa il actualizati:");
        int x = in.nextInt();
        Student student = studDao.getStudent(x);
        System.out.println("Introduceti varsta noua:");
        student.setVarsta(in.nextInt());
        studDao.update(student);
    }

    public void DeleteStudent() throws SQLException {
        StudentDAO studDao = new StudentDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul studentului:");
        int x = in.nextInt();
        studDao.delete(x);
    }

    public void AddMaterie() throws SQLException {
        Materie mat;
        MateriiDAO materieDao = new MateriiDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Denumire: ");
        String den = in.next();
        System.out.println("Puncte credit: ");
        int pc = in.nextInt();
        Profesor prof = new Profesor();
        mat = new Materie(den,pc,prof);
        materieDao.add(mat);
    }

    public void SelectMaterie() throws SQLException, NullPointerException {
        MateriiDAO matDao = new MateriiDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul materiei:");
        int x = in.nextInt();
        Materie e = matDao.getMaterie(x);
        System.out.println(e.getID() + " "
                + e.getDenumire() + " " + e.getPuncte_credit());
    }

    public void SelectAllMat() throws SQLException {
        MateriiDAO matDao = new MateriiDAO();
        List<Materie> ls = matDao.getMaterii();
        for (Materie allmat : ls) {
            System.out.println(allmat.getID() + " " + allmat.getDenumire() + " " + allmat.getPuncte_credit());
        }
    }

    public void UpdateMaterie() throws SQLException {
        MateriiDAO matDao = new MateriiDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul materiei pe care doriti sa o actualizati:");
        int x = in.nextInt();
        Materie mat = matDao.getMaterie(x);
        System.out.println("Introduceti numarul de credite dorit:");
        int y = in.nextInt();
        mat.setPuncte_credit(y);
        matDao.update(mat);
    }

    public void DeleteMaterie() throws SQLException {
        MateriiDAO matDao = new MateriiDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul materiei:");
        int x = in.nextInt();
        matDao.delete(x);
    }

    public void AddGrupa() throws SQLException {
        GrupaDAO grupaDao = new GrupaDAO();
        Grupa grupa;
        Scanner in = new Scanner(System.in);
        System.out.println("An: ");
        int an = in.nextInt();
        System.out.println("Serie: ");
        int serie = in.nextInt();
        System.out.println("Ordine: ");
        int ordine = in.nextInt();
        grupa = new Grupa(an,serie,ordine);
        grupaDao.add(grupa);
    }

    public void SelectGrupa() throws SQLException, NullPointerException {
        GrupaDAO grupaDAO = new GrupaDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul grupei:");
        int x = in.nextInt();
        Grupa g = grupaDAO.getGrupa(x);
        System.out.println(g.getID() + " "
                + g.getAn() + " " + g.getSerie() + " " + g.getOrdine());
    }

    public void SelectAllGrup() throws SQLException {
        GrupaDAO grupaDAO = new GrupaDAO();
        List<Grupa> ls = grupaDAO.getGrupe();
        for (Grupa allgrup : ls) {
            System.out.println(allgrup.getID() + " " + allgrup.getAn() + " " + allgrup.getSerie() + " " + allgrup.getOrdine());
        }
    }

    public void UpdateGrupa() throws SQLException, NullPointerException {
        GrupaDAO grupaDAO = new GrupaDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul grupei pe care doriti sa o actualizati:");
        int x = in.nextInt();
        Grupa g;
        g = grupaDAO.getGrupa(x);
        System.out.println("Introduceti anul dorit:");
        int y = in.nextInt();
        g.setAn(y);
        grupaDAO.update(g);
    }

    public void AddNota() throws SQLException, ParseException {
        Nota nota = new Nota();
        NoteDAO noteDAO = new NoteDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Nota: ");
        int not = in.nextInt();
        System.out.println("ID-ul studentului: ");
        int id_student = in.nextInt();
        System.out.println("ID-ul materiei: ");
        int id_materie = in.nextInt();
        nota = new Nota(not);
        noteDAO.add(nota,id_student,id_materie);
    }

    public void SelectNota() throws SQLException, NullPointerException {
        NoteDAO noteDAO = new NoteDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul notei:");
        int x = in.nextInt();
        Nota n = noteDAO.getNota(x);
        System.out.println(n.getID() + " "
                + n.getNota() + " " + n.getData());
    }

    public void SelectAllNote() throws SQLException {
        NoteDAO noteDAO = new NoteDAO();
        List<Nota> ls = noteDAO.getNote();
        for (Nota allnote : ls) {
            System.out.println(allnote.getID() + " " + allnote.getNota() + " " + allnote.getData());
        }
    }

    public void UpdateNota() throws SQLException {
        NoteDAO noteDAO = new NoteDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul notei pe care doriti sa o actualizati: ");
        int x = in.nextInt();
        Nota nota = noteDAO.getNota(x);
        System.out.println("Introduceti noua nota: ");
        int y = in.nextInt();
        nota.setNota(y);
        noteDAO.update(nota);
    }

    public void DeleteNota() throws SQLException {
        NoteDAO noteDAO = new NoteDAO();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti ID-ul notei:");
        int x = in.nextInt();
        noteDAO.delete(x);
    }

    public void menu() throws SQLException, ParseException {
        String jdbcURL = "jdbc:mysql://localhost:3306/sys";
        String username = "root";
        String password = "qweasd123";
        Connection con = DriverManager.getConnection(jdbcURL, username, password);
        Meniu run = new Meniu();
        for (; ; ) {
            System.out.println("1.Adauga student");
            System.out.println("2.Afiseaza studentul dorit");
            System.out.println("3.Afiseaza toti studentii");
            System.out.println("4.Actualizeaza  studentul dorit");
            System.out.println("5.Sterge studentul dorit");
            System.out.println("6.Adauga materie");
            System.out.println("7.Afiseaza materia dorita");
            System.out.println("8.Afiseaza toate materiile");
            System.out.println("9.Actualizeaza  materia dorita");
            System.out.println("10.Sterge materia dorita");
            System.out.println("11.Adauga grupa");
            System.out.println("12.Afiseaza grupa dorita");
            System.out.println("13.Afiseaza toate grupele");
            System.out.println("14.Actualizeaza grupa dorita");
            System.out.println("15.Adauga nota");
            System.out.println("16.Afiseaza nota dorita");
            System.out.println("17.Actualizeaza nota dorita");
            System.out.println("18.Sterge nota dorita");
            System.out.println("19.Afiseaza toate notele din catalog");
            int option = scanner.nextInt();
            if (option == 0) {
                break;
            }
            switch (option) {
                case 1:
                    run.AddStudent();
                    break;
                case 2:
                    run.SelectStudent();
                    break;
                case 3:
                    run.SelectAllStudents();
                    break;
                case 4:
                    run.UpdateStudent();
                    break;
                case 5:
                    run.DeleteStudent();
                    break;
                case 6:
                    run.AddMaterie();
                    break;
                case 7:
                    run.SelectMaterie();
                    break;
                case 8:
                    run.SelectAllMat();
                    break;
                case 9:
                    run.UpdateMaterie();
                    break;
                case 10:
                    run.DeleteMaterie();
                    break;
                case 11:
                    run.AddGrupa();
                    break;
                case 12:
                    run.SelectGrupa();
                    break;
                case 13:
                    run.SelectAllGrup();
                    break;
                case 14:
                    run.UpdateGrupa();
                    break;
                case 15:
                    run.AddNota();
                    break;
                case 16:
                    run.SelectNota();
                    break;
                case 17:
                    run.UpdateNota();
                    break;
                case 18:
                    run.DeleteNota();
                    break;
                case 19:
                    run.SelectAllNote();
                    break;
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }

    }

    public static void main(String[] args) throws SQLException, ParseException {

        Meniu meniu = new Meniu();
        meniu.menu();


        //run.AddCurs();
        //run.AddStudent();
        //run.SelectStudent();
        //run.SelectAllStudents();
        //run.UpdateStudent();
        //run.DeleteStudent();
    }
}