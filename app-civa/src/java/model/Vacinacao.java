package model;
/**
 *
 * @author randel
 */
public class Vacinacao {
    private Long idVacinacao;
    private Long idVaciva;
    private Long idAcessopc;
    private Long idUnidade;
    private Long lote;
    private Integer doseAplicacao;
    
    public Long getIdVacinacao() {
        return idVacinacao;
    }

    public void setIdVacinacao(Long idVacinacao) {
        this.idVacinacao = idVacinacao;
    }

    public Long getIdVaciva() {
        return idVaciva;
    }

    public void setIdVaciva(Long idVaciva) {
        this.idVaciva = idVaciva;
    }

    public Long getIdAcessopc() {
        return idAcessopc;
    }

    public void setIdAcessopc(Long idAcessopc) {
        this.idAcessopc = idAcessopc;
    }

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Long getLote() {
        return lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }

    public Integer getDoseAplicacao() {
        return doseAplicacao;
    }

    public void setDoseAplicacao(Integer doseAplicacao) {
        this.doseAplicacao = doseAplicacao;
    }
 
}
