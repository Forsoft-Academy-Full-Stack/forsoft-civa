package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Pais;

/**
 *
 * @author randel
 */
public class DocsDao {
    public static boolean insert(Docs docs) {
        boolean resultado = false;

        // Insert into Docs values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Docs find(Integer idDocs) {
        Docs docs = new Docs();
        
        docs.setDataEmissao("");
        docs.setDocumento("");
        docs.setIdPessoa(1);
        docs.setIddocs(idDocs);
        docs.setIdtipodoc(2);
        
        return docs;
    }

    public static List<Docs> list() {
        List<Docs> listaDocs = new ArrayList<Docs>();

        //"SELECT * FROM Docs ;
        Docs docs = new Docs();
        
        docs.setDataEmissao("");
        docs.setDocumento("");
        docs.setIdPessoa(1);
        docs.setIddocs(1);
        docs.setIdtipodoc(2);
        
        listaDocs.add(docs);

        Docs docs2 = new Docs();
        
        docs2.setDataEmissao("");
        docs2.setDocumento("");
        docs2.setIdPessoa(1);
        docs2.setIddocs(1);
        docs2.setIdtipodoc(2);
        
        listaDocs.add(docs2);
     
        return listaDocs;
    }

    public static boolean update(Docs docs) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
    public static boolean delete(Docs docs) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
}
