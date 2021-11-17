package model;
/**
 *
 * @author randel
 */
public class Docs {
    private Integer iddocs;
    private Integer idPessoa;
    private Integer idtipodoc;
    private String documento;
    private String dataEmissao;

    public Integer getIddocs() {
        return iddocs;
    }

    public void setIddocs(Integer iddocs) {
        this.iddocs = iddocs;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(Integer idtipodoc) {
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
