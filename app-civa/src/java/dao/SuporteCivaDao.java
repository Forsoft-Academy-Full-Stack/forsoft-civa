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
    public static SuporteCiva find(String nomeSuporteCiva){
        SuporteCiva suporteCiva = new SuporteCiva();
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setDataNascimento("");
        pessoa.setDdiContato("");
        pessoa.setNome("");
        pessoa.setSobrenome("");
        pessoa.setTelefoneDdd("");
        pessoa.setGenero("");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);
        
        Docs documento1 = new Docs();
        
        documento1.setDataEmissao("");
        documento1.setDocumento("");
        documento1.setIdPessoa(1);
        documento1.setIddocs(1);
        
        Docs documento2 = new Docs();
        
        documento2.setDataEmissao("");
        documento2.setDocumento("");
        documento2.setIdPessoa(1);
        documento2.setIddocs(1);
                
        Docs documento3 = new Docs();
        
        documento3.setDataEmissao("");
        documento3.setDocumento("");
        documento3.setIdPessoa(1);
        documento3.setIddocs(1);
         
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
        
        suporteCiva.setPessoa(pessoa);
        suporteCiva.setDocumento1(documento1);
        suporteCiva.setDocumento2(documento2);
        suporteCiva.setDocumento3(documento3);
        suporteCiva.setEndereco(endereco);
        
        return suporteCiva;
    }
    
    public static List<SuporteCiva> list(){
        List<SuporteCiva> suportesCiva = new ArrayList<SuporteCiva>();
        
        SuporteCiva suporteCiva = new SuporteCiva();
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setDataNascimento("");
        pessoa.setDdiContato("");
        pessoa.setNome("");
        pessoa.setSobrenome("");
        pessoa.setTelefoneDdd("");
        pessoa.setGenero("");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);
        
        Docs documento1 = new Docs();
        documento1.setDataEmissao("");
        documento1.setDocumento("");
        documento1.setIdPessoa(1);
        documento1.setIddocs(1);
        documento1.setIdtipodoc(1);
                
        Docs documento2 = new Docs();
        documento2.setDataEmissao("");
        documento2.setDocumento("");
        documento2.setIdPessoa(1);
        documento2.setIddocs(1);
        documento2.setIdtipodoc(1);
        
        Docs documento3 = new Docs();
        documento3.setDataEmissao("");
        documento3.setDocumento("");
        documento3.setIdPessoa(1);
        documento3.setIddocs(1);
        documento3.setIdtipodoc(1);
        
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
        
        suporteCiva.setPessoa(pessoa);
        suporteCiva.setDocumento1(documento1);
        suporteCiva.setDocumento2(documento2);
        suporteCiva.setDocumento3(documento3);
        suporteCiva.setEndereco(endereco);
        
        suportesCiva.add(suporteCiva);
        
        SuporteCiva suporteCiva2 = new SuporteCiva();
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setDataNascimento("");
        pessoa2.setDdiContato("");
        pessoa2.setNome("");
        pessoa2.setSobrenome("");
        pessoa2.setTelefoneDdd("");
        pessoa2.setGenero("");
        pessoa2.setIdNacionalidade(1);
        pessoa2.setIdPessoa(1);
        
        Docs documento12 = new Docs();
        documento12.setDataEmissao("");
        documento12.setDocumento("");
        documento12.setIdPessoa(1);
        documento12.setIddocs(1);
        documento12.setIdtipodoc(1);
                
        Docs documento22 = new Docs();
        documento22.setDataEmissao("");
        documento22.setDocumento("");
        documento22.setIdPessoa(1);
        documento22.setIddocs(1);
        documento22.setIdtipodoc(1);
        
        Docs documento32 = new Docs();
        documento32.setDataEmissao("");
        documento32.setDocumento("");
        documento32.setIdPessoa(1);
        documento32.setIddocs(1);
        documento32.setIdtipodoc(1);
        
        Endereco endereco2 = new Endereco();
        endereco2.setCodigoPostal("");
        endereco2.setIdEndereco(1);
        endereco2.setIdPais(1);
        endereco2.setLogradouro(" ");
        endereco2.setNomesubdivisao1("");
        endereco2.setNomesubdivisao2("");
        endereco2.setNomesubdivisao3("");
        endereco2.setNomesubdivisao4("");
        endereco2.setNomesubdivisao5("");
        endereco2.setNomesubdivisao7("");
        endereco2.setTipoLogradouro("");
        
        suporteCiva2.setPessoa(pessoa);
        suporteCiva2.setDocumento1(documento1);
        suporteCiva2.setDocumento2(documento2);
        suporteCiva2.setDocumento3(documento3);
        suporteCiva2.setEndereco(endereco);
        
        suportesCiva.add(suporteCiva2);
        
        return suportesCiva;
    }
    public static boolean insert(SuporteCiva suporteCiva){
        boolean resultado = false;
        
        if (true){
            resultado = true;
        }
        return resultado;
    }        
    
    public static boolean update(SuporteCiva suporteCiva){
        boolean resultado = false;
        
        if (true){
            resultado = true;
        }
        return resultado;
    }
    
    public static boolean delete(SuporteCiva suporteCiva){
        boolean resultado = false;
        
        if (true){
            resultado = true;
        }
        return resultado;
    }
}
