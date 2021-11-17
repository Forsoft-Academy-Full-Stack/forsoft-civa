package model;
/**
 *
 * @author randel
 */
public class Vacinacao {
    private Integer doseAplicada;
    private String vacina;
    private String laboratorio;
    private String dataAplicacao;
    private String unidade;
    private String pais;

    public Integer getDoseAplicada() {
        return doseAplicada;
    }

    public void setDoseAplicada(Integer doseAplicada) {
        this.doseAplicada = doseAplicada;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
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
