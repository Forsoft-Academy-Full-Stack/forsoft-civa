package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.GestorOms;
import model.Pessoa;

/**
 *
 * @author Kerolen | Ludwig
 */
public class GestorOmsDao {
     public static boolean insert(GestorOms gestoroms) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static GestorOms find(String codigoCivaGestorOms) {
        for (GestorOms gestorOms : GestorOmsDao.list()) {
            if( gestorOms.getCodigoCiva().equals( codigoCivaGestorOms )){
                return gestorOms;
            }
        }

        return null;
    }

        public static List<GestorOms> list() {
        List<GestorOms> gestoresoms = new ArrayList<GestorOms>();

        GestorOms gestorOms = new GestorOms();
        
        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento("12-03-1977");
        pessoa.setDdiContato("+55");
        pessoa.setNomePessoa("José");
        pessoa.setSobrenomePessoa("Carlos");
        pessoa.setTelefoneDdd("983578300");
        pessoa.setGenero("homem cis");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);
        
        Docs documento1 = new Docs();
        documento1.setDataEmissao("19-04-1945");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);
                
        Docs documento2 = new Docs();
        documento2.setDataEmissao("19-04-1945");
        documento2.setDocumento("99383946577");
        documento2.setIdPessoa(1);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);
        
        Docs documento3 = new Docs();
        documento3.setDataEmissao("19-04-1945");
        documento3.setDocumento("99383946577");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);
        
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
        //"SELECT * FROM pais where nome = "+pais;
        
        gestorOms.setPessoa(pessoa);
        gestorOms.setDocumento1(documento1);
        gestorOms.setDocumento2(documento2);
        gestorOms.setDocumento3(documento3);
        gestorOms.setEndereco(endereco);
        gestorOms.setCodigoCiva("BR16616616");

        gestoresoms.add(gestorOms);
        
        GestorOms gestorOms2 = new GestorOms();
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setDataNascimento("12-03-1977");
        pessoa2.setDdiContato("+55");
        pessoa2.setNomePessoa("Antonio");
        pessoa2.setSobrenomePessoa("Pedro");
        pessoa2.setTelefoneDdd("983578300");
        pessoa2.setGenero("homem cis");
        pessoa2.setIdNacionalidade(1);
        pessoa2.setIdPessoa(1);
        
        Docs documento12 = new Docs();
        documento12.setDataEmissao("19-04-1945");
        documento12.setDocumento("99383946577");
        documento12.setIdPessoa(1);
        documento12.setIdDocs(1);
        documento12.setIdTipoDoc(1);
                
        Docs documento22 = new Docs();
        documento22.setDataEmissao("19-04-1945");
        documento22.setDocumento("99383946577");
        documento22.setIdPessoa(1);
        documento22.setIdDocs(1);
        documento22.setIdTipoDoc(1);
        
        Docs documento32 = new Docs();
        documento32.setDataEmissao("19-04-1945");
        documento32.setDocumento("99383946577");
        documento32.setIdPessoa(1);
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
        //"SELECT * FROM pais where nome = "+pais;
        
        gestorOms2.setPessoa(pessoa2);
        gestorOms2.setDocumento1(documento12);
        gestorOms2.setDocumento2(documento22);
        gestorOms2.setDocumento3(documento32);
        gestorOms2.setEndereco(endereco2);
        gestorOms2.setCodigoCiva("BR898896767");

        gestoresoms.add(gestorOms2);

        return gestoresoms;
    }
    

    public static boolean update(GestorOms gestoromsNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
    public static boolean delete(GestorOms gestoroms) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
}
