package model;
/**
 *
 * @author randel
 */
public class Vacina {
    private Integer idVacina;
    private String laboratorio;
    private Integer numeroDoses;
    private String nomeVacina;
    private String tipoVacina;
    private Integer tempoEntreDoses;
    private Integer tempoReforco;

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }
    
    private Integer lote;

    public Integer getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Integer idVacina) {
        this.idVacina = idVacina;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getNumeroDoses() {
        return numeroDoses;
    }

    public void setNumeroDoses(Integer numeroDoses) {
        this.numeroDoses = numeroDoses;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(String tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    public Integer getTempoEntreDoses() {
        return tempoEntreDoses;
    }

    public void setTempoEntreDoses(Integer tempoEntreDoses) {
        this.tempoEntreDoses = tempoEntreDoses;
    }

    public Integer getTempoReforco() {
        return tempoReforco;
    }

    public void setTempoReforco(Integer tempoReforco) {
        this.tempoReforco = tempoReforco;
    }
    
    
    
       
}
