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
import model.Vacina;

/**
 *
 * @author randel
 */
public class VacinaDao {

    public static boolean insert(Vacina vacina) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }
    
    public static Vacina findByNome(String nomeVacina) {
        Connection connection = ConnectionFactory.getConnection();
        Vacina vacina = null;

        String sql = "";
        sql = "SELECT * FROM vacina AS vac\n"
                + "WHERE vac.nomevacina LIKE ?; ";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, "%"+nomeVacina+"%");
            rs = ps.executeQuery();

            if (rs.next()) {
                vacina = new Vacina();
                vacina.setIdVacina(rs.getInt("idvacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getInt("numerodedoses"));
                vacina.setNomeVacina(rs.getString("nomevacina"));
                vacina.setTipoVacina(rs.getString("tipodevacina"));
                vacina.setTempoEntreDoses(rs.getInt("tempoentredoses"));
                vacina.setTempoReforco(rs.getInt("tempoparareforco"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacina;
    }

    public static Vacina findById(Integer idVacina) {
        Connection connection = ConnectionFactory.getConnection();
        Vacina vacina = null;

        String sql = "";
        sql = "SELECT * FROM vacina AS vac\n"
                + "WHERE vac.idvacina = ?; ";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idVacina);
            rs = ps.executeQuery();

            if (rs.next()) {
                vacina = new Vacina();
                vacina.setIdVacina(rs.getInt("idvacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getInt("numerodedoses"));
                vacina.setNomeVacina(rs.getString("nomevacina"));
                vacina.setTipoVacina(rs.getString("tipodevacina"));
                vacina.setTempoEntreDoses(rs.getInt("tempoentredoses"));
                vacina.setTempoReforco(rs.getInt("tempoparareforco"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacina;
    }

    public static Vacina findByIdGestorNacional(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();
        Vacina vacina = null;

        String sql = "";
        sql = "SELECT vac.idvacina, vac.laboratorio, vac.numerodedoses, vac.nomevacina,\n"
                + "    vac.tipodevacina, vac.tempoentredoses, vac.tempoparareforco FROM vacina vac\n"
                + "    LEFT JOIN vacina_do_pais vdp \n"
                + "    ON vac.idvacina =vdp.idvacina \n"
                + "    WHERE vdp.idpais = (\n"
                + "    SELECT pa.idpais FROM acessogestao ag\n"
                + "    LEFT JOIN pessoa peag\n"
                + "    ON ag.idpessoa = peag.idpessoa\n"
                + "    LEFT JOIN pais pa\n"
                + "    ON peag.idpaisdenascimento = pa.idpais\n"
                + "    WHERE ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            if (rs.next()) {
                vacina = new Vacina();
                vacina.setIdVacina(rs.getInt("idvacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getInt("numerodedoses"));
                vacina.setNomeVacina(rs.getString("nomevacina"));
                vacina.setTipoVacina(rs.getString("tipodevacina"));
                vacina.setTempoEntreDoses(rs.getInt("tempoentredoses"));
                vacina.setTempoReforco(rs.getInt("tempoparareforco"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacina;
    }

    public static List<Vacina> listByGestorNacional(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        List<Vacina> vacinas = null;
        Vacina vacina;

        sql = "SELECT vac.idvacina,\n"
                + "	   vac.laboratorio,\n"
                + "	   vac.numerodedoses,\n"
                + "       vac.nomevacina,\n"
                + "       vac.tipodevacina,\n"
                + "	   vac.tempoentredoses,\n"
                + "       vac.tempoparareforco \n"
                + "FROM vacina vac\n"
                + "LEFT JOIN vacina_do_pais vdp \n"
                + "ON vac.idvacina =vdp.idvacina \n"
                + "WHERE vdp.idpais = (\n"
                + "SELECT pa.idpais FROM acessogestao ag\n"
                + "LEFT JOIN pessoa peag\n"
                + "ON ag.idpessoa = peag.idpessoa\n"
                + "LEFT JOIN pais pa\n"
                + "ON peag.idpaisdenascimento = pa.idpais\n"
                + "WHERE ag.codigocivagestao = ?)";

        try {
            vacinas = new ArrayList<>();

            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            while (rs.next()) {
                vacina = new Vacina();
                vacina.setIdVacina(rs.getInt("idvacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getInt("numerodedoses"));
                vacina.setNomeVacina(rs.getString("nomevacina"));
                vacina.setTipoVacina(rs.getString("tipodevacina"));
                vacina.setTempoEntreDoses(rs.getInt("tempoentredoses"));
                vacina.setTempoReforco(rs.getInt("tempoparareforco"));

                vacinas.add(vacina);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacinas;
    }

    public static List<Vacina> listByGestorOms() {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        List<Vacina> vacinas = null;
        Vacina vacina;

        sql = "SELECT vac.idvacina,\n"
                + "	   vac.laboratorio,\n"
                + "	   vac.numerodedoses,\n"
                + "        vac.nomevacina,\n"
                + "        vac.tipodevacina,\n"
                + "	   vac.tempoentredoses,\n"
                + "        vac.tempoparareforco \n"
                + "FROM vacina vac\n;";                              

        try {
            vacinas = new ArrayList<>();

            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);         
            rs = ps.executeQuery();

            while (rs.next()) {
                vacina = new Vacina();
                vacina.setIdVacina(rs.getInt("idvacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getInt("numerodedoses"));
                vacina.setNomeVacina(rs.getString("nomevacina"));
                vacina.setTipoVacina(rs.getString("tipodevacina"));
                vacina.setTempoEntreDoses(rs.getInt("tempoentredoses"));
                vacina.setTempoReforco(rs.getInt("tempoparareforco"));

                vacinas.add(vacina);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacinas;
    }

    
    
    
    
    public static boolean update(Vacina vacinaNova) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Vacina vacina) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
