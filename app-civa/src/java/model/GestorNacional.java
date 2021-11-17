package model;

/**
 *
 * @author randel
 */
public class GestorNacional {
    private Pessoa pessoa;
    private Docs documentacao;
    private Docs documentacao2;
    private Docs documentacao3;
    private Endereco endereco;

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

    public Docs getDocumentacao() {
        return documentacao;
    }

    public void setDocumentacao(Docs documentacao) {
        this.documentacao = documentacao;
    }

    public Docs getDocumentacao2() {
        return documentacao2;
    }

    public void setDocumentacao2(Docs documentacao2) {
        this.documentacao2 = documentacao2;
    }

    public Docs getDocumentacao3() {
        return documentacao3;
    }

    public void setDocumentacao3(Docs documentacao3) {
        this.documentacao3 = documentacao3;
    }
}
