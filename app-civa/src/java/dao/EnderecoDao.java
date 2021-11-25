package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Endereco;

public class EnderecoDao {

    public static boolean insert(Endereco endereco) {
        boolean resultado = false;

        // Insert into Endereco values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Endereco find(Integer idEndereco) {
        for (Endereco unidade : EnderecoDao.list()) {
            if( Objects.equals(unidade.getIdEndereco(), idEndereco) ){
                return unidade;
            }
        }
        
        return null;
    }

    public static List<Endereco> list() {
        List<Endereco> enderecos = new ArrayList<Endereco>();

        //"SELECT * FROM endereco;
        Endereco endereco = new Endereco();

        endereco.setCodigoPostal("");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setTipoLogradouro("");
        endereco.setLogradouro("");
        endereco.setNomesubdivisao1("");
        endereco.setNomesubdivisao2("");
        endereco.setNomesubdivisao3("");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setNomesubdivisao6("");
        endereco.setNomesubdivisao7("");

        enderecos.add(endereco);

        Endereco endereco2 = new Endereco();

        endereco2.setCodigoPostal("");
        endereco2.setIdEndereco(1);
        endereco2.setIdPais(1);
        endereco2.setTipoLogradouro("");
        endereco2.setLogradouro("");
        endereco2.setNomesubdivisao1("");
        endereco2.setNomesubdivisao2("");
        endereco2.setNomesubdivisao3("");
        endereco2.setNomesubdivisao4("");
        endereco2.setNomesubdivisao5("");
        endereco2.setNomesubdivisao6("");
        endereco2.setNomesubdivisao7("");

        enderecos.add(endereco2);

        return enderecos;
    }

    public static boolean update(Endereco enderecoNovo) {
        boolean resultado = false;

        // Update endereco;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Endereco endereco) {
        boolean resultado = false;

        // Delete Endereco;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
