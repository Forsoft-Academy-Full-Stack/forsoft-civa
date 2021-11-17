package dao;

import java.util.ArrayList;
import java.util.List;
import model.Pais;

/**
 *
 * @author miguel.bispo
 */
public class PaisDao {

    public static boolean insert(Pais pais) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Pais find(String pais) {
        Pais pais1 = new Pais();
        //"SELECT * FROM pais where nome = "+pais;
        pais1.setSigla(pais);
        pais1.setNomePais(pais);
        pais1.setIdPais(12);

        return pais1;
    }

    public static List<Pais> list() {
        List<Pais> paises = new ArrayList<Pais>();

        //"SELECT * FROM pais ;
        Pais pais1 = new Pais();
        pais1.setSigla("BR");
        pais1.setNomePais("Brasil");
        pais1.setIdContinente(1);
        pais1.setOrgaoResponsavel("SUS");
        pais1.setPadraoContato("(xx) x xxxx-xxxx");
        pais1.setDdi(21);

        paises.add(pais1);

        Pais pais2 = new Pais();
        pais1.setSigla("JP");
        pais1.setNomePais("Japão");
        pais1.setIdContinente(1);
        pais1.setOrgaoResponsavel("okioyto");
        pais1.setPadraoContato("(xx) x xxxx-xxxx");
        pais1.setDdi(99);

        paises.add(pais2);

        return paises;
    }

    public static boolean update(Pais paisNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
    public static boolean delete(Pais pais) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
    
}
