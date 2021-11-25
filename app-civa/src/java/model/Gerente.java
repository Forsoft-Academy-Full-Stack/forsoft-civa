package model;
/**
 *
 * @author randel
 */
public class Gerente{
    private Pessoa pessoa;
    private Endereco endereco;
    private String codigoCiva;
    private Docs documento1;
    private Docs documento2;
    private Docs documento3;

    public Gerente(Pessoa pessoa, Endereco endereco, String codigoCiva, Docs documento1, Docs documento2, Docs documento3) {
        this.pessoa = pessoa;
        this.endereco = endereco;
        this.codigoCiva = codigoCiva;
        this.documento1 = documento1;
        this.documento2 = documento2;
        this.documento3 = documento3;
    }

    public Gerente() {
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

    public String getCodigoCiva() {
        return codigoCiva;
    }

    public void setCodigoCiva(String codigoCiva) {
        this.codigoCiva = codigoCiva;
    }

    public Docs getDocumento1() {
        return documento1;
    }

    public void setDocumento1(Docs documento1) {
        this.documento1 = documento1;
    }

    public Docs getDocumento2() {
        return documento2;
    }

    public void setDocumento2(Docs documento2) {
        this.documento2 = documento2;
    }

    public Docs getDocumento3() {
        return documento3;
    }

    public void setDocumento3(Docs documento3) {
        this.documento3 = documento3;
    }
}
