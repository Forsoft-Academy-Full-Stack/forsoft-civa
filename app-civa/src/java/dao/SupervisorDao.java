/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.Pais;
import model.Pessoa;
import model.Supervisor;

/**
 *
 * @author randel
 */
public class SupervisorDao {

    public static boolean insert(Supervisor supervisor) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Supervisor find(String nomeSupervisor) {
        Supervisor supervisor = new Supervisor();

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

        supervisor.setPessoa(pessoa);
        supervisor.setDocumento1(documento1);
        supervisor.setDocumento2(documento2);
        supervisor.setDocumento3(documento3);
        supervisor.setEndereco(endereco);
        supervisor.setCodigoCiva("BR672537621576");

        return supervisor;
    }

    public static List<Supervisor> list() {
        List<Supervisor> supervisores = new ArrayList<Supervisor>();

        // Início Supervisor 1 //
        Supervisor supervisor = new Supervisor();

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

        Docs documento1 = new Docs();
        documento1.setDataEmissao("1945-04-19");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);
        documento1.setNomeTipoDoc("Identidade");

        Docs documento2 = new Docs();
        documento2.setDataEmissao("1945-01-19");
        documento2.setDocumento("1232323");
        documento2.setIdPessoa(2);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);
        documento2.setNomeTipoDoc("Identidade");

        Docs documento3 = new Docs();
        documento3.setDataEmissao("1946-07-5");
        documento3.setDocumento("567657567567");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);
        documento3.setNomeTipoDoc("Identidade");

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("54678000");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setLogradouro("Rua José");
        endereco.setNomesubdivisao1("");
        endereco.setNomesubdivisao2("");
        endereco.setNomesubdivisao3("");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setNomesubdivisao6("");
        endereco.setNomesubdivisao7("");
        endereco.setTipoLogradouro("Rua");
        endereco.setNumero("23");

        supervisor.setPessoa(pessoa);
        supervisor.setDocumento1(documento1);
        supervisor.setDocumento2(documento2);
        supervisor.setDocumento3(documento3);
        supervisor.setEndereco(endereco);
        supervisor.setCodigoCiva("BR672537621576");

        supervisores.add(supervisor);

        // Início Supervisor 2 //
        Supervisor supervisor2 = new Supervisor();

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
        endereco2.setNomesubdivisao1("");
        endereco2.setNomesubdivisao2("");
        endereco2.setNomesubdivisao3("");
        endereco2.setNomesubdivisao4("");
        endereco2.setNomesubdivisao5("");
        endereco2.setNomesubdivisao7("");
        endereco2.setTipoLogradouro("Rua");
        endereco2.setNumero("21");
        //"SELECT * FROM pais where nome = "+pais;

        supervisor2.setPessoa(pessoa2);
        supervisor2.setDocumento1(documento12);
        supervisor2.setDocumento2(documento22);
        supervisor2.setDocumento3(documento32);
        supervisor2.setEndereco(endereco2);
        supervisor2.setCodigoCiva("BR999923721873");

        supervisores.add(supervisor2);

        // Início Supervisor 3 //
        return supervisores;
    }

    public static boolean update(Supervisor supervisorNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Supervisor supervisor) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
}
