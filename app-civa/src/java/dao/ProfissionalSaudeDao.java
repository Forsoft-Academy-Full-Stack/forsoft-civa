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
import model.ProfissionalSaude;
import model.Pessoa;
import model.Supervisor;

/**
 *
 * @author Meliza Maia | Michel Assis
 */
public class ProfissionalSaudeDao {

    public static ProfissionalSaude findByCodigoCiva(String codigoCivaProfissionalSaude) {
        Connection connection = ConnectionFactory.getConnection();
        ProfissionalSaude profissionalSaude = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;

        String sql = "";
        String sql2 = "";

        sql = "SELECT peag.idpessoa,"
                + "   ag.codigocivagestao,"
                + "   peag.nomepessoa,"
                + "   peag.sobrenomepessoa,"
                + "   peag.genero, \n"
                + "   peag.datadenascimento,"
                + "   pa.nomedopais,"
                + "   en.codigopostal,"
                + "   en.tipodelogradouro,"
                + "   en.logradouro,"
                + "   peen.numero,"
                + "   peen.complemento,"
                + "   en.nomesubdivisao3 AS subdivisao1,\n"
                + "   en.nomesubdivisao2 AS subdivisao2,"
                + "   en.nomesubdivisao1 AS subdivisao3,"
                + "   peag.telefonecomddd,"
                + "   ag.emailgestao     \n"
                + "from acessogestao ag\n"
                + "left join pessoa peag \n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "left join docs doc \n"
                + "on peag.idpessoa = doc.idpessoa \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "on peag.idpessoa = peen.idpessoa\n"
                + "left join endereco en \n"
                + "on peen.idendereco = en.idendereco \n"
                + "LEFT join pais pa \n"
                + "on pa.idpais = en.idpais \n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "on doc.idtipodoc = tidoc.idtipodoc \n"
                + "WHERE ag.codigocivagestao = ?;";

        sql2 = "SELECT  tidoc.nomedoc,doc.documento \n"
                + "        FROM acessogestao ag\n"
                + "        left join pessoa peag \n"
                + "        on ag.idpessoa = peag.idpessoa \n"
                + "        left join docs doc \n"
                + "        on peag.idpessoa = doc.idpessoa \n"
                + "        LEFT JOIN tipodoc tidoc \n"
                + "        on doc.idtipodoc = tidoc.idtipodoc \n"
                + "        WHERE ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaProfissionalSaude);
            rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setTelefoneDdd(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailgestao"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));

                // Pegar nacionalidade
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

                endereco = new Endereco();
                endereco.setNomePais(rs.getString("nomedopais"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setTipoLogradouro(rs.getString("tipodelogradouro"));
                endereco.setLogradouro(endereco.getTipoLogradouro() + " " + rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao1"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));

            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaProfissionalSaude);

            rs = ps.executeQuery();

            if (rs.next()) {
                documento1 = new Docs();
                documento1.setNomeTipoDoc(rs.getString("nomedoc"));
                documento1.setDocumento(rs.getString("documento"));
            }

            if (rs.next()) {
                documento2 = new Docs();
                documento2.setNomeTipoDoc(rs.getString("nomedoc"));
                documento2.setDocumento(rs.getString("documento"));
            }

            if (rs.next()) {
                documento3 = new Docs();
                documento3.setNomeTipoDoc(rs.getString("nomedoc"));
                documento3.setDocumento(rs.getString("documento"));
            }

            profissionalSaude = new ProfissionalSaude(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(ProfissionalSaudeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profissionalSaude;
    }

    public static List<ProfissionalSaude> listBySuporteCiva(String codigoCivaSuporte) {
        Connection connection = ConnectionFactory.getConnection();
        List<ProfissionalSaude> profissionaisSaude = new ArrayList<>();
        ProfissionalSaude profissionalSaude;
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
                + "WHERE ag.cargo='Profissional de Saúde'  \n"
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

                profissionalSaude = new ProfissionalSaude();
                profissionalSaude.setPessoa(pessoa);
                profissionalSaude.setDocumento1(documento1);
                profissionalSaude.setCodigoCiva(pessoa.getCodigoCiva());

                profissionaisSaude.add(profissionalSaude);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profissionaisSaude;
    }
    
    public static List<ProfissionalSaude> listBySupervisor(String codigoSupervisor) {
        Connection connection = ConnectionFactory.getConnection();
        List<ProfissionalSaude> profissionaisSaude = null;
        ProfissionalSaude profissionalsaude;
        Pessoa pessoa;
        Docs documento1;

        String sql = "SELECT peag.nomepessoa AS nome,\n"
                + "                  peag.sobrenomepessoa AS sobrenome,\n"
                + "	              doc.documento AS documento,\n"
                + "                   peag.datadenascimento AS datanascimento,\n"
                + "	              ag.codigocivagestao AS codigociva\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "on peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "on ag.idpessoa = peag.idpessoa\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "ON ag.idacessogestao = aguni.idacessogestao\n"
                + "WHERE ag.cargo = 'Profissional de Saúde'\n"
                + "	AND tidoc.nivel ='Primário'\n"
                + "	AND aguni.idunidade IN ( SELECT uni.idunidade from unidade uni\n"
                + "					LEFT JOIN acessogestao_unidade aguni\n"
                + "					ON uni.idunidade = aguni.idunidade\n"
                + "                                     LEFT JOIN acessogestao ag\n"
                + "                                     ON aguni.idacessogestao = ag.idacessogestao\n"
                + "					WHERE ag.codigocivagestao = ?)\n"
                + " ";

        try {
            profissionaisSaude = new ArrayList<>();

            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoSupervisor);
            rs = ps.executeQuery();

            while (rs.next()) {

                pessoa = new Pessoa();
                documento1 = new Docs();
                profissionalsaude = new ProfissionalSaude();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                documento1.setDocumento(rs.getString("documento"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));

                profissionalsaude.setPessoa(pessoa);
                profissionalsaude.setDocumento1(documento1);
                profissionalsaude.setCodigoCiva(rs.getString("codigociva"));

                profissionaisSaude.add(profissionalsaude);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profissionaisSaude;

    }

    public static List<ProfissionalSaude> listByUnidade(Integer idUnidade) {
        Connection connection = ConnectionFactory.getConnection();
        List<ProfissionalSaude> profissionaisSaude = null;
        ProfissionalSaude profissionalsaude;
        Pessoa pessoa;
        Docs documento1;
        
        String sql = "";
        sql = "SELECT peag.nomepessoa AS nome,\n"
                + "	   peag.sobrenomepessoa AS sobrenome,\n"
                + "	   doc.documento AS documento,\n"
                + "	   peag.datadenascimento AS datanascimento,\n"
                + "	   ag.codigocivagestao AS codigociva\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc\n"
                + "on peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "LEFT JOIN acessogestao ag \n"
                + "on ag.idpessoa = peag.idpessoa\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "ON ag.idacessogestao = aguni.idacessogestao\n"
                + "WHERE ag.cargo = 'Profissional de Saúde'\n"
                + "AND tidoc.nivel ='Primário'\n"
                + "AND aguni.idunidade IN ( SELECT uni.idunidade from unidade uni\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "ON uni.idunidade = aguni.idunidade\n"
                + "LEFT JOIN acessogestao ag\n"
                + "ON aguni.idacessogestao = ag.idacessogestao\n"
                + "WHERE uni.idunidade = ?)";
        
         try {
            profissionaisSaude = new ArrayList<>();

            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idUnidade);
            rs = ps.executeQuery();

            while (rs.next()) {

                pessoa = new Pessoa();
                documento1 = new Docs();
                profissionalsaude = new ProfissionalSaude();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                documento1.setDocumento(rs.getString("documento"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));

                profissionalsaude.setPessoa(pessoa);
                profissionalsaude.setDocumento1(documento1);
                profissionalsaude.setCodigoCiva(rs.getString("codigociva"));

                profissionaisSaude.add(profissionalsaude);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return profissionaisSaude;

    }

    public static boolean insert(ProfissionalSaude profissionalsaude) {
        boolean resultado = false;

        // Insert into ProfissionalSaude values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static ProfissionalSaude find(String codigoCivaProfissionalSaude) {
        return null;
    }

    public static List<ProfissionalSaude> list() {
        List<ProfissionalSaude> profissionaisSaude = new ArrayList<ProfissionalSaude>();
        return profissionaisSaude;
    }

    public static boolean update(ProfissionalSaude profissionalsaudeNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(ProfissionalSaude profissionalsaude) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
