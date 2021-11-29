package dao;

import model.Gerente;
import model.GestorNacional;
import model.GestorOms;
import model.Login;
import model.Pessoa;
import model.PortadorCiva;
import model.ProfissionalSaude;
import model.Supervisor;
import model.SuporteCiva;
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
                for (PortadorCiva portadorCiva : PortadorCivaDao.list()) {
                    if( login.getEmail().trim().equals( portadorCiva.getPessoa().getEmail().trim() ) && login.getSenha().trim().equals("123")){                        
                    
                        dadosPessoa.setNomePessoa(portadorCiva.getPessoa().getNomePessoa());
                        dadosPessoa.setSobrenomePessoa(portadorCiva.getPessoa().getSobrenomePessoa());
                        dadosPessoa.setCodigoCiva(portadorCiva.getCodigoCiva());
                    }
                }
                                
                break;
                
            case "gerente":                                
                for (Gerente gerente : GerenteDao.list()) {
                    if( login.getCodigoCiva().trim().equals( gerente.getCodigoCiva().trim() ) && login.getSenha().trim().equals("1234")){                        
                    
                        dadosPessoa.setNomePessoa(gerente.getPessoa().getNomePessoa());
                        dadosPessoa.setSobrenomePessoa(gerente.getPessoa().getSobrenomePessoa());
                        dadosPessoa.setCodigoCiva(gerente.getCodigoCiva());
                    }
                }
                                             
                break;
                
            case "supervisor":
                for (Supervisor supervisor : SupervisorDao.list()) {
                    if( login.getCodigoCiva().trim().equals( supervisor.getCodigoCiva().trim() ) && login.getSenha().trim().equals("12345")){                                                                        
                    
                        dadosPessoa.setNomePessoa(supervisor.getPessoa().getNomePessoa());
                        dadosPessoa.setSobrenomePessoa(supervisor.getPessoa().getSobrenomePessoa());
                        dadosPessoa.setCodigoCiva(supervisor.getCodigoCiva());
                    }
                }
                                
                break;
                
            case "profissional-saude":
                for (ProfissionalSaude profissionalSaude : ProfissionalSaudeDao.list()) {
                    if( login.getCodigoCiva().trim().equals( profissionalSaude.getCodigoCiva().trim() ) && login.getSenha().trim().equals("123456")){                                                
                    
                        dadosPessoa.setNomePessoa(profissionalSaude.getPessoa().getNomePessoa());
                        dadosPessoa.setSobrenomePessoa(profissionalSaude.getPessoa().getSobrenomePessoa());
                        dadosPessoa.setCodigoCiva(profissionalSaude.getCodigoCiva());
                    }
                } 
                
                break;
                
            case "suporte-civa":
                for (SuporteCiva suporteCiva : SuporteCivaDao.list()) {
                    if( login.getCodigoCiva().trim().equals( suporteCiva.getCodigoCiva().trim() ) && login.getSenha().trim().equals("1234567")){                      
                    
                        dadosPessoa.setNomePessoa(suporteCiva.getPessoa().getNomePessoa());
                        dadosPessoa.setSobrenomePessoa(suporteCiva.getPessoa().getSobrenomePessoa());
                        dadosPessoa.setCodigoCiva(suporteCiva.getCodigoCiva());
                    }
                }
                
                break;
                
            case "gestor-nacional":
                for (GestorNacional gestorNacional : GestorNacionalDao.list()) {
                    if( login.getCodigoCiva().trim().equals( gestorNacional.getCodigoCiva().trim() ) && login.getSenha().trim().equals("12345678")){                                             
                    
                        dadosPessoa.setNomePessoa(gestorNacional.getPessoa().getNomePessoa());
                        dadosPessoa.setSobrenomePessoa(gestorNacional.getPessoa().getSobrenomePessoa());
                        dadosPessoa.setCodigoCiva(gestorNacional.getCodigoCiva());
                    }
                }
                
                break;
                      
            case "gestor-oms":
                for (GestorOms gestorOms : GestorOmsDao.list()) {
                    if( login.getCodigoCiva().trim().equals( gestorOms.getCodigoCiva().trim() ) && login.getSenha().trim().equals("123456789")){                        
                    
                        dadosPessoa.setNomePessoa(gestorOms.getPessoa().getNomePessoa());
                        dadosPessoa.setSobrenomePessoa(gestorOms.getPessoa().getSobrenomePessoa());
                        dadosPessoa.setCodigoCiva(gestorOms.getCodigoCiva());
                    }
                }
                
                break;            
        }

        return dadosPessoa;
    }
}
