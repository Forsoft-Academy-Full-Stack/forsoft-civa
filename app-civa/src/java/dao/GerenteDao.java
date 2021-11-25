package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.Gerente;
import model.Pessoa;

/**
 *
 * @author Rafael Marçal | Antonio Henrique
 */
public class GerenteDao {

    public static boolean insert(Gerente gerente) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static boolean update(Gerente gerente) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Gerente gerente) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static Gerente find(String codigoCivaGerente) {
        Gerente gerente = new Gerente();
        Pessoa pessoa = new Pessoa();
        Endereco endereco = new Endereco();
        Docs documento1 = new Docs();
        Docs documento2 = new Docs();
        Docs documento3 = new Docs();

        switch (codigoCivaGerente) {
            case "BR879987":
                pessoa.setNomePessoa("Antônio");
                pessoa.setSobrenomePessoa("Henrique");
                pessoa.setGenero("Homem Cis");
                pessoa.setDataNascimento("1998-11-24");
                pessoa.setDdiContato("+55");
                pessoa.setTelefoneDdd("21 9 69179669");

                endereco.setCodigoPostal("24716591");
                endereco.setTipoLogradouro("Rua");
                endereco.setLogradouro("Soares dos Reis");
                endereco.setNomesubdivisao1("América do Sul");
                endereco.setNomesubdivisao2("Brasil");
                endereco.setNomesubdivisao3("Sudeste");
                endereco.setNomesubdivisao4("Rio de Janeiro");
                endereco.setNomesubdivisao5("Região Metropolitana");
                endereco.setNomesubdivisao6("São Gonçalo");
                endereco.setNomesubdivisao7("Jardim Catarina");

                documento1.setDataEmissao("29-09-2017");
                documento1.setDocumento("16328761759");

                documento2.setDataEmissao("29-09-2018");
                documento2.setDocumento("16328761759");

                documento3.setDataEmissao("29-09-2019");
                documento3.setDocumento("16328761759");

                gerente.setPessoa(pessoa);
                gerente.setEndereco(endereco);
                gerente.setDocumento1(documento1);
                gerente.setDocumento2(documento2);
                gerente.setDocumento3(documento3);

                gerente.setCodigoCiva("BR879987");
                break;

            case "BR99089877":

                pessoa.setNomePessoa("Henrique");
                pessoa.setSobrenomePessoa("Junior");
                pessoa.setGenero("Homem Cis");
                pessoa.setDataNascimento("1998-10-15");
                pessoa.setDdiContato("+351");
                pessoa.setTelefoneDdd("12 1 96696917");

                endereco.setCodigoPostal("12358295");
                endereco.setTipoLogradouro("Avenida");
                endereco.setLogradouro("Reis dos Soares");
                endereco.setNomesubdivisao1("Europa");
                endereco.setNomesubdivisao2("Portugal");
                endereco.setNomesubdivisao3("Sul");
                endereco.setNomesubdivisao4("Algarve");
                endereco.setNomesubdivisao5("Centro");
                endereco.setNomesubdivisao6("Santo Gonçalves");
                endereco.setNomesubdivisao7("Floresta Catarina");

                documento1.setDataEmissao("27-09-2020");
                documento1.setDocumento("291632826");

                documento2.setDataEmissao("27-09-2021");
                documento2.setDocumento("291632826");

                documento3.setDataEmissao("27-09-2022");
                documento3.setDocumento("291632826");

                gerente.setPessoa(pessoa);
                gerente.setEndereco(endereco);
                gerente.setDocumento1(documento1);
                gerente.setDocumento2(documento2);
                gerente.setDocumento3(documento3);
                gerente.setCodigoCiva("BR99089877");
                break;
        }

        return gerente;
    }

    public static List<Gerente> list() {
        List<Gerente> gerentes = new ArrayList<Gerente>();

        Gerente gerente = new Gerente();

        Pessoa pessoa = new Pessoa();
        pessoa.setNomePessoa("Antônio");
        pessoa.setSobrenomePessoa("Henrique");
        pessoa.setGenero("Homem Cis");
        pessoa.setDataNascimento("26-10-1998");
        pessoa.setDdiContato("+55");
        pessoa.setTelefoneDdd("21 9 69179669");

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("24716591");
        endereco.setTipoLogradouro("Rua");
        endereco.setLogradouro("Soares dos Reis");
        endereco.setNomesubdivisao1("América do Sul");
        endereco.setNomesubdivisao2("Brasil");
        endereco.setNomesubdivisao3("Sudeste");
        endereco.setNomesubdivisao4("Rio de Janeiro");
        endereco.setNomesubdivisao5("Região Metropolitana");
        endereco.setNomesubdivisao6("São Gonçalo");
        endereco.setNomesubdivisao7("Jardim Catarina");

        Docs documento1 = new Docs();
        documento1.setDataEmissao("29-09-2017");
        documento1.setDocumento("16328761759");

        Docs documento2 = new Docs();
        documento2.setDataEmissao("29-09-2018");
        documento2.setDocumento("16328761759");

        Docs documento3 = new Docs();
        documento3.setDataEmissao("29-09-2019");
        documento3.setDocumento("16328761759");

        gerente.setPessoa(pessoa);
        gerente.setEndereco(endereco);
        gerente.setDocumento1(documento1);
        gerente.setDocumento2(documento2);
        gerente.setDocumento3(documento3);

        gerente.setCodigoCiva("BR879987");

        gerentes.add(gerente);

        Gerente gerente2 = new Gerente();

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNomePessoa("Henrique");
        pessoa2.setSobrenomePessoa("Junior");
        pessoa2.setGenero("Homem Cis");
        pessoa2.setDataNascimento("15-10-1998");
        pessoa2.setDdiContato("+351");
        pessoa2.setTelefoneDdd("12 1 96696917");

        Endereco endereco2 = new Endereco();
        endereco2.setCodigoPostal("12358295");
        endereco2.setTipoLogradouro("Avenida");
        endereco2.setLogradouro("Reis dos Soares");
        endereco2.setNomesubdivisao1("Europa");
        endereco2.setNomesubdivisao2("Portugal");
        endereco2.setNomesubdivisao3("Sul");
        endereco2.setNomesubdivisao4("Algarve");
        endereco2.setNomesubdivisao5("Centro");
        endereco2.setNomesubdivisao6("Santo Gonçalves");
        endereco2.setNomesubdivisao7("Floresta Catarina");

        Docs documento12 = new Docs();
        documento12.setDataEmissao("27-09-2020");
        documento12.setDocumento("291632826");

        Docs documento22 = new Docs();
        documento22.setDataEmissao("27-09-2021");
        documento22.setDocumento("291632826");

        Docs documento32 = new Docs();
        documento32.setDataEmissao("27-09-2022");
        documento32.setDocumento("291632826");

        gerente2.setPessoa(pessoa2);
        gerente2.setEndereco(endereco2);
        gerente2.setDocumento1(documento12);
        gerente2.setDocumento2(documento22);
        gerente2.setDocumento3(documento32);

        gerente2.setCodigoCiva("BR99089877");

        gerentes.add(gerente2);

        return gerentes;
    }

}
