package dao;

import model.Gerente;
import model.Login;
import model.Pessoa;
import model.Supervisor;

/**
 *
 * @author randel
 */
public class LoginDao {

    public static Pessoa validar(Login login) {
        Pessoa dadosPessoa = new Pessoa();
        Gerente gerente = new Gerente();
    

        //Tratamento dos dados e configuração na sessão
        switch (login.getPerfil()) {
            case "portador-civa":
                if (login.getEmail().equals("joaolopes@gmail.com") && login.getSenha().equals("123")) {
                    dadosPessoa.setNomePessoa("João");
                    dadosPessoa.setSobrenomePessoa("Lopes");                
                }
                break;
                
            case "gerente":
              
                if (login.getCodigoCiva().equals("BR879987") && login.getSenha().equals("1234")) {
                    gerente = GerenteDao.find( login.getCodigoCiva() );
                    
                    dadosPessoa.setNomePessoa(gerente.getPessoa().getNomePessoa());
                    dadosPessoa.setSobrenomePessoa(gerente.getPessoa().getSobrenomePessoa());
                    dadosPessoa.setCondigoCiva(gerente.getCodigoCiva());

                }
                
                if (login.getCodigoCiva().equals("BR99089877") && login.getSenha().equals("1234")) {
                    gerente = GerenteDao.find( login.getCodigoCiva() );
                    
                    dadosPessoa.setNomePessoa(gerente.getPessoa().getNomePessoa());
                    dadosPessoa.setSobrenomePessoa(gerente.getPessoa().getSobrenomePessoa());
                    dadosPessoa.setCondigoCiva(gerente.getCodigoCiva());

                }
                
                break;
                
            case "supervisor":
                if (login.getCodigoCiva().equals("2") && login.getSenha().equals("12345")) {
                    dadosPessoa.setNomePessoa("Pedro");
                    dadosPessoa.setSobrenomePessoa("Almeida");
                }
                break;
                
            case "profissional-saude":
                if (login.getCodigoCiva().equals("3") && login.getSenha().equals("123456")) {
                    dadosPessoa.setNomePessoa("Victoria");
                    dadosPessoa.setSobrenomePessoa("Strada");
                }
                break;
                
            case "suporte-civa":
                if (login.getCodigoCiva().equals("4") && login.getSenha().equals("1234567")) {
                    dadosPessoa.setNomePessoa("Victoria");
                    dadosPessoa.setSobrenomePessoa("Strada");
                }
                break;
                
            case "gestor-nacional":
                if (login.getCodigoCiva().equals("5") && login.getSenha().equals("12345678")) {
                    dadosPessoa.setNomePessoa("Lucas");
                    dadosPessoa.setSobrenomePessoa("Santos");
                }
                break;
                      
            case "gestor-oms":
                if (login.getCodigoCiva().equals("6") && login.getSenha().equals("123456789")) {
                    dadosPessoa.setNomePessoa("Ruth");
                    dadosPessoa.setSobrenomePessoa("Alencar");
                }
                break;               
        }

        return dadosPessoa;
    }
}
