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
import model.Pessoa;
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

        List<Vacinacao> vacinacoes = new ArrayList<>();
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
            //vacinacoes = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortador);
            rs = ps.executeQuery();

            while (rs.next()) {
                vacina = new Vacina();
                vacinacao = new Vacinacao();

                vacina.setNomeVacina(rs.getString("vacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getString("numerodedoses"));

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

        List<Vacinacao> vacinacoes = new ArrayList<>();
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

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortador);
            rs = ps.executeQuery();

            while (rs.next()) {
                vacina = new Vacina();
                vacinacao = new Vacinacao();

                vacina.setNomeVacina(rs.getString("vacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getString("numerodedoses"));

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
    
    
     //BUSCAR VACINAÇÃO SEM LOGAR POR CÓDIGO
    public static List<Vacinacao> listbyCodigoCert(String codigoCodigoCert) {
        Connection connection = ConnectionFactory.getConnection();

        List<Vacinacao> vacinacoes = new ArrayList<>();
        Vacinacao vacinacao = null;
        Vacina vacina = null;
        Pessoa pessoa = null;
        
        

        String sql = "SELECT pepc.nomepessoa, pepc.sobrenomepessoa, doc.documento, pepc.datadenascimento , apc.codigocivapc, pa.nomedopais , vac.nomevacina ,vacao.doseaplicada \n"
                + "from vacinacao vacao\n"
                + "LEFT JOIN acessopc apc\n"
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
                + "ON en.idpais = pa.idpais\n"
                + "left JOIN codigocertificado codcert\n"
                + "on apc.idacessopc = codcert.idacessopc\n"
                + "LEFT JOIN docs doc\n"
                + "on pepc.idpessoa = doc.idpessoa \n"
                + "WHERE codcert.codigocertificado = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCodigoCert);
            rs = ps.executeQuery();

            while (rs.next()) {
                vacina = new Vacina();
                vacinacao = new Vacinacao();
                pessoa = new Pessoa();
                
                
                //PARA DIRECIONAR PARA CAMPOS
                
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                
                                   
                vacina.setNomeVacina(rs.getString("vacina"));
                vacina.setLaboratorio(rs.getString("laboratorio"));
                vacina.setNumeroDoses(rs.getString("numerodedoses"));
                
                

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

    public static Vacinacao find(int idVacinacao, List<Vacinacao> vacinacoes) {     
        
        for (Vacinacao vacinacao : vacinacoes) {
            if(vacinacao.getIdVacinacao() == idVacinacao){
                return vacinacao;
            }
        }

        return null;
    }

    public static boolean insert(int idAcessoPc, int idAcessoGestao, Vacinacao vacinacao) {
        Connection connection = ConnectionFactory.getConnection();
        Vacina vacina = vacinacao.getVacina();

        boolean resultado = false;

        String sql = "INSERT INTO vacinacao\n"
                + "(idacessopc, idunidade, idacessogestao, idvacina, lote, doseaplicada, datadeaplicacao)\n"
                + "VALUES(?, ?, ?, ?, ?, ?, ?);";
        try {
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idAcessoPc);
            ps.setInt(2, vacinacao.getIdUnidade());
            ps.setInt(3, idAcessoGestao);
            ps.setInt(4, vacina.getIdVacina());
            ps.setString(5, vacina.getLote());
            ps.setString(6, vacinacao.getDoseAplicada());
            ps.setString(7, vacinacao.getDataAplicacao());

            int i = ps.executeUpdate();
            System.err.println("teste add vacina: " + i);

            rs = ps.getGeneratedKeys();

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
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
