package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.Pessoa;
import model.PortadorCiva;
import model.Vacina;
import model.Vacinacao;
/**
 *
 * @author Otacilio Lima
 */
public class PortadorCivaDao {

    public static boolean insert(PortadorCiva portadorciva) {
        boolean resultado = false;

        // Insert into PortadorCIVA values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static PortadorCiva find(String codigoCivaPortadorCiva) {
       for (PortadorCiva portadorCiva : PortadorCivaDao.list()) {
            if( portadorCiva.getCodigoCiva().equals( codigoCivaPortadorCiva )){
                return portadorCiva;
            }
        }

        return null;
    }

    public static List<PortadorCiva> list() {
        List<PortadorCiva> portadoresciva = new ArrayList<PortadorCiva>();
       
       //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
       //String sobrenomePessoa, String dataNascimento, String ddiContato,
       //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa = new Pessoa(1, 1, "Brasileira", "Fernado", "Mendes", "1978-07-03", "+55", "fernando@gmail.com", "983578300", "homem cis", "BR9878766");
        
        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento1 = new Docs(1, "993839465878", 1, 1, "Identidade", "1947-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(2, "21676790890", 1, 2, "Passaporte", "1948-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(3, "096543456478", 1, 3, "CPF", "1956-07-5", "XXXXXXXXXXX", "Civil");

        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco = new Endereco(1, 1, "Brasil", "Rua", "Tatuí", "76542445", "Apto 14", "Vila são marcos", "Niterói", "Rio de Janeiro", "", "", "", "", "23");        
        
        List<Vacinacao> listaVacinacao = new ArrayList<Vacinacao>();
        
        // Integer idVacina, String laboratorio, Integer numeroDoses, String nomeVacina, String tipoVacina, Integer tempoEntreDoses, Integer tempoReforco, Integer lote
        Vacina vacina = new Vacina(1, "Sinovac/Butantan", 3, "Coronavac", "Inativada", 28, 0, 998);        

        // Vacina vacina, Integer doseAplicada, String dataAplicacao, Integer idUnidade, String unidade, String pais, Integer idVacinacao
        Vacinacao vacinacao1 = new Vacinacao(vacina, 1, "2021-04-12", 1, "Monte carlos 2", "Brasil", 100);
        vacinacao1.setCodigoCivaCadastrante("BR4434434343");
        
        Vacinacao vacinacao2 = new Vacinacao(vacina, 2, "2021-06-12", 1, "Monte carlos 2", "Brasil", 101);    
        vacinacao2.setCodigoCivaCadastrante("BR89899988");
        
        listaVacinacao.add(vacinacao1);
        listaVacinacao.add(vacinacao2);
        
        PortadorCiva portadorciva = new PortadorCiva(pessoa, documento1, documento2, documento3, endereco, vacinacao1, listaVacinacao, pessoa.getCodigoCiva());
        portadoresciva.add(portadorciva);            
 

        //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
       //String sobrenomePessoa, String dataNascimento, String ddiContato,
       //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa2 = new Pessoa(2, 1, "Brasileira", "Alberto", "Silva", "1978-07-03", "+55", "alberto@gmail.com", "983578300", "homem cis", "BR987879998");
        
        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento12 = new Docs(1, "993839465878", 2, 1, "Identidade", "1947-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento22 = new Docs(2, "21676790890", 2, 2, "Passaporte", "1948-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento32 = new Docs(3, "096543456478", 2, 3, "CPF", "1956-07-5", "XXXXXXXXXXX", "Civil");

        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco2 = new Endereco(2, 1, "Brasil", "Rua", "Serrinha", "321232123", "Apto 14", "Montes belos", "Terraria", "Piauí", "", "", "", "", "897");        
        
        List<Vacinacao> listaVacinacao2 = new ArrayList<Vacinacao>();
        
        // Integer idVacina, String laboratorio, Integer numeroDoses, String nomeVacina, String tipoVacina, Integer tempoEntreDoses, Integer tempoReforco, Integer lote
        Vacina vacina2 = new Vacina(1, "Sinovac/Butantan", 3, "Coronavac", "Inativada", 28, 0, 1233);        

        // Vacina vacina, Integer doseAplicada, String dataAplicacao, Integer idUnidade, String unidade, String pais, Integer idVacinacao
        Vacinacao vacinacao12 = new Vacinacao(vacina2, 1, "2021-04-16", 2, "Hospital Pan", "Brasil", 102);
        vacinacao12.setCodigoCivaCadastrante("BR4434434343");
        Vacinacao vacinacao22 = new Vacinacao(vacina2, 2, "2021-06-21", 2, "Hospital Pan", "Brasil", 103);
        vacinacao22.setCodigoCivaCadastrante("BR89899988");
        Vacinacao vacinacao23 = new Vacinacao(vacina2, 3, "2021-08-14", 2, "Hospital Pan", "Brasil", 104);
        vacinacao23.setCodigoCivaCadastrante("BR4434434343");
        
        listaVacinacao2.add(vacinacao12);
        listaVacinacao2.add(vacinacao22);
        listaVacinacao2.add(vacinacao23);
        
        PortadorCiva portadorciva2 = new PortadorCiva(pessoa2, documento12, documento22, documento32, endereco2, vacinacao2, listaVacinacao2, pessoa2.getCodigoCiva());
        portadoresciva.add(portadorciva2);

        return portadoresciva;
    }

    public static boolean update(PortadorCiva portadorcivaNovo) {
        boolean resultado = false;

        // Update portadorciva;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(PortadorCiva portadorciva) {
        boolean resultado = false;

        // Delete portadorciva
        if (true) {
            resultado = true;
        }

        return resultado;
    }
}
