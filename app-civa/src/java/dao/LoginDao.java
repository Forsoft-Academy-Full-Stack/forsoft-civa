package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Gerente;
import model.GestorNacional;
import model.GestorOms;
import model.Login;
import model.Pessoa;
import model.PortadorCiva;
import model.ProfissionalSaude;
import model.Supervisor;
import model.SuporteCiva;

public class LoginDao {

    public static Pessoa validar(Login login) {
        Connection connection = ConnectionFactory.getConnection();

        Pessoa dadosPessoa = null;

        //Tratamento dos dados e configuração na sessão
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = null;
            String sql = "";

            switch (login.getPerfil()) {
                case "portador-civa":

                    sql = "SELECT nomepessoa AS nome,\n"
                            + "       sobrenomepessoa AS sobrenome,\n"
                            + "       codigocivapc as codigociva\n"
                            + "FROM pessoa AS p\n"
                            + "LEFT JOIN acessopc AS acp\n"
                            + "ON p.idpessoa = acp.idpessoa\n"
                            + "WHERE acp.emailpc = ? AND acp.senhapc = ? ;";

                    PreparedStatement ps = connection.prepareStatement(sql);

                    ps.setString(1, login.getEmail().trim());
                    ps.setString(2, login.getSenha().trim());
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        dadosPessoa = new Pessoa();
                        dadosPessoa.setNomePessoa(rs.getString("nome"));
                        dadosPessoa.setSobrenomePessoa(rs.getString("sobrenome"));
                        dadosPessoa.setCodigoCiva(rs.getString("codigociva"));
                    }
                    
                    System.err.println(dadosPessoa.getNomePessoa());
                    //ResultSet rs = ps.executeQuery();
                    // rs = stmt.executeQuery("SELECT * FROM pessoa WHERE email=" + login.getEmail() + " and senha=" + login.getSenha());
                    break;

                case "gerente":
                    for (Gerente gerente : GerenteDao.list()) {
                        if (login.getCodigoCiva().trim().equals(gerente.getCodigoCiva().trim()) && login.getSenha().trim().equals("1234")) {

                            dadosPessoa.setNomePessoa(gerente.getPessoa().getNomePessoa());
                            dadosPessoa.setSobrenomePessoa(gerente.getPessoa().getSobrenomePessoa());
                            dadosPessoa.setCodigoCiva(gerente.getCodigoCiva());
                        }
                    }

                    break;

                case "supervisor":
                    for (Supervisor supervisor : SupervisorDao.list()) {
                        if (login.getCodigoCiva().trim().equals(supervisor.getCodigoCiva().trim()) && login.getSenha().trim().equals("12345")) {

                            dadosPessoa.setNomePessoa(supervisor.getPessoa().getNomePessoa());
                            dadosPessoa.setSobrenomePessoa(supervisor.getPessoa().getSobrenomePessoa());
                            dadosPessoa.setCodigoCiva(supervisor.getCodigoCiva());
                        }
                    }

                    break;

                case "profissional-saude":
                    for (ProfissionalSaude profissionalSaude : ProfissionalSaudeDao.list()) {
                        if (login.getCodigoCiva().trim().equals(profissionalSaude.getCodigoCiva().trim()) && login.getSenha().trim().equals("123456")) {

                            dadosPessoa.setNomePessoa(profissionalSaude.getPessoa().getNomePessoa());
                            dadosPessoa.setSobrenomePessoa(profissionalSaude.getPessoa().getSobrenomePessoa());
                            dadosPessoa.setCodigoCiva(profissionalSaude.getCodigoCiva());
                        }
                    }

                    break;

                case "suporte-civa":
                    for (SuporteCiva suporteCiva : SuporteCivaDao.list()) {
                        if (login.getCodigoCiva().trim().equals(suporteCiva.getCodigoCiva().trim()) && login.getSenha().trim().equals("1234567")) {

                            dadosPessoa.setNomePessoa(suporteCiva.getPessoa().getNomePessoa());
                            dadosPessoa.setSobrenomePessoa(suporteCiva.getPessoa().getSobrenomePessoa());
                            dadosPessoa.setCodigoCiva(suporteCiva.getCodigoCiva());
                        }
                    }

                    break;

                case "gestor-nacional":
                    for (GestorNacional gestorNacional : GestorNacionalDao.list()) {
                        if (login.getCodigoCiva().trim().equals(gestorNacional.getCodigoCiva().trim()) && login.getSenha().trim().equals("12345678")) {

                            dadosPessoa.setNomePessoa(gestorNacional.getPessoa().getNomePessoa());
                            dadosPessoa.setSobrenomePessoa(gestorNacional.getPessoa().getSobrenomePessoa());
                            dadosPessoa.setCodigoCiva(gestorNacional.getCodigoCiva());
                        }
                    }

                    break;

                case "gestor-oms":
                    for (GestorOms gestorOms : GestorOmsDao.list()) {
                        if (login.getCodigoCiva().trim().equals(gestorOms.getCodigoCiva().trim()) && login.getSenha().trim().equals("123456789")) {

                            dadosPessoa.setNomePessoa(gestorOms.getPessoa().getNomePessoa());
                            dadosPessoa.setSobrenomePessoa(gestorOms.getPessoa().getSobrenomePessoa());
                            dadosPessoa.setCodigoCiva(gestorOms.getCodigoCiva());
                        }
                    }

                    break;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dadosPessoa;
    }
}
