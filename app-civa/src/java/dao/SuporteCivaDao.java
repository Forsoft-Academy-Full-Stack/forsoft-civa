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
import model.SuporteCiva;
import model.Pessoa;

/**
 *
 * @author felipe gomes
 */
public class SuporteCivaDao {

    public static SuporteCiva find(String codigoCivaSuporteCiva) {
       for (SuporteCiva suporteCiva : SuporteCivaDao.list()) {
            if( suporteCiva.getCodigoCiva().equals( codigoCivaSuporteCiva )){
                return suporteCiva;
            }
        }
      
        return null;
    }

    public static List<SuporteCiva> list() {
        List<SuporteCiva> suportesCiva = new ArrayList<SuporteCiva>();
       
        // Início Supervisor 1 //
       //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
       //String sobrenomePessoa, String dataNascimento, String ddiContato,
       //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa = new Pessoa(1, 1, "Brasileira", "Josef", "Carl", "1977-07-03", "+55", "joséCarlos@gmail.com", "983578300", "homem cis", "BR672537621576867876");
                
        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento1 = new Docs(1, "299383946577", 1, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(2, "121676786876", 1, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(3, "906543456478", 1, 3, "CPF", "1946-07-5", "XXX.XXX.XXX-XX", "Civil");     
            
        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco = new Endereco(1, 1, "Brasil", "Rua", "Rua José", "54678000", "Apto 14", "Vila Bela", "Niterói", "Rio de Janeiro", "", "", "", "", "23");
   
        SuporteCiva suporteCiva = new SuporteCiva(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());
        suportesCiva.add(suporteCiva);

        SuporteCiva suporteCiva2 = new SuporteCiva();

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

        suporteCiva2.setPessoa(pessoa2);
        suporteCiva2.setDocumento1(documento12);
        suporteCiva2.setDocumento2(documento22);
        suporteCiva2.setDocumento3(documento32);
        suporteCiva2.setEndereco(endereco2);
        suporteCiva2.setCodigoCiva("BR115566787");

        suportesCiva.add(suporteCiva2);

        return suportesCiva;
    }

    public static boolean insert(SuporteCiva suporteCiva) {
        boolean resultado = false;

        if (true) {
            resultado = true;
        }
        return resultado;
    }

    public static boolean update(SuporteCiva suporteCiva) {
        boolean resultado = false;

        if (true) {
            resultado = true;
        }
        return resultado;
    }

    public static boolean delete(SuporteCiva suporteCiva) {
        boolean resultado = false;

        if (true) {
            resultado = true;
        }
        return resultado;
    }
}
