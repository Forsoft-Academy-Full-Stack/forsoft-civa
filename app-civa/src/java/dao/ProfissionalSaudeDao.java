package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.ProfissionalSaude;
import model.Pessoa;

/**
 *
 * @author Meliza Maia | Michel Assis
 */
public class ProfissionalSaudeDao {

    public static boolean insert(ProfissionalSaude profissionalsaude) {
        boolean resultado = false;

        // Insert into ProfissionalSaude values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static ProfissionalSaude find(String nomeprofissionalsaude) {
        ProfissionalSaude profissionalsaude = new ProfissionalSaude();
        //"SELECT * FROM pais where profissionalSaude = "+nomeprofissionalsaude;
        Pessoa pessoa = new Pessoa();
        pessoa.setNomePessoa("Michel");
        pessoa.setSobrenomePessoa("Assis");
        pessoa.setGenero("Masculino");
        pessoa.setDataNascimento("03/05/1996");
        pessoa.setDdiContato("+55");
        pessoa.setTelefoneDdd("2124727922");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);

        profissionalsaude.setPessoa(pessoa);

        Docs documento1 = new Docs();
        documento1.setDataEmissao("19-04-1945");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIddocs(1);
        documento1.setIdtipodoc(1);

        profissionalsaude.setDocumento1(documento1);

        Docs documento2 = new Docs();
        documento2.setDataEmissao("19-04-1945");
        documento2.setDocumento("99383946577");
        documento2.setIdPessoa(1);
        documento2.setIddocs(1);
        documento2.setIdtipodoc(1);

        profissionalsaude.setDocumento2(documento2);

        Docs documento3 = new Docs();
        documento3.setDataEmissao("19-04-1945");
        documento3.setDocumento("99383946577");
        documento3.setIdPessoa(1);
        documento3.setIddocs(1);
        documento3.setIdtipodoc(1);

        profissionalsaude.setDocumento3(documento3);

        Endereco endereco = new Endereco();
        endereco.setTipoLogradouro("Rua");
        endereco.setLogradouro("Rua José");
        endereco.setCodigoPostal("54678000");
        endereco.setNomesubdivisao1("");
        endereco.setNomesubdivisao2("");
        endereco.setNomesubdivisao3("");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setNomesubdivisao6("");
        endereco.setNomesubdivisao7("");

        profissionalsaude.setEndereco(endereco);

        return profissionalsaude;
    }

    public static List<ProfissionalSaude> list() {
        List<ProfissionalSaude> profissionaisSaude = new ArrayList<ProfissionalSaude>();

        //"SELECT * FROM pais ;
        ProfissionalSaude profissionalsaude = new ProfissionalSaude();

        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento("12-03-1977");
        pessoa.setDdiContato("+55");
        pessoa.setNomePessoa("José");
        pessoa.setSobrenomePessoa("Carlos");
        pessoa.setTelefoneDdd("983578300");
        pessoa.setGenero("homem cis");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);

        Docs documento1 = new Docs();
        documento1.setDataEmissao("19-04-1945");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIddocs(1);
        documento1.setIdtipodoc(1);

        Docs documento2 = new Docs();
        documento2.setDataEmissao("19-04-1945");
        documento2.setDocumento("99383946577");
        documento2.setIdPessoa(1);
        documento2.setIddocs(1);
        documento2.setIdtipodoc(1);

        Docs documento3 = new Docs();
        documento3.setDataEmissao("19-04-1945");
        documento3.setDocumento("99383946577");
        documento3.setIdPessoa(1);
        documento3.setIddocs(1);
        documento3.setIdtipodoc(1);

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("54678000");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setLogradouro("Rua José");
        endereco.setNomesubdivisao1("");
        endereco.setNomesubdivisao2("");
        endereco.setNomesubdivisao3("");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setNomesubdivisao6("");
        endereco.setNomesubdivisao7("");
        endereco.setTipoLogradouro("Rua");
        //"SELECT * FROM pais where nome = "+pais;

        profissionalsaude.setPessoa(pessoa);
        profissionalsaude.setDocumento1(documento1);
        profissionalsaude.setDocumento2(documento2);
        profissionalsaude.setDocumento3(documento3);
        profissionalsaude.setEndereco(endereco);

        profissionaisSaude.add(profissionalsaude);

        ProfissionalSaude profissionalsaude2 = new ProfissionalSaude();

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setDataNascimento("12-03-1977");
        pessoa2.setDdiContato("+55");
        pessoa2.setNomePessoa("José");
        pessoa2.setSobrenomePessoa("Carlos");
        pessoa2.setTelefoneDdd("983578300");
        pessoa2.setGenero("homem cis");
        pessoa2.setIdNacionalidade(1);
        pessoa2.setIdPessoa(1);

        Docs documento12 = new Docs();
        documento12.setDataEmissao("19-04-1945");
        documento12.setDocumento("99383946577");
        documento12.setIdPessoa(1);
        documento12.setIddocs(1);
        documento12.setIdtipodoc(1);

        Docs documento22 = new Docs();
        documento22.setDataEmissao("19-04-1945");
        documento22.setDocumento("99383946577");
        documento22.setIdPessoa(1);
        documento22.setIddocs(1);
        documento22.setIdtipodoc(1);

        Docs documento32 = new Docs();
        documento32.setDataEmissao("19-04-1945");
        documento32.setDocumento("99383946577");
        documento32.setIdPessoa(1);
        documento32.setIddocs(1);
        documento32.setIdtipodoc(1);

        Endereco endereco2 = new Endereco();
        endereco2.setCodigoPostal("54678000");
        endereco2.setIdEndereco(1);
        endereco2.setIdPais(1);
        endereco2.setLogradouro("Rua José");
        endereco2.setNomesubdivisao1("");
        endereco2.setNomesubdivisao2("");
        endereco2.setNomesubdivisao3("");
        endereco2.setNomesubdivisao4("");
        endereco2.setNomesubdivisao5("");
        endereco2.setNomesubdivisao7("");
        endereco2.setTipoLogradouro("Rua");
        //"SELECT * FROM pais where nome = "+pais;

        profissionalsaude2.setPessoa(pessoa);
        profissionalsaude2.setDocumento1(documento1);
        profissionalsaude2.setDocumento2(documento2);
        profissionalsaude2.setDocumento3(documento3);
        profissionalsaude2.setEndereco(endereco);

        profissionaisSaude.add(profissionalsaude);

        return profissionaisSaude;
    }

    public static boolean update(ProfissionalSaude profissionalsaudeNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(ProfissionalSaude profissionalsaude) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
