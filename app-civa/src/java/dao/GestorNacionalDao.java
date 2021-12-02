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
import model.GestorNacional;
import model.Pais;
import model.Pessoa;

/**
 *
 * @author Geize Kele | Israel de Araujo
 */
public class GestorNacionalDao {

    public static GestorNacional findByCodigociva(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();

        GestorNacional gestorNacional = null;

        Pessoa pessoa = null;
        Endereco endereco = null;
        Docs documento1 = null;
        Docs documento2 = null;
        Docs documento3 = null;

        String sql = "";
        String sql2 = "";
        String sql3 = "";

        sql = "SELECT ag.codigocivagestao AS codigociva,\n"
                + "	   peag.nomepessoa AS nome, peag.idpessoa, \n"
                + "	   peag.sobrenomepessoa AS sobrenome,\n"
                + "        peag.genero,\n"
                + "	   peag.datadenascimento AS datanascimento,\n"
                + "	   pa.nomedopais AS pais,\n"
                + "	   en.codigopostal,\n"
                + "	   en.tipodelogradouro,\n"
                + "	   en.logradouro,\n"
                + "	   peen.numero,\n"
                + "	   peen.complemento,\n"
                + "	   en.nomesubdivisao1 AS subdivisao3,\n"
                + "	   en.nomesubdivisao2 subdivisao2,\n"
                + "	   en.nomesubdivisao3 subdivisao1, \n"
                + "	   peag.telefonecomddd,\n"
                + "	   ag.emailgestao\n"
                + "FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag\n"
                + "   ON peag.idpessoa = ag.idpessoa\n"
                + "LEFT JOIN pais pa\n"
                + "   ON peag.idpaisdenascimento = pa.idpais\n"
                + "LEFT JOIN pessoa_endereco peen\n"
                + "	ON peag.idpessoa = peen.idpessoa \n"
                + "LEFT JOIN endereco en\n"
                + "   ON peen.idendereco = en.idendereco\n"
                + "WHERE ag.cargo = 'Gestor Nacional'\n"
                + "AND ag.codigocivagestao = ?;";

        sql2 = "SELECT tidoc.nomedoc , doc.documento FROM pessoa peag\n"
                + "        LEFT JOIN acessogestao ag \n"
                + "            ON peag.idpessoa = ag.idpessoa \n"
                + "        LEFT JOIN docs doc\n"
                + "            ON doc.idpessoa = peag.idpessoa \n"
                + "        LEFT JOIN tipodoc tidoc\n"
                + "            ON doc.idtipodoc = tidoc.idtipodoc\n"
                + "        WHERE ag.codigocivagestao = ?;";
        
        sql3 = "";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            pessoa = new Pessoa();
            endereco = new Endereco();                         

            if (rs.next()) {
                
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setCodigoCiva(rs.getString("codigociva"));
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datanascimento"));
                pessoa.setTelefoneDdd(rs.getString("telefonecomddd"));
                pessoa.setEmail(rs.getString("emailgestao"));
                
                Pais pais = PaisDao.findByIdPessoa(pessoa.getIdPessoa());
                pessoa.setNacionalidade(pais.getNomePais());

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
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            documento1 = new Docs();
            documento2 = new Docs();
            documento3 = new Docs();

            if (rs.next()) {
                documento1.setDocumento(rs.getString("documento"));
                documento1.setNomeTipoDoc(rs.getString("nomedoc"));
            }

            if (rs.next()) {
                documento2.setDocumento(rs.getString("documento"));
                documento2.setNomeTipoDoc(rs.getString("nomedoc"));
            }

            if (rs.next()) {
                documento3.setDocumento(rs.getString("documento"));
                documento3.setNomeTipoDoc(rs.getString("nomedoc"));
            }
            
            gestorNacional = new GestorNacional(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());

        } catch (SQLException ex) {
            Logger.getLogger(GestorNacionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gestorNacional;
    }

    public static List<GestorNacional> listBySuporteCiva(String codigoCivaSuportel) {
        Connection connection = ConnectionFactory.getConnection();
        GestorNacional gestorNacional;
        List<GestorNacional> gestoresNacionais = null;
        Pessoa pessoa;
        Docs documento1;
        String sql = "";

        sql = "SELECT DISTINCT peag.nomepessoa AS nome,"
                + "            doc.documento,"
                + "            peag.datadenascimento, \n"
                + "            ag.codigocivagestao "
                + "    FROM pessoa peag\n"
                + "    LEFT JOIN docs doc \n"
                + "        on peag.idpessoa = doc.idpessoa\n"
                + "    LEFT JOIN tipodoc tidoc \n"
                + "        ON tidoc.idtipodoc = doc.idtipodoc \n"
                + "    LEFT JOIN acessogestao ag \n"
                + "        on peag.idpessoa = ag.idpessoa\n"
                + "    WHERE ag.cargo = 'Gestor Nacional'\n"
                + "    AND tidoc.nivel ='Primário'\n"
                + "    AND peag.idpaisdenascimento = (\n"
                + "        SELECT peag.idpaisdenascimento FROM pessoa peag\n"
                + "        LEFT JOIN acessogestao ag\n"
                + "            ON peag.idpessoa = ag.idpessoa\n"
                + "        WHERE ag.codigocivagestao = ? );";

        try {
            gestoresNacionais = new ArrayList<>();
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaSuportel);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                documento1 = new Docs();
                gestorNacional = new GestorNacional();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));
                documento1.setDocumento(rs.getString("documento"));

                gestorNacional.setPessoa(pessoa);
                gestorNacional.setDocumento1(documento1);
                gestorNacional.setCodigoCiva(pessoa.getCodigoCiva());

                gestoresNacionais.add(gestorNacional);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorNacionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gestoresNacionais;
    }
    
    public static List<GestorNacional> listByGestorNacional(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();
        GestorNacional gestorNacional;
        List<GestorNacional> gestoresNacionais = null;
        Pessoa pessoa;
        Docs documento1;
        String sql = "";

        sql = "SELECT DISTINCT peag.nomepessoa AS nome,"
                + "            doc.documento,"
                + "            peag.datadenascimento, \n"
                + "            ag.codigocivagestao "
                + "    FROM pessoa peag\n"
                + "    LEFT JOIN docs doc \n"
                + "        on peag.idpessoa = doc.idpessoa\n"
                + "    LEFT JOIN tipodoc tidoc \n"
                + "        ON tidoc.idtipodoc = doc.idtipodoc \n"
                + "    LEFT JOIN acessogestao ag \n"
                + "        on peag.idpessoa = ag.idpessoa\n"
                + "    WHERE ag.cargo = 'Gestor Nacional'\n"
                + "    AND tidoc.nivel ='Primário'\n"
                + "    AND peag.idpaisdenascimento = (\n"
                + "        SELECT peag.idpaisdenascimento FROM pessoa peag\n"
                + "        LEFT JOIN acessogestao ag\n"
                + "            ON peag.idpessoa = ag.idpessoa\n"
                + "        WHERE ag.codigocivagestao = ? );";

        try {
            gestoresNacionais = new ArrayList<>();
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGestorNacional);
            rs = ps.executeQuery();

            while (rs.next()) {
                pessoa = new Pessoa();
                documento1 = new Docs();
                gestorNacional = new GestorNacional();

                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setCodigoCiva(rs.getString("codigocivagestao"));
                documento1.setDocumento(rs.getString("documento"));

                gestorNacional.setPessoa(pessoa);
                gestorNacional.setDocumento1(documento1);
                gestorNacional.setCodigoCiva(pessoa.getCodigoCiva());

                gestoresNacionais.add(gestorNacional);

            }

        } catch (SQLException ex) {
            Logger.getLogger(GestorNacionalDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gestoresNacionais;
    }

    public static boolean insert(GestorNacional gestornacional) {
        boolean resultado = false;

        // Insert into Gestor Nacional values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static boolean update(GestorNacional gestorNacional) {
        boolean resultado = false;

        // Update Gestor Nacional;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(GestorNacional gestorNacional) {
        boolean resultado = false;

        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static GestorNacional find(String codigoCivaGestorNacional) {
        for (GestorNacional gestorNacional : GestorNacionalDao.list()) {
            if (gestorNacional.getCodigoCiva().equals(codigoCivaGestorNacional)) {
                return gestorNacional;
            }
        }

        return null;

    }

    public static List<GestorNacional> list() {
        List<GestorNacional> gestoresNacionais = new ArrayList<GestorNacional>();
        return gestoresNacionais;
    }
}
