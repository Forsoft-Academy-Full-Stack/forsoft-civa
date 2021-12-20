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
        sql = "SELECT distinct u.nomeunidade,\n"
                + "				u.idunidade,\n"
                + "				en.nomesubdivisao1 AS subdivisao3,\n"
                + "				en.nomesubdivisao2 AS subdivisao2,\n"
                + "				en.codigopostal,\n"
                + "				u.registrodaunidade\n"
                + "FROM unidade as u\n"
                + "left join endereco as en\n"
                + "on u.idendereco = en.idendereco\n"
                + "left join pais as pa\n"
                + "on en.idpais = pa.idpais\n"
                + "where pa.idpais = (select pa.idpais from pessoa AS pe\n"
                + "		  left join acessogestao AS ag\n"
                + "		  on pe.idpessoa = ag.idpessoa\n"
                + "		  left join pessoa_endereco AS pen\n"
                + "		  on pen.idpessoa = pe.idpessoa\n"
                + "		  left join endereco as en\n"
                + "		  on pen.idendereco = en.idendereco\n"
                + "		  left join pais as pa\n"
                + "		  on en.idpais = pa.idpais	\n"
                + "		  Where ag.codigocivagestao = ?)";

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
        sql = "SELECT distinct uni.nomeunidade,\n"
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
                + "Where ag.codigocivagestao = ? AND aguni.status = true;";

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

    public static boolean insertProficionalUnidade(int idUnidade, int idacessoGestao) {

        Connection connection = ConnectionFactory.getConnection();

        boolean resultado = false;

        String sql = "INSERT INTO acessogestao_unidade\n"
                + "(idunidade, idacessogestao, status)\n"
                + "VALUES(?, ?, 1);";

        int idGestaoUnidadeExistente = UnidadeDao.getIdGestaoUnidade(idUnidade, idacessoGestao);

        if (idGestaoUnidadeExistente == -1) {
            try {
                ResultSet rs = null;

                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setInt(1, idUnidade);
                ps.setInt(2, idacessoGestao);

                int i = ps.executeUpdate();
                System.err.println("teste: " + i);

                rs = ps.getGeneratedKeys();

                resultado = true;

            } catch (SQLException ex) {
                Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return resultado;
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

    public static boolean insert(Unidade unidade) {
        int idEndereco = -1;
        Endereco endereco = unidade.getEndereco();
        try {
            idEndereco = EnderecoDao.insert(endereco);
        } catch (Exception e) {
            System.err.println("Deu ruim");
        }

        System.err.println(idEndereco);

        Connection connection = ConnectionFactory.getConnection();

        boolean resultado = false;

        String sql = "INSERT INTO unidade\n"
                + "(idendereco, numeroendereco, nomeunidade, contato, locacao, natureza, tipodeestabelecimento, situacao, datadecadastro, registrodaunidade)\n"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idEndereco);
            ps.setString(2, endereco.getNumero());
            ps.setString(3, unidade.getNome());
            ps.setString(4, unidade.getContato());
            ps.setString(5, unidade.getLocacao());
            ps.setString(6, unidade.getNatureza());
            ps.setString(7, unidade.getTipoEstabelecimento());
            ps.setString(8, unidade.getSituacao());
            ps.setString(9, unidade.getDataCadastro());
            ps.setString(10, unidade.getRegistro());

            int i = ps.executeUpdate();
            System.err.println("teste: " + i);

            rs = ps.getGeneratedKeys();

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public static int getIdEndereco(int idUnidade) {
        Connection connection = ConnectionFactory.getConnection();
        int idEndereco = -1;
        String sql = "SELECT en.idendereco\n"
                + "FROM endereco AS en\n"
                + "LEFT JOIN unidade AS uni\n"
                + "on en.idendereco = uni.idendereco\n"
                + "WHERE uni.idunidade = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idUnidade);
            rs = ps.executeQuery();

            if (rs.next()) {
                idEndereco = rs.getInt("idendereco");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idEndereco;
    }

    public static int getIdGestaoUnidade(int idUnidade, int idAcessoGestao) {
        Connection connection = ConnectionFactory.getConnection();
        int idGestaoUnidade = -1;
        String sql = "SELECT idgestaounidade\n"
                + "FROM acessogestao_unidade \n"
                + "WHERE idunidade = ? AND idacessogestao = ? AND status = true;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idUnidade);
            ps.setInt(2, idAcessoGestao);
            rs = ps.executeQuery();

            if (rs.next()) {
                idGestaoUnidade = rs.getInt("idgestaounidade");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idGestaoUnidade;
    }

    public static boolean deleteGestaoUnidade(int idGestaoUnidade) {
        Connection connection = ConnectionFactory.getConnection();

        boolean resultado = false;

        String sql = "UPDATE acessogestao_unidade SET status=?\n"
                + "WHERE idgestaounidade = ?;";

        if (idGestaoUnidade != -1) {

            try {
                ResultSet rs = null;

                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setInt(1, 0);
                ps.setInt(2, idGestaoUnidade);

                ps.executeUpdate();

                resultado = true;

            } catch (SQLException ex) {
                Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;

    }

    public static boolean update(Unidade unidadeNova) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;

        Endereco endereco = unidadeNova.getEndereco();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "UPDATE unidade\n"
                    + "SET numeroendereco=?, nomeunidade=?, contato=?, locacao=?, natureza=?, tipodeestabelecimento=?, situacao=?, datadecadastro=?, registrodaunidade=?\n"
                    + "WHERE idunidade=?;";

            ps = connection.prepareStatement(sql);

            ps.setString(1, unidadeNova.getNumero());
            ps.setString(2, unidadeNova.getNome());
            ps.setString(3, unidadeNova.getContato());
            ps.setString(4, unidadeNova.getLocacao());
            ps.setString(5, unidadeNova.getNatureza());
            ps.setString(6, unidadeNova.getTipoEstabelecimento());
            ps.setString(7, unidadeNova.getSituacao());
            ps.setString(8, unidadeNova.getDataCadastro());
            ps.setString(9, unidadeNova.getRegistro());
            ps.setInt(10, unidadeNova.getIdUnidade());

            ps.executeUpdate();

            // Atualiza os dados endereco
            Boolean enderecoResult = EnderecoDao.update(endereco);

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
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

    public static List<Unidade> getUnidadesVacinacao(String codigoCivaPortador) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT uni.nomeunidade, en.codigopostal\n"
                + "FROM vacinacao AS vac\n"
                + "LEFT JOIN unidade AS uni\n"
                + "ON vac.idunidade = uni.idunidade\n"
                + "LEFT JOIN endereco AS en\n"
                + "ON uni.idendereco = en.idendereco\n"
                + "LEFT JOIN acessopc AS acp\n"
                + "ON vac.idacessopc = acp.idacessopc\n"
                + "WHERE acp.codigocivapc LIKE ?; ";

        List<Unidade> unidadesVacinacao = new ArrayList<>();
        Unidade unidade = null;

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortador);
            rs = ps.executeQuery();

            while (rs.next()) {
                unidade = new Unidade();
                Endereco endereco = new Endereco();

                unidade.setNome(rs.getString("nomeunidade"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                unidade.setEndereco(endereco);

                unidadesVacinacao.add(unidade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VacinacaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidadesVacinacao;

    }

}
