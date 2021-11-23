package model;
/**
 *
 * @author randel
 */
public class Vacinacao {
    private Vacina vacina;
    private Integer doseAplicada;
    private String dataAplicacao;
    private Integer idUnidade;
    private String unidade;
    private String pais;
    private Integer idVacinacao;

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }    
    
    public Integer getIdVacinacao() {
        return idVacinacao;
    }

    public void setIdVacinacao(Integer idVacinacao) {
        this.idVacinacao = idVacinacao;
    }
    
    

    public Integer getDoseAplicada() {
        return doseAplicada;
    }

    public void setDoseAplicada(Integer doseAplicada) {
        this.doseAplicada = doseAplicada;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
