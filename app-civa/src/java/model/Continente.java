package model;
/**
 *
 * @author randel
 */
public class Continente {
    private Long idContinente;
    private String nomeContinente1;

    public Continente(Long idContinente, String nomeContinente1) {
        this.idContinente = idContinente;
        this.nomeContinente1 = nomeContinente1;
    } 

    public Continente() {
    }        

    public Long getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Long idContinente) {
        this.idContinente = idContinente;
    }

    public String getNomeContinente1() {
        return nomeContinente1;
    }

    public void setNomeContinente1(String nomeContinente1) {
        this.nomeContinente1 = nomeContinente1;
    }
}
