package model;
/**
 *
 * @author randel
 */
public class NivelAcesso {
    private Long idNivelacesso;
    private Long idAcessoPc;
    private Long idAcessoGestao;
    private String nivelAcesso;

    public NivelAcesso(Long idNivelacesso, Long idAcessoPc, Long idAcessoGestao, String nivelAcesso) {
        this.idNivelacesso = idNivelacesso;
        this.idAcessoPc = idAcessoPc;
        this.idAcessoGestao = idAcessoGestao;
        this.nivelAcesso = nivelAcesso;
    }

    public NivelAcesso() {
    }        
       
    public Long getIdNivelacesso() {
        return idNivelacesso;
    }

    public void setIdNivelacesso(Long idNivelacesso) {
        this.idNivelacesso = idNivelacesso;
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

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }   
}
