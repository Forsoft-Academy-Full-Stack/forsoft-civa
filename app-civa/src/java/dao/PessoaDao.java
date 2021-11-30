/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Pais;
import model.Pessoa;

/**
 *
 * @author miguel.bispo
 */
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

    public static boolean insert(Pessoa pinsert) {
        boolean resultado = false;

        if (pinsert.getNomePessoa() != null) {
            //se conseguir inserir no banco

            // Brasil
            Pais pais = PaisDao.find(1);

            Endereco e = new Endereco();
            e.setIdPais(pais.getIdPais());
            EnderecoDao.insert(e);

            resultado = true;
        }

        return resultado;
    }

    public static Pessoa selectAll(String pattern) {

        return new Pessoa();
    }
}
