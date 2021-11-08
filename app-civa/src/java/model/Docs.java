package model;
/**
 *
 * @author randel
 */
public class Docs {
    private Long iddocs;
    private Long idPessoa;
    private Long idtipodoc;
    private String documento;
    private String dataEmissao;

    public Long getIddocs() {
        return iddocs;
    }

    public void setIddocs(Long iddocs) {
        this.iddocs = iddocs;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(Long idtipodoc) {
        this.idtipodoc = idtipodoc;
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
