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
    private String lote;

    public Vacina(Integer idVacina, String laboratorio, Integer numeroDoses, String nomeVacina, String tipoVacina, Integer tempoEntreDoses, Integer tempoReforco, String lote) {
        this.idVacina = idVacina;
        this.laboratorio = laboratorio;
        this.numeroDoses = numeroDoses;
        this.nomeVacina = nomeVacina;
        this.tipoVacina = tipoVacina;
        this.tempoEntreDoses = tempoEntreDoses;
        this.tempoReforco = tempoReforco;
        this.lote = lote;
    }        

    public Vacina() {
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

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
