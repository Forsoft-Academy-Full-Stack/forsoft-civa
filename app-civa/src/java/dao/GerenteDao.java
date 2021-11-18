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
import model.Gerente;
import model.Pessoa;


/**
 *
 * @author randel
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
    
    public static Gerente find(String gerenteNome) {
        Gerente gerente1 = new Gerente();
        //"SELECT * FROM pais where nome = "+pais;
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("");
        pessoa.setSobrenome("");
        pessoa.setGenero("");
        pessoa.setDataNascimento("");
        pessoa.setDdiContato("");
        pessoa.setTelefoneDdd("");
        
        gerente1.setPessoa(pessoa);
        
        Endereco endereco = new Endereco();
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
        
        gerente1.setEndereco(endereco);
        
                
        Docs docs1 = new Docs();
        docs1.setDocumento("");
        docs1.setDataEmissao("");
        
        gerente1.setDocumento1(docs1);
       
        Docs docs2 = new Docs();
        docs2.setDocumento("");
        docs2.setDataEmissao("");
        
        gerente1.setDocumento1(docs2);
        
        Docs docs3 = new Docs();
        docs3.setDocumento("");
        docs3.setDataEmissao("");
        
        gerente1.setDocumento1(docs3);
        
        
        

        return gerente1;
    }

    public static List<Gerente> list() {
        List<Gerente> gerentes = new ArrayList<Gerente>();

        Gerente gerente1 = new Gerente();
        //"SELECT * FROM pais ;
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("");
        pessoa.setSobrenome("");
        pessoa.setGenero("");
        pessoa.setDataNascimento("");
        pessoa.setDdiContato("");
        pessoa.setTelefoneDdd("");
        
        gerente1.setPessoa(pessoa);
        
        Endereco endereco = new Endereco();
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
        
        gerente1.setEndereco(endereco);
        
                
        Docs docs1 = new Docs();
        docs1.setDocumento("");
        docs1.setDataEmissao("");
        
        gerente1.setDocumento1(docs1);
       
        Docs docs2 = new Docs();
        docs2.setDocumento("");
        docs2.setDataEmissao("");
        
        gerente1.setDocumento1(docs2);
        
        Docs docs3 = new Docs();
        docs3.setDocumento("");
        docs3.setDataEmissao("");
        
        gerente1.setDocumento1(docs3);
        //ÚLTIMO REGISTRO DO GENRETE 1//
        
        gerentes.add(gerente1);
        
        //GERENTE 2//
        Gerente gerente2 = new Gerente();
        
        //"SELECT * FROM pais ;
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("");
        pessoa2.setSobrenome("");
        pessoa2.setGenero("");
        pessoa2.setDataNascimento("");
        pessoa2.setDdiContato("");
        pessoa2.setTelefoneDdd("");
        
        gerente1.setPessoa(pessoa2);
        
        Endereco endereco2 = new Endereco();
        endereco2.setTipoLogradouro("");
        endereco2.setLogradouro("");
        endereco2.setCodigoPostal("");
        endereco2.setNomesubdivisao1("");
        endereco2.setNomesubdivisao2("");
        endereco2.setNomesubdivisao3("");
        endereco2.setNomesubdivisao4("");
        endereco2.setNomesubdivisao5("");
        endereco2.setNomesubdivisao6("");
        endereco2.setNomesubdivisao7("");
        
        gerente2.setEndereco(endereco2);
        
                
        Docs docs12 = new Docs();
        docs12.setDocumento("");
        docs12.setDataEmissao("");
        
        gerente2.setDocumento1(docs12);
       
        Docs docs22 = new Docs();
        docs22.setDocumento("");
        docs22.setDataEmissao("");
        
        gerente2.setDocumento1(docs22);
        
        Docs docs32 = new Docs();
        docs32.setDocumento("");
        docs32.setDataEmissao("");
        
        gerente2.setDocumento1(docs32);
        
        gerentes.add(gerente2);
        
        

        return gerentes;
    }
 
}
