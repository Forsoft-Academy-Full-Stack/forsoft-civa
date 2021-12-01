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
import model.SuporteCiva;
import model.Pessoa;

/**
 *
 * @author felipe gomes
 */
public class SuporteCivaDao {

    public static SuporteCiva find(String codigoCivaSuporteCiva) {
        return null;
    }

    public static List<SuporteCiva> listByGestorNacional(String codigoCivaGestorNacional) {
        Connection connection = ConnectionFactory.getConnection();
        List<SuporteCiva> suportesCiva = null;
        SuporteCiva suporteCiva;
        Pessoa pessoa;
        Docs documento1;
        String sql = "";   
        
        sql = "SELECT DISTINCT peag.nomepessoa,\n"
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
                + "WHERE ag.cargo = 'Suporte'\n"
                + "AND tidoc.nivel ='Primário'\n"
                + "AND peag.idpaisdenascimento = (\n"
                + "SELECT peag.idpaisdenascimento FROM pessoa peag\n"
                + "LEFT JOIN acessogestao ag\n"
                + "ON peag.idpessoa = ag.idpessoa\n"
                + "WHERE ag.codigocivagestao = ?);";

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
                                
                pessoa.setNomePessoa(rs.getString("nomepessoa"));
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

    public static boolean insert(SuporteCiva suporteCiva) {
        boolean resultado = false;

        if (true) {
            resultado = true;
        }
        return resultado;
    }

    public static boolean update(SuporteCiva suporteCiva) {
        boolean resultado = false;

        if (true) {
            resultado = true;
        }
        return resultado;
    }

    public static boolean delete(SuporteCiva suporteCiva) {
        boolean resultado = false;

        if (true) {
            resultado = true;
        }
        return resultado;
    }
}
