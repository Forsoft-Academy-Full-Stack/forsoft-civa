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
                + "       peag.nomepessoa AS nome,\n"
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
                + "       en.nomesubdivisao3  AS subdivisao, \n"
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
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));
                pessoa.setTelefoneDdd(rs.getString("contato"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));

                endereco = new Endereco();
                endereco.setNomePais(rs.getString("pais"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setTipoLogradouro(rs.getString("tipologradouro"));
                endereco.setLogradouro(endereco.getTipoLogradouro() +" "+ rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao"));
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
        List<Gerente> gerentes = new ArrayList<Gerente>();

        // Início Genrente 1 //
        //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
        //String sobrenomePessoa, String dataNascimento, String ddiContato,
        //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa = new Pessoa(22, 1, "Brasileira", "Maria", "Ferreira de Almeida", "1980-08-02", "+55", "mariaferreira@gmail.com", "987898758", "mulher cis", "BR89855455");

        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento1 = new Docs(20, "99383946577", 22, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");
        Docs documento2 = new Docs(21, "21676786876", 22, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");
        Docs documento3 = new Docs(22, "06543456478", 22, 3, "CPF", "1946-07-5", "09878765678", "Civil");

        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco = new Endereco(22, 22, "Brasil", "Rua", "Rua Alvorada", "58665645", "Apto 20", "Vila Nova", "Aracaju", "Sergipe", "", "", "", "", "20");

        // Pessoa pessoa3, Docs documento1, Docs documento2, Docs documento3,
        // Endereco endereco, String codigoCiva      
        Gerente gerente = new Gerente(pessoa, endereco, pessoa.getCodigoCiva(), documento1, documento2, documento3);
        gerentes.add(gerente);

        // Início Gerente 2 // 
        Pessoa pessoa2 = new Pessoa(23, 1, "Brasileira", "Lais", "Dantas", "1998-03-21", "+55", "laisdantas@gmail.com", "998756455", "mulher trans", "BR999923721873");

        Docs documento12 = new Docs(23, "7657328490", 23, 1, "Identidade", "1999-04-1", "XXXXXXXXXXX", "Civil");
        Docs documento22 = new Docs(24, "99383946577", 23, 2, "Passaporte", "2000-04-1", "XXXXXXXXXXX", "Civil");
        Docs documento32 = new Docs(25, "99383946577", 23, 3, "CPF", "2001-04-1", "XXX.XXX.XXX-XX", "Civil");

        Endereco endereco2 = new Endereco(23, 1, "Brasil", "Avenida", "Av Brasil", "98755855", "Casa", "Vila Bela", "Jundiai", "São Paulo", "", "", "", "", "30");

        Gerente gerente2 = new Gerente(pessoa2, endereco2, pessoa2.getCodigoCiva(), documento12, documento22, documento32);
        gerentes.add(gerente2);

        // Início Gerente 3 //
        Pessoa pessoa3 = new Pessoa(24, 1, "Brasileira", "Marina", "Alcantara", "1993-08-03", "+55", "marinaalcantara@gmail.com", "9856458655", "Mulher trans", "BR998544574");

        Docs documento13 = new Docs(26, "879879879", 24, 1, "Identidade", "1998-05-21", "XXXXXXXXXXX", "Civil");
        Docs documento23 = new Docs(27, "99383946577", 24, 2, "Passaporte", "2000-06-12", "XXXXXXXXXXX", "Civil");
        Docs documento33 = new Docs(28, "4567895445", 24, 3, "CPF", "2000-06-12", "XXX.XXX.XXX-XX", "Civil");

        Endereco endereco3 = new Endereco(24, 1, "Brasil", "Rua", "Rua D", "9855655", "Casa J", "Santa Luz", "Campinas", "Sao Paulo", "", "", "", "", "300");

        Gerente gerente3 = new Gerente(pessoa3, endereco3, pessoa3.getCodigoCiva(), documento13, documento23, documento33);
        gerentes.add(gerente3);

        // Início Gerente 4 //
        Pessoa pessoa4 = new Pessoa(25, 1, "Brasileira", "Luana", "Tavares", "1995-07-23", "+55", "luanatavares@gmail.com", "98559855", "Mulher cis", "BR8559556");

        Docs documento14 = new Docs(29, "485595758", 25, 1, "Identidade", "1996-02-23", "XXXXXXXXXXX", "Civil");
        Docs documento24 = new Docs(30, "987555455", 25, 2, "Passaporte", "1998-04-12", "XXXXXXXXXXX", "Civil");
        Docs documento34 = new Docs(31, "255581412", 25, 3, "CPF", "1998-04-12", "XXX.XXX.XXX-XX", "Civil");

        Endereco endereco4 = new Endereco(25, 1, "Brasil", "Rua", "Rua Marajor", "67734243", "Casa", "Alto do Céu", "Uberaba", "Minas Gerais", "", "", "", "", "258");

        Gerente gerente4 = new Gerente(pessoa4, endereco4, pessoa4.getCodigoCiva(), documento14, documento24, documento34);
        gerentes.add(gerente4);

        // Início Gerente 5 //
        Pessoa pessoa5 = new Pessoa(26, 1, "Brasileira", "Kerolen", "Rodrigues", "1998-02-23", "+55", "kerolenrodrigues@gmail.com", "59555555", "mulher cis", "BR98855956");

        Docs documento15 = new Docs(32, "855455658", 26, 1, "Identidade", "2000-03-12", "XXXXXXXXXXX", "Civil");
        Docs documento25 = new Docs(33, "994744444", 26, 2, "Passaporte", "2000-03-12", "XXXXXXXXXXX", "Civil");
        Docs documento35 = new Docs(34, "886665556", 26, 3, "CPF", "2000-03-12", "XXX.XXX.XXX-XX", "Civil");

        Endereco endereco5 = new Endereco(26, 1, "Brasil", "Rua", "Rua Z", "89955656", "Apt 20", "Vila Nova", "Pirassununga", "Sao Paulo", "", "", "", "", "508");

        Gerente gerente5 = new Gerente(pessoa5, endereco5, pessoa5.getCodigoCiva(), documento15, documento25, documento35);
        gerentes.add(gerente5);

        // Início Gerente 6 //   
        Pessoa pessoa6 = new Pessoa(26, 1, "Brasileira", "Katarina", "Martine", "1999-03-10", "+55", "katarinamartine@gmail.com", "985895585", "mulher trans", "BR998555655");

        Docs documento16 = new Docs(35, "9875522005", 6, 1, "Identidade", "2000-07-10", "XXXXXXXXXXX", "Civil");
        Docs documento26 = new Docs(36, "1235687585", 6, 2, "Passaporte", "2000-07-10", "XXXXXXXXXXX", "Civil");
        Docs documento36 = new Docs(37, "3588566812", 6, 3, "CPF", "2000-07-10", "XXX.XXX.XXX-XX", "Civil");

        Endereco endereco6 = new Endereco(27, 1, "Brasil", "Rua", "Rua Jau", "97785855", "Casa", "Nova Pedra", "Sapezal", "Mato grosso", "", "", "", "", "100");

        Gerente gerente6 = new Gerente(pessoa6, endereco6, pessoa6.getCodigoCiva(), documento16, documento26, documento36);
        gerentes.add(gerente6);

        return gerentes;
    }

}
