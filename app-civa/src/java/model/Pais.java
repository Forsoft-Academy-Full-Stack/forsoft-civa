package model;

public class Pais {
    private Long idPais;
    private Long idContinente;
    private Long idCadastrante;
    private String nomePais;
    private String orgaoResponsavel;
    private String padraoContato;
    private Integer ddi;
    private String sigla;

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Long idContinente) {
        this.idContinente = idContinente;
    }

    public Long getIdCadastrante() {
        return idCadastrante;
    }

    public void setIdCadastrante(Long idCadastrante) {
        this.idCadastrante = idCadastrante;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getOrgaoResponsavel() {
        return orgaoResponsavel;
    }

    public void setOrgaoResponsavel(String orgaoResponsavel) {
        this.orgaoResponsavel = orgaoResponsavel;
    }

    public String getPadraoContato() {
        return padraoContato;
    }

    public void setPadraoContato(String padraoContato) {
        this.padraoContato = padraoContato;
    }

    public Integer getDdi() {
        return ddi;
    }

    public void setDdi(Integer ddi) {
        this.ddi = ddi;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }    
}