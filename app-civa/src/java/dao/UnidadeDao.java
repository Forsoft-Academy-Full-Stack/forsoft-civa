package dao;

import java.util.ArrayList;
import java.util.List;
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

    public static Unidade find(String registro) {
       Unidade unidade = new Unidade();

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1);
        endereco.setCodigoPostal("76542445");
        // BAIRRO
        endereco.setNomesubdivisao1("Vila são marcos");
        // MUNICIPIO
        endereco.setNomesubdivisao2("Rio de Janeiro");
          // ESTADO
        endereco.setNomesubdivisao3("Rio de Janeiro");
        endereco.setLogradouro("Tatuí");
        endereco.setNomePais("Brasil");
        endereco.setNumero("5543");
        endereco.setComplemento("Conjunto A");
        
        unidade.setEndereco(endereco);
        
        unidade.setContato("+55 9985563445");
        unidade.setDataCadastro("2021-01-10");
        unidade.setIdUnidade(1);
        unidade.setLocacao("Fixa");
        unidade.setNatureza("Privada");
        unidade.setNome("Bezerra da Silva");
        unidade.setNumero(23);
        unidade.setRegistro("07.235.197/0001-97");
        unidade.setSituacao(Boolean.TRUE);
        unidade.setTipoEstabelecimento("Hospital");

        return unidade;
    }

    public static List<Unidade> list() {
        List<Unidade> unidades = new ArrayList<Unidade>();

        //"SELECT * FROM pais ;
        Unidade unidade = new Unidade();

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1);
        endereco.setCodigoPostal("76542445");
        // BAIRRO
        endereco.setNomesubdivisao1("Vila são marcos");
        // MUNICIPIO
        endereco.setNomesubdivisao2("Rio de Janeiro");
          // ESTADO
        endereco.setNomesubdivisao3("Rio de Janeiro");
        
        endereco.setLogradouro("Tatuí");
        endereco.setNomePais("Brasil");
        
        unidade.setEndereco(endereco);
        
        unidade.setContato("+55 9985563445");
        unidade.setDataCadastro("2021-01-10");
        unidade.setIdUnidade(1);
        unidade.setLocacao("Privada");
        unidade.setNatureza("");
        unidade.setNome("Bezerra da Silva");
        unidade.setNumero(23);
        unidade.setRegistro("07.235.197/0001-97");
        unidade.setSituacao(Boolean.TRUE);
        unidade.setTipoEstabelecimento("Hospital");

        unidades.add(unidade);

        Unidade unidade2 = new Unidade();

        unidade2.setContato("21 88545765");
        unidade2.setDataCadastro("2021-04-15");
        unidade2.setIdUnidade(1);
        unidade2.setLocacao("Fixa");
        unidade2.setNatureza("Pública");
        unidade2.setNome("Alfonso Padilha");
        unidade2.setNumero(23);
        unidade2.setRegistro("47.408.010/0001-24");
        unidade2.setSituacao(Boolean.TRUE);
        unidade2.setTipoEstabelecimento("Posto");
        
        Endereco endereco2 = new Endereco();
        endereco2.setIdEndereco(1);
        endereco2.setCodigoPostal("321232123");
        // BAIRRO
        endereco2.setNomesubdivisao1("Montes belos");
        // MUNICIPIO
        endereco2.setNomesubdivisao2("Terraria");
         // ESTADO
        endereco2.setNomesubdivisao3("Piauí");
        
        endereco2.setLogradouro("Serrinha");
        endereco2.setNomePais("Brasil");
        
        unidade2.setEndereco(endereco2);

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
