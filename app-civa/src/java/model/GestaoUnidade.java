package model;
/**
 *
 * @author randel
 */
public class GestaoUnidade {
    private Long idGestaoUnidade;
    private Long idAcessoGestao;
    private Long idUnidade;

    public GestaoUnidade(Long idGestaoUnidade, Long idAcessoGestao, Long idUnidade) {
        this.idGestaoUnidade = idGestaoUnidade;
        this.idAcessoGestao = idAcessoGestao;
        this.idUnidade = idUnidade;
    }

    public GestaoUnidade() {
    }        

    public Long getIdGestaoUnidade() {
        return idGestaoUnidade;
    }

    public void setIdGestaoUnidade(Long idGestaoUnidade) {
        this.idGestaoUnidade = idGestaoUnidade;
    }

    public Long getIdAcessoGestao() {
        return idAcessoGestao;
    }

    public void setIdAcessoGestao(Long idAcessoGestao) {
        this.idAcessoGestao = idAcessoGestao;
    }

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }
    
}
