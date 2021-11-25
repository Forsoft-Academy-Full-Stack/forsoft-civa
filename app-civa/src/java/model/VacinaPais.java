package model;
/**
 *
 * @author randel
 */
public class VacinaPais {
    private Long idVacinaPais;
    private Long idPais;
    private Long idVacina;

    public VacinaPais(Long idVacinaPais, Long idPais, Long idVacina) {
        this.idVacinaPais = idVacinaPais;
        this.idPais = idPais;
        this.idVacina = idVacina;
    }  

    public VacinaPais() {
    }
    
    public Long getIdVacinaPais() {
        return idVacinaPais;
    }

    public void setIdVacinaPais(Long idVacinaPais) {
        this.idVacinaPais = idVacinaPais;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Long idVacina) {
        this.idVacina = idVacina;
    }
    
}
