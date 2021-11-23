package dao;

import java.util.ArrayList;
import java.util.List;
import model.Vacina;
import model.Vacinacao;

/**
 *
 * @author randel
 */
public class VacinacaoDao {

    public static boolean insert(Vacinacao vacinacao) {
        boolean resultado = false;

        // Insert into vacinacao values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Vacinacao find(Integer idVacinacao) {
      
        Vacinacao vacinacao = new Vacinacao();
        
        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Coronavac");
        vacina.setLaboratorio("Sinovac/Butantan");
        vacina.setNumeroDoses(3);
        vacina.setTempoEntreDoses(28);
        vacina.setTipoVacina("Inativada");
        vacina.setTempoReforco(0);
        vacina.setIdVacina(000001);

        vacinacao.setDataAplicacao("2021-04-12");
        vacinacao.setDoseAplicada(1);
        vacinacao.setPais("Brasil");
        vacinacao.setUnidade("Monte carlos");
        vacinacao.setVacina(vacina);

        return vacinacao;
    }

    public static List<Vacinacao> list() {
        List<Vacinacao> vacinacoes = new ArrayList<Vacinacao>();

        Vacinacao vacinacao = new Vacinacao();
        
        Vacina vacina = new Vacina();
        vacina.setNomeVacina("Coronavac");
        vacina.setLaboratorio("Sinovac/Butantan");
        vacina.setNumeroDoses(3);
        vacina.setTempoEntreDoses(28);
        vacina.setTipoVacina("Inativada");
        vacina.setTempoReforco(0);
        vacina.setIdVacina(000001);

        vacinacao.setDataAplicacao("2021-04-12");
        vacinacao.setDoseAplicada(1);
        vacinacao.setPais("Brasil");
        vacinacao.setUnidade("Monte carlos");
        vacinacao.setVacina(vacina);
     

        vacinacoes.add(vacinacao);

        Vacinacao vacinacao2 = new Vacinacao();
        
        Vacina vacina2 = new Vacina();
        vacina2.setNomeVacina("Coronavac");
        vacina2.setLaboratorio("Sinovac/Butantan");
        vacina2.setNumeroDoses(3);
        vacina2.setTempoEntreDoses(28);
        vacina2.setTipoVacina("Inativada");
        vacina2.setTempoReforco(0);
        vacina2.setIdVacina(000001);
        
        vacinacao2.setDataAplicacao("2021-06-14");
        vacinacao2.setDoseAplicada(2);
       
        vacinacao2.setPais("Brasil");
        vacinacao2.setUnidade("Monte Carlos");
        vacinacao2.setVacina(vacina2);

        vacinacoes.add(vacinacao2);

        return vacinacoes;
    }

    public static boolean update(Vacinacao vacinacaoNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Vacinacao vacinacao) {
        boolean resultado = false;

        // Delete vacinacao;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
