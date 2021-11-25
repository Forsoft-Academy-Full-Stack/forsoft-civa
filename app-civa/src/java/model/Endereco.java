package model;
/**
 *
 * @author randel
 */
public class Endereco {
    private Integer idEndereco;
    private Integer idPais;
    private String nomePais;
    private String tipoLogradouro;
    private String logradouro;
    private String codigoPostal;
    private String complemento;
    private String nomesubdivisao1;
    private String nomesubdivisao2;
    private String nomesubdivisao3;
    private String nomesubdivisao4;
    private String nomesubdivisao5;
    private String nomesubdivisao6;
    private String nomesubdivisao7;
    private String numero;

    public Endereco(Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro, String logradouro, String codigoPostal, String complemento, String nomesubdivisao1, String nomesubdivisao2, String nomesubdivisao3, String nomesubdivisao4, String nomesubdivisao5, String nomesubdivisao6, String nomesubdivisao7, String numero) {
        this.idEndereco = idEndereco;
        this.idPais = idPais;
        this.nomePais = nomePais;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.codigoPostal = codigoPostal;
        this.complemento = complemento;
        this.nomesubdivisao1 = nomesubdivisao1;
        this.nomesubdivisao2 = nomesubdivisao2;
        this.nomesubdivisao3 = nomesubdivisao3;
        this.nomesubdivisao4 = nomesubdivisao4;
        this.nomesubdivisao5 = nomesubdivisao5;
        this.nomesubdivisao6 = nomesubdivisao6;
        this.nomesubdivisao7 = nomesubdivisao7;
        this.numero = numero;
    }

    public Endereco() {
    }        
       
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
       
    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
  
    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNomesubdivisao1() {
        return nomesubdivisao1;
    }

    public void setNomesubdivisao1(String nomesubdivisao1) {
        this.nomesubdivisao1 = nomesubdivisao1;
    }

    public String getNomesubdivisao2() {
        return nomesubdivisao2;
    }

    public void setNomesubdivisao2(String nomesubdivisao2) {
        this.nomesubdivisao2 = nomesubdivisao2;
    }

    public String getNomesubdivisao3() {
        return nomesubdivisao3;
    }

    public void setNomesubdivisao3(String nomesubdivisao3) {
        this.nomesubdivisao3 = nomesubdivisao3;
    }

    public String getNomesubdivisao4() {
        return nomesubdivisao4;
    }

    public void setNomesubdivisao4(String nomesubdivisao4) {
        this.nomesubdivisao4 = nomesubdivisao4;
    }

    public String getNomesubdivisao5() {
        return nomesubdivisao5;
    }

    public void setNomesubdivisao5(String nomesubdivisao5) {
        this.nomesubdivisao5 = nomesubdivisao5;
    }

    public String getNomesubdivisao6() {
        return nomesubdivisao6;
    }

    public void setNomesubdivisao6(String nomesubdivisao6) {
        this.nomesubdivisao6 = nomesubdivisao6;
    }

    public String getNomesubdivisao7() {
        return nomesubdivisao7;
    }

    public void setNomesubdivisao7(String nomesubdivisao7) {
        this.nomesubdivisao7 = nomesubdivisao7;
    }


    
}
