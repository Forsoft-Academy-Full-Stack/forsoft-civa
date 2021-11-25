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
        
        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Coronavac");
        vacina.setLaboratorio("Sinovac/Butantan");
        vacina.setNumeroDoses(3);
        vacina.setTempoEntreDoses(28);
        vacina.setTipoVacina("Inativada");
        vacina.setTempoReforco(0);
        vacina.setIdVacina(000001);
        
        vacinas.add(vacina);
               
        Vacina vacina2 = new Vacina();
        vacina2.setNomeVacina("AstraZeneca");
        vacina2.setLaboratorio("Oxford/AstraZeneca");
        vacina2.setNumeroDoses(2);
        vacina2.setTempoEntreDoses(30);
        vacina2.setTipoVacina("Vetor Viral");
        vacina2.setTempoReforco(0);
        vacina2.setIdVacina(000002);
        
        vacinas.add(vacina2);
        
        Vacina vacina3 = new Vacina();
        vacina3.setNomeVacina("Janssen");
        vacina3.setLaboratorio("Janssen Pharmaceutical Companies (Johnson)");
        vacina3.setNumeroDoses(1);
        vacina3.setTipoVacina("Vetor Viral");
        vacina3.setTempoReforco(0);
        vacina3.setTempoEntreDoses(0);
        
        vacina3.setIdVacina(000003);
        
        vacinas.add(vacina3);
                
        Vacina vacina4 = new Vacina();
        vacina4.setNomeVacina("Pfizer");
        vacina4.setLaboratorio("BioNTech/Fosun Pharma/Pfizer");
        vacina4.setNumeroDoses(2);
        vacina4.setTempoEntreDoses(21);
        vacina4.setTipoVacina("Genética");
        vacina4.setTempoReforco(0);
        vacina4.setIdVacina(000004);
        
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
