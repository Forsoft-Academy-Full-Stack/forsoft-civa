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
import model.SuporteCiva;
import model.Pessoa;

/**
 *
 * @author felipe gomes
 */
public class SuporteCivaDao {

    public static SuporteCiva findByCodigoCiva(String codigoCivaSuporteCiva, String codigoCivaGestao) {
        Connection connection = ConnectionFactory.getConnection();
        SuporteCiva suporteCiva = null;

        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;

        String sql = "";
        String sql2 = "";

        sql = " SELECT ag.codigocivagestao,\n"
                + "               peag.idpessoa, pa.ddi,\n"
                + "               peag.nomepessoa,\n"
                + "               peag.sobrenomepessoa,\n"
                + "               peag.genero,\n"
                + "               peag.datadenascimento, \n"
                + "               pa.nomedopais,\n"
                + "               en.codigopostal,\n"
                + "               en.tipodelogradouro,\n"
                + "               en.logradouro,\n"
                + "               peen.numero,\n"
                + "               peen.complemento,\n"
                + "               en.nomesubdivisao1 AS subdivisao3,\n"
                + "               en.nomesubdivisao2 AS subdivisao2,\n"
                + "               en.nomesubdivisao3 AS subdivisao1, \n"
                + "               peag.telefonecomddd,\n"
                + "               ag.emailgestao \n"
                + "        FROM pessoa peag \n"
                + "        LEFT JOIN acessogestao ag \n"
                + "            ON peag.idpessoa = ag.idpessoa  \n"
                + "        LEFT JOIN pais pa \n"
                + "            ON peag.idpaisdenascimento = pa.idpais          \n"
                + "        LEFT JOIN pessoa_endereco peen \n"
                + "            ON peag.idpessoa = peen.idpessoa  \n"
                + "        LEFT JOIN endereco en \n"
                + "            ON peen.idendereco = en.idendereco \n"
                + "        WHERE ag.cargo = 'Suporte' \n"
                + "        AND ag.codigocivagestao = ? AND ag.statusgestao = true"
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
                + "    doc.documento\n"
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
            ps.setString(1, codigoCivaSuporteCiva);
            ps.setString(2, codigoCivaGestao);
            rs = ps.executeQuery();

            pessoa = new Pessoa();
            documento1 = new Docs();
            documento2 = new Docs();
            documento3 = new Docs();
            endereco = new Endereco();

            if (rs.next()) {
                pessoa.setDdiContato(rs.getString("ddi"));
                pessoa.setIdPessoa(Integer.parseInt(rs.getString("idpessoa")));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setTelefoneDdd(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailgestao"));

                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

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
            ps.setString(1, codigoCivaSuporteCiva);
            rs = ps.executeQuery();

            if (rs.next()) {
                documento1.setNomeTipoDoc(rs.getString("nomedoc"));
                documento1.setDocumento(rs.getString("documento"));
            }

            if (rs.next()) {
                documento2.setNomeTipoDoc(rs.getString("nomedoc"));
                documento2.setDocumento(rs.getString("documento"));
            }

            if (rs.next()) {
                documento3.setNomeTipoDoc(rs.getString("nomedoc"));
                documento3.setDocumento(rs.getString("documento"));
            }

            suporteCiva = new SuporteCiva(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(SuporteCivaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return suporteCiva;
    }

    public static List<SuporteCiva> listByGestorNacional(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();
        List<SuporteCiva> suportesCiva = null;
        SuporteCiva suporteCiva;
        Pessoa pessoa;
        Docs documento1;
        String sql = "";

        sql = "SELECT DISTINCT peag.nomepessoa, peag.sobrenomepessoa, pa.ddi,\n"
                + "	       doc.documento,\n"
                + "	       peag.datadenascimento,\n"
                + "	       ag.codigocivagestao\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN docs doc \n"
                + "on peag.idpessoa = doc.idpessoa\n"
                + "LEFT JOIN tipodoc tidoc \n"
                + "ON tidoc.idtipodoc = doc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag \n"
                + "on peag.idpessoa = ag.idpessoa\n"
                + "LEFT JOIN pais pa \n"
                + "on peag.idpaisdenascimento = pa.idpais\n"
                + "WHERE ag.cargo = 'Suporte'\n"
                + "AND tidoc.nivel ='Primário'\n"
                + "AND peag.idpaisdenascimento = (\n"
                + "SELECT peag.idpaisdenascimento FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag\n"
                + "ON peag.idpessoa = ag.idpessoa\n"
                + "WHERE ag.codigocivagestao = ?) AND ag.statusgestao = true;";

        try {
            suportesCiva = new ArrayList<>();
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                documento1 = new Docs();

                pessoa.setDdiContato(rs.getString("ddi"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));
                documento1.setDocumento(rs.getString("documento"));

                suporteCiva = new SuporteCiva();
                suporteCiva.setPessoa(pessoa);
                suporteCiva.setDocumento1(documento1);
                suporteCiva.setCodigoCiva(pessoa.getCodigoCiva());
                System.out.println("teste " + pessoa.getNomePessoa());

                suportesCiva.add(suporteCiva);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SuporteCivaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return suportesCiva;
    }

    public static String gerarCodigoCiva(String nomePais, int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String atorSigla = "SPT";
        String codigoCiva = "";
        String sigla = PaisDao.getSiglaByName(nomePais);

        sql = "SELECT COUNT(*) + 100000000 + ? AS codigo\n"
                + "FROM acessogestao AS acg\n"
                + "WHERE acg.cargo LIKE 'Suporte';";

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

    public static boolean insert(SuporteCiva suporteCiva, int idCadastrante) {
        boolean resultado = false;

        Pessoa pessoa = suporteCiva.getPessoa();
        Docs documento1 = suporteCiva.getDocumento1();
        Endereco endereco = suporteCiva.getEndereco();

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

            String codigoCivaSuporteCiva = SuporteCivaDao.gerarCodigoCiva(endereco.getNomePais(), idPessoa);
            System.err.println(codigoCivaSuporteCiva);

            String cargo = "Suporte";
            resultado = PessoaDao.insertAcessoGestao(idPessoa, idCadastrante, cargo, codigoCivaSuporteCiva, pessoa.getEmail(), formatador.format(data));

            System.err.println("Chegou no dao do suporte civa " + suporteCiva.getPessoa().getNomePessoa());
        } catch (Exception e) {
        }

        return resultado;
    }

    public static boolean update(SuporteCiva suporteCiva) {
         Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;
        Pessoa pessoa = suporteCiva.getPessoa();
        Docs documento1 = suporteCiva.getDocumento1();
        Endereco endereco = suporteCiva.getEndereco();

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

    public static boolean delete(SuporteCiva suporteCiva) {
            boolean resultado = false;
        Pessoa pessoa = suporteCiva.getPessoa();
        int idAcessoGestao = PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa());
        
        resultado = PessoaDao.desativarAcessoGestao(idAcessoGestao);
        
        return resultado;
    }
}
