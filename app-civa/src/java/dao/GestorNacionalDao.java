package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.GestorNacional;
import model.Pessoa;
/**
 *
 * @author Geize Kele | Israel de Araujo
 */
public class GestorNacionalDao {
    
        public static boolean insert(GestorNacional gestornacional) {
        boolean resultado = false;
        
        // Insert into Gestor Nacional values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }
    
        public static boolean update(GestorNacional gestorNacional) {
        boolean resultado = false;

        // Update Gestor Nacional;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
        public static boolean delete(GestorNacional gestorNacional) {
        boolean resultado = false;

        // Delete Gestor Nacional;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
        
        public static GestorNacional find(String nomeGestorNacional) {
        GestorNacional gestorNacional = new GestorNacional();
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("");
        pessoa.setSobrenome("");
        pessoa.setDataNascimento("");
        pessoa.setDdiContato("");
        pessoa.setTelefoneDdd("");
        pessoa.setGenero("");
        
        gestorNacional.setPessoa(pessoa);
        
        Docs docs1 = new Docs();
        docs1.setDocumento("");
        docs1.setDataEmissao("");
        
        gestorNacional.setDocumentacao1(docs1);
        
        Docs docs2 = new Docs();
        docs2.setDocumento("");
        docs2.setDataEmissao("");
        
        gestorNacional.setDocumentacao2(docs2);
        
        Docs docs3 = new Docs();
        docs3.setDocumento("");
        docs3.setDataEmissao("");
        
        gestorNacional.setDocumentacao3(docs3);
        
        
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

        gestorNacional.setEndereco(endereco);
        

        return gestorNacional;        
        
    }

    public static List<GestorNacional> list() {
        List<GestorNacional> gestoresNacionais = new ArrayList<GestorNacional>();
        GestorNacional gestorNacional1 = new GestorNacional();
        
        //"SELECT * FROM Gestor Nacional ;
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("");
        pessoa.setSobrenome("");
        pessoa.setDataNascimento("");
        pessoa.setDdiContato("");
        pessoa.setTelefoneDdd("");
        pessoa.setGenero("");
        
        gestorNacional1.setPessoa(pessoa);
        
        Docs docs1 = new Docs();
        docs1.setDocumento("");
        docs1.setDataEmissao("");
        
        gestorNacional1.setDocumentacao1(docs1);
        
        Docs docs2 = new Docs();
        docs2.setDocumento("");
        docs2.setDataEmissao("");
        
        gestorNacional1.setDocumentacao2(docs2);
        
        Docs docs3 = new Docs();
        docs3.setDocumento("");
        docs3.setDataEmissao("");
        
        gestorNacional1.setDocumentacao3(docs3);
        
        
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

        gestorNacional1.setEndereco(endereco);
        //Último egistro de Gestor Nacional 1
        gestoresNacionais.add(gestorNacional1);
        
        
        GestorNacional gestorNacional2 = new GestorNacional();
        
        //"SELECT * FROM Gestor Nacional ;
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("");
        pessoa2.setSobrenome("");
        pessoa2.setDataNascimento("");
        pessoa2.setDdiContato("");
        pessoa2.setTelefoneDdd("");
        pessoa2.setGenero("");
        
        gestorNacional2.setPessoa(pessoa2);
        
        Docs docs12 = new Docs();
        docs12.setDocumento("");
        docs12.setDataEmissao("");
        
        gestorNacional2.setDocumentacao1(docs12);
        
        Docs docs22 = new Docs();
        docs22.setDocumento("");
        docs22.setDataEmissao("");
        
        gestorNacional2.setDocumentacao2(docs22);
        
        Docs docs32 = new Docs();
        docs32.setDocumento("");
        docs32.setDataEmissao("");
        
        gestorNacional2.setDocumentacao3(docs32);
        
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

        gestorNacional2.setEndereco(endereco2);
        //Último egistro de Gestor Nacional 2
        gestoresNacionais.add(gestorNacional2);
        
        
        return gestoresNacionais;
    }

    
}