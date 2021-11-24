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
        PortadorCiva portadorciva = new PortadorCiva();

        Pessoa pessoa = new Pessoa();
        // data no formato AAAA/mm/dd
        pessoa.setDataNascimento("1977-07-03");
        pessoa.setDdiContato("+55");
        pessoa.setNomePessoa("José");
        pessoa.setSobrenomePessoa("Carlos");
        pessoa.setTelefoneDdd("983578300");
        pessoa.setGenero("homem cis");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);
        pessoa.setNacionalidade("Brasileira");
        pessoa.setEmail("jose@gmail.com");

        Docs documento1 = new Docs();
        documento1.setDataEmissao("19-04-1945");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);
        documento1.setNomeTipoDoc("Identidade");

        Docs documento2 = new Docs();
        documento2.setDataEmissao("19-04-1945");
        documento2.setDocumento("BR123456");
        documento2.setIdPessoa(2);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);
        documento2.setNomeTipoDoc("Passaporte");

        Docs documento3 = new Docs();
        documento3.setDataEmissao("19-04-1945");
        documento3.setDocumento("987.654.564-09");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);
        documento3.setNomeTipoDoc("CPF");

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("54678000");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setNomePais("Brasil");
        endereco.setLogradouro("Rua José");
        // BAIRRO
        endereco.setNomesubdivisao1("Vila Bela");
        // Municipio
        endereco.setNomesubdivisao2("Niterói");
        // ESTADO
        endereco.setNomesubdivisao3("Rio de Janeiro");

        endereco.setTipoLogradouro("Rua");
        endereco.setNumero("23");
        endereco.setComplemento("Apto 10");
        
        portadorciva.setPessoa(pessoa);
        portadorciva.setDocumento1(documento1);
        portadorciva.setDocumento3(documento3);
        portadorciva.setCodigoCiva("BR9878766");
        
        Vacinacao vacinacao = new Vacinacao();
        
        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Coronavac");
        vacina.setLaboratorio("Sinovac/Butantan");
        vacina.setNumeroDoses(3);
        vacina.setTempoEntreDoses(28);
        vacina.setTipoVacina("Inativada");
        vacina.setTempoReforco(0);
        vacina.setIdVacina(000001);
        vacina.setLote(998);

        vacinacao.setDataAplicacao("2021-04-12");
        vacinacao.setDoseAplicada(1);
        vacinacao.setPais("Brasil");
        vacinacao.setUnidade("Monte carlos");
        vacinacao.setVacina(vacina);
        vacinacao.setIdVacinacao(12292);
        vacinacao.setIdUnidade(123);
        
        portadorciva.setPessoa(pessoa);
        portadorciva.setDocumento1(documento1);
        portadorciva.setDocumento2(documento2);
        portadorciva.setDocumento3(documento3);
        portadorciva.setEndereco(endereco);
        portadorciva.setVacinacao(vacinacao);

        return portadorciva;
    }

    public static List<PortadorCiva> list() {
        List<PortadorCiva> portadoresciva = new ArrayList<PortadorCiva>();

        // SELECT * FROM PortadorCiva;
        PortadorCiva portadorciva = new PortadorCiva();

        Pessoa pessoa = new Pessoa();
        // data no formato AAAA/mm/dd
        pessoa.setDataNascimento("1977-07-03");
        pessoa.setDdiContato("+55");
        pessoa.setNomePessoa("José");
        pessoa.setSobrenomePessoa("Carlos");
        pessoa.setTelefoneDdd("983578300");
        pessoa.setGenero("homem cis");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);
        pessoa.setNacionalidade("Brasileira");
        pessoa.setEmail("jose@gmail.com");

        Docs documento1 = new Docs();
        documento1.setDataEmissao("19-04-1945");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);
        documento1.setNomeTipoDoc("Identidade");

        Docs documento2 = new Docs();
        documento2.setDataEmissao("19-04-1945");
        documento2.setDocumento("BR123456");
        documento2.setIdPessoa(2);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);
        documento2.setNomeTipoDoc("Passaporte");

        Docs documento3 = new Docs();
        documento3.setDataEmissao("19-04-1945");
        documento3.setDocumento("987.654.564-09");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);
        documento3.setNomeTipoDoc("CPF");

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("54678000");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setNomePais("Brasil");
        endereco.setLogradouro("Rua José");
        // BAIRRO
        endereco.setNomesubdivisao1("Vila Bela");
        // Municipio
        endereco.setNomesubdivisao2("Niterói");
        // ESTADO
        endereco.setNomesubdivisao3("Rio de Janeiro");

        endereco.setTipoLogradouro("Rua");
        endereco.setNumero("23");
        endereco.setComplemento("Apto 10");
        portadoresciva.add(portadorciva);
        
        Vacinacao vacinacao = new Vacinacao();
        
        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Coronavac");
        vacina.setLaboratorio("Sinovac/Butantan");
        vacina.setNumeroDoses(3);
        vacina.setTempoEntreDoses(28);
        vacina.setTipoVacina("Inativada");
        vacina.setTempoReforco(0);
        vacina.setIdVacina(000001);
        vacina.setLote(998);

        vacinacao.setDataAplicacao("2021-04-12");
        vacinacao.setDoseAplicada(1);
        vacinacao.setPais("Brasil");
        vacinacao.setUnidade("Monte carlos");
        vacinacao.setVacina(vacina);
        vacinacao.setIdVacinacao(12292);
        vacinacao.setIdUnidade(123);
        
        portadorciva.setPessoa(pessoa);
        portadorciva.setDocumento1(documento1);
        portadorciva.setDocumento3(documento3);
        portadorciva.setCodigoCiva("BR9878766");
        portadorciva.setVacinacao(vacinacao);

        PortadorCiva portadorciva2 = new PortadorCiva();

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setDataNascimento("1996-07-11");
        pessoa2.setDdiContato("+55");
        pessoa2.setNomePessoa("Pedro");
        pessoa2.setSobrenomePessoa("Silva");
        pessoa2.setTelefoneDdd("217687655645");
        pessoa2.setGenero("homem trans");
        pessoa2.setIdNacionalidade(1);
        pessoa2.setIdPessoa(2);
        pessoa2.setNacionalidade("Brasileira");

        Docs documento12 = new Docs();
        documento12.setDataEmissao("1999-04-1");
        documento12.setDocumento("7657328490");
        documento12.setIdPessoa(2);
        documento12.setIdDocs(1);
        documento12.setIdTipoDoc(1);

        Docs documento22 = new Docs();
        documento22.setDataEmissao("2000-04-1");
        documento22.setDocumento("99383946577");
        documento22.setIdPessoa(2);
        documento22.setIdDocs(1);
        documento22.setIdTipoDoc(1);

        Docs documento32 = new Docs();
        documento32.setDataEmissao("2001-04-1");
        documento32.setDocumento("99383946577");
        documento32.setIdPessoa(2);
        documento32.setIdDocs(1);
        documento32.setIdTipoDoc(1);

        Endereco endereco2 = new Endereco();
        endereco2.setCodigoPostal("54678000");
        endereco2.setIdEndereco(1);
        endereco2.setIdPais(1);
        endereco2.setLogradouro("Rua José");
        endereco2.setLogradouro("Rua José");
        // BAIRRO
        endereco2.setNomesubdivisao1("Vila Bela");
        // Municipio
        endereco2.setNomesubdivisao2("Niterói");
        // ESTADO
        endereco2.setNomesubdivisao4("Rio de Janeiro");
        endereco2.setNomesubdivisao5("");
        endereco2.setTipoLogradouro("Rua");
        endereco2.setNumero("21");
        
        Vacinacao vacinacao2 = new Vacinacao();
        
        Vacina vacina2 = new Vacina();
        vacina2.setNomeVacina("Coronavac");
        vacina2.setLaboratorio("Sinovac/Butantan");
        vacina2.setNumeroDoses(3);
        vacina2.setTempoEntreDoses(28);
        vacina2.setTipoVacina("Inativada");
        vacina2.setTempoReforco(0);
        vacina2.setIdVacina(000001);
        vacina2.setLote(1008);
        
        vacinacao2.setDataAplicacao("2021-06-14");
        vacinacao2.setDoseAplicada(2);
       
        vacinacao2.setPais("Brasil");
        vacinacao2.setUnidade("Monte Carlos");
        vacinacao2.setVacina(vacina2);
        vacinacao2.setIdVacinacao(12339);
        vacinacao2.setIdUnidade(153);
        
        portadorciva2.setPessoa(pessoa2);
        portadorciva2.setDocumento1(documento12);
        portadorciva2.setDocumento3(documento32);
        portadorciva2.setCodigoCiva("BR28782282");
        portadorciva2.setVacinacao(vacinacao2);

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
