package com.company;

import com.company.testare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriiDAO {
    static Connection con = testare.getConnection();

    public int add(Materie mat)
            throws SQLException {
        String query = "insert into materii(id_materie, denumire, puncte_credit) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, mat.getID());
        ps.setString(2, mat.getDenumire());
        ps.setInt(3, mat.getPuncte_credit());
        int n = ps.executeUpdate();
        return n;
    }

    public void delete(int id_materie)
            throws SQLException {
        String query = "delete from materii where id_materie =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_materie);
        ps.executeUpdate();
    }

    public void delete_all()
            throws SQLException {
        String query = "delete from materii";
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
    }

    public Materie getMaterie(int id_materie)
            throws SQLException {

        String query = "select * from materii where id_materie= ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_materie);
        Materie mat = new Materie();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            mat.setID(rs.getInt("id_materie"));
            mat.setDenumire(rs.getString("denumire"));
            mat.setPuncte_credit(rs.getInt("puncte_credit"));
        }

        if (check == true) {
            return mat;
        } else
            return null;
    }


    public List<Materie> getMaterii()
            throws SQLException {
        String query = "select * from materii";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Materie> ls = new ArrayList();
        while (rs.next()) {
            Materie mat = new Materie();
            mat.setID(rs.getInt("id_materie"));
            mat.setDenumire(rs.getString("denumire"));
            mat.setPuncte_credit(rs.getInt("puncte_credit"));
            ls.add(mat);
        }
        return ls;
    }

    public void update(Materie mat)
            throws SQLException
    {

        String query
                = "update materii set denumire= ?, puncte_credit= ? where id_materie = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setString(1, mat.getDenumire());
        ps.setInt(2, mat.getPuncte_credit());
        ps.setInt(3, mat.getID());
        ps.executeUpdate();
    }
}
