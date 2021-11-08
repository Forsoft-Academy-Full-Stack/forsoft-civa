package model;
/**
 *
 * @author randel
 */
public class TipoDoc {
    private Long idTipoDoc;
    private Long idPais;
    private String nomeDoc;
    private String formatoDoc;
    private String nivel;

    public Long getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Long idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
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