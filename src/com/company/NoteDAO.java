package com.company;

import com.company.testare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {
    static Connection con = testare.getConnection();

    public int add(Nota not, int id_student, int id_materie)
            throws SQLException {
        String query = "insert into note(id_nota, id_student, id_materie, nota, data) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, not.getID());
        ps.setInt(2, id_student);
        ps.setInt(3, id_materie);
        ps.setInt(4, not.getNota());
        ps.setDate(5, not.getData());
        int n = ps.executeUpdate();
        return n;
    }

    public void delete(int id_nota)
            throws SQLException {
        String query = "delete from note where id_nota =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_nota);
        ps.executeUpdate();
    }

    public void delete_all()
            throws SQLException {
        String query = "delete from note";
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
    }

    public Nota getNota(int id_nota)
            throws SQLException {

        String query = "select * from note where id_nota= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_nota);
        Nota not = new Nota();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            not.setID(rs.getInt("id_nota"));
            not.setNota(rs.getInt("nota"));
            not.setData(rs.getDate("data"));
        }

        if (check == true) {
            return not;
        } else
            return null;
    }


    public List<Nota> getNote()
            throws SQLException {
        String query = "select * from note";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Nota> ls = new ArrayList();
        while (rs.next()) {
            Nota not = new Nota();
            not.setID(rs.getInt("id_nota"));
            not.setNota(rs.getInt("nota"));
            not.setData(rs.getDate("data"));
            ls.add(not);
        }
        return ls;
    }

    public void update(Nota not)
            throws SQLException
    {

        String query
                = "update note set nota= ?, data= ? where id_nota = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, not.getNota());
        ps.setDate(2, not.getData());
        ps.setInt(3, not.getID());
        ps.executeUpdate();
    }
}

