package model;
/**
 *
 * @author randel
 */
public class Continente {
    private int idContinente;
    private String nomeContinente1;

    public Continente(int idContinente, String nomeContinente1) {
        this.idContinente = idContinente;
        this.nomeContinente1 = nomeContinente1;
    } 

    public Continente() {
    }        

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public String getNomeContinente1() {
        return nomeContinente1;
    }

    public void setNomeContinente1(String nomeContinente1) {
        this.nomeContinente1 = nomeContinente1;
    }
}
