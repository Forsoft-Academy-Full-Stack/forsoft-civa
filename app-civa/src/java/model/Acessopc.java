package model;
import model.Pessoa;

public class Acessopc extends Pessoa {
    private Integer idacessoPC;
    private Integer idPessoa;
    private Integer idCadastrante;
    private Integer codigoCiva;
    private String cargo;
    private String email;
    private String senha;
  
    public Integer getIdCadastrante() {
        return idCadastrante;
    }

    public void setIdCadastrante(Integer idCadastrante) {
        this.idCadastrante = idCadastrante;
    }

    public Integer getCodigoCiva() {
        return codigoCiva;
    }

    public void setCodigoCiva(Integer codigoCiva) {
        this.codigoCiva = codigoCiva;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
    
}
