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
import model.Pessoa;
import model.PortadorCiva;
import model.Vacinacao;
/**
 *
 * @author Otacilio Lima
 */
public class PortadorCivaDao {

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
                + "on p.idpessoa = dc.idpessoa\n"
                + "LIMIT 1;";

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

    public static boolean insert(PortadorCiva portadorciva) {
        boolean resultado = false;

        // Insert into PortadorCIVA values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
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

            sql = " SELECT apc.codigocivapc,"
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
                    + "    WHERE apc.codigocivapc = ?;";

            sql2 = "SELECT doc.documento, \n"
                    + "	   tidoc.nomedoc AS tipodocumento\n"
                    + "FROM pessoa pepc\n"
                    + "LEFT JOIN acessopc apc\n"
                    + "ON pepc.idpessoa = apc.idpessoa\n"
                    + "LEFT JOIN docs doc\n"
                    + "ON pepc.idpessoa = doc.idpessoa\n"
                    + "LEFT JOIN tipodoc tidoc\n"
                    + "ON doc.idtipodoc = tidoc.idtipodoc\n"
                    + "WHERE apc.codigocivapc = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaPortadorCiva);
            rs = ps.executeQuery();
            
            portadorCiva = new PortadorCiva();           
            
            if (rs.next()) {              
                pessoa = new Pessoa();
                System.err.println(rs.getString("codigocivapc"));
                pessoa.setCodigoCiva(rs.getString("codigocivapc"));
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenomepessoa"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setNomePessoa(rs.getString("nomedopais"));
                pessoa.setTelefoneDdd(rs.getString("ddidocontato"));
                pessoa.setDdiContato(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailpc"));

                endereco = new Endereco();
                endereco.setCodigoPostal(rs.getString("codigopostal"));
                endereco.setNomesubdivisao1(rs.getString("subdivisao1"));
                endereco.setNomesubdivisao2(rs.getString("subdivisao2"));
                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setTipoLogradouro(rs.getString("tipodelogradouro"));
                endereco.setLogradouro(endereco.getTipoLogradouro() + " " + rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
            }
                        
            ps = connection.prepareStatement(sql2);
            ps.setString(1, codigoCivaPortadorCiva);
            rs = ps.executeQuery();
            
            if(rs.next()){
                documento1 = new Docs();
                documento1.setDocumento(rs.getString("documento"));
                documento1.setTipoDocumento(rs.getString("tipodocumento"));
                portadorCiva.setDocumento1(documento1);
            }
            
            vacinacoes = VacinacaoDao.listByPortadorCiva(codigoCivaPortadorCiva);
                              
            portadorCiva.setListaVacinacao(vacinacoes);
            portadorCiva.setPessoa(pessoa);           
            portadorCiva.setEndereco(endereco);
            portadorCiva.setCodigoCiva(pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(PortadorCivaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return portadorCiva;
    }

    public static List<PortadorCiva> list() {
        List<PortadorCiva> portadoresciva = new ArrayList<PortadorCiva>();
        return portadoresciva;
    }

    public static boolean update(PortadorCiva portadorcivaNovo) {
        boolean resultado = false;

        // Update portadorciva;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(PortadorCiva portadorciva) {
        boolean resultado = false;

        // Delete portadorciva
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
