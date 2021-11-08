package model;

/**
 *
 * @author randel
 */
public class PessoaEndereco {

    public Long getIdPessoaEndereco() {
        return idPessoaEndereco;
    }

    public void setIdPessoaEndereco(Long idPessoaEndereco) {
        this.idPessoaEndereco = idPessoaEndereco;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    private Long idPessoaEndereco;
    private Long idPessoa;
    private Long idEndereco;
    private String complemento;
    
    
    
}
