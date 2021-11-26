package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
      for (Vacinacao vacinacao : VacinacaoDao.list()) {
            if( Objects.equals(vacinacao.getIdVacinacao(), idVacinacao) ){
                return vacinacao;
            }
        }
       
        return null;
    }
    
     public static Vacinacao find(Integer idVacinacao, List<Vacinacao> listaVacinacaoPortador) {
      for (Vacinacao vacinacao : listaVacinacaoPortador) {
            if( Objects.equals(vacinacao.getIdVacinacao(), idVacinacao) ){
                return vacinacao;
            }
        }
       
        return null;
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
        vacina.setLote(998);

        vacinacao.setDataAplicacao("2021-04-12");
        vacinacao.setDoseAplicada(1);
        vacinacao.setPais("Brasil");
        vacinacao.setUnidade("Monte carlos");
        vacinacao.setVacina(vacina);
        vacinacao.setIdVacinacao(12292);
        vacinacao.setIdUnidade(123);

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
        vacina2.setLote(1008);
        
        vacinacao2.setDataAplicacao("2021-06-14");
        vacinacao2.setDoseAplicada(2);
       
        vacinacao2.setPais("Brasil");
        vacinacao2.setUnidade("Monte Carlos");
        vacinacao2.setVacina(vacina2);
        vacinacao2.setIdVacinacao(12339);
        vacinacao2.setIdUnidade(153);

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
