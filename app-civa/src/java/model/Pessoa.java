package model;

public class Pessoa {
    private Integer idPessoa;
    private Integer idNacionalidade;
    private String nacionalidade;
    private String nomePessoa;
    private String sobrenomePessoa;
    private String dataNascimento;
    private String ddiContato;
    private String email;
    private String telefoneDdd;
    private String genero;
    private String codigoCiva;

    public Pessoa(Integer idPessoa, Integer idNacionalidade,
                  String nacionalidade, String nomePessoa,
                  String sobrenomePessoa, String dataNascimento,
                  String ddiContato, String email,
                  String telefoneDdd, String genero, String codigoCiva){
            
        this.idPessoa = idPessoa;
        this.idNacionalidade = idNacionalidade;
        this.nacionalidade = nacionalidade;
        this.nomePessoa = nomePessoa;
        this.sobrenomePessoa = sobrenomePessoa;
        this.dataNascimento = dataNascimento;
        this.ddiContato = ddiContato;
        this.email = email;
        this.telefoneDdd = telefoneDdd;
        this.genero = genero;
        this.codigoCiva = codigoCiva;
    }

    public Pessoa() {
    }        
    
    public String getCodigoCiva() {
        return codigoCiva;
    }

    public void setCodigoCiva(String codigoCiva) {
        this.codigoCiva = codigoCiva;
    }
    
    

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
   
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
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
    public String getSobrenomePessoa() {
        return sobrenomePessoa;
    }

    public void setSobrenomePessoa(String sobrenomePessoa) {
        this.sobrenomePessoa = sobrenomePessoa;
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
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


