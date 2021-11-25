package dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Docs;
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
        for ( Docs docs : DocsDao.list() ) {
            if( Objects.equals(docs.getIdDocs(), idDocs) ){
                return docs;
            }
        }
        
        return null;
    }

    public static List<Docs> list() {
        List<Docs> listaDocs = new ArrayList<Docs>();

        //"SELECT * FROM Docs ;
        Docs docs = new Docs();
        
        docs.setDataEmissao("");
        docs.setDocumento("");
        docs.setIdPessoa(1);
        docs.setIdDocs(1);
        docs.setIdTipoDoc(2);
        
        listaDocs.add(docs);

        Docs docs2 = new Docs();
        
        docs2.setDataEmissao("");
        docs2.setDocumento("");
        docs2.setIdPessoa(1);
        docs2.setIdDocs(1);
        docs2.setIdTipoDoc(2);
        
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