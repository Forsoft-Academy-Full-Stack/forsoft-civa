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
import model.Gerente;
import model.Pais;
import model.Pessoa;

/**
 *
 * @author Rafael Marçal | Antonio Henrique
 */
public class GerenteDao {

    public static Gerente findByCodigoCiva(String codigoCivaGerente) {
        Connection connection = ConnectionFactory.getConnection();

        Gerente gerente = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;

        String sql = "SELECT ag.codigocivagestao AS codigociva,\n"
                + "       peag.nomepessoa AS nome, peag.idpessoa,\n"
                + "       peag.sobrenomepessoa AS sobrenome,\n"
                + "       peag.genero,\n"
                + "       peag.datadenascimento AS datanascimento,\n"
                + "       pa.nomedopais AS pais,\n"
                + "       en.codigopostal,\n"
                + "       en.logradouro,\n"
                + "       en.tipodelogradouro AS tipologradouro,\n"
                + "       peen.numero, peen.complemento, \n"
                + "       en.nomesubdivisao1 AS subdivisao3,\n"
                + "       en.nomesubdivisao2  AS subdivisao2,\n"
                + "       en.nomesubdivisao3  AS subdivisao1, \n"
                + "	   peag.telefonecomddd AS contato,\n"
                + "       ag.emailgestao AS email\n"
                + "FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "	ON peag.idpessoa = ag.idpessoa  \n"
                + "LEFT JOIN pais pa \n"
                + "	ON peag.idpaisdenascimento = pa.idpais          \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "	ON peag.idpessoa = peen.idpessoa  \n"
                + "LEFT JOIN endereco en \n"
                + "	ON peen.idendereco = en.idendereco \n"
                + "WHERE ag.cargo = 'Gerente' \n"
                + "AND ag.codigocivagestao = ?;";

        String sql2 = "SELECT tidoc.nomedoc AS tipoDocumento,\n"
                + "        doc.documento\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag \n"
                + "	ON peag.idpessoa = ag.idpessoa \n"
                + "LEFT JOIN docs doc\n"
                + "	ON doc.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN tipodoc tidoc\n"
                + "	ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "WHERE ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);

            ps.setString(1, codigoCivaGerente);

            rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));
                pessoa.setTelefoneDdd(rs.getString("contato"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));

                // Pegar nacionalidade
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

                endereco = new Endereco();
                endereco.setNomePais(rs.getString("pais"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setTipoLogradouro(rs.getString("tipologradouro"));
                endereco.setLogradouro(endereco.getTipoLogradouro() + " " + rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao1"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaGerente);

            rs = ps.executeQuery();

            if (rs.next()) {
                documento1 = new Docs();
                documento1.setNomeTipoDoc(rs.getString("tipoDocumento"));
                documento1.setDocumento(rs.getString("documento"));
            }

            if (rs.next()) {
                documento2 = new Docs();
                documento2.setNomeTipoDoc(rs.getString("tipoDocumento"));
                documento2.setDocumento(rs.getString("documento"));
            }

            if (rs.next()) {
                documento3 = new Docs();
                documento3.setNomeTipoDoc(rs.getString("tipoDocumento"));
                documento3.setDocumento(rs.getString("documento"));
            }

            gerente = new Gerente(pessoa, endereco, pessoa.getCodigoCiva(), documento1, documento2, documento3);

        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gerente;
    }

    public static List<Gerente> listBySuporteCiva(String codigoCivaSuporte) {
        Connection connection = ConnectionFactory.getConnection();
        List<Gerente> gerentes = null;
        Gerente gerente;
        Pessoa pessoa;
        Docs documento1;

        String sql = "SELECT peag.nomepessoa AS nome,\n"
                + "        peag.sobrenomepessoa,\n"
                + "        doc.documento,\n"
                + "        peag.datadenascimento AS datanascimento,\n"
                + "        ag.codigocivagestao AS codigociva\n"
                + "\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "ON peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON ag.idpessoa = peag.idpessoa\n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa \n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "WHERE ag.cargo='Gerente'  \n"
                + "AND tidoc.nivel = 'Primário'\n"
                + "AND en.idpais = \n"
                + "(SELECT en.idpais FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa =peen.idpessoa\n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco =en.idendereco \n"
                + "WHERE ag.codigocivagestao = ? /*Código CIVA do Suporte Logado*/);"
                + " ";

        try {
            gerentes = new ArrayList<>();

            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSuporte);
            rs = ps.executeQuery();

            while (rs.next()) {
                gerente = new Gerente();
                pessoa = new Pessoa();
                documento1 = new Docs();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                documento1.setDocumento(rs.getString("documento"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));

                gerente.setPessoa(pessoa);
                gerente.setDocumento1(documento1);
                gerente.setCodigoCiva(rs.getString("codigociva"));

                gerentes.add(gerente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gerentes;

    }

    public static List<Gerente> listByGestorNacional(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();
        List<Gerente> gerentes = null;
        Gerente gerente;
        Pessoa pessoa;
        Docs documento1;

        String sql = "SELECT DISTINCT peag.nomepessoa AS nome,\n"
                + "	              doc.documento AS documento,\n"
                + "                   peag.datadenascimento AS datanascimento,\n"
                + "	              ag.codigocivagestao AS codigociva\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "on peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "on peag.idpessoa = ag.idpessoa\n"
                + "WHERE ag.cargo = 'Gerente'\n"
                + "	AND tidoc.nivel ='Primário'\n"
                + "	AND peag.idpaisdenascimento = ( SELECT peag.idpaisdenascimento FROM pessoa peag\n"
                + "					LEFT JOIN acessogestao ag\n"
                + "					ON peag.idpessoa = ag.idpessoa\n"
                + "					WHERE ag.codigocivagestao = ?)\n"
                + " ";

        try {
            gerentes = new ArrayList<>();

            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            while (rs.next()) {
                gerente = new Gerente();
                pessoa = new Pessoa();
                documento1 = new Docs();

                pessoa.setNomePessoa(rs.getString("nome"));
                documento1.setDocumento(rs.getString("documento"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));

                gerente.setPessoa(pessoa);
                gerente.setDocumento1(documento1);
                gerente.setCodigoCiva(rs.getString("codigociva"));

                gerentes.add(gerente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gerentes;

    }

    public static List<Gerente> listByIdUnidade(Integer idUnidade) {
        Connection connection = ConnectionFactory.getConnection();
        List<Gerente> gerentes = null;
        Gerente gerente;
        Pessoa pessoa;
        Docs documento1;

        String sql = "";
        sql = "   SELECT peag.nomepessoa,  peag.sobrenomepessoa, \n"
                + "	      doc.documento,\n"
                + "           ag.codigocivagestao\n"
                + "	FROM pessoa peag \n"
                + "    LEFT JOIN acessogestao ag \n"
                + "        ON peag.idpessoa = ag.idpessoa  \n"
                + "    LEFT JOIN docs doc \n"
                + "        ON peag.idpessoa = doc.idpessoa  \n"
                + "    LEFT JOIN acessogestao_unidade aguni \n"
                + "        ON ag.idacessogestao = aguni.idacessogestao  \n"
                + "    LEFT JOIN unidade uni \n"
                + "        ON aguni.idunidade = uni.idunidade  \n"
                + "    LEFT JOIN tipodoc tidoc \n"
                + "        ON doc.idtipodoc = tidoc.idtipodoc  \n"
                + "    WHERE uni.idunidade = ?\n"
                + "    AND tidoc.nivel = 'Primário'\n"
                + "    AND ag.cargo = 'Gerente';";

        try {
            gerentes = new ArrayList<>();

            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idUnidade);
            rs = ps.executeQuery();

            while (rs.next()) {
                gerente = new Gerente();

                pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));

                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));

                gerente.setPessoa(pessoa);
                gerente.setDocumento1(documento1);
                gerente.setCodigoCiva(pessoa.getCodigoCiva());

                gerentes.add(gerente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GerenteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gerentes;
    }

    public static boolean insert(Gerente gerente) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static boolean update(Gerente gerente) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Gerente gerente) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static List<Gerente> list() {
        List<Gerente> gerentes = new ArrayList<>();
        return gerentes;
    }

}
