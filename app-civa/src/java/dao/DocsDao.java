package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Docs;

/**
 *
 * @author randel
 */
public class DocsDao {

    public static boolean insert(int idTipoDoc, int idPessoa, String documento, String dataEmissao) {
        Connection connection = ConnectionFactory.getConnection();
        boolean resultado = false;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "";

            sql = "INSERT INTO docs\n"
                    + "(idpessoa, idtipodoc, documento, datadeemissao)\n"
                    + "VALUES(?, ?, ?, ?);";

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPessoa);
            ps.setInt(2, idTipoDoc);
            ps.setString(3, documento);
            ps.setString(4, dataEmissao);
            
            ps.executeUpdate();
            
            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(DocsDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public static int findIdTipodoc(String nomeDoc) {
        Connection connection = ConnectionFactory.getConnection();
        int idTipoDoc = -1;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "";

            sql = "SELECT tpc.idtipodoc FROM tipodoc as tpc\n"
                    + "WHERE tpc.nomedoc LIKE ? ;";

            ps = connection.prepareStatement(sql);
            ps.setString(1, nomeDoc);
            rs = ps.executeQuery();

            if (rs.next()) {
                idTipoDoc = rs.getInt("idtipodoc");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DocsDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idTipoDoc;

    }

    public static Docs find(Integer idDocs) {
        for (Docs docs : DocsDao.list()) {
            if (Objects.equals(docs.getIdDocs(), idDocs)) {
                return docs;
            }
        }

        return null;
    }

    public static List<Docs> list() {
        List<Docs> listaDocs = new ArrayList<Docs>();

        return listaDocs;
    }

    public static boolean update(Docs docs) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Docs docs) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
