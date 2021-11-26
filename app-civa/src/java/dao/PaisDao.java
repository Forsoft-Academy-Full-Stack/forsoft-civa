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
 
        Docs documento1 = new Docs(20, "99383946577", 22, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(21, "21676786876", 22, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(22, "06543456478", 22, 3, "CPF", "1946-07-5", "09878765678", "Civil");     
        
        // Integer idPais, Integer idContinente, String nomeContinente,
        // Integer idCadastrante, String nomePais, String orgaoResponsavel,
        // String padraoContato, Integer ddi, String sigla, Docs documento1,
        // Docs documento2, Docs documento3, String fusoHorario
        Pais pais = new Pais(1, 1, "América do Sul", 33, "Brasil", "SUS", "(xx) x xxxx-xxxx", 55, "BR", documento1, documento2, documento3, "BRT Hora de Brasília UTC−3");
        paises.add(pais);

        Docs documento12 = new Docs(20, "99383946577", 22, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento22 = new Docs(21, "21676786876", 22, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento32 = new Docs(22, "06543456478", 22, 3, "CPF", "1946-07-5", "09878765678", "Civil");     
             
        Pais pais2 = new Pais(2, 2, "Asia", 33, "Japão", "SHIS", "(xx) x xxxx-xxxx", 55, "JP", documento12, documento22, documento32, "Japan Standard Time (JST), UTC +9");
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
