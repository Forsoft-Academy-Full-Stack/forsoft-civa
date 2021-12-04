package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Login;
import model.Pessoa;

public class LoginDao {

    public static Pessoa validar(Login login) {
        Connection connection = ConnectionFactory.getConnection();
        String sqlPortador = "";
        String sqlGestao = "";
        Pessoa dadosPessoa = null;

        sqlPortador = "SELECT nomepessoa AS nome,\n"
                + "       sobrenomepessoa AS sobrenome,\n"
                + "       codigocivapc as codigociva,"
                + "       p.idpessoa \n"
                + "FROM pessoa AS p\n"
                + "LEFT JOIN acessopc AS acp\n"
                + "ON p.idpessoa = acp.idpessoa\n"
                + "WHERE acp.emailpc = ? AND acp.senhapc = ? ;";

        sqlGestao = "SELECT p.nomepessoa AS nome,\n"
                + "       p.sobrenomepessoa AS sobrenome,\n"
                + "       acg.codigocivagestao AS codigociva, \n"
                + "       p.idpessoa \n"
                + "FROM pessoa AS p\n"
                + "LEFT JOIN acessogestao AS acg\n"
                + "ON p.idpessoa = acg.idpessoa\n"
                + "WHERE acg.codigocivagestao LIKE ?\n"
                + "	AND acg.senhagestao = ?\n"
                + " AND acg.cargo LIKE ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;

            switch (login.getPerfil()) {
                case "portador-civa":
                    ps = connection.prepareStatement(sqlPortador);

                    ps.setString(1, login.getEmail().trim());
                    ps.setString(2, login.getSenha().trim());
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;

                case "gerente":
                    ps = connection.prepareStatement(sqlGestao);

                    ps.setString(1, login.getCodigoCiva().trim());
                    ps.setString(2, login.getSenha().trim());
                    ps.setString(3, "Gerente");

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;

                case "supervisor":
                    ps = connection.prepareStatement(sqlGestao);

                    ps.setString(1, login.getCodigoCiva().trim());
                    ps.setString(2, login.getSenha().trim());
                    ps.setString(3, "Supervisor");

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;

                case "profissional-saude":
                    ps = connection.prepareStatement(sqlGestao);

                    ps.setString(1, login.getCodigoCiva().trim());
                    ps.setString(2, login.getSenha().trim());
                    ps.setString(3, "Profissional de Saúde");

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;

                case "suporte-civa":
                    ps = connection.prepareStatement(sqlGestao);

                    ps.setString(1, login.getCodigoCiva().trim());
                    ps.setString(2, login.getSenha().trim());
                    ps.setString(3, "Suporte");

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;

                case "gestor-nacional":
                    ps = connection.prepareStatement(sqlGestao);

                    ps.setString(1, login.getCodigoCiva().trim());
                    ps.setString(2, login.getSenha().trim());
                    ps.setString(3, "Gestor Nacional");

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;

                case "gestor-oms":
                    ps = connection.prepareStatement(sqlGestao);

                    ps.setString(1, login.getCodigoCiva().trim());
                    ps.setString(2, login.getSenha().trim());
                    ps.setString(3, "Gestor OMS");

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;

                case "administrador-oms":
                    ps = connection.prepareStatement(sqlGestao);

                    ps.setString(1, login.getCodigoCiva().trim());
                    ps.setString(2, login.getSenha().trim());
                    ps.setString(3, "Administrador");

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                        dadosPessoa.setIdPessoa(rs.getInt("idpessoa"));
                    }

                    break;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dadosPessoa;
    }
}
