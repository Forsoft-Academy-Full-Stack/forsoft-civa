package model;

/**
 *
 * @author randel
 */
public class GestorNacional {

    private Pessoa pessoa;
    private Docs documento1;
    private Docs documento2;
    private Docs documento3;
    private Docs documento4;
    private Docs documento5;
    private Endereco endereco;
    private String codigoCiva;

    public GestorNacional(Pessoa pessoa, Docs documento1, Docs documento2, Docs documento3, Endereco endereco, String codigoCiva) {
        this.pessoa = pessoa;
        this.documento1 = documento1;
        this.documento2 = documento2;
        this.documento3 = documento3;
        this.endereco = endereco;
        this.codigoCiva = codigoCiva;
    }

    public Docs getDocumento4() {
        return documento4;
    }

    public void setDocumento4(Docs documento4) {
        this.documento4 = documento4;
    }

    public Docs getDocumento5() {
        return documento5;
    }

    public void setDocumento5(Docs documento5) {
        this.documento5 = documento5;
    }

    
    
    public GestorNacional() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Docs getDocumento1() {
        return documento1;
    }

    public void setDocumento1(Docs documentacao) {
        this.documento1 = documentacao;
    }

    public Docs getDocumento2() {
        return documento2;
    }

    public void setDocumento2(Docs documentacao2) {
        this.documento2 = documentacao2;
    }

    public Docs getDocumento3() {
        return documento3;
    }

    public void setDocumento3(Docs documentacao3) {
        this.documento3 = documentacao3;
    }

    public String getCodigoCiva() {
        return codigoCiva;
    }

    public void setCodigoCiva(String codigoCiva) {
        this.codigoCiva = codigoCiva;
    }

}
