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
import model.Pais;
import model.Unidade;
import model.Vacina;
import model.Vacinacao;

/**
 *
 * @author randel
 */
public class VacinacaoDao {

    public static List<Vacinacao> listByPortadorCivaInternacional(String codigoCivaPortador) {
        Connection connection = ConnectionFactory.getConnection();

        List<Vacinacao> vacinacoes = null;
        Vacinacao vacinacao = null;
        Vacina vacina = null;

        String sql = "SELECT vac.idvacina, vacao.lote, vac.nomevacina AS vacina,\n"
                + "	vac.laboratorio, vac.numerodedoses,\n"
                + "	vacao.doseaplicada,\n"
                + "	pa.nomedopais AS pais,\n"
                + "	vacao.datadeaplicacao AS dataaplicacao,\n"
                + "	uni.nomeunidade,\n"
                + "	vacao.idacessogestao,\n"
                + "	uni.idunidade\n"
                + "from vacinacao vacao\n"
                + "LEFT JOIN acessopc apc \n"
                + "ON vacao.idacessopc = apc.idacessopc\n"
                + "LEFT JOIN pessoa pepc\n"
                + "ON pepc.idpessoa = apc.idpessoa\n"
                + "LEFT JOIN vacina vac\n"
                + "ON vacao.idvacina = vac.idvacina\n"
                + "LEFT JOIN unidade uni\n"
                + "on vacao.idunidade = uni.idunidade\n"
                + "LEFT JOIN endereco en\n"
                + "ON uni.idendereco = en.idendereco\n"
                + "LEFT JOIN pais pa\n"
                + "ON en.idpais != pa.idpais\n"
                + "WHERE apc.codigocivapc = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            vacinacoes = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortador);
            rs = ps.executeQuery();

            while (rs.next()) {
                vacina = new Vacina();
                vacinacao = new Vacinacao();

                vacina.setNomeVacina(rs.getString("vacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getInt("numerodedoses"));

                vacinacao.setVacina(vacina);

                vacinacao.setDoseAplicada(rs.getString("doseaplicada"));
                vacinacao.setPais(rs.getString("pais"));
                vacinacao.setDataAplicacao(rs.getString("dataaplicacao"));
                vacinacao.setIdVacinacao(Integer.parseInt(rs.getString("idvacina")));
                vacinacao.setUnidade(rs.getString("nomeunidade"));
                vacinacao.setCodigoCivaCadastrante(rs.getString("idacessogestao"));
                vacinacao.setIdUnidade(rs.getInt("idunidade"));
                vacina.setLote(rs.getString("lote"));
                vacinacoes.add(vacinacao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacinacoes;
    }

    public static List<Vacinacao> listByPortadorCiva(String codigoCivaPortador) {
        Connection connection = ConnectionFactory.getConnection();

        List<Vacinacao> vacinacoes = null;
        Vacinacao vacinacao = null;
        Vacina vacina = null;

        String sql = "SELECT vac.idvacina, vacao.lote, vac.nomevacina AS vacina,\n"
                + "       vac.laboratorio, vac.numerodedoses,\n"
                + "       vacao.doseaplicada,\n"
                + "       pa.nomedopais AS pais,\n"
                + "       vacao.datadeaplicacao AS dataaplicacao,"
                + "       uni.nomeunidade,"
                + "       vacao.idacessogestao,\n"
                + "       uni.idunidade"
                + "       from vacinacao vacao\n"
                + "LEFT JOIN acessopc apc \n"
                + "ON vacao.idacessopc = apc.idacessopc\n"
                + "LEFT JOIN pessoa pepc\n"
                + "ON pepc.idpessoa = apc.idpessoa \n"
                + "LEFT JOIN vacina vac\n"
                + "ON vacao.idvacina = vac.idvacina \n"
                + "LEFT JOIN unidade uni \n"
                + "on vacao.idunidade = uni.idunidade \n"
                + "LEFT JOIN endereco en \n"
                + "ON uni.idendereco = en.idendereco \n"
                + "LEFT JOIN pais pa \n"
                + "ON en.idpais = pa.idpais\n"
                + "WHERE apc.codigocivapc = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            vacinacoes = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortador);
            rs = ps.executeQuery();

            while (rs.next()) {
                vacina = new Vacina();
                vacinacao = new Vacinacao();

                vacina.setNomeVacina(rs.getString("vacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getInt("numerodedoses"));

                vacinacao.setVacina(vacina);

                vacinacao.setDoseAplicada(rs.getString("doseaplicada"));
                vacinacao.setPais(rs.getString("pais"));
                vacinacao.setDataAplicacao(rs.getString("dataaplicacao"));
                vacinacao.setIdVacinacao(Integer.parseInt(rs.getString("idvacina")));
                vacinacao.setUnidade(rs.getString("nomeunidade"));
                vacinacao.setCodigoCivaCadastrante(rs.getString("idacessogestao"));
                vacinacao.setIdUnidade(rs.getInt("idunidade"));
                vacina.setLote(rs.getString("lote"));
                vacinacoes.add(vacinacao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacinacoes;
    }

    public static List<Vacinacao> list(String codigoCivaPortador) {
        Connection connection = ConnectionFactory.getConnection();
        List<Vacinacao> vacinacoes = null;
        Vacinacao vacinacao = null;
        Vacina vacina = null;
        Pais pais = null;
        Unidade unidade = null;

        String sql = "";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortador);
            rs = ps.executeQuery();

            while (rs.next()) {

            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static boolean insert(Vacinacao vacinacao) {
        boolean resultado = false;

        // Insert into vacinacao values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Vacinacao find(Integer idVacinacao) {
        for (Vacinacao vacinacao : VacinacaoDao.list()) {
            if (Objects.equals(vacinacao.getIdVacinacao(), idVacinacao)) {
                return vacinacao;
            }
        }

        return null;
    }

    public static Vacinacao find(Integer idVacinacao, List<Vacinacao> listaVacinacaoPortador) {
        for (Vacinacao vacinacao : listaVacinacaoPortador) {
            if (Objects.equals(vacinacao.getIdVacinacao(), idVacinacao)) {
                return vacinacao;
            }
        }

        return null;
    }

    public static List<Vacinacao> list() {
        List<Vacinacao> vacinacoes = new ArrayList<Vacinacao>();
        return vacinacoes;
    }

    public static boolean update(Vacinacao vacinacaoNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Vacinacao vacinacao) {
        boolean resultado = false;

        // Delete vacinacao;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
