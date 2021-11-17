package model;

public class Pessoa {
    private Integer idPessoa;
    private Integer idNacionalidade;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String ddiContato;
    private String telefoneDdd;
    private String genero;
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdNacionalidade() {
        return idNacionalidade;
    }

    public void setIdNacionalidade(Integer idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDdiContato() {
        return ddiContato;
    }

    public void setDdiContato(String ddiContato) {
        this.ddiContato = ddiContato;
    }

    public String getTelefoneDdd() {
        return telefoneDdd;
    }

    public void setTelefoneDdd(String telefoneDdd) {
        this.telefoneDdd = telefoneDdd;
    }    
}


/* CRIAR AS ENTIDADES DE ACORDO COM O BANCO DE DADOS
* ORGANIZAR AS TELAS CONFORME O ATOR
* CRIAR SERVLET COM SWITCH CASE PARA ACESSAR AS PÁGINAS DE CADA ATOR
* 
*/ 


