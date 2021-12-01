package model;

public class Pais {

    private Integer idPais;
    private Integer idContinente;
    private String nomeContinente;
    private Integer idCadastrante;
    private String nomePais;
    private String orgaoResponsavel;
    private String padraoContato;
    private Integer ddi;
    private String sigla;
    private Docs documento1;
    private Docs documento2;
    private Docs documento3;
    private String fusoHorario;
    private DivisaoTerritorial divisaoTerritorial;

    public Pais(Integer idPais, Integer idContinente, String nomeContinente, Integer idCadastrante, String nomePais, String orgaoResponsavel, String padraoContato, Integer ddi, String sigla, Docs documento1, Docs documento2, Docs documento3, String fusoHorario) {
        this.idPais = idPais;
        this.idContinente = idContinente;
        this.nomeContinente = nomeContinente;
        this.idCadastrante = idCadastrante;
        this.nomePais = nomePais;
        this.orgaoResponsavel = orgaoResponsavel;
        this.padraoContato = padraoContato;
        this.ddi = ddi;
        this.sigla = sigla;
        this.documento1 = documento1;
        this.documento2 = documento2;
        this.documento3 = documento3;
        this.fusoHorario = fusoHorario;
    }       

    public Pais() {
    }        

    public String getFusoHorario() {
        return fusoHorario;
    }

    public void setFusoHorario(String fusoHorario) {
        this.fusoHorario = fusoHorario;
    }
    
    public Docs getDocumento1() {
        return documento1;
    }

    public void setDocumento1(Docs documento1) {
        this.documento1 = documento1;
    }

    public Docs getDocumento2() {
        return documento2;
    }

    public void setDocumento2(Docs documento2) {
        this.documento2 = documento2;
    }

    public Docs getDocumento3() {
        return documento3;
    }

    public void setDocumento3(Docs documento3) {
        this.documento3 = documento3;
    }

    
    
    public String getNomeContinente() {
        return nomeContinente;
    }

    public void setNomeContinente(String nomeContinente) {
        this.nomeContinente = nomeContinente;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public Integer getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public Integer getIdCadastrante() {
        return idCadastrante;
    }

    public void setIdCadastrante(Integer idCadastrante) {
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
    
    public DivisaoTerritorial getDivisaoTerritorial() {
        return divisaoTerritorial;
    }

    public void setDivisaoTerritorial(DivisaoTerritorial divisaoTerritorial) {
        this.divisaoTerritorial = divisaoTerritorial;
    }
}
