package model;

public class AcessoGestao extends Pessoa{
    private Long idacessoGestao;
    private Long idPessoa;
    private Long idCadastrante;
    private String codigoCiva;    
    private String cargo;
    private String email;
    private String senha;
    
     public Long getIdacessoGestao() {
        return idacessoGestao;
    }

    public void setIdacessoGestao(Long idacessoGestao) {
        this.idacessoGestao = idacessoGestao;
    }
     
    public String getCodigoCiva() {
        return codigoCiva;
    }

    public void setCodigoCiva(String codigoCiva) {
        this.codigoCiva = codigoCiva;
    }

    public Long getIdCadastrante() {
        return idCadastrante;
    }

    public void setIdCadastrante(Long idCadastrante) {
        this.idCadastrante = idCadastrante;
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

