package dao;

import model.Login;
import model.Pessoa;

/**
 *
 * @author randel
 */
public class LoginDao {

    public static Pessoa validar(Login login) {
        Pessoa dadosPessoa = new Pessoa();

        //Tratamento dos dados e configuração na sessão
        switch (login.getPerfil()) {
            case "portador-civa":
                if (login.getEmail().equals("joaolopes@gmail.com") && login.getSenha().equals("123")) {
                    dadosPessoa.setNome("João");
                    dadosPessoa.setSobrenome("Lopes");
                }
                break;
                
            case "gerente":
                if (login.getCodigoCiva().equals("1") && login.getSenha().equals("1234")) {
                    dadosPessoa.setNome("Lucia");
                    dadosPessoa.setSobrenome("Alves");
                }
                break;
                
            case "supervisor":
                if (login.getCodigoCiva().equals("2") && login.getSenha().equals("12345")) {
                    dadosPessoa.setNome("Pedro");
                    dadosPessoa.setSobrenome("Almeida");
                }
                break;
                
            case "profissional-saude":
                if (login.getCodigoCiva().equals("3") && login.getSenha().equals("123456")) {
                    dadosPessoa.setNome("Victoria");
                    dadosPessoa.setSobrenome("Strada");
                }
                break;
                
            case "suporte-civa":
                if (login.getCodigoCiva().equals("4") && login.getSenha().equals("1234567")) {
                    dadosPessoa.setNome("Victoria");
                    dadosPessoa.setSobrenome("Strada");
                }
                break;
                
            case "gestor-nacional":
                if (login.getCodigoCiva().equals("5") && login.getSenha().equals("12345678")) {
                    dadosPessoa.setNome("Lucas");
                    dadosPessoa.setSobrenome("Santos");
                }
                break;
                      
            case "gestor-oms":
                if (login.getCodigoCiva().equals("6") && login.getSenha().equals("123456789")) {
                    dadosPessoa.setNome("Ruth");
                    dadosPessoa.setSobrenome("Alencar");
                }
                break;
        }

        return dadosPessoa;
    }
}
