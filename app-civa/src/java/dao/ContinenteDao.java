/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Continente;

/**
 *
 * @author randel
 */
public class ContinenteDao {

    public static List<Continente> list() {
        List<Continente> continentes = new ArrayList<>();
        Continente continente;
        Connection connection = ConnectionFactory.getConnection();

        String sql = "SELECT ct.idcontinente,\n"
                + "	  ct.nomecontinente\n"
                + "FROM continente as ct;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            ps = connection.prepareStatement(sql);
        
            rs = ps.executeQuery();
        
            while (rs.next()) {
                continente = new Continente();
                continente.setIdContinente(rs.getInt("idcontinente"));
                continente.setNomeContinente1(rs.getString("nomecontinente"));
                continentes.add(continente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return continentes;
    }
}
