package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentDAO {
    static Connection con = testare.getConnection();

    public int add(Student stud, int id_grupa)
            throws SQLException {
        String query = "insert into studenti(nume, prenume, varsta, sex, id_student, id_grupa) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, stud.getNume());
        ps.setString(2, stud.getPrenume());
        ps.setString(3, String.valueOf(stud.getVarsta()));
        ps.setString(4, String.valueOf(stud.getSex()));
        ps.setString(5, String.valueOf(stud.getID()));
        ps.setInt(6, id_grupa);
        int n = ps.executeUpdate();
        return n;
    }

    public void delete(int id_student)
            throws SQLException {
        String query = "delete from studenti where id_student =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_student);
        ps.executeUpdate();
    }

    public void delete_all()
            throws SQLException {
        String query = "delete from studenti";
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
    }

    public Student getStudent(int id_student)
            throws SQLException {

        String query = "select * from studenti where id_student= ?";
        PreparedStatement ps = con.prepareStatement(query);


        ps.setInt(1, id_student);
        Student stud = new Student();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            stud.setID(rs.getInt("id_student"));
            stud.setNume(rs.getString("nume"));
            stud.setPrenume(rs.getString("prenume"));
            stud.setVarsta(Integer.parseInt(rs.getString("varsta")));
            stud.setSex(rs.getString("sex").charAt(0));
        }

        if (check == true) {
            return stud;
        } else
            return null;
    }


    public List<Student> getStudents()
            throws SQLException {
        String query = "select * from studenti";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Student> ls = new ArrayList();

        while (rs.next()) {
            Student stud = new Student();
            stud.setID(rs.getInt("id_student"));
            stud.setNume(rs.getString("nume"));
            stud.setPrenume(rs.getString("prenume"));
            stud.setVarsta(Integer.parseInt(rs.getString("varsta")));
            stud.setSex(rs.getString("sex").charAt(0));
            ls.add(stud);
        }
        return ls;
    }

    public void update(Student stud)
            throws SQLException
    {

        String query
                = "update studenti set nume= ?, prenume= ?, varsta= ?, sex= ? where id_student = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, stud.getNume());
        ps.setString(2, stud.getPrenume());
        ps.setString(3, String.valueOf(stud.getVarsta()));
        ps.setString(4, String.valueOf(stud.getSex()));
        ps.setInt(5, stud.getID());
        ps.executeUpdate();
    }
}


