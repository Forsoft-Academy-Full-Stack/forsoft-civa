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
import model.AdministradorOms;
import model.Docs;
import model.Endereco;
import model.GestorOms;
import model.Pais;
import model.Pessoa;
/**
 *
 * @author Kerolen | Ludwig
 */
public class AdministradorOmsDao {

    public static GestorOms findAdministrador(String codigoCivaAdministradorOms) {
        Connection connection = ConnectionFactory.getConnection();
        GestorOms gestoroms = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;
        String sql = "";
        String sql2 = "";

        sql = "SELECT peag.idpessoa, ag.codigocivagestao , peag.nomepessoa, peag.sobrenomepessoa , peag.genero,  peag.datadenascimento, \n"
                + "pa.nomedopais, en.codigopostal, en.tipodelogradouro, en.logradouro, peen.numero,  peen.complemento, en.nomesubdivisao1, en.nomesubdivisao2, en.nomesubdivisao3, \n"
                + "peag.telefonecomddd, ag.emailgestao FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON peag.idpessoa = ag.idpessoa  \n"
                + "LEFT JOIN pais pa \n"
                + "ON peag.idpaisdenascimento = pa.idpais \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa  \n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "WHERE ag.cargo = 'Administrador' \n"
                + "AND ag.codigocivagestao = ? AND ag.statusgestao = true;";

        sql2 = "SELECT tidoc.nomedoc, doc.documento FROM pessoa peag\n"
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
            ps.setString(1, codigoCivaAdministradorOms);
            rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setTelefoneDdd(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailgestao"));

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
                endereco.setNomesubdivisao1(rs.getString("nomesubdivisao3"));
                endereco.setNomesubdivisao2(rs.getString("nomesubdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("nomesubdivisao1"));
            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaAdministradorOms);
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

            gestoroms = new GestorOms(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorOmsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gestoroms;

    }

    public static AdministradorOms findByCodigCiva(String codigoCivaGestorOms) {
        Connection connection = ConnectionFactory.getConnection();
        AdministradorOms adiministradoroms = null;
        Pessoa pessoa = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;
        Endereco endereco = null;
        String sql = "";
        String sql2 = "";

        sql = "SELECT peag.idpessoa, ag.codigocivagestao , peag.nomepessoa, peag.sobrenomepessoa , peag.genero,  peag.datadenascimento, \n"
                + "pa.nomedopais, en.codigopostal, en.tipodelogradouro, en.logradouro, peen.numero,  peen.complemento, en.nomesubdivisao1, en.nomesubdivisao2, en.nomesubdivisao3, \n"
                + "peag.telefonecomddd, ag.emailgestao, pa.ddi FROM pessoa peag \n"
                + "LEFT JOIN acessogestao ag \n"
                + "ON peag.idpessoa = ag.idpessoa  \n"
                + "LEFT JOIN pais pa \n"
                + "ON peag.idpaisdenascimento = pa.idpais \n"
                + "LEFT JOIN pessoa_endereco peen \n"
                + "ON peag.idpessoa = peen.idpessoa  \n"
                + "LEFT JOIN endereco en \n"
                + "ON peen.idendereco = en.idendereco \n"
                + "WHERE ag.cargo = 'Administrador' \n"
                + "AND ag.codigocivagestao = ? AND ag.statusgestao = true;";

        sql2 = "SELECT tidoc.nomedoc, doc.documento FROM pessoa peag\n"
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
            ps.setString(1, codigoCivaGestorOms);
            rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setTelefoneDdd(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailgestao"));
                pessoa.setDdiContato(rs.getString("ddi"));

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
                endereco.setNomesubdivisao1(rs.getString("nomesubdivisao3"));
                endereco.setNomesubdivisao2(rs.getString("nomesubdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("nomesubdivisao1"));
            }

            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaGestorOms);
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

            adiministradoroms = new AdministradorOms(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorOmsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adiministradoroms;

    }

    public static List<AdministradorOms> listByAdiministradorOms() {
        Connection connection = ConnectionFactory.getConnection();
        List<AdministradorOms> adiministradoresOms = new ArrayList<>();
        AdministradorOms adiministradorOms;
        Pessoa pessoa = null;
        Docs documento1 = null;
        String sql = "";
        String sql2 = "";

        sql = "SELECT DISTINCT peag.nomepessoa,"
                + "peag.sobrenomepessoa , doc.documento , peag.datadenascimento , ag.codigocivagestao FROM pessoa peag\n"
                + "left join docs doc\n"
                + "on peag.idpessoa = doc.idpessoa \n"
                + "left join tipodoc tidoc \n"
                + "on tidoc.idtipodoc = doc.idtipodoc \n"
                + "LEFT JOIN acessogestao ag\n"
                + "on ag.idpessoa = peag.idpessoa \n"
                + "WHERE ag.cargo = 'Administrador'\n"
                + "AND tidoc.nivel = 'Primário' AND ag.statusgestao = true;";

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;

            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));

                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));

                adiministradorOms = new AdministradorOms();
                adiministradorOms.setPessoa(pessoa);
                adiministradorOms.setDocumento1(documento1);
                adiministradorOms.setCodigoCiva(pessoa.getCodigoCiva());

                adiministradoresOms.add(adiministradorOms);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SupervisorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return adiministradoresOms;
    }

    public static String gerarCodigoCiva(int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "";
        String atorSigla = "ADM";
        String codigoCiva = "";

        sql = "SELECT COUNT(*) + 100000000 + ? AS codigo\n"
                + "FROM acessogestao AS acg\n"
                + "WHERE acg.cargo LIKE 'Administrador';";

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

        return atorSigla + codigoCiva + "OMS";

    }

    public static boolean insert(AdministradorOms administradorOms, int idCadastrante) {
        boolean resultado = false;

        Pessoa pessoa = administradorOms.getPessoa();
        Docs documento1 = administradorOms.getDocumento1();
        Endereco endereco = administradorOms.getEndereco();

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

            String codigoCivaAdministrador = AdministradorOmsDao.gerarCodigoCiva(idPessoa);
            System.err.println(codigoCivaAdministrador);

            String cargo = "Administrador";
            resultado = PessoaDao.insertAcessoGestao(idPessoa, idCadastrante, cargo, codigoCivaAdministrador, pessoa.getEmail(), formatador.format(data));

            System.err.println("Chegou no dao do suporte civa " + administradorOms.getPessoa().getNomePessoa());

        } catch (Exception e) {
        }

        return resultado;
    }

    public static boolean update(AdministradorOms administradorOms) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;
        Pessoa pessoa = administradorOms.getPessoa();
        Docs documento1 = administradorOms.getDocumento1();
        Endereco endereco = administradorOms.getEndereco();

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

    public static boolean delete(AdministradorOms administradorOms) {
        boolean resultado = false;
        Pessoa pessoa = administradorOms.getPessoa();
        int idAcessoGestao = PessoaDao.getIdAcessoGestao(pessoa.getIdPessoa());

        resultado = PessoaDao.desativarAcessoGestao(idAcessoGestao);

        return resultado;
    }

}
