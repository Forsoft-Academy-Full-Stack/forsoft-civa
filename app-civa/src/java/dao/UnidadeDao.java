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
import model.Endereco;
import model.Pais;
import model.Unidade;

/**
 *
 * @author randel
 */
public class UnidadeDao {
    
    public static List<Unidade> listUnidadeSuporteCiva(String codigoCivaSuporte) {
        Connection connection = ConnectionFactory.getConnection();
        List<Unidade> unidades = null;
        Unidade unidade = null;
        Endereco endereco = null;

        String sql = "";
        sql = "SELECT uni.nomeunidade,\n"
                + "   uni.idunidade,\n"
                + "   en.nomesubdivisao1 AS subdivisao3,\n"
                + "   en.nomesubdivisao2 AS subdivisao2,\n"
                + "   en.codigopostal,\n"
                + "   uni.registrodaunidade\n"
                + "FROM unidade uni\n"
                + "left join acessogestao_unidade aguni \n"
                + "on uni.idunidade = aguni.idunidade \n"
                + "left join endereco en \n"
                + "on uni.idendereco = en.idendereco \n"
                + "LEFT JOIN acessogestao ag\n"
                + "on ag.idacessogestao = aguni.idacessogestao  \n"
                + "LEFT JOIN pessoa peag \n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "Where ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            unidades = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSuporte);
            rs = ps.executeQuery();

            while (rs.next()) {
                unidade = new Unidade();
                endereco = new Endereco();

                unidade.setIdUnidade(rs.getInt("idunidade"));
                unidade.setNome(rs.getString("nomeunidade"));

                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));

                unidade.setEndereco(endereco);

                unidades.add(unidade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidades;
    }

    public static List<Unidade> listUnidadeBySupervisor(String codigoCivaSupervisor) {
        Connection connection = ConnectionFactory.getConnection();
        List<Unidade> unidades = null;
        Unidade unidade = null;
        Endereco endereco = null;

        String sql = "";
        sql = "SELECT uni.nomeunidade,\n"
                + "   uni.idunidade,\n"
                + "   en.nomesubdivisao1 AS subdivisao3,\n"
                + "   en.nomesubdivisao2 AS subdivisao2,\n"
                + "   en.codigopostal,\n"
                + "   uni.registrodaunidade\n"
                + "FROM unidade uni\n"
                + "left join acessogestao_unidade aguni \n"
                + "on uni.idunidade = aguni.idunidade \n"
                + "left join endereco en \n"
                + "on uni.idendereco = en.idendereco \n"
                + "LEFT JOIN acessogestao ag\n"
                + "on ag.idacessogestao = aguni.idacessogestao  \n"
                + "LEFT JOIN pessoa peag \n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "Where ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            unidades = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSupervisor);
            rs = ps.executeQuery();

            while (rs.next()) {
                unidade = new Unidade();
                endereco = new Endereco();

                unidade.setIdUnidade(rs.getInt("idunidade"));
                unidade.setNome(rs.getString("nomeunidade"));

                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));

                unidade.setEndereco(endereco);

                unidades.add(unidade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidades;
    }

    public static List<Unidade> listUnidadeByProfissionalSaude(String codigoCivaProfissionalSaude) {
        Connection connection = ConnectionFactory.getConnection();
        List<Unidade> unidades = null;
        Unidade unidade = null;
        Endereco endereco = null;

        String sql = "";
        sql = "SELECT uni.nomeunidade,\n"
                + "   uni.idunidade,\n"
                + "   en.nomesubdivisao1 AS subdivisao3,\n"
                + "   en.codigopostal,\n"
                + "   uni.registrodaunidade\n"
                + "FROM unidade uni\n"
                + "left join acessogestao_unidade aguni \n"
                + "on uni.idunidade = aguni.idunidade \n"
                + "left join endereco en \n"
                + "on uni.idendereco = en.idendereco \n"
                + "LEFT JOIN acessogestao ag\n"
                + "on ag.idacessogestao = aguni.idacessogestao  \n"
                + "LEFT JOIN pessoa peag \n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "Where ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            unidades = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaProfissionalSaude);
            rs = ps.executeQuery();

            while (rs.next()) {
                unidade = new Unidade();
                endereco = new Endereco();

                unidade.setIdUnidade(rs.getInt("idunidade"));
                unidade.setNome(rs.getString("nomeunidade"));

                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));

                unidade.setEndereco(endereco);

                unidades.add(unidade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidades;
    }

    public static List<Unidade> listUnidadeByGestorNacional(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();
        List<Unidade> unidades = null;
        Unidade unidade = null;
        Endereco endereco = null;

        String sql = "";
        sql = "SELECT uni.nomeunidade, en.nomesubdivisao1 AS subdivisao3, en.nomesubdivisao2 AS subdivisao2,\n"
                + "    en.codigopostal, uni.idunidade FROM unidade uni\n"
                + "    LEFT JOIN endereco en \n"
                + "        ON uni.idendereco = en.idendereco\n"
                + "    LEFT JOIN pais pa \n"
                + "        ON en.idpais = pa.idpais \n"
                + "    WHERE pa.idpais=(\n"
                + "    SELECT peag.idpaisdenascimento FROM pessoa peag\n"
                + "    LEFT JOIN acessogestao ag\n"
                + "    ON peag.idpessoa = ag.idpessoa\n"
                + "    WHERE ag.codigocivagestao = ?)";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            unidades = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            while (rs.next()) {
                unidade = new Unidade();
                endereco = new Endereco();

                unidade.setIdUnidade(rs.getInt("idunidade"));
                unidade.setNome(rs.getString("nomeunidade"));

                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));

                unidade.setEndereco(endereco);

                unidades.add(unidade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidades;
    }

    public static List<Unidade> listUnidadeByGerente(String codigoCivaGerente) {
        Connection connection = ConnectionFactory.getConnection();
        List<Unidade> unidades = null;
        Unidade unidade = null;
        Endereco endereco = null;

        String sql = "SELECT uni.idunidade AS identificador, \n"
                + "       nomeunidade AS nome,\n"
                + "       en.nomesubdivisao1 AS subdivisao3,\n"
                + "       en.nomesubdivisao2 AS subdivisao2,\n"
                + "       en.codigopostal\n"
                + "FROM unidade uni \n"
                + "LEFT JOIN endereco en  \n"
                + "	ON uni.idendereco = en.idendereco\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "	ON uni.idunidade = aguni.idunidade \n"
                + "LEFT JOIN acessogestao ag\n"
                + "	ON aguni.idacessogestao = ag.idacessogestao \n"
                + "WHERE ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            unidades = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGerente);
            rs = ps.executeQuery();

            while (rs.next()) {
                unidade = new Unidade();
                endereco = new Endereco();

                unidade.setIdUnidade(rs.getInt("identificador"));
                unidade.setNome(rs.getString("nome"));

                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));

                unidade.setEndereco(endereco);

                unidades.add(unidade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidades;
    }

  

    public static Unidade findById(Integer idUnidade) {
        Connection connection = ConnectionFactory.getConnection();
        Unidade unidade = null;
        Endereco endereco = null;
        String sql = "";
        String sql2 = "";

        sql = "SELECT DISTINCT  uni.nomeunidade,\n"
                + "		uni.registrodaunidade,\n"
                + "		uni.natureza,\n"
                + "		uni.tipodeestabelecimento,\n"
                + "		pa.nomedopais,\n"
                + "		en.codigopostal,\n"
                + "		en.tipodelogradouro,\n"
                + "		en.logradouro,\n"
                + "		uni.numeroendereco,\n"
                + "		uni.situacao,\n"
                + "		en.nomesubdivisao3 AS subdivisao1,\n"
                + "		en.nomesubdivisao2 AS subdivisao2,\n"
                + "		en.nomesubdivisao1 AS subdivisao3,\n"
                + "		uni.contato,\n"
                + "		uni.locacao \n"
                + "FROM unidade uni\n"
                + "    LEFT JOIN endereco en \n"
                + "    ON uni.idendereco = en.idendereco\n"
                + "    LEFT JOIN pais pa \n"
                + "    ON en.idpais = pa.idpais\n"
                + "    WHERE uni.idunidade = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idUnidade);
            rs = ps.executeQuery();

            endereco = new Endereco();
            unidade = new Unidade();

            if (rs.next()) {
                endereco.setNomePais(rs.getString("nomedopais"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setTipoLogradouro(rs.getString("tipodelogradouro"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao1"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setNumero(rs.getString("numeroendereco"));

                unidade.setNome(rs.getString("nomeunidade"));
                unidade.setRegistro(rs.getString("registrodaunidade"));
                unidade.setNatureza(rs.getString("natureza"));
                unidade.setTipoEstabelecimento(rs.getString("tipodeestabelecimento"));
                unidade.setSituacao(rs.getString("situacao"));
                unidade.setContato(rs.getString("contato"));
                unidade.setLocacao(rs.getString("locacao"));
                unidade.setEndereco(endereco);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidade;
    }

    public static boolean insert(Pais pais) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static List<Unidade> list() {

        return null;
    }

    public static boolean update(Unidade unidadeNova) {
        boolean resultado = false;

        // Update unidade;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Unidade unidade) {
        boolean resultado = false;

        // Delete unidade;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
