package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Endereco;
import model.Pais;
import model.Unidade;

/**
 *
 * @author randel
 */
public class UnidadeDao {

    public static boolean insert(Pais pais) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Unidade find(Integer idUnidade) {
        
        for (Unidade unidade : UnidadeDao.list()) {
            if( Objects.equals(unidade.getIdUnidade(), idUnidade) ){
                return unidade;
            }
        }
        
        return null;
    }

    public static List<Unidade> list() {
        List<Unidade> unidades = new ArrayList<Unidade>();              
       
        Endereco endereco = new Endereco(1, 1, "Brasil", "Rua", "Tatuí", "76542445", "Apto 14", "Vila são marcos", "Niterói", "Rio de Janeiro", "", "", "", "", "23");        
        Unidade unidade = new Unidade(1, 23, "07.235.197/0001-97", "Bezerra da Silva", "+55 9985563445", "Fixa", "Privada", "Hospital", true, "2021-01-10", endereco);
        unidades.add(unidade);
        
        Endereco endereco2 = new Endereco(2, 1, "Brasil", "Rua", "Serrinha", "321232123", "Apto 14", "Montes belos", "Terraria", "Piauí", "", "", "", "", "897");        
        Unidade unidade2 = new Unidade(2, 55, "47.408.010/0001-24", "Alfonso Padilha", "21 88545765", "Fixa", "Pública", "Posto", true, "2021-04-15", endereco2);
        unidades.add(unidade2);

        return unidades;
    }

    public static boolean update(Unidade unidadeNova) {
        boolean resultado = false;

        // Update unidade;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Unidade unidade) {
        boolean resultado = false;

        // Delete unidade;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
