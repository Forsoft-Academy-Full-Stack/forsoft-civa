package model;
/**
 *
 * @author randel
 */
public class Unidade {
    private Integer idUnidade;
    private String numero;
    private String registro;
    private String nome;
    private String contato;
    private String locacao;
    private String natureza;
    private String tipoEstabelecimento;
    private String situacao;
    private String dataCadastro;
    private Endereco endereco;

    public Unidade(Integer idUnidade, String numero, String registro, String nome, String contato, String locacao, String natureza, String tipoEstabelecimento, String situacao, String dataCadastro, Endereco endereco) {
        this.idUnidade = idUnidade;
        this.numero = numero;
        this.registro = registro;
        this.nome = nome;
        this.contato = contato;
        this.locacao = locacao;
        this.natureza = natureza;
        this.tipoEstabelecimento = tipoEstabelecimento;
        this.situacao = situacao;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
    }       

    public Unidade() {
    }
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getLocacao() {
        return locacao;
    }

    public void setLocacao(String locacao) {
        this.locacao = locacao;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }

    public void setTipoEstabelecimento(String tipoEstabelecimento) {
        this.tipoEstabelecimento = tipoEstabelecimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
