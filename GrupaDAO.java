package com.company;

import com.company.testare;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupaDAO {
    static Connection con = testare.getConnection();

    public int add(Grupa grup)
            throws SQLException {
        String query = "insert into grupe(id_grupa, an, serie, ordine) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, grup.getID());
        ps.setInt(2, grup.getAn());
        ps.setInt(3, grup.getSerie());
        ps.setInt(4, grup.getOrdine());
        int n = ps.executeUpdate();
        return n;
    }

    public void delete(int id_grupa)
            throws SQLException {
        String query = "delete from grupe where id_grupa =?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_grupa);
        ps.executeUpdate();
    }

    public void delete_all()
            throws SQLException {
        String query = "delete from grupe";
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
    }

    public Grupa getGrupa(int id_grupa)
            throws SQLException {

        String query = "select * from grupe where id_grupa= ?";
        PreparedStatement ps = con.prepareStatement(query);


        ps.setInt(1, id_grupa);
        Grupa grup = new Grupa();
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        while (rs.next()) {
            check = true;
            grup.setID(rs.getInt("id_grupa"));
            grup.setAn(rs.getInt("an"));
            grup.setSerie(rs.getInt("serie"));
            grup.setOrdine(rs.getInt("ordine"));
        }

        if (check == true) {
            return grup;
        } else
            return null;
    }




    public List<Grupa> getGrupe()
            throws SQLException {
        String query = "select * from grupe";
        PreparedStatement ps
                = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Grupa> ls = new ArrayList();

        while (rs.next()) {
            Grupa grup = new Grupa();
            grup.setID(rs.getInt("id_grupa"));
            grup.setAn(rs.getInt("an"));
            grup.setSerie(rs.getInt("serie"));
            grup.setOrdine(Integer.parseInt(rs.getString("ordine")));
            ls.add(grup);
        }
        return ls;
    }

    public void update(Grupa grup)
            throws SQLException
    {

        String query
                = "update grupe set an= ?, serie= ?, ordine= ? where id_grupa = ?";
        PreparedStatement ps
                = con.prepareStatement(query);
        ps.setInt(1, grup.getAn());
        ps.setInt(2, grup.getSerie());
        ps.setInt(3, grup.getOrdine());
        ps.setInt(4, grup.getID());
        ps.executeUpdate();
    }
}
