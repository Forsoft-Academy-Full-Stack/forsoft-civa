package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.Pessoa;
import model.PortadorCiva;

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

    public static PortadorCiva find(String nomePortadorCiva) {
        PortadorCiva portadorciva = new PortadorCiva();

        Pessoa pessoa = new Pessoa();
        pessoa.setNomePessoa("");
        pessoa.setSobrenomePessoa("");
        pessoa.setDataNascimento("");
        pessoa.setTelefoneDdd("");
        pessoa.setGenero("");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);


        Docs documento1 = new Docs();
        documento1.setDataEmissao("");
        documento1.setDocumento("");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);

        Docs documento2 = new Docs();
        documento2.setDataEmissao("");
        documento2.setDocumento("");
        documento2.setIdPessoa(1);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);

        Docs documento3 = new Docs();
        documento3.setDataEmissao("");
        documento3.setDocumento("");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setTipoLogradouro("");
        endereco.setLogradouro("");
        endereco.setCodigoPostal("");
        endereco.setNomesubdivisao1("");
        endereco.setNomesubdivisao2("");
        endereco.setNomesubdivisao3("");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setNomesubdivisao6("");
        endereco.setNomesubdivisao7("");
        // SELECT * FROM portadorciva where nome="";

        portadorciva.setPessoa(pessoa);
        portadorciva.setDocumento1(documento1);
        portadorciva.setDocumento2(documento2);
        portadorciva.setDocumento3(documento3);
        portadorciva.setEndereco(endereco);

        return portadorciva;
    }

    public static List<PortadorCiva> list() {
        List<PortadorCiva> portadoresciva = new ArrayList<PortadorCiva>();

        // SELECT * FROM PortadorCiva;
        PortadorCiva portadorciva = new PortadorCiva();

        Pessoa pessoa = new Pessoa();
        pessoa.setNomePessoa("");
        pessoa.setSobrenomePessoa("");
        pessoa.setDataNascimento("");
        pessoa.setTelefoneDdd("");
        pessoa.setDdiContato("");
        pessoa.setGenero("");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);

        Docs documento1 = new Docs();
        documento1.setDataEmissao("");
        documento1.setDocumento("");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);

        Docs documento2 = new Docs();
        documento2.setDataEmissao("");
        documento2.setDocumento("");
        documento2.setIdPessoa(1);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);

        Docs documento3 = new Docs();
        documento3.setDataEmissao("");
        documento3.setDocumento("");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setLogradouro("");
        endereco.setNomesubdivisao1("");
        endereco.setNomesubdivisao2("");
        endereco.setNomesubdivisao3("");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setNomesubdivisao6("");
        endereco.setNomesubdivisao7("");
        endereco.setTipoLogradouro("");

        portadoresciva.add(portadorciva);

        PortadorCiva portadorciva2 = new PortadorCiva();

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNomePessoa("");
        pessoa2.setSobrenomePessoa("");
        pessoa2.setDataNascimento("");
        pessoa2.setTelefoneDdd("");
        pessoa2.setDdiContato("");
        pessoa2.setGenero("");
        pessoa2.setIdNacionalidade(1);
        pessoa2.setIdPessoa(1);

        Docs documento12 = new Docs();
        documento12.setDataEmissao("");
        documento12.setDocumento("");
        documento12.setIdPessoa(1);
        documento12.setIdDocs(1);
        documento12.setIdTipoDoc(1);

        Docs documento22 = new Docs();
        documento22.setDataEmissao("");
        documento22.setDocumento("");
        documento22.setIdPessoa(1);
        documento22.setIdDocs(1);
        documento22.setIdTipoDoc(1);

        Docs documento32 = new Docs();
        documento32.setDataEmissao("");
        documento32.setDocumento("");
        documento32.setIdPessoa(1);
        documento32.setIdDocs(1);
        documento32.setIdTipoDoc(1);

        Endereco endereco2 = new Endereco();
        endereco2.setCodigoPostal("");
        endereco2.setIdEndereco(1);
        endereco2.setIdPais(1);
        endereco2.setLogradouro("");
        endereco2.setNomesubdivisao1("");
        endereco2.setNomesubdivisao2("");
        endereco2.setNomesubdivisao3("");
        endereco2.setNomesubdivisao4("");
        endereco2.setNomesubdivisao5("");
        endereco2.setNomesubdivisao6("");
        endereco2.setNomesubdivisao7("");
        endereco2.setTipoLogradouro("");

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
