package model;
/**
**
** @author randel
*/
public class DivisaoTerritorial {
    private Integer idLocalidade;
    private Long idPais;
    private String tiposubdivisao1;
    private String tiposubdivisao2;
    private String tiposubdivisao3;
    private String tiposubdivisao4;
    private String tiposubdivisao5;
    private String tiposubdivisao6;
    private String tiposubdivisao7;

    public DivisaoTerritorial(Integer idLocalidade, Long idPais, String tiposubivisao1, String tiposubdivisao2, String tiposubdivisao3, String tiposubdivisao4, String tiposubdivisao5, String tiposubdivisao6, String tiposubdivisao7) {
        this.idLocalidade = idLocalidade;
        this.idPais = idPais;
        this.tiposubdivisao1 = tiposubivisao1;
        this.tiposubdivisao2 = tiposubdivisao2;
        this.tiposubdivisao3 = tiposubdivisao3;
        this.tiposubdivisao4 = tiposubdivisao4;
        this.tiposubdivisao5 = tiposubdivisao5;
        this.tiposubdivisao6 = tiposubdivisao6;
        this.tiposubdivisao7 = tiposubdivisao7;
    }         

    public DivisaoTerritorial() {
    }        

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Integer idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getTiposubdivisao1() {
        return tiposubdivisao1;
    }

    public void setTiposubdivisao1(String tiposubdivisao1) {
        this.tiposubdivisao1 = tiposubdivisao1;
    }

    public String getTiposubdivisao2() {
        return tiposubdivisao2;
    }

    public void setTiposubdivisao2(String tiposubdivisao2) {
        this.tiposubdivisao2 = tiposubdivisao2;
    }

    public String getTiposubdivisao3() {
        return tiposubdivisao3;
    }

    public void setTiposubdivisao3(String tiposubdivisao3) {
        this.tiposubdivisao3 = tiposubdivisao3;
    }

    public String getTiposubdivisao4() {
        return tiposubdivisao4;
    }

    public void setTiposubdivisao4(String tiposubdivisao4) {
        this.tiposubdivisao4 = tiposubdivisao4;
    }

    public String getTiposubdivisao5() {
        return tiposubdivisao5;
    }

    public void setTiposubdivisao5(String tiposubdivisao5) {
        this.tiposubdivisao5 = tiposubdivisao5;
    }

    public String getTiposubdivisao6() {
        return tiposubdivisao6;
    }

    public void setTiposubdivisao6(String tiposubdivisao6) {
        this.tiposubdivisao6 = tiposubdivisao6;
    }

    public String getTiposubdivisao7() {
        return tiposubdivisao7;
    }

    public void setTiposubdivisao7(String tiposubdivisao7) {
        this.tiposubdivisao7 = tiposubdivisao7;
    }
   
}
