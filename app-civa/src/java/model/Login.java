package model;

/**
 *
 * @author randel
 */
public class Login {
    private String email;
    private String senha;
    private String perfil;
    private String codigoCiva;

    public Login(String email, String senha, String perfil, String codigoCiva) {
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
        this.codigoCiva = codigoCiva;
    }

    public Login() {
    }        
    
    public String getCodigoCiva() {
        return codigoCiva;
    }

    public void setCodigoCiva(String codigoCiva) {
        this.codigoCiva = codigoCiva;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
