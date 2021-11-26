package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
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

    public static Pais find(Integer idPais) {
       for (Pais pais : PaisDao.list()) {
            if( pais.getIdPais().equals( idPais )){
                return pais;
            }
        }

        return null;
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
        pais1.setNomeContinente("América do Sul");
        pais1.setDdi(21);
        pais1.setIdPais(1);
        pais1.setFusoHorario("BRT Hora de Brasília UTC−3");
        
        Docs documento1 = new Docs(20, "99383946577", 22, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(21, "21676786876", 22, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(22, "06543456478", 22, 3, "CPF", "1946-07-5", "09878765678", "Civil");     
          
        pais1.setDocumento1(documento1);
        pais1.setDocumento2(documento2);
        pais1.setDocumento3(documento2);

        paises.add(pais1);

        Pais pais2 = new Pais();
        pais2.setSigla("JP");
        pais2.setNomePais("Japão");
        pais2.setIdContinente(1);
        pais2.setOrgaoResponsavel("Okioyto");
        pais2.setPadraoContato("(xx) x xxxx-xxxx");
        pais2.setNomeContinente("Asia");
        pais2.setDdi(88);
        pais2.setIdPais(2);
        pais2.setFusoHorario("Japan Standard Time (JST), UTC +9");

        Docs documento12 = new Docs(20, "99383946577", 22, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento22 = new Docs(21, "21676786876", 22, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento32 = new Docs(22, "06543456478", 22, 3, "CPF", "1946-07-5", "09878765678", "Civil");     
          
        pais2.setDocumento1(documento12);
        pais2.setDocumento2(documento22);
        pais2.setDocumento3(documento22);
        
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
