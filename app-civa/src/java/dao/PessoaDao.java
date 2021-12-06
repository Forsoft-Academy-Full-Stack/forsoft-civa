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

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, pessoa.getIdNacionalidade());
            ps.setString(2, pessoa.getNomePessoa());
            ps.setString(3, pessoa.getSobrenomePessoa());
            ps.setString(4, pessoa.getGenero());
            ps.setString(5, pessoa.getDataNascimento());
            ps.setString(6, pessoa.getDdiContato());
            ps.setString(7, pessoa.getTelefoneDdd());

            int i = ps.executeUpdate();

            rs = ps.getGeneratedKeys();

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

    public static Boolean update(Pessoa pessoa) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "UPDATE pessoa\n"
                    + "   SET idpaisdenascimento=?,"
                    + "         nomepessoa=?,"
                    + "         sobrenomepessoa=?,"
                    + "         genero=?,"
                    + "         datadenascimento=?,"
                    + "         ddidocontato=?,"
                    + "         telefonecomddd=?\n"
                    + "   WHERE idpessoa=?;";

            ps = connection.prepareStatement(sql);

            ps.setInt(1, pessoa.getIdNacionalidade());
            ps.setString(2, pessoa.getNomePessoa());
            ps.setString(3, pessoa.getSobrenomePessoa());
            ps.setString(4, pessoa.getGenero());
            ps.setString(5, pessoa.getDataNascimento());
            ps.setString(6, pessoa.getDdiContato());
            ps.setString(7, pessoa.getTelefoneDdd());
            ps.setInt(8, pessoa.getIdPessoa());

            ps.executeUpdate();

            PessoaDao.updateAcessoPc(pessoa.getEmail(), PessoaDao.getIdAcessoPc(pessoa.getIdPessoa()));

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public static int getIdPessoa(String codigoCiva) {
        Connection connection = ConnectionFactory.getConnection();
        int idPessoa = -1;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            sql = "SELECT pe.idpessoa\n"
                    + "FROM pessoa AS pe\n"
                    + "LEFT JOIN acessogestao as ac\n"
                    + "ON pe.idpessoa = ac.idpessoa\n"
                    + "LEFT JOIN acessopc AS ag\n"
                    + "ON pe.idpessoa = ag.idpessoa\n"
                    + "WHERE ag.codigocivapc = ? OR ac.codigocivagestao = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, codigoCiva);
            ps.setString(2, codigoCiva);

            rs = ps.executeQuery();

            if (rs.next()) {
                idPessoa = rs.getInt("idpessoa");
                System.out.println("ID da pessoa: " + idPessoa);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idPessoa;
    }

    public static Boolean updateAcessoPc(String email, int idAcessoPc) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "UPDATE acessopc\n"
                    + "SET emailpc=?\n"
                    + "WHERE idacessopc=?;";

            ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setInt(2, idAcessoPc);

            ps.executeUpdate();

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public static int getIdAcessoPc(int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        int idAcessoPc = -1;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            sql = "SELECT acessopc.idacessopc \n"
                    + "FROM acessopc\n"
                    + "WHERE acessopc.idpessoa = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idPessoa);

            rs = ps.executeQuery();

            if (rs.next()) {
                idAcessoPc = rs.getInt("idacessopc");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idAcessoPc;
    }

    public static Boolean updateAcessoGestao(String email, int idAcessocGestao) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "UPDATE acessogestao\n"
                    + "SET  emailgestao=?\n"
                    + "WHERE idacessogestao=?;";

            ps = connection.prepareStatement(sql);

            ps.setString(1, email);
            ps.setInt(2, idAcessocGestao);

            ps.executeUpdate();

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public static int getIdAcessoGestao(int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        int idAcessoPc = -1;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            sql = "SELECT acessogestao.idacessogestao\n"
                    + "FROM acessogestao\n"
                    + "WHERE acessogestao.idpessoa =?;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idPessoa);

            rs = ps.executeQuery();

            if (rs.next()) {
                idAcessoPc = rs.getInt("idacessogestao");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idAcessoPc;
    }

}
