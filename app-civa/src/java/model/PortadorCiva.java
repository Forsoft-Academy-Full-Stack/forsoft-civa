package model;
/**
 *
 * @author randel
 */
public class PortadorCiva {
    private Pessoa pessoa;
    private Docs documento1;
    private Docs documento2;
    private Docs documento3;
    private Endereco endereco;
    private Acessopc acessopc;
    private Vacinacao vacinacao;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Vacinacao getVacinacao() {
        return vacinacao;
    }

    public void setVacinacao(Vacinacao vacinacao) {
        this.vacinacao = vacinacao;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Acessopc getAcessopc() {
        return acessopc;
    }

    public void setAcessopc(Acessopc acessopc) {
        this.acessopc = acessopc;
    }
    
}
