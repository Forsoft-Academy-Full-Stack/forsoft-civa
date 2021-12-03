package model;
/**
 *
 * @author randel
 */
public class Vacinacao {
    private Vacina vacina;
    private String doseAplicada;
    private String dataAplicacao;
    private Integer idUnidade;
    private String unidade;
    private String pais;
    private Integer idVacinacao;
    private String codigoCivaCadastrante;
    private String hora;

   
    

    public Vacinacao(Vacina vacina, String doseAplicada, String dataAplicacao, Integer idUnidade, String unidade, String pais, Integer idVacinacao) {
        this.vacina = vacina;
        this.doseAplicada = doseAplicada;
        this.dataAplicacao = dataAplicacao;
        this.idUnidade = idUnidade;
        this.unidade = unidade;
        this.pais = pais;
        this.idVacinacao = idVacinacao;
    }
    
     public String getHora() {
        return hora;
    }
    
    public Vacinacao() { 
    }

    public String getCodigoCivaCadastrante() {
        return codigoCivaCadastrante;
    }

    public void setCodigoCivaCadastrante(String codigoCivaCadastrante) {
        this.codigoCivaCadastrante = codigoCivaCadastrante;
    }

    public Integer getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Integer idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Integer getIdVacinacao() {
        return idVacinacao;
    }

    public void setIdVacinacao(Integer idVacinacao) {
        this.idVacinacao = idVacinacao;
    }

    public String getDoseAplicada() {
        return doseAplicada;
    }

    public void setDoseAplicada(String doseAplicada) {
        this.doseAplicada = doseAplicada;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        String dataAplicacaoNova = dataAplicacao.substring(0, 10);
        String horaNova = dataAplicacao.substring(13, dataAplicacao.length());
        this.hora = horaNova;
        
        this.dataAplicacao = dataAplicacaoNova;        
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
