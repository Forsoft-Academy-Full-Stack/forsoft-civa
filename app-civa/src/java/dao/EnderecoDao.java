package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;

public class EnderecoDao {

    public static int insert(Endereco endereco) {
        Connection connection = ConnectionFactory.getConnection();
        int idEndereco = -1;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            sql = "INSERT INTO endereco\n"
                    + "(idpais, tipodelogradouro, logradouro, codigopostal, nomesubdivisao1, nomesubdivisao2, nomesubdivisao3, nomesubdivisao4, nomesubdivisao5, nomesubdivisao6, nomesubdivisao7)\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, endereco.getIdPais());
            ps.setString(2, endereco.getTipoLogradouro());
            ps.setString(3, endereco.getLogradouro());
            ps.setString(4, endereco.getCodigoPostal());
            ps.setString(5, endereco.getNomesubdivisao1());
            ps.setString(6, endereco.getNomesubdivisao2());
            ps.setString(7, endereco.getNomesubdivisao3());
            ps.setString(8, endereco.getNomesubdivisao4());
            ps.setString(9, endereco.getNomesubdivisao5());
            ps.setString(10, endereco.getNomesubdivisao6());
            ps.setString(11, endereco.getNomesubdivisao7());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idEndereco;
    }

    public static Endereco find(Integer idEndereco) {
        for (Endereco unidade : EnderecoDao.list()) {
            if (Objects.equals(unidade.getIdEndereco(), idEndereco)) {
                return unidade;
            }
        }

        return null;
    }

    public static List<Endereco> list() {
        List<Endereco> enderecos = new ArrayList<Endereco>();

        return enderecos;
    }

    public static int getIdEnderecoByIdPessoa(int idPessoa) {
        Connection connection = ConnectionFactory.getConnection();
        int idEndereco = -1;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            sql = "SELECT en.idendereco\n"
                    + "FROM endereco AS en\n"
                    + "LEFT JOIN pessoa_endereco AS pen\n"
                    + "ON en.idendereco = pen.idendereco\n"
                    + "LEFT JOIN pessoa AS pe\n"
                    + "ON pen.idpessoa = pe.idpessoa\n"
                    + "WHERE pe.idpessoa = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idPessoa);

            rs = ps.executeQuery();

            if (rs.next()) {
                idEndereco = rs.getInt("idendereco");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idEndereco;
    }

    public static boolean update(Endereco endereco) {
        Connection connection = ConnectionFactory.getConnection();
        Boolean resultado = false;

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            PreparedStatement ps;
            String sql = "UPDATE endereco\n"
                    + "SET idpais=?,"
                    + "tipodelogradouro=?,"
                    + " logradouro=?,"
                    + "codigopostal=?,"
                    + "nomesubdivisao1=?,"
                    + " nomesubdivisao2=?,"
                    + " nomesubdivisao3=?,"
                    + "nomesubdivisao4=?,"
                    + "nomesubdivisao5=?,"
                    + "nomesubdivisao6=?,"
                    + " nomesubdivisao7=?\n"
                    + "WHERE idendereco=?;";

            ps = connection.prepareStatement(sql);
         
            ps.setInt(1, endereco.getIdPais());
            ps.setString(2, endereco.getTipoLogradouro().trim());
            ps.setString(3, endereco.getLogradouro().trim());
            ps.setString(4, endereco.getCodigoPostal().trim());
            ps.setString(5, endereco.getNomesubdivisao1().trim());
            ps.setString(6, endereco.getNomesubdivisao2().trim());
            ps.setString(7, endereco.getNomesubdivisao3().trim());
            ps.setString(8, endereco.getNomesubdivisao4().trim());
            ps.setString(9, endereco.getNomesubdivisao5().trim());
            ps.setString(10, endereco.getNomesubdivisao6().trim());
            ps.setString(11, endereco.getNomesubdivisao7().trim());
            ps.setInt(12, endereco.getIdEndereco());

            ps.executeUpdate();

            resultado = true;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public static boolean delete(Endereco endereco) {
        boolean resultado = false;

        // Delete Endereco;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
