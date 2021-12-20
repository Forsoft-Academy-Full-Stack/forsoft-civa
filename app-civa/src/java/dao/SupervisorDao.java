package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public static boolean insert(Supervisor supervisor, int idCadastrante) {
        boolean resultado = false;

        Pessoa pessoa = supervisor.getPessoa();
        Docs documento1 = supervisor.getDocumento1();
        Endereco endereco = supervisor.getEndereco();

        try {

            // Pessoa
            // Verificar se a pessoa já tem cadastro no sistema
            // Se não tiver cadastrar e pegar o idPessoa gerado
            // Caso tenha pegar o idPessoa do banco de dados
            // Inserir idNacionalidade, nome, sobrenome, genero
            // dataDeNascimento, ddiDoContato e telefoneComDdd
            int idPessoa = PessoaDao.insert(pessoa);

            // Endereço
            // Inserir o endereço
            // Pegar o idEndereco gerado
            int idEndereco = EnderecoDao.insert(endereco);
            System.err.println(idEndereco);

            // Pessoa Endereco (Vincular)
            // Inserir o idPessoa e IdEndereco na Tabela pessoa_endereco
            int idPessoaEndereco = PessoaDao.vincularEndereco(idPessoa, idEndereco, endereco.getNumero(), endereco.getComplemento());

            System.err.println(idPessoaEndereco);

            // Tipodoc
            // Pegar idTipodoc pelo Nometipodoc vindo do formulário
            int idTipoDoc = DocsDao.findIdTipodoc(documento1.getNomeTipoDoc());

            // Cadastrar na tabela Docs
            // O idTipoDoc, idPessoa documento e data de emissão
            Boolean resultDocs = DocsDao.insert(idTipoDoc, idPessoa, documento1.getDocumento(), documento1.getDataEmissao());

            System.err.println("Docs enviado: " + resultDocs);

            // Cadastrar na tabela acessoGestão
            // idPessoa, idCadastrante, codigoCiva, cargo, email, senha e data de registro
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");

            String codigoCivaSupervisor = SupervisorDao.gerarCodigoCiva(endereco.getNomePais(), idPessoa);
            System.err.println(codigoCivaSupervisor);

            String cargo = "Supervisor";
            resultado = PessoaDao.insertAcessoGestao(idPessoa, idCadastrante, cargo, codigoCivaSupervisor, pessoa.getEmail(), formatador.format(data));

            System.err.println("Chegou no dao do supervisor " + supervisor.getPessoa().getNomePessoa());
        } catch (Exception e) {
        }

        return resultado;
    }

    public static Supervisor findByCodigoCiva(String codigoCivaSupervisor, String codigoCivaGestao) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String sql2 = "";
        Supervisor supervisor = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;

        sql = "SELECT ag.codigocivagestao AS codigociva, pa.ddi,\n"
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
                + "AND ag.codigocivagestao = ? AND ag.statusgestao = true "
                + "                 AND en.idpais = (\n"
                + "                 SELECT en.idpais From pessoa pe\n"
                + "                 LEFT JOIN acessogestao ag\n"
                + "                 ON ag.idpessoa = pe.idpessoa \n"
                + "                 LEFT JOIN pessoa_endereco peen \n"
                + "                 ON pe.idpessoa = peen.idpessoa \n"
                + "                 LEFT JOIN endereco en \n"
                + "                 ON peen.idendereco = en.idendereco \n"
                + "                 WHERE ag.codigocivagestao = ?);";

        sql2 = "SELECT tidoc.nomedoc,\n"
                + "       doc.documento\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON peag.idpessoa = ag.idpessoa \n"
                + "LEFT JOIN docs doc\n"
                + "ON doc.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN tipodoc tidoc\n"
                + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "WHERE ag.codigocivagestao = ? AND ag.statusgestao = true;";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSupervisor);
            ps.setString(2, codigoCivaGestao);
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
                pessoa.setDdiContato(rs.getString("ddi"));

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
        List<Supervisor> supervisores = new ArrayList<>();
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
                + "WHERE uni.idunidade = ?) AND ag.statusgestao = true AND aguni.status = TRUE;";

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
                + "WHERE ag.codigocivagestao = ?),'%') AND ag.statusgestao = true;";

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
                + "WHERE ag.codigocivagestao = ?),'%') AND ag.statusgestao = true;";

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

    public static List<Supervisor> listByGerenteNomeSupervisor(String codigoCivaGerente, String nome) {
        Connection connection = ConnectionFactory.getConnection();
        List<Supervisor> supervisores = null;
        Supervisor supervisor = null;
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
                + "WHERE ag.codigocivagestao = ?),'%') AND peag.nomepessoa LIKE ? AND ag.statusgestao = true;";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            supervisores = new ArrayList<>();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGerente);
            ps.setString(2, "%" + nome + "%");
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

    public static List<Supervisor> listBySuporteCivaNomeSupervisor(String codigoCivaSuporte, String nome) {
        Connection connection = ConnectionFactory.getConnection();
        List<Supervisor> supervisores = null;
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
                + "WHERE ag.codigocivagestao = ?),'%') AND peag.nomepessoa LIKE ? AND ag.statusgestao = true;";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            supervisores = new ArrayList<Supervisor>();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSuporte);
            ps.setString(2, "%" + nome + "%");
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

    public static String gerarCodigoCiva(String nomePais, int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String atorSigla = "SU";
        String codigoCiva = "";
        String sigla = PaisDao.getSiglaByName(nomePais);

        sql = "SELECT COUNT(*) + 100000000 + ? AS codigo\n"
                + "FROM acessogestao AS acg\n"
                + "WHERE acg.cargo LIKE 'Supervisor';";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setInt(1, idPessoa);
            rs = ps.executeQuery();

            if (rs.next()) {
                codigoCiva = String.valueOf(rs.getInt("codigo"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorNacionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sigla + codigoCiva + atorSigla;

    }

    public static List<Supervisor> list(String codigoCivaGerente) {
        Connection connection = ConnectionFactory.getConnection();
        List<Supervisor> supervisores = new ArrayList<>();
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
                + "WHERE ag.codigocivagestao = ?) AND ag.statusgestao = true;";

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
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;
        Pessoa pessoa = supervisorNovo.getPessoa();
        Docs documento1 = supervisorNovo.getDocumento1();
        Endereco endereco = supervisorNovo.getEndereco();

        try {
            // Atualiza os dados da pessoa
            Boolean pessoaResult = PessoaDao.update(pessoa);

            PessoaDao.updateAcessoGestao(pessoa.getEmail(), PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa()));

            // Atualiza os dados do documento
            Boolean docsResult = DocsDao.update(documento1);

            // Atualiza os dados endereco
            Boolean enderecoResult = EnderecoDao.update(endereco);

            int idPessoaEndereco = EnderecoDao.getIdPessoaEnderecoByIdPessoa(pessoa.getIdPessoa());

            Boolean pessoaEndereco = EnderecoDao.updatePessoaEndereco(idPessoaEndereco, endereco.getNumero(), endereco.getComplemento());

            resultado = true;

        } catch (Exception e) {
        }
        return resultado;
    }

    public static boolean delete(Supervisor supervisor) {
        boolean resultado = false;
        Pessoa pessoa = supervisor.getPessoa();
        int idAcessoGestao = PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa());

        resultado = PessoaDao.desativarAcessoGestao(idAcessoGestao);

        return resultado;
    }

}
