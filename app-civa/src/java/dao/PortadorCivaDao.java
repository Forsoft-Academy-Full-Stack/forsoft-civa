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
import model.PortadorCiva;
import model.Vacinacao;

/**
 *
 * @author Otacilio Lima
 */
public class PortadorCivaDao {

    public static List<PortadorCiva> listBySuporteCiva(String codigoSuporteCiva) {
        Connection connection = ConnectionFactory.getConnection();
        PortadorCiva portadorCiva;
        List<PortadorCiva> portadoresCiva = null;
        Pessoa pessoa;
        Docs documento1;
        String sql = "";

        sql = "SELECT pepc.nomepessoa AS nome,\n"
                + "       pepc.sobrenomepessoa,\n"
                + "       doc.documento,\n"
                + "       pepc.datadenascimento,\n"
                + "       apc.codigocivapc\n"
                + "FROM pessoa pepc\n"
                + "    LEFT JOIN docs doc \n"
                + "    ON pepc.idpessoa = doc.idpessoa\n"
                + "    LEFT JOIN tipodoc tidoc \n"
                + "    ON doc.idtipodoc = tidoc.idtipodoc \n"
                + "    LEFT JOIN acessopc apc \n"
                + "    ON apc.idpessoa = pepc.idpessoa\n"
                + "    WHERE tidoc.nivel = 'Primário'\n"
                + "    AND apc.codigocivapc LIKE \n"
                + "    CONCAT( \n"
                + "    (SELECT pa.sigla FROM pessoa peag \n"
                + "    LEFT JOIN acessogestao ag \n"
                + "    on ag.idpessoa = peag.idpessoa \n"
                + "    LEFT JOIN pessoa_endereco peen \n"
                + "    ON peag.idpessoa = peen.idpessoa\n"
                + "    LEFT JOIN endereco en \n"
                + "    ON peen.idendereco = en.idendereco \n"
                + "    LEFT JOIN pais pa \n"
                + "    ON en.idpais = pa.idpais  \n"
                + "   	WHERE ag.codigocivagestao = ? ),'%') AND apc.statuspc = true order by apc.codigocivapc desc limit 20;";

        try {
            portadoresCiva = new ArrayList<>();
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoSuporteCiva);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                documento1 = new Docs();
                portadorCiva = new PortadorCiva();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setCodigoCiva(rs.getString("codigocivapc"));
                documento1.setDocumento(rs.getString("documento"));

                portadorCiva.setPessoa(pessoa);
                portadorCiva.setDocumento1(documento1);
                portadorCiva.setCodigoCiva(pessoa.getCodigoCiva());

                portadoresCiva.add(portadorCiva);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorNacionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return portadoresCiva;
    }

    public static List<PortadorCiva> listByProfissionalSaude(String codigoCivaProfissionalSaude) {
        Connection connection = ConnectionFactory.getConnection();
        PortadorCiva portadorCiva;
        List<PortadorCiva> portadoresCiva = null;
        Pessoa pessoa;
        Docs documento1;
        String sql = "";

        sql = "SELECT peag.nomepessoa AS nome,\n"
                + "   peag.sobrenomepessoa,"
                + "	   doc.documento,\n"
                + "	   peag.datadenascimento, \n"
                + "	   ag.codigocivapc\n"
                + "FROM pessoa AS peag\n"
                + "LEFT JOIN docs AS doc \n"
                + "on peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON tidoc.idtipodoc = doc.idtipodoc \n"
                + "LEFT JOIN acessopc ag \n"
                + "on peag.idpessoa = ag.idpessoa\n"
                + "AND peag.idpaisdenascimento = (\n"
                + "SELECT peag.idpaisdenascimento FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag\n"
                + "ON peag.idpessoa = ag.idpessoa\n"
                + "WHERE  ag.codigocivagestao = ? AND tidoc.nivel ='Primário') AND ag.statuspc = true LIMIT 20;";

        try {
            portadoresCiva = new ArrayList<>();
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaProfissionalSaude);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                documento1 = new Docs();
                portadorCiva = new PortadorCiva();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setCodigoCiva(rs.getString("codigocivapc"));
                documento1.setDocumento(rs.getString("documento"));

                portadorCiva.setPessoa(pessoa);
                portadorCiva.setDocumento1(documento1);
                portadorCiva.setCodigoCiva(pessoa.getCodigoCiva());

                portadoresCiva.add(portadorCiva);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorNacionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return portadoresCiva;
    }

    public static List<PortadorCiva> listDadosPessoais() {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";

        List<PortadorCiva> portadoresCivas = null;

        PortadorCiva portadorCiva;
        Pessoa pessoa;
        //Endereco endereco = null;
        Docs documento1;
        //Docs documento2 = new Docs();
        //Docs documento3 = new Docs();

        sql = "SELECT p.nomepessoa AS nome,\n"
                + "       p.sobrenomepessoa AS sobrenome,\n"
                + "       p.datadenascimento AS datanascimento,\n"
                + "	   acp.codigocivapc AS codigociva,\n"
                + "       dc.documento\n"
                + "FROM pessoa AS p\n"
                + "LEFT JOIN acessopc AS acp\n"
                + "ON p.idpessoa = acp.idpessoa\n"
                + "LEFT JOIN docs AS dc\n"
                + "on p.idpessoa = dc.idpessoa AND apc.statuspc = true;\n";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            portadoresCivas = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                portadorCiva = new PortadorCiva();
                documento1 = new Docs();

                pessoa.setNomePessoa(rs.getString("nome"));

                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));

                documento1.setDocumento(rs.getString("documento"));

                portadorCiva.setDocumento1(documento1);
                portadorCiva.setPessoa(pessoa);
                portadorCiva.setCodigoCiva(pessoa.getCodigoCiva());
                portadoresCivas.add(portadorCiva);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PortadorCivaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return portadoresCivas;
    }

    public static List<PortadorCiva> listBySuporteCivaNomePortador(String codigoSuporteCiva, String nome) {
        Connection connection = ConnectionFactory.getConnection();
        PortadorCiva portadorCiva;
        List<PortadorCiva> portadoresCiva = null;
        Pessoa pessoa;
        Docs documento1;
        String sql = "";

        sql = "SELECT pepc.nomepessoa AS nome,\n"
                + "	pepc.sobrenomepessoa,\n"
                + "	doc.documento,\n"
                + "	pepc.datadenascimento,\n"
                + "	apc.codigocivapc\n"
                + "FROM pessoa pepc\n"
                + "LEFT JOIN docs doc \n"
                + "ON pepc.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc\n"
                + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "LEFT JOIN acessopc apc \n"
                + "ON apc.idpessoa = pepc.idpessoa\n"
                + "WHERE tidoc.nivel = 'Primário'\n"
                + "AND apc.codigocivapc LIKE \n"
                + "CONCAT( \n"
                + "(SELECT pa.sigla FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag\n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa\n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "LEFT JOIN pais pa \n"
                + "ON en.idpais = pa.idpais  \n"
                + "WHERE ag.codigocivagestao = ? ),'%') AND pepc.nomepessoa LIKE ? AND apc.statuspc = true LIMIT 20;";

        try {
            portadoresCiva = new ArrayList<>();
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoSuporteCiva);
            ps.setString(2, "%" + nome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                documento1 = new Docs();
                portadorCiva = new PortadorCiva();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setCodigoCiva(rs.getString("codigocivapc"));
                documento1.setDocumento(rs.getString("documento"));

                portadorCiva.setPessoa(pessoa);
                portadorCiva.setDocumento1(documento1);
                portadorCiva.setCodigoCiva(pessoa.getCodigoCiva());

                portadoresCiva.add(portadorCiva);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorNacionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return portadoresCiva;
    }

    public static boolean insert(PortadorCiva portadorCiva, int idCadastrante) {
        boolean resultado = false;

        Pessoa pessoa = portadorCiva.getPessoa();
        Docs documento1 = portadorCiva.getDocumento1();
        Endereco endereco = portadorCiva.getEndereco();

        try {

            // Pessoa
            // Verificar se a pessoa já tem cadastro no sistema
            // Se não tiver cadastrar e pegar o idPessoa gerado
            // Caso tenha pegar o idPessoa do banco de dados
            // Inserir idNacionalidade, nome, sobrenome, genero
            // dataDeNascimento, ddiDoContato e telefoneComDdd
            int idPessoa = PessoaDao.insert(pessoa);
             System.err.println(idPessoa);

            // Endereço
            // Inserir o endereço
            // Pegar o idEndereco gerado
            int idEndereco = EnderecoDao.insert(endereco);
            System.err.println(idEndereco);

            // Pessoa Endereco (Vincular)
            // Inserir o idPessoa e IdEndereco na Tabela pessoa_endereco
            int idPessoaEndereco = PessoaDao.vincularEndereco(idPessoa, idEndereco, endereco.getNumero(), endereco.getComplemento());

            // Tipodoc
            // Pegar idTipodoc pelo Nometipodoc vindo do formulário
            int idTipoDoc = DocsDao.findIdTipodoc(documento1.getNomeTipoDoc());

            // Cadastrar na tabela Docs
            // O idTipoDoc, idPessoa documento e data de emissão
            Boolean resultDocs = DocsDao.insert(idTipoDoc, idPessoa, documento1.getDocumento(), documento1.getDataEmissao());

            // Cadastrar na tabela acessoGestão
            // idPessoa, idCadastrante, codigoCiva, cargo, email, senha e data de registro
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");

            String codigoCivaPortador = PortadorCivaDao.gerarCodigoCiva(endereco.getNomePais(), idPessoa);

            resultado = PessoaDao.insertAcessoPc(idPessoa, idCadastrante, codigoCivaPortador, pessoa.getEmail(), formatador.format(data), pessoa.getSenha());

        } catch (Exception e) {
        }

        return resultado;
    }

    public static PortadorCiva findByCodigoCiva(String codigoCivaPortadorCiva) {
        Connection connection = ConnectionFactory.getConnection();
        PortadorCiva portadorCiva = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Endereco endereco = null;
        List<Vacinacao> vacinacoes = null;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";
            String sql2 = "";

            sql = " SELECT apc.codigocivapc, pepc.idpessoa, "
                    + " pepc.nomepessoa,"
                    + " pepc.sobrenomepessoa,"
                    + " pepc.genero,  \n"
                    + " pepc.datadenascimento,"
                    + " pa.nomedopais,"
                    + " en.codigopostal,"
                    + " en.nomesubdivisao1 AS subdivisao3, \n"
                    + " en.nomesubdivisao2 AS subdivisao2,"
                    + " en.nomesubdivisao3 AS subdivisao1,"
                    + " en.tipodelogradouro,"
                    + " en.logradouro,"
                    + " peen.numero,"
                    + " peen.complemento, \n"
                    + " pepc.ddidocontato,"
                    + " pepc.telefonecomddd,"
                    + " apc.emailpc \n"
                    + "    FROM pessoa pepc\n"
                    + "    LEFT JOIN acessopc apc\n"
                    + "    ON pepc.idpessoa = apc.idpessoa\n"
                    + "    LEFT JOIN pais pa\n"
                    + "    ON pepc.idpaisdenascimento = pa.idpais\n"
                    + "    LEFT JOIN pessoa_endereco peen\n"
                    + "    ON pepc.idpessoa = peen.idpessoa\n"
                    + "    LEFT JOIN endereco en\n"
                    + "    ON peen.idendereco = en.idendereco\n"
                    + "    WHERE apc.codigocivapc = ? AND apc.statuspc = true;";

            sql2 = "SELECT doc.documento, \n"
                    + "	   tidoc.nomedoc AS tipodocumento\n"
                    + "FROM pessoa pepc\n"
                    + "LEFT JOIN acessopc apc\n"
                    + "ON pepc.idpessoa = apc.idpessoa\n"
                    + "LEFT JOIN docs doc\n"
                    + "ON pepc.idpessoa = doc.idpessoa\n"
                    + "LEFT JOIN tipodoc tidoc\n"
                    + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                    + "WHERE apc.codigocivapc = ? AND apc.statuspc = true;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortadorCiva);
            rs = ps.executeQuery();

            portadorCiva = new PortadorCiva();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setCodigoCiva(rs.getString("codigocivapc"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setTelefoneDdd(rs.getString("telefonecomddd"));
                pessoa.setDdiContato(rs.getString("ddidocontato"));
                pessoa.setEmail(rs.getString("emailpc"));

                System.err.println("DDI:" + pessoa.getDdiContato());
                System.err.println("Telefone com ddd:" + pessoa.getTelefoneDdd());

                // Pegar nacionalidade
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

                System.err.println("País: " + pais);

                endereco = new Endereco();
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao1"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setTipoLogradouro(rs.getString("tipodelogradouro"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNomePais(rs.getString("nomedopais"));

            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaPortadorCiva);
            rs = ps.executeQuery();

            if (rs.next()) {
                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));
                documento1.setNomeTipoDoc(rs.getString("tipodocumento"));
                portadorCiva.setDocumento1(documento1);
            }

            try {
                vacinacoes = VacinacaoDao.listByPortadorCiva(codigoCivaPortadorCiva);
                System.err.println(vacinacoes.get(0).getVacina().getNomeVacina());
                portadorCiva.setListaVacinacao(vacinacoes);
            } catch (Exception e) {
                System.err.println("Ainda não foi cadastrada nenhuma vacinação.");
            }

            portadorCiva.setListaVacinacao(vacinacoes);
            portadorCiva.setPessoa(pessoa);
            portadorCiva.setEndereco(endereco);
            portadorCiva.setCodigoCiva(pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(PortadorCivaDao.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erro dao: " + ex.getErrorCode() + " " + ex.getMessage());
        }

        return portadorCiva;
    }

    public static PortadorCiva findByCodigoCivaVacinacaoInternacional(String codigoCivaPortadorCiva) {
        Connection connection = ConnectionFactory.getConnection();
        PortadorCiva portadorCiva = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Endereco endereco = null;
        List<Vacinacao> vacinacoes = null;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";
            String sql2 = "";

            sql = " SELECT apc.codigocivapc, pepc.idpessoa, "
                    + " pepc.nomepessoa,"
                    + " pepc.sobrenomepessoa,"
                    + " pepc.genero,  \n"
                    + " pepc.datadenascimento,"
                    + " pa.nomedopais,"
                    + " en.codigopostal,"
                    + " en.nomesubdivisao1 AS subdivisao3, \n"
                    + " en.nomesubdivisao2 AS subdivisao2,"
                    + " en.nomesubdivisao3 AS subdivisao1,"
                    + " en.tipodelogradouro,"
                    + " en.logradouro,"
                    + " peen.numero,"
                    + " peen.complemento, \n"
                    + " pepc.ddidocontato,"
                    + " pepc.telefonecomddd,"
                    + " apc.emailpc \n"
                    + "    FROM pessoa pepc\n"
                    + "    LEFT JOIN acessopc apc\n"
                    + "    ON pepc.idpessoa = apc.idpessoa\n"
                    + "    LEFT JOIN pais pa\n"
                    + "    ON pepc.idpaisdenascimento = pa.idpais\n"
                    + "    LEFT JOIN pessoa_endereco peen\n"
                    + "    ON pepc.idpessoa = peen.idpessoa\n"
                    + "    LEFT JOIN endereco en\n"
                    + "    ON peen.idendereco = en.idendereco\n"
                    + "    WHERE apc.codigocivapc = ? AND apc.statuspc = true;";

            sql2 = "SELECT doc.documento, \n"
                    + "	   tidoc.nomedoc AS tipodocumento\n"
                    + "FROM pessoa pepc\n"
                    + "LEFT JOIN acessopc apc\n"
                    + "ON pepc.idpessoa = apc.idpessoa\n"
                    + "LEFT JOIN docs doc\n"
                    + "ON pepc.idpessoa = doc.idpessoa\n"
                    + "LEFT JOIN tipodoc tidoc\n"
                    + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                    + "WHERE apc.codigocivapc = ? AND apc.statuspc = true;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortadorCiva);
            rs = ps.executeQuery();

            portadorCiva = new PortadorCiva();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setCodigoCiva(rs.getString("codigocivapc"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setTelefoneDdd(rs.getString("ddidocontato"));
                pessoa.setDdiContato(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailpc"));

                // Pegar nacionalidade
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

                endereco = new Endereco();
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao1"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setTipoLogradouro(rs.getString("tipodelogradouro"));
                endereco.setLogradouro(endereco.getTipoLogradouro() + " " + rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNomePais(rs.getString("nomedopais"));
            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaPortadorCiva);
            rs = ps.executeQuery();

            if (rs.next()) {
                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));
                documento1.setNomeTipoDoc(rs.getString("tipodocumento"));
                portadorCiva.setDocumento1(documento1);
            }

            vacinacoes = VacinacaoDao.listByPortadorCivaInternacional(codigoCivaPortadorCiva);

            portadorCiva.setListaVacinacao(vacinacoes);
            portadorCiva.setPessoa(pessoa);
            portadorCiva.setEndereco(endereco);
            portadorCiva.setCodigoCiva(pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(PortadorCivaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return portadorCiva;
    }

    public static String gerarCodigoCiva(String nomePais, int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String atorSigla = "PC";
        String codigoCiva = "";
        String sigla = PaisDao.getSiglaByName(nomePais);

        sql = "SELECT COUNT(*) + 100000000 + ? AS codigo\n"
                + "FROM acessopc AS apc;";

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

    public static List<PortadorCiva> list() {
        List<PortadorCiva> portadoresciva = new ArrayList<PortadorCiva>();
        return portadoresciva;
    }

    public static boolean update(PortadorCiva portadorCiva) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;
        Pessoa pessoa = portadorCiva.getPessoa();
        Docs documento1 = portadorCiva.getDocumento1();
        Endereco endereco = portadorCiva.getEndereco();

        try {
            // Atualiza os dados da pessoa
            Boolean pessoaResult = PessoaDao.update(pessoa);
            PessoaDao.updateAcessoPc(pessoa.getEmail(), PessoaDao.getIdAcessoPc(pessoa.getIdPessoa()));
            
            // Atualiza os dados do documento
            Boolean docsResult = DocsDao.update(documento1);
            System.err.println("Resultado docs: " + docsResult);

            // Atualiza os dados endereco
            Boolean enderecoResult = EnderecoDao.update(endereco);

            int idPessoaEndereco = EnderecoDao.getIdPessoaEnderecoByIdPessoa(pessoa.getIdPessoa());

            Boolean pessoaEndereco = EnderecoDao.updatePessoaEndereco(idPessoaEndereco, endereco.getNumero(), endereco.getComplemento());

            resultado = true;

            System.err.println("Resultado endereco: " + enderecoResult);

        } catch (Exception e) {
        }
        return resultado;
    }

    public static boolean delete(PortadorCiva portadorciva) {
        boolean resultado = false;
        Pessoa pessoa = portadorciva.getPessoa();
        
        int idAcessoPc = PessoaDao.getIdAcessoPc(pessoa.getIdPessoa());
        resultado = PessoaDao.desativarAcessoPc(idAcessoPc);
        
        return resultado;
    }

}
