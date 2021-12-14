package model;
/**
 *
 * @author randel
 */
public class TipoDoc {
    private Integer idTipoDoc;
    private Integer idPais;
    private String nomeDoc;
    private String formatoDoc;
    private String nivel;

    public TipoDoc(Integer idTipoDoc, Integer idPais, String nomeDoc, String formatoDoc, String nivel) {
        this.idTipoDoc = idTipoDoc;
        this.idPais = idPais;
        this.nomeDoc = nomeDoc;
        this.formatoDoc = formatoDoc;
        this.nivel = nivel;
    }       

    public TipoDoc() {
    }

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNomeDoc() {
        return nomeDoc;
    }

    public void setNomeDoc(String nomeDoc) {
        this.nomeDoc = nomeDoc;
    }

    public String getFormatoDoc() {
        return formatoDoc;
    }

    public void setFormatoDoc(String formatoDoc) {
        this.formatoDoc = formatoDoc;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }    
}