/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
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

        vacinacao.setDataAplicacao("");
        vacinacao.setDoseAplicada(1);
        vacinacao.setLaboratorio("");
        vacinacao.setPais("");
        vacinacao.setUnidade("");
        vacinacao.setVacina("");

        return vacinacao;
    }

    public static List<Vacinacao> list() {
        List<Vacinacao> vacinacoes = new ArrayList<Vacinacao>();

        Vacinacao vacinacao = new Vacinacao();

        vacinacao.setDataAplicacao("");
        vacinacao.setDoseAplicada(1);
        vacinacao.setLaboratorio("");
        vacinacao.setPais("");
        vacinacao.setUnidade("");
        vacinacao.setVacina("");

        vacinacoes.add(vacinacao);

        Vacinacao vacinacao2 = new Vacinacao();

        vacinacao2.setDataAplicacao("");
        vacinacao2.setDoseAplicada(1);
        vacinacao2.setLaboratorio("");
        vacinacao2.setPais("");
        vacinacao2.setUnidade("");
        vacinacao2.setVacina("");

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
