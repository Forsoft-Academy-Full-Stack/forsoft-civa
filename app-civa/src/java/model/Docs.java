package model;
/**
 *
 * @author randel
 */
public class Docs {
    private Integer idDocs;
    private String documento;
    private Integer idPessoa;
    private Integer idTipoDoc;
    private String nomeTipoDoc;
    private String dataEmissao;
    private String formatoDocumento;
    private String tipoDocumento;

    public Docs(Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc, String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento) {
        this.idDocs = idDocs;
        this.documento = documento;
        this.idPessoa = idPessoa;
        this.idTipoDoc = idTipoDoc;
        this.nomeTipoDoc = nomeTipoDoc;
        this.dataEmissao = dataEmissao;
        this.formatoDocumento = formatoDocumento;
        this.tipoDocumento = tipoDocumento;
    }  

    public Docs() {
    }
    

    public String getFormatoDocumento() {
        return formatoDocumento;
    }

    public void setFormatoDocumento(String formatoDocumento) {
        this.formatoDocumento = formatoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    

    public Integer getIdDocs() {
        return idDocs;
    }

    public void setIdDocs(Integer idDocs) {
        this.idDocs = idDocs;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getNomeTipoDoc() {
        return nomeTipoDoc;
    }

    public void setNomeTipoDoc(String nomeTipoDoc) {
        this.nomeTipoDoc = nomeTipoDoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
