package dao;

import java.util.ArrayList;
import java.util.List;
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

    public static Pais find(String pais) {
        Pais pais1 = new Pais();
        //"SELECT * FROM pais where nome = "+pais;
        pais1.setSigla(pais);
        pais1.setNomePais(pais);
        pais1.setIdPais(12);

        return pais1;
    }

    public static List<Unidade> list() {
        List<Unidade> unidades = new ArrayList<Unidade>();

        //"SELECT * FROM pais ;
        Unidade unidade = new Unidade();

        unidade.setContato("");
        unidade.setDataCadastro("");
        unidade.setIdEndereco(2);
        unidade.setIdUnidade(1);
        unidade.setLocacao("");
        unidade.setNatureza("");
        unidade.setNome("");
        unidade.setNumero(23);
        unidade.setRegistro("");
        unidade.setSituacao(Boolean.TRUE);
        unidade.setTipoEstabelecimento("");

        unidades.add(unidade);

        Unidade unidade2 = new Unidade();

        unidade2.setContato("");
        unidade2.setDataCadastro("");
        unidade2.setIdEndereco(2);
        unidade2.setIdUnidade(1);
        unidade2.setLocacao("");
        unidade2.setNatureza("");
        unidade2.setNome("");
        unidade2.setNumero(23);
        unidade2.setRegistro("");
        unidade2.setSituacao(Boolean.TRUE);
        unidade2.setTipoEstabelecimento("");

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
