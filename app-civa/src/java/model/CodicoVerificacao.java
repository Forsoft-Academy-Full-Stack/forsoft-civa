package model;
/**
 *
 * @author randel | text
 */
public class CodicoVerificacao {
    private Long idReset;
    private Long idAcessoPc;
    private Long idAcessoGestao;
    private Integer codigo;
    private Boolean ativo;

    public CodicoVerificacao(Long idReset, Long idAcessoPc, Long idAcessoGestao, Integer codigo, Boolean ativo) {
        this.idReset = idReset;
        this.idAcessoPc = idAcessoPc;
        this.idAcessoGestao = idAcessoGestao;
        this.codigo = codigo;
        this.ativo = ativo;
    }     

    public CodicoVerificacao() {
    }
    
    

    public Long getIdReset() {
        return idReset;
    }

    public void setIdReset(Long idReset) {
        this.idReset = idReset;
    }

    public Long getIdAcessoPc() {
        return idAcessoPc;
    }

    public void setIdAcessoPc(Long idAcessoPc) {
        this.idAcessoPc = idAcessoPc;
    }

    public Long getIdAcessoGestao() {
        return idAcessoGestao;
    }

    public void setIdAcessoGestao(Long idAcessoGestao) {
        this.idAcessoGestao = idAcessoGestao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
