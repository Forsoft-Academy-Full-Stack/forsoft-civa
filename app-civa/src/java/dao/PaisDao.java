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
import model.Docs;
import model.Pais;

/**
 *
 * @author miguel.bispo
 */
public class PaisDao {

    public static boolean insert(Pais pais) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }
    
     public static Pais findById(Integer idPais) {
         return null;
     }

    public static Pais findByIdPessoa(Integer idPessoa) {
        Connection connection = ConnectionFactory.getConnection();

        Pais pais = null;

        String sql = "SELECT pa.nomedopais \n"
                + "FROM pessoa AS pe\n"
                + "LEFT JOIN pais AS pa\n"
                + "ON pe.idpaisdenascimento = pa.idpais \n"
                + "WHERE pe.idpessoa = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPessoa);
            rs = ps.executeQuery();
            
            pais = new Pais();
            
            if(rs.next()){
                pais.setNomePais(rs.getString("nomedopais"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pais;
    }

    public static List<Pais> list() {
        List<Pais> paises = new ArrayList<Pais>();
        return paises;
    }

    public static boolean update(Pais paisNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Pais pais) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
