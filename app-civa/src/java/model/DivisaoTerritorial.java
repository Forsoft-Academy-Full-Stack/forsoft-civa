package model;
/**
**
** @author randel
*/
public class DivisaoTerritorial {
    private Long idLocalidade;
    private Long idPais;
    private String tiposubivisao1;
    private String tiposubdivisao2;
    private String tiposubdivisao3;
    private String tiposubdivisao4;
    private String tiposubdivisao5;
    private String tiposubdivisao6;
    private String tiposubdivisao7;

    public DivisaoTerritorial(Long idLocalidade, Long idPais, String tiposubivisao1, String tiposubdivisao2, String tiposubdivisao3, String tiposubdivisao4, String tiposubdivisao5, String tiposubdivisao6, String tiposubdivisao7) {
        this.idLocalidade = idLocalidade;
        this.idPais = idPais;
        this.tiposubivisao1 = tiposubivisao1;
        this.tiposubdivisao2 = tiposubdivisao2;
        this.tiposubdivisao3 = tiposubdivisao3;
        this.tiposubdivisao4 = tiposubdivisao4;
        this.tiposubdivisao5 = tiposubdivisao5;
        this.tiposubdivisao6 = tiposubdivisao6;
        this.tiposubdivisao7 = tiposubdivisao7;
    }         

    public DivisaoTerritorial() {
    }        

    public Long getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Long idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getTiposubivisao1() {
        return tiposubivisao1;
    }

    public void setTiposubivisao1(String tiposubivisao1) {
        this.tiposubivisao1 = tiposubivisao1;
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
