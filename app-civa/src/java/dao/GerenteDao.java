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
import model.Gerente;
import model.Pais;
import model.Pessoa;

/**
 *
 * @author Rafael Marçal | Antonio Henrique
 */
public class GerenteDao {

    public static Gerente findByCodigoCiva(String codigoCivaGerente, String codigoCivaGestao) {
        Connection connection = ConnectionFactory.getConnection();

        Gerente gerente = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;

        String sql = "SELECT ag.codigocivagestao AS codigociva, pa.ddi,\n"
                + "                        peag.nomepessoa AS nome, peag.idpessoa,\n"
                + "                        peag.sobrenomepessoa AS sobrenome,\n"
                + "                        peag.genero,\n"
                + "                        peag.datadenascimento AS datanascimento,\n"
                + "                        pa.nomedopais AS pais,\n"
                + "                        en.codigopostal,\n"
                + "                        en.logradouro,\n"
                + "                        en.tipodelogradouro AS tipologradouro,\n"
                + "                        peen.numero, peen.complemento, \n"
                + "                        en.nomesubdivisao1 AS subdivisao3,\n"
                + "                        en.nomesubdivisao2  AS subdivisao2,\n"
                + "                        en.nomesubdivisao3  AS subdivisao1, \n"
                + "                 	   peag.telefonecomddd AS contato,\n"
                + "                        ag.emailgestao AS email\n"
                + "                 FROM pessoa peag \n"
                + "                 LEFT JOIN acessogestao ag \n"
                + "                 	ON peag.idpessoa = ag.idpessoa  \n"
                + "                 LEFT JOIN pais pa \n"
                + "                 	ON peag.idpaisdenascimento = pa.idpais          \n"
                + "                 LEFT JOIN pessoa_endereco peen \n"
                + "                 	ON peag.idpessoa = peen.idpessoa  \n"
                + "                 LEFT JOIN endereco en \n"
                + "                 	ON peen.idendereco = en.idendereco \n"
                + "                 WHERE ag.cargo = 'Gerente' \n"
                + "                 AND ag.codigocivagestao = ?  \n"
                + "                 AND ag.statusgestao = true\n"
                + "                 AND en.idpais = (\n"
                + "                 SELECT en.idpais From pessoa pe\n"
                + "                 LEFT JOIN acessogestao ag\n"
                + "                 ON ag.idpessoa = pe.idpessoa \n"
                + "                 LEFT JOIN pessoa_endereco peen \n"
                + "                 ON pe.idpessoa = peen.idpessoa \n"
                + "                 LEFT JOIN endereco en \n"
                + "                 ON peen.idendereco = en.idendereco \n"
                + "                 WHERE ag.codigocivagestao = ?);";

        String sql2 = "SELECT tidoc.nomedoc AS tipoDocumento,\n"
                + "        doc.documento\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag \n"
                + "	ON peag.idpessoa = ag.idpessoa \n"
                + "LEFT JOIN docs doc\n"
                + "	ON doc.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN tipodoc tidoc\n"
                + "	ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "WHERE ag.codigocivagestao = ? AND ag.statusgestao = true;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);

            ps.setString(1, codigoCivaGerente);
            ps.setString(2, codigoCivaGestao);

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
                pessoa.setDdiContato(rs.getString("ddi"));
                System.err.println(pessoa.getDdiContato());

                // Pegar nacionalidade
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

                endereco = new Endereco();
                endereco.setNomePais(rs.getString("pais"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setTipoLogradouro(rs.getString("tipologradouro"));
                endereco.setLogradouro(rs.getString("logradouro"));
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
                + "AND ag.statusgestao = true "
                //+ "AND tidoc.nivel = 'Primário'\n"
                + "AND en.idpais = \n"
                + "(SELECT en.idpais FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa =peen.idpessoa\n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco =en.idendereco \n"
                + "WHERE ag.codigocivagestao = ? ) AND ag.statusgestao = true;"
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
                + "AND ag.statusgestao = true ;";

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
                + "WHERE ag.cargo='Gerente'  \n"
                + "AND tidoc.nivel = 'Primário'\n"
                + "AND aguni.idunidade IN \n"
                + "(SELECT uni.idunidade from unidade uni\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "ON uni.idunidade = aguni.idunidade\n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON aguni.idacessogestao = ag.idacessogestao \n"
                + "WHERE uni.idunidade = ?) AND ag.statusgestao = true AND aguni.status = true;";

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
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));

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

    public static String gerarCodigoCiva(String nomePais, int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String atorSigla = "GR";
        String codigoCiva = "";
        String sigla = PaisDao.getSiglaByName(nomePais);

        sql = "SELECT COUNT(*) + 100000000 + ? AS codigo\n"
                + "FROM acessogestao AS acg\n"
                + "WHERE acg.cargo LIKE 'Gerente';";

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

    public static boolean insert(Gerente gerente, int idCadastrante) {
        boolean resultado = false;

        Pessoa pessoa = gerente.getPessoa();
        Docs documento1 = gerente.getDocumento1();
        Endereco endereco = gerente.getEndereco();

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

            String codigoCivaGerente = GerenteDao.gerarCodigoCiva(endereco.getNomePais(), idPessoa);
            System.err.println(codigoCivaGerente);

            String cargo = "Gerente";
            resultado = PessoaDao.insertAcessoGestao(idPessoa, idCadastrante, cargo, codigoCivaGerente, pessoa.getEmail(), formatador.format(data));

            System.err.println("Chegou no dao do Gerente " + gerente.getPessoa().getNomePessoa());
        } catch (Exception e) {
        }

        return resultado;
    }

    public static boolean update(Gerente gerente) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;
        Pessoa pessoa = gerente.getPessoa();
        Docs documento1 = gerente.getDocumento1();
        Endereco endereco = gerente.getEndereco();

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

    public static boolean delete(Gerente gerente) {
        boolean resultado = false;
        Pessoa pessoa = gerente.getPessoa();
        int idAcessoGestao = PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa());

        resultado = PessoaDao.desativarAcessoGestao(idAcessoGestao);

        return resultado;
    }

    public static List<Gerente> list() {
        List<Gerente> gerentes = new ArrayList<>();
        return gerentes;
    }

}
