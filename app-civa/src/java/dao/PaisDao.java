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
import model.DivisaoTerritorial;
import model.Docs;
import model.Pais;
import model.TipoDoc;

/**
 *
 * @author miguel.bispo
 */
public class PaisDao {

    public static int insert(Pais pais) {
        Connection connection = ConnectionFactory.getConnection();
        int idPais = -1;

        try {
            ResultSet rs = null;
            String sql = "";

            sql = "INSERT INTO pais\n"
                    + "(idcontinente, idcadastrante, nomedopais, orgaoresponsavel, padraodecontato, ddi, sigla)\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, pais.getIdContinente());
            ps.setInt(2, pais.getIdCadastrante());
            ps.setString(3, pais.getNomePais());
            ps.setString(4, pais.getOrgaoResponsavel());
            ps.setString(5, pais.getPadraoContato());
            ps.setInt(6, pais.getDdi());
            ps.setString(7, pais.getSigla());

            int i = ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idPais = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.err.println(idPais);
        return idPais;
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

            if (rs.next()) {
                pais.setNomePais(rs.getString("nomedopais"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pais;
    }

    public static Pais findByIdPais(Integer idPais) {
        Connection connection = ConnectionFactory.getConnection();
        Pais pais = null;
        DivisaoTerritorial divisaoterritorial = null;
        Docs documento = null;
        Docs documento2 = null;
        Docs documento3 = null;
        String sql = "";
        String sql2 = "";

        sql = "SELECT DISTINCT pa.nomedopais,\n"
                + "     cont.nomecontinente,\n"
                + "	 pa.ddi, pa.padraodecontato,\n"
                + "     pa.orgaoresponsavel,\n"
                + "     dite.tiposubdivisao1,\n"
                + "     dite.tiposubdivisao2,\n"
                + "     dite.tiposubdivisao3,\n"
                + "     dite.tiposubdivisao4, \n"
                + "     dite.tiposubdivisao5,\n"
                + "     dite.tiposubdivisao6,\n"
                + "     dite.tiposubdivisao7\n"
                + "FROM pais pa\n"
                + "LEFT JOIN continente cont\n"
                + "ON pa.idcontinente = cont.idcontinente \n"
                + "LEFT JOIN divisaoterritorial dite \n"
                + "ON pa.idpais = dite.idpais \n"
                + "WHERE pa.idpais = ?;";

        sql2 = "SELECT tidoc.nivel,\n"
                + "       tidoc.nomedoc,\n"
                + "       tidoc.formatodoc \n"
                + "FROM pais pa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON pa.idpais = tidoc.idpais \n"
                + "WHERE pa.idpais = ?";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPais);
            rs = ps.executeQuery();

            pais = new Pais();
            divisaoterritorial = new DivisaoTerritorial();
            documento = new Docs();
            documento2 = new Docs();
            documento3 = new Docs();

            if (rs.next()) {
                pais.setNomePais(rs.getString("nomedopais"));
                pais.setNomeContinente(rs.getString("nomecontinente"));
                pais.setDdi(rs.getInt("ddi"));
                pais.setPadraoContato(rs.getString("padraodecontato"));
                pais.setOrgaoResponsavel(rs.getString("orgaoresponsavel"));

                divisaoterritorial.setTiposubdivisao1(rs.getString("tiposubdivisao1"));
                divisaoterritorial.setTiposubdivisao2(rs.getString("tiposubdivisao2"));
                divisaoterritorial.setTiposubdivisao3(rs.getString("tiposubdivisao3"));
                divisaoterritorial.setTiposubdivisao4(rs.getString("tiposubdivisao4"));
                divisaoterritorial.setTiposubdivisao5(rs.getString("tiposubdivisao5"));
                divisaoterritorial.setTiposubdivisao6(rs.getString("tiposubdivisao6"));
                divisaoterritorial.setTiposubdivisao7(rs.getString("tiposubdivisao7"));

                pais.setDivisaoTerritorial(divisaoterritorial);

            }

            ps = connection.prepareStatement(sql2);
            ps.setInt(1, idPais);
            rs = ps.executeQuery();

            if (rs.next()) {
                documento.setNomeTipoDoc(rs.getString("nomedoc"));
                documento.setFormatoDocumento(rs.getString("formatodoc"));
                documento.setTipoDocumento(rs.getString("nivel"));

                pais.setDocumento1(documento);

            }

            if (rs.next()) {
                documento2.setNomeTipoDoc(rs.getString("nomedoc"));
                documento2.setFormatoDocumento(rs.getString("formatodoc"));
                documento2.setTipoDocumento(rs.getString("nivel"));

                pais.setDocumento2(documento2);

            }

            if (rs.next()) {
                documento3.setNomeTipoDoc(rs.getString("nomedoc"));
                documento3.setFormatoDocumento(rs.getString("formatodoc"));
                documento3.setTipoDocumento(rs.getString("nivel"));

                pais.setDocumento3(documento3);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pais;
    }

    public static List<Pais> listPais() {
        List<Pais> paises = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        Pais pais;
        String sql = "";
        String sql2 = "";

        sql = "SELECT pa.nomedopais, co.nomecontinente, pa.orgaoresponsavel, pa.idpais FROM\n"
                + "pais pa\n"
                + "LEFT JOIN continente co ON pa.idcontinente = co.idcontinente ";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pais = new Pais();
                pais.setNomePais(rs.getString("nomedopais"));
                pais.setNomeContinente(rs.getString("nomecontinente"));
                pais.setOrgaoResponsavel(rs.getString("orgaoresponsavel"));
                pais.setNomeContinente(rs.getString("nomecontinente"));
                pais.setIdPais(rs.getInt("idpais"));

                paises.add(pais);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public static String getSiglaByName(String nomePais) {
        Connection connection = ConnectionFactory.getConnection();
        String sigla = null;

        String sql = "SELECT p.sigla FROM\n"
                + "pais AS p\n"
                + "WHERE p.nomedopais LIKE ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, nomePais);
            rs = ps.executeQuery();

            if (rs.next()) {
                sigla = rs.getString("sigla");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sigla;
    }

    public static int getIdPaisByName(String nomePais) {
        Connection connection = ConnectionFactory.getConnection();
        int idPais = -1;

        String sql = "SELECT p.idpais FROM\n"
                + "pais AS p\n"
                + "WHERE p.nomedopais LIKE ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, nomePais);
            rs = ps.executeQuery();

            if (rs.next()) {
                idPais = rs.getInt("idpais");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idPais;
    }

    public static String getDdiByName(String nomePais) {
        Connection connection = ConnectionFactory.getConnection();
        String ddi = null;

        String sql = "SELECT p.ddi FROM\n"
                + "pais AS p\n"
                + "WHERE p.nomedopais LIKE ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, nomePais);
            rs = ps.executeQuery();

            if (rs.next()) {
                ddi = rs.getString("ddi");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ddi;
    }
}
