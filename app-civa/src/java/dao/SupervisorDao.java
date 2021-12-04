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
import model.Endereco;
import model.Pais;
import model.Pessoa;
import model.Supervisor;

/**
 *
 * @author randel
 */
public class SupervisorDao {

    public static boolean insert(Supervisor supervisor) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Supervisor findByCodigoCiva(String codigoCivaSupervisor) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String sql2 = "";
        Supervisor supervisor = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;

        sql = "SELECT ag.codigocivagestao AS codigociva,\n"
                + "	   peag.nomepessoa AS nome,\n"
                + "	   peag.idpessoa,\n"
                + "       peag.sobrenomepessoa AS sobrenome,\n"
                + "       peag.genero,\n"
                + "       peag.datadenascimento, \n"
                + "	   pa.nomedopais AS pais, \n"
                + "       en.codigopostal,\n"
                + "       en.tipodelogradouro,\n"
                + "       en.logradouro,\n"
                + "       peen.numero,\n"
                + "       peen.complemento,\n"
                + "       en.nomesubdivisao1 AS subdivisao3, \n"
                + "       en.nomesubdivisao2 AS subdivisao2, \n"
                + "       en.nomesubdivisao3 AS subdivisao1, \n"
                + "	   peag.telefonecomddd,\n"
                + "       ag.emailgestao \n"
                + "FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON peag.idpessoa = ag.idpessoa  \n"
                + "LEFT JOIN pais pa \n"
                + "ON peag.idpaisdenascimento = pa.idpais          \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa  \n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "WHERE ag.cargo = 'Supervisor' \n"
                + "AND ag.codigocivagestao = ?;";

        sql2 = "SELECT tidoc.nomedoc,\n"
                + "       doc.documento\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON peag.idpessoa = ag.idpessoa \n"
                + "LEFT JOIN docs doc\n"
                + "ON doc.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN tipodoc tidoc\n"
                + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "WHERE ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSupervisor);
            rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setTelefoneDdd(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailgestao"));

                // Pegar nacionalidade
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

                endereco = new Endereco();
                endereco.setNomePais(rs.getString("pais"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setTipoLogradouro(rs.getString("tipodelogradouro"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao1"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaSupervisor);
            rs = ps.executeQuery();

            if (rs.next()) {
                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));
                documento1.setNomeTipoDoc(rs.getString("nomedoc"));
            }

            if (rs.next()) {
                documento2 = new Docs();
                documento2.setDocumento(rs.getString("documento"));
                documento2.setNomeTipoDoc(rs.getString("nomedoc"));
            }

            if (rs.next()) {
                documento3 = new Docs();
                documento3.setDocumento(rs.getString("documento"));
                documento3.setNomeTipoDoc(rs.getString("nomedoc"));
            }

            supervisor = new Supervisor(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return supervisor;
    }

    public static List<Supervisor> listByUnidade(Integer idUnidade) {
        Connection connection = ConnectionFactory.getConnection();
        List<Supervisor> supervisores = new ArrayList<Supervisor>();
        Supervisor supervisor;
        Pessoa pessoa = null;
        Docs documento1 = null;

        String sql = "";

        sql = "SELECT peag.nomepessoa AS nome,\n"
                + "       peag.sobrenomepessoa AS sobrenome,\n"
                + "       doc.documento,\n"
                + "       peag.datadenascimento,\n"
                + "       ag.codigocivagestao AS codigociva\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "ON peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON ag.idpessoa = peag.idpessoa\n"
                + "LEFT JOIN acessogestao_unidade aguni \n"
                + "ON ag.idacessogestao = aguni.idacessogestao \n"
                + "WHERE ag.cargo='Supervisor'  \n"
                + "AND tidoc.nivel = 'Primário'\n"
                + "AND aguni.idunidade IN \n"
                + "(SELECT uni.idunidade from unidade uni\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "ON uni.idunidade = aguni.idunidade\n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON aguni.idacessogestao = ag.idacessogestao \n"
                + "WHERE uni.idunidade = ?);";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idUnidade);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));

                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));

                supervisor = new Supervisor();
                supervisor.setPessoa(pessoa);
                supervisor.setDocumento1(documento1);
                supervisor.setCodigoCiva(pessoa.getCodigoCiva());

                supervisores.add(supervisor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return supervisores;
    }

    public static List<Supervisor> listByGerente(String codigoCivaGerente) {
        Connection connection = ConnectionFactory.getConnection();
        List<Supervisor> supervisores = new ArrayList<>();
        Supervisor supervisor = null;
        Pessoa pessoa = null;
        Docs documento1 = null;

        String sql = "";

        sql = "SELECT peag.nomepessoa AS nome,\n"
                + "	   peag.sobrenomepessoa AS sobrenome,\n"
                + "	   doc.documento,\n"
                + "	   peag.datadenascimento,\n"
                + "	  ag.codigocivagestao AS codigociva\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "ON peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON ag.idpessoa = peag.idpessoa\n"
                + "LEFT JOIN acessogestao_unidade aguni \n"
                + "ON ag.idacessogestao = aguni.idacessogestao \n"
                + "WHERE ag.cargo='Supervisor'  \n"
                + "AND tidoc.nivel = 'Primário'\n"
                + "AND aguni.idunidade = \n"
                + "(SELECT uni.idunidade from unidade uni\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "ON uni.idunidade = aguni.idunidade\n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON aguni.idacessogestao = ag.idacessogestao \n"
                + "WHERE ag.codigocivagestao = ?);";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGerente);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));           

                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));

                supervisor = new Supervisor();
                supervisor.setPessoa(pessoa);
                supervisor.setDocumento1(documento1);
                supervisor.setCodigoCiva(pessoa.getCodigoCiva());

                supervisores.add(supervisor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return supervisores;
    }

    public static List<Supervisor> listBySuporteCiva(String codigoCivaSuporte) {
        Connection connection = ConnectionFactory.getConnection();
        List<Supervisor> supervisores = new ArrayList<Supervisor>();
        Supervisor supervisor;
        Pessoa pessoa = null;
        Docs documento1 = null;

        String sql = "";

        sql = "SELECT peag.nomepessoa AS nome,\n"
                + "	   peag.sobrenomepessoa AS sobrenome,\n"
                + "       doc.documento,\n"
                + "       peag.datadenascimento,\n"
                + "       ag.codigocivagestao AS codigociva\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "ON peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON ag.idpessoa = peag.idpessoa\n"
                + "WHERE ag.cargo='Supervisor'  \n"
                + "AND tidoc.nivel = 'Primário'\n"
                + "AND ag.codigocivagestao LIKE \n"
                + "CONCAT( \n"
                + "(SELECT pa.sigla FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa\n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "LEFT JOIN pais pa \n"
                + "ON en.idpais = pa.idpais  \n"
                + "WHERE ag.codigocivagestao = ?),'%');";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSuporte);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));

                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));

                supervisor = new Supervisor();
                supervisor.setPessoa(pessoa);
                supervisor.setDocumento1(documento1);
                supervisor.setCodigoCiva(pessoa.getCodigoCiva());

                supervisores.add(supervisor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return supervisores;
    }

    // Refazer
    public static List<Supervisor> list(String codigoCivaGerente) {
        Connection connection = ConnectionFactory.getConnection();
        List<Supervisor> supervisores = new ArrayList<Supervisor>();
        Supervisor supervisor;
        Pessoa pessoa = null;
        Docs documento1 = null;

        String sql = "";

        sql = "SELECT peag.nomepessoa AS nome,\n"
                + "       peag.sobrenomepessoa AS sobrenome,\n"
                + "       doc.documento,\n"
                + "       peag.datadenascimento,\n"
                + "       ag.codigocivagestao AS codigociva\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "ON peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON ag.idpessoa = peag.idpessoa\n"
                + "LEFT JOIN acessogestao_unidade aguni \n"
                + "ON ag.idacessogestao = aguni.idacessogestao \n"
                + "WHERE ag.cargo='Supervisor'  \n"
                + "AND tidoc.nivel = 'Primário'\n"
                + "AND aguni.idunidade IN \n"
                + "(SELECT uni.idunidade from unidade uni\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "ON uni.idunidade = aguni.idunidade\n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON aguni.idacessogestao = ag.idacessogestao \n"
                + "WHERE ag.codigocivagestao = ?);";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGerente);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));

                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));

                supervisor = new Supervisor();
                supervisor.setPessoa(pessoa);
                supervisor.setDocumento1(documento1);
                supervisor.setCodigoCiva(pessoa.getCodigoCiva());

                supervisores.add(supervisor);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return supervisores;
    }

    public static boolean update(Supervisor supervisorNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(String codigoCivaSupervisor) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
}
