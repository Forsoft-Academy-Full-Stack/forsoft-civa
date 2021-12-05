package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

public class PessoaDao {

    public static Pessoa findById(Integer idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        Pessoa pessoa = null;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            sql = "SELECT * FROM pessoa WHERE idpessoa = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idPessoa);
            rs = ps.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setIdPessoa(rs.getInt("idpessoa"));
                pessoa.setIdNacionalidade(rs.getInt("idpaisdenascimento"));
                pessoa.setNomePessoa(rs.getString("nome"));
                pessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                pessoa.setGenero(rs.getString("genero"));
                pessoa.setDataNascimento(rs.getString("datadenascimento"));
                pessoa.setDdiContato(rs.getString("ddidocontato"));
                pessoa.setDdiContato(rs.getString("telefonecomddd"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pessoa;
    }

    public static int insert(Pessoa pessoa) {
        Connection connection = ConnectionFactory.getConnection();
        int idPessoa = -1;

        try {
            ResultSet rs = null;
            String sql = "";

            sql = "INSERT INTO pessoa\n"
                    + "(idpaisdenascimento, nomepessoa, sobrenomepessoa, genero, datadenascimento, ddidocontato, telefonecomddd)\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?);";

            System.err.println("Chegou aquiu");
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            System.err.println("Chegou aquiu tb");
            ps.setInt(1, pessoa.getIdNacionalidade());
            ps.setString(2, pessoa.getNomePessoa());
            ps.setString(3, pessoa.getSobrenomePessoa());
            ps.setString(4, pessoa.getGenero());
            ps.setString(5, pessoa.getDataNascimento());
            ps.setString(6, pessoa.getDdiContato());
            ps.setString(7, pessoa.getTelefoneDdd());

            int i = ps.executeUpdate();
            System.err.println("Chegou aquiu tb tb" + i);
            rs = ps.getGeneratedKeys();
            System.err.println("Chegou aquiu tb tb" + rs);

            if (rs.next()) {
                idPessoa = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.err.println(idPessoa);
        return idPessoa;
    }

    public static boolean insertAcessoGestao(int idPessoa, int idCadastrante, String cargo, String codigoCiva, String email, String dataRegistro) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "";

            sql = "INSERT INTO acessogestao\n"
                    + "(idpessoa, idcadastrante, codigocivagestao, cargo, emailgestao, senhagestao, dataregistrogestao)\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?);";

            ps = connection.prepareStatement(sql);

            ps.setInt(1, idPessoa);
            ps.setInt(2, idCadastrante);
            ps.setString(3, codigoCiva);
            ps.setString(4, cargo);
            ps.setString(5, email);
            ps.setString(6, "12345");
            ps.setString(7, dataRegistro);

            ps.executeUpdate();

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public static boolean insertAcessoPc(int idPessoa, int idCadastrante, String codigoCiva, String email, String dataRegistro) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "";

            sql = "INSERT INTO acessopc\n"
                    + "(idpessoa, idcadastrante, codigocivapc, emailpc, senhapc, dataregistropc)\n"
                    + "VALUES(?, ?, ?, ?, ?, ?);";

            ps = connection.prepareStatement(sql);

            ps.setInt(1, idPessoa);
            ps.setInt(2, idCadastrante);
            ps.setString(3, codigoCiva);
            ps.setString(4, email);
            ps.setString(5, "12345");
            ps.setString(6, dataRegistro);

            ps.executeUpdate();

            resultado = true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public static int vincularEndereco(int idPessoa, int idEndereco, String numero, String complemento) {
        Connection connection = ConnectionFactory.getConnection();
        int idPessoaEndereco = -1;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            sql = "INSERT INTO pessoa_endereco\n"
                    + "(idpessoa, idendereco, numero, complemento)\n"
                    + "VALUES(?, ?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idPessoa);
            ps.setInt(2, idEndereco);
            ps.setString(3, numero);
            ps.setString(4, complemento);

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idPessoaEndereco = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idPessoaEndereco;
    }

    public static Pessoa list(String pattern) {

        return new Pessoa();
    }
}
