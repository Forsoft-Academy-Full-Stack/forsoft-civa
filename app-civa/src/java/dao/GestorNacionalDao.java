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

    public static GestorNacional find(String codigoCivaGestorNacional) {
       for (GestorNacional gestorNacional : GestorNacionalDao.list()) {
            if( gestorNacional.getCodigoCiva().equals( codigoCivaGestorNacional )){
                return gestorNacional;
            }
        }

        return null;

    }

    public static List<GestorNacional> list() {
        List<GestorNacional> gestoresNacionais = new ArrayList<GestorNacional>();
        GestorNacional gestorNacional1 = new GestorNacional();
        
        //"SELECT * FROM Gestor Nacional;
        Pessoa pessoa = new Pessoa();
        pessoa.setNomePessoa("Paulo");
        pessoa.setSobrenomePessoa("Maia");
        pessoa.setDataNascimento("1990-11-20");
        pessoa.setDdiContato("55");
        pessoa.setTelefoneDdd("2121332323");
        pessoa.setGenero("homem trans");
        gestorNacional1.setCodigoCiva("BR12671812");

        gestorNacional1.setPessoa(pessoa);

        Docs documento1 = new Docs();
        documento1.setDataEmissao("1945-04-19");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);
        documento1.setNomeTipoDoc("Identidade");

        gestorNacional1.setDocumento1(documento1);

        Docs docs2 = new Docs();
        docs2.setDocumento("87687568776");
        docs2.setDataEmissao("1999-05-12");

        gestorNacional1.setDocumento1(docs2);

        Docs docs3 = new Docs();
        docs3.setDocumento("7689798798");
        docs3.setDataEmissao("");

        gestorNacional1.setDocumento3(docs3);

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
        pessoa2.setNomePessoa("Paula");
        pessoa2.setSobrenomePessoa("Silva");
        pessoa2.setDataNascimento("1992-09-10");
        pessoa2.setDdiContato("55");
        pessoa2.setTelefoneDdd("212139993");
        pessoa2.setGenero("mulher trans");
        gestorNacional2.setCodigoCiva("BR12627772");

        gestorNacional2.setPessoa(pessoa2);

        Docs docs12 = new Docs();
        docs12.setDocumento("2334245");
        docs12.setDataEmissao("1998-09-14");

        gestorNacional2.setDocumento1(docs12);

        Docs docs22 = new Docs();
        docs22.setDocumento("");
        docs22.setDataEmissao("");

        gestorNacional2.setDocumento2(docs22);

        Docs docs32 = new Docs();
        docs32.setDocumento("");
        docs32.setDataEmissao("");

        gestorNacional2.setDocumento3(docs32);

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
