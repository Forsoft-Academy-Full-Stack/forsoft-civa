package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Vacina;

/**
 *
 * @author randel
 */
public class VacinaDao {
    
    public static boolean insert(Vacina vacina) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Vacina find(Integer idVacina) {                 
       for (Vacina vacina : VacinaDao.list()) {
            if( Objects.equals(vacina.getIdVacina(), idVacina) ){
                return vacina;
            }
        }
       
        return null;
    }

    public static List<Vacina> list() {
        List<Vacina> vacinas = new ArrayList<Vacina>();
        
        //Integer idVacina, String laboratorio, Integer numeroDoses,
        //String nomeVacina, String tipoVacina, Integer tempoEntreDoses,
        //Integer tempoReforco, Integer lote
        Vacina vacina = new Vacina(1, "Sinovac/Butantan", 3, "Coronavac", "Inativada", 28, 0, 701);
        vacinas.add(vacina);
               
        Vacina vacina2 = new Vacina(2, "Oxford/AstraZeneca", 2, "AstraZeneca", "Vetor Viral", 30, 0, 802);
        vacinas.add(vacina2);
        
        Vacina vacina3 = new Vacina(3, "Janssen Pharmaceutical Companies (Johnson)", 1, "Janssen", "Vetor Viral", 0, 0, 902);     
        vacinas.add(vacina3);
                
        
        Vacina vacina4 = new Vacina(4, "BioNTech/Fosun Pharma/Pfizer", 2, "Pfizer", "Genética", 21, 0, 1002);             
        vacinas.add(vacina4);
            
        return vacinas;
    }

    public static boolean update(Vacina vacinaNova) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
    public static boolean delete(Vacina vacina) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
}
