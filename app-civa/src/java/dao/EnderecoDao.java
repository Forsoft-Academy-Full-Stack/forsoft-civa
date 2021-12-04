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

        //"SELECT * FROM endereco;
        Endereco endereco = new Endereco();

        endereco.setCodigoPostal("");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setTipoLogradouro("");
        endereco.setLogradouro("");
        endereco.setNomesubdivisao1("");
        endereco.setNomesubdivisao2("");
        endereco.setNomesubdivisao3("");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setNomesubdivisao6("");
        endereco.setNomesubdivisao7("");

        enderecos.add(endereco);

        Endereco endereco2 = new Endereco();

        endereco2.setCodigoPostal("");
        endereco2.setIdEndereco(1);
        endereco2.setIdPais(1);
        endereco2.setTipoLogradouro("");
        endereco2.setLogradouro("");
        endereco2.setNomesubdivisao1("");
        endereco2.setNomesubdivisao2("");
        endereco2.setNomesubdivisao3("");
        endereco2.setNomesubdivisao4("");
        endereco2.setNomesubdivisao5("");
        endereco2.setNomesubdivisao6("");
        endereco2.setNomesubdivisao7("");

        enderecos.add(endereco2);

        return enderecos;
    }

    public static boolean update(Endereco enderecoNovo) {
        boolean resultado = false;

        // Update endereco;
        if (true) {
            resultado = true;
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
