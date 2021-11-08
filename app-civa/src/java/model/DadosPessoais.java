package model;

/**
 *
 * @author randel
 */
public class DadosPessoais {
    private String nome;
    private String sobrenome;
    private String codigoCiva;
    private String identidade;
    private String dataNascimento;
    private String cargo;
    private String subdivisao1;
    private String subdivisao2;
    private String logradouro;
    private String paisOrigem;
    private String ddi;
    private String contato;
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String email;
    
    
    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCodigoCiva() {
        return codigoCiva;
    }

    public void setCodigoCiva(String codigoCiva) {
        this.codigoCiva = codigoCiva;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSubdivisao1() {
        return subdivisao1;
    }

    public void setSubdivisao1(String subdivisao1) {
        this.subdivisao1 = subdivisao1;
    }

    public String getSubdivisao2() {
        return subdivisao2;
    }

    public void setSubdivisao2(String subdivisao2) {
        this.subdivisao2 = subdivisao2;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
