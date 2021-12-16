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
import model.ProfissionalSaude;
import model.Pessoa;

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
        Docs documento4 = null;
        Docs documento5 = null;
        Endereco endereco = null;

        String sql = "";
        String sql2 = "";

        sql = "SELECT peag.idpessoa,"
                + "   ag.codigocivagestao,"
                + "   peag.nomepessoa,"
                + "   peag.ddidocontato,"
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
                + "WHERE ag.codigocivagestao = ? AND ag.statusgestao = true AND ag.cargo LIKE 'Profissional de Saúde';";

        sql2 = "SELECT  tidoc.nomedoc,doc.documento \n"
                + "        FROM acessogestao ag\n"
                + "        left join pessoa peag \n"
                + "        on ag.idpessoa = peag.idpessoa \n"
                + "        left join docs doc \n"
                + "        on peag.idpessoa = doc.idpessoa \n"
                + "        LEFT JOIN tipodoc tidoc \n"
                + "        on doc.idtipodoc = tidoc.idtipodoc \n"
                + "        WHERE ag.codigocivagestao = ? AND ag.statusgestao = true AND ag.cargo LIKE 'Profissional de Saúde';";

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
                pessoa.setDdiContato(rs.getString("ddidocontato"));

                // Pegar nacionalidade
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

                endereco = new Endereco();
                endereco.setNomePais(rs.getString("nomedopais"));
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

            if (rs.next()) {
                documento4 = new Docs();
                documento4.setNomeTipoDoc(rs.getString("nomedoc"));
                documento4.setDocumento(rs.getString("documento"));
            }

            if (rs.next()) {
                documento5 = new Docs();
                documento5.setNomeTipoDoc(rs.getString("nomedoc"));
                documento5.setDocumento(rs.getString("documento"));
            }

            profissionalSaude = new ProfissionalSaude(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());
            profissionalSaude.setDocumento4(documento4);
            profissionalSaude.setDocumento5(documento5);

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

        sql = "SELECT distinct ag.codigocivagestao AS codigociva,\n"
                + "	peag.nomepessoa AS nome, peag.idpessoa,\n"
                + "	peag.sobrenomepessoa AS sobrenome,\n"
                + "	peag.genero,\n"
                + "	peag.datadenascimento AS datanascimento,\n"
                + "	pa.nomedopais AS pais,\n"
                + "	en.codigopostal,\n"
                + "	en.logradouro,\n"
                + "	en.tipodelogradouro AS tipologradouro,\n"
                + "	peen.numero, peen.complemento, \n"
                + "	en.nomesubdivisao1 AS subdivisao3,\n"
                + "	en.nomesubdivisao2  AS subdivisao2,\n"
                + "	en.nomesubdivisao3  AS subdivisao1, \n"
                + "	peag.telefonecomddd AS contato,\n"
                + "   doc.documento AS documento,\n"
                + "	ag.emailgestao AS email\n"
                + "FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON peag.idpessoa = ag.idpessoa  \n"
                + "LEFT JOIN docs doc\n"
                + "on peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "LEFT JOIN pais pa \n"
                + "ON peag.idpaisdenascimento = pa.idpais          \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa  \n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "WHERE ag.cargo = 'Profissional de Saúde'\n"
                + "AND tidoc.nivel = 'Primário'\n"
                + "AND en.idpais = \n"
                + "(SELECT en.idpais FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag \n"
                + "on peag.idpessoa = ag.idpessoa \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa \n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "WHERE ag.codigocivagestao = ?) AND ag.statusgestao = true order by codigociva desc limit 30;";

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
                pessoa.setDataNascimento(rs.getString("datanascimento"));

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
                + " AND ag.statusgestao = true AND aguni.status = true;";

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
                + "WHERE uni.idunidade = ? ) AND aguni.status = true AND ag.statusgestao = true;";

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

    public static String gerarCodigoCiva(String nomePais, int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String atorSigla = "PS";
        String codigoCiva = "";
        String sigla = PaisDao.getSiglaByName(nomePais);

        sql = "SELECT COUNT(*) + 100000000 + ? AS codigo\n"
                + "FROM acessogestao AS acg\n"
                + "WHERE acg.cargo LIKE 'Profissional de Saúde';";

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

    public static boolean insert(ProfissionalSaude profissionalSaude, int idCadastrante) {
        boolean resultado = false;

        Pessoa pessoa = profissionalSaude.getPessoa();

        // São até 5 tipos de documentos
        Docs documento1 = profissionalSaude.getDocumento1();
        Docs documento2 = profissionalSaude.getDocumento2();
        Docs documento3 = profissionalSaude.getDocumento3();
        Docs documento4 = profissionalSaude.getDocumento4();
        Docs documento5 = profissionalSaude.getDocumento5();

        Endereco endereco = profissionalSaude.getEndereco();

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
            System.err.println("Doc2" + documento2.getNomeTipoDoc());

            // Tipodoc
            // Pegar idTipodoc pelo Nometipodoc vindo do formulário
            int idTipoDoc = DocsDao.findIdTipodoc(documento1.getNomeTipoDoc());

            if (idTipoDoc != -1) {
                // Cadastrar na tabela Docs
                // O idTipoDoc, idPessoa documento e data de emissão
                Boolean resultDocs = DocsDao.insert(idTipoDoc, idPessoa, documento1.getDocumento(), documento1.getDataEmissao());

                System.err.println("Docs enviado 1: " + resultDocs);
            }

            System.err.println(documento2.getNomeTipoDoc());

            int idTipoDoc2 = DocsDao.findIdTipodoc(documento2.getNomeTipoDoc());
            if (idTipoDoc2 != -1) {
                // Cadastrar na tabela Docs
                // O idTipoDoc, idPessoa documento e data de emissão
                Boolean resultDocs = DocsDao.insert(idTipoDoc2, idPessoa, documento2.getDocumento(), documento2.getDataEmissao());

                System.err.println("Docs enviado 2: " + resultDocs);
            }

            int idTipoDoc3 = DocsDao.findIdTipodoc(documento3.getNomeTipoDoc());
            if (idTipoDoc3 != -1) {
                // Cadastrar na tabela Docs
                // O idTipoDoc, idPessoa documento e data de emissão
                Boolean resultDocs = DocsDao.insert(idTipoDoc3, idPessoa, documento3.getDocumento(), documento3.getDataEmissao());

                System.err.println("Docs enviado 3: " + resultDocs);
            }

            int idTipoDoc4 = DocsDao.findIdTipodoc(documento4.getNomeTipoDoc());
            if (idTipoDoc4 != -1) {
                // Cadastrar na tabela Docs
                // O idTipoDoc, idPessoa documento e data de emissão
                Boolean resultDocs = DocsDao.insert(idTipoDoc4, idPessoa, documento4.getDocumento(), documento4.getDataEmissao());

                System.err.println("Docs enviado 4: " + resultDocs);
            }

            int idTipoDoc5 = DocsDao.findIdTipodoc(documento5.getNomeTipoDoc());
            if (idTipoDoc5 != -1) {
                // Cadastrar na tabela Docs
                // O idTipoDoc, idPessoa documento e data de emissão
                Boolean resultDocs = DocsDao.insert(idTipoDoc5, idPessoa, documento5.getDocumento(), documento5.getDataEmissao());

                System.err.println("Docs enviado 5: " + resultDocs);
            }

            // Cadastrar na tabela acessoGestão
            // idPessoa, idCadastrante, codigoCiva, cargo, email, senha e data de registro
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");

            String codigoCivaGestorNacional = ProfissionalSaudeDao.gerarCodigoCiva(endereco.getNomePais(), idPessoa);
            System.err.println(codigoCivaGestorNacional);

            String cargo = "Profissional de Saúde";
            resultado = PessoaDao.insertAcessoGestao(idPessoa, idCadastrante, cargo, codigoCivaGestorNacional, pessoa.getEmail(), formatador.format(data));

            System.err.println("Chegou no dao do profissional de Saude " + profissionalSaude.getPessoa().getNomePessoa());
        } catch (Exception e) {
        }

        return resultado;
    }

    public static ProfissionalSaude find(String codigoCivaProfissionalSaude) {
        return null;
    }

    public static List<ProfissionalSaude> list() {
        List<ProfissionalSaude> profissionaisSaude = new ArrayList<>();
        return profissionaisSaude;
    }

    public static boolean update(ProfissionalSaude profissionalSaude) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;
        Pessoa pessoa = profissionalSaude.getPessoa();

        Docs documento1 = profissionalSaude.getDocumento1();
        Docs documento2 = profissionalSaude.getDocumento2();
        Docs documento3 = profissionalSaude.getDocumento3();
        Docs documento4 = profissionalSaude.getDocumento4();
        Docs documento5 = profissionalSaude.getDocumento5();
        Endereco endereco = profissionalSaude.getEndereco();

        try {
            // Atualiza os dados da pessoa
            Boolean pessoaResult = PessoaDao.update(pessoa);
            PessoaDao.updateAcessoGestao(pessoa.getEmail(), PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa()));

            try {
                // Atualiza os dados do documento
                boolean docsResult = DocsDao.update(documento1);

                // Atualiza os dados do documento
                docsResult = DocsDao.update(documento2);
                // Atualiza os dados do documento
                docsResult = DocsDao.update(documento3);
                // Atualiza os dados do documento
                docsResult = DocsDao.update(documento4);
                // Atualiza os dados do documento
                docsResult = DocsDao.update(documento5);

            } catch (Exception e) {
                System.err.println("Nao cadastrou os docs");
            }

            // Atualiza os dados endereco
            boolean enderecoResult = EnderecoDao.update(endereco);

            int idPessoaEndereco = EnderecoDao.getIdPessoaEnderecoByIdPessoa(pessoa.getIdPessoa());

            boolean pessoaEndereco = EnderecoDao.updatePessoaEndereco(idPessoaEndereco, endereco.getNumero(), endereco.getComplemento());

            resultado = true;

        } catch (Exception e) {
        }
        return resultado;
    }

    public static boolean delete(ProfissionalSaude profissionalsaude) {
        boolean resultado = false;
        Pessoa pessoa = profissionalsaude.getPessoa();
        int idAcessoGestao = PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa());

        resultado = PessoaDao.desativarAcessoGestao(idAcessoGestao);

        return resultado;
    }

}
