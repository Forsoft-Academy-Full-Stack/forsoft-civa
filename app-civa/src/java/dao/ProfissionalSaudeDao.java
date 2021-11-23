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
        
       // data no formato AAAA/mm/dd
       
        Pessoa pessoa = new Pessoa();
        // data no formato AAAA/mm/dd
        pessoa.setDataNascimento("1991-02-22");
        pessoa.setDdiContato("+55");
        pessoa.setNomePessoa("Felipe");
        pessoa.setSobrenomePessoa("Gomes");
        pessoa.setTelefoneDdd("983578300");
        pessoa.setGenero("homem cis");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);
        pessoa.setNacionalidade("Brasileira");
        pessoa.setEmail("jose@gmail.com");

        Docs documento1 = new Docs();
        documento1.setDataEmissao("19-04-1945");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);
        documento1.setNomeTipoDoc("Identidade");

        Docs documento2 = new Docs();
        documento2.setDataEmissao("19-04-1945");
        documento2.setDocumento("BR123456");
        documento2.setIdPessoa(2);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);
        documento2.setNomeTipoDoc("Passaporte");

        Docs documento3 = new Docs();
        documento3.setDataEmissao("19-04-1945");
        documento3.setDocumento("987.654.564-09");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);
        documento3.setNomeTipoDoc("CPF");

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("54678000");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setNomePais("Brasil");
        endereco.setLogradouro("Rua José");
        // BAIRRO
        endereco.setNomesubdivisao1("Vila Bela");
        // Municipio
        endereco.setNomesubdivisao2("Niterói");
        // ESTADO
        endereco.setNomesubdivisao3("Rio de Janeiro");
        
        endereco.setTipoLogradouro("Rua");
        endereco.setNumero("23");
        endereco.setComplemento("Apto 10");

        profissionalsaude.setPessoa(pessoa);
        profissionalsaude.setDocumento1(documento1);
        profissionalsaude.setDocumento2(documento2);
        profissionalsaude.setDocumento3(documento3);
        profissionalsaude.setEndereco(endereco);
        profissionalsaude.setCodigoCiva("BR672537621576");

        return profissionalsaude;
    }

    public static List<ProfissionalSaude> list() {
        List<ProfissionalSaude> profissionaisSaude = new ArrayList<ProfissionalSaude>();

        //"SELECT * FROM pais ;
        ProfissionalSaude profissionalsaude = new ProfissionalSaude();

        Pessoa pessoa = new Pessoa();
        // data no formato AAAA/mm/dd
        pessoa.setDataNascimento("1991-02-22");
        pessoa.setDdiContato("+55");
        pessoa.setNomePessoa("Felipe");
        pessoa.setSobrenomePessoa("Gomes");
        pessoa.setTelefoneDdd("983578300");
        pessoa.setGenero("Homem cis");
        pessoa.setIdNacionalidade(1);
        pessoa.setIdPessoa(1);
        pessoa.setNacionalidade("Brasileira");

        Docs documento1 = new Docs();
        documento1.setDataEmissao("1945-04-19");
        documento1.setDocumento("99383946577");
        documento1.setIdPessoa(1);
        documento1.setIdDocs(1);
        documento1.setIdTipoDoc(1);
        documento1.setNomeTipoDoc("Identidade");

        Docs documento2 = new Docs();
        documento2.setDataEmissao("1945-01-19");
        documento2.setDocumento("1232323");
        documento2.setIdPessoa(2);
        documento2.setIdDocs(1);
        documento2.setIdTipoDoc(1);
        documento2.setNomeTipoDoc("Identidade");

        Docs documento3 = new Docs();
        documento3.setDataEmissao("1946-07-5");
        documento3.setDocumento("567657567567");
        documento3.setIdPessoa(1);
        documento3.setIdDocs(1);
        documento3.setIdTipoDoc(1);
        documento3.setNomeTipoDoc("Identidade");

        Endereco endereco = new Endereco();
        endereco.setCodigoPostal("54678000");
        endereco.setIdEndereco(1);
        endereco.setIdPais(1);
        endereco.setLogradouro("Rua José");
        // BAIRRO
        endereco.setNomesubdivisao1("Vila Bela");
        // Municipio
        endereco.setNomesubdivisao2("Niterói");
        // ESTADO
        endereco.setNomesubdivisao3("Rio de Janeiro");
        endereco.setNomesubdivisao4("");
        endereco.setNomesubdivisao5("");
        endereco.setTipoLogradouro("Rua");
        endereco.setNumero("23");

        profissionalsaude.setPessoa(pessoa);
        profissionalsaude.setDocumento1(documento1);
        profissionalsaude.setDocumento2(documento2);
        profissionalsaude.setDocumento3(documento3);
        profissionalsaude.setEndereco(endereco);
        profissionalsaude.setCodigoCiva("BR672537621576");

        profissionaisSaude.add(profissionalsaude);

        // Início Supervisor 2 //
        ProfissionalSaude profissionalsaude2 = new ProfissionalSaude();

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setDataNascimento("1996-07-11");
        pessoa2.setDdiContato("+55");
        pessoa2.setNomePessoa("Pedro");
        pessoa2.setSobrenomePessoa("Silva");
        pessoa2.setTelefoneDdd("217687655645");
        pessoa2.setGenero("homem trans");
        pessoa2.setIdNacionalidade(1);
        pessoa2.setIdPessoa(2);
        pessoa2.setNacionalidade("Brasileira");

        Docs documento12 = new Docs();
        documento12.setDataEmissao("1999-04-1");
        documento12.setDocumento("7657328490");
        documento12.setIdPessoa(2);
        documento12.setIdDocs(1);
        documento12.setIdTipoDoc(1);

        Docs documento22 = new Docs();
        documento22.setDataEmissao("2000-04-1");
        documento22.setDocumento("99383946577");
        documento22.setIdPessoa(2);
        documento22.setIdDocs(1);
        documento22.setIdTipoDoc(1);

        Docs documento32 = new Docs();
        documento32.setDataEmissao("2001-04-1");
        documento32.setDocumento("99383946577");
        documento32.setIdPessoa(2);
        documento32.setIdDocs(1);
        documento32.setIdTipoDoc(1);

        Endereco endereco2 = new Endereco();
        endereco2.setCodigoPostal("54678000");
        endereco2.setIdEndereco(1);
        endereco2.setIdPais(1);
        endereco2.setLogradouro("Rua José");
        endereco2.setLogradouro("Rua José");
        // BAIRRO
        endereco2.setNomesubdivisao1("Vila Bela");
        // Municipio
        endereco2.setNomesubdivisao2("Niterói");
        // ESTADO
        endereco2.setNomesubdivisao4("Rio de Janeiro");
        endereco2.setNomesubdivisao5("");
        endereco2.setTipoLogradouro("Rua");
        endereco2.setNumero("21");
        //"SELECT * FROM pais where nome = "+pais;

        profissionalsaude2.setPessoa(pessoa2);
        profissionalsaude2.setDocumento1(documento12);
        profissionalsaude2.setDocumento2(documento22);
        profissionalsaude2.setDocumento3(documento32);
        profissionalsaude2.setEndereco(endereco2);
        profissionalsaude2.setCodigoCiva("BR999923721873");

        profissionaisSaude.add(profissionalsaude2);
        
        // Início Supervisor 3 //
        ProfissionalSaude profissionalsaude3 = new ProfissionalSaude();

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setDataNascimento("1998-07-11");
        pessoa3.setDdiContato("+55");
        pessoa3.setNomePessoa("Maria");
        pessoa3.setSobrenomePessoa("Alcantara");
        pessoa3.setTelefoneDdd("112121212");
        pessoa3.setGenero("Mulher trans");
        pessoa3.setIdNacionalidade(1);
        pessoa3.setIdPessoa(3);
        pessoa3.setNacionalidade("Brasileira");

        Docs documento13 = new Docs();
        documento13.setDataEmissao("2000-04-1");
        documento13.setDocumento("879879879");
        documento13.setIdPessoa(3);
        documento13.setIdDocs(1);
        documento13.setIdTipoDoc(1);

        Docs documento23 = new Docs();
        documento23.setDataEmissao("2001-04-1");
        documento23.setDocumento("99383946577");
        documento23.setIdPessoa(3);
        documento23.setIdDocs(1);
        documento23.setIdTipoDoc(1);

        Docs documento33 = new Docs();
        documento33.setDataEmissao("2002-04-1");
        documento33.setDocumento("4567895445");
        documento33.setIdPessoa(3);
        documento33.setIdDocs(1);
        documento33.setIdTipoDoc(1);

        Endereco endereco3 = new Endereco();
        endereco3.setCodigoPostal("67437643");
        endereco3.setIdEndereco(1);
        endereco3.setIdPais(1);
        endereco3.setLogradouro("Rua C");
        // BAIRRO
        endereco3.setNomesubdivisao1("Santa Marta");
        // Municipio
        endereco3.setNomesubdivisao2("Lagos 2");
        // ESTADO
        endereco3.setNomesubdivisao4("Rio Grande do Norte");
        endereco3.setNomesubdivisao5("");
        endereco3.setTipoLogradouro("Rua");
        endereco3.setNumero("245");
        //"SELECT * FROM pais where nome = "+pais;

        profissionalsaude3.setPessoa(pessoa3);
        profissionalsaude3.setDocumento1(documento13);
        profissionalsaude3.setDocumento2(documento23);
        profissionalsaude3.setDocumento3(documento33);
        profissionalsaude3.setEndereco(endereco3);
        profissionalsaude3.setCodigoCiva("BR87675645");

        profissionaisSaude.add(profissionalsaude3);
        
        
         // Início Supervisor 4 //
        ProfissionalSaude profissionalsaude4 = new ProfissionalSaude();

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setDataNascimento("1999-09-11");
        pessoa4.setDdiContato("+55");
        pessoa4.setNomePessoa("Lucia");
        pessoa4.setSobrenomePessoa("Aruda");
        pessoa4.setTelefoneDdd("98989898");
        pessoa4.setGenero("Mulher cis");
        pessoa4.setIdNacionalidade(1);
        pessoa4.setIdPessoa(4);
        pessoa4.setNacionalidade("Brasileira");

        Docs documento14 = new Docs();
        documento14.setDataEmissao("2001-04-1");
        documento14.setDocumento("676767676");
        documento14.setIdPessoa(4);
        documento14.setIdDocs(1);
        documento14.setIdTipoDoc(1);

        Docs documento24 = new Docs();
        documento24.setDataEmissao("2002-04-1");
        documento24.setDocumento("8787865555");
        documento24.setIdPessoa(4);
        documento24.setIdDocs(1);
        documento24.setIdTipoDoc(1);

        Docs documento34 = new Docs();
        documento34.setDataEmissao("2003-05-1");
        documento34.setDocumento("545455565");
        documento34.setIdPessoa(4);
        documento34.setIdDocs(1);
        documento34.setIdTipoDoc(1);

        Endereco endereco4 = new Endereco();
        endereco4.setCodigoPostal("67734243");
        endereco4.setIdEndereco(1);
        endereco4.setIdPais(1);
        endereco4.setLogradouro("Rua D");
        // BAIRRO
        endereco4.setNomesubdivisao1("Alto da paz");
        // Municipio
        endereco4.setNomesubdivisao2("Ilha");
        // ESTADO
        endereco4.setNomesubdivisao4("Rio Grande do Sul");
        endereco4.setNomesubdivisao5("");
        endereco4.setTipoLogradouro("Rua");
        endereco4.setNumero("258");
        //"SELECT * FROM pais where nome = "+pais;

        profissionalsaude4.setPessoa(pessoa4);
        profissionalsaude4.setDocumento1(documento14);
        profissionalsaude4.setDocumento2(documento24);
        profissionalsaude4.setDocumento3(documento34);
        profissionalsaude4.setEndereco(endereco4);
        profissionalsaude4.setCodigoCiva("BR7764545");

        profissionaisSaude.add(profissionalsaude4);
        
        // Início Supervisor 5 //
        ProfissionalSaude profissionalsaude5 = new ProfissionalSaude();

        Pessoa pessoa5 = new Pessoa();
        pessoa5.setDataNascimento("2003-09-15");
        pessoa5.setDdiContato("+55");
        pessoa5.setNomePessoa("Tadeu");
        pessoa5.setSobrenomePessoa("Virgo");
        pessoa5.setTelefoneDdd("954543768");
        pessoa5.setGenero("Homen cis");
        pessoa5.setIdNacionalidade(1);
        pessoa5.setIdPessoa(5);
        pessoa5.setNacionalidade("Brasileira");

        Docs documento15 = new Docs();
        documento15.setDataEmissao("2007-04-14");
        documento15.setDocumento("123454321");
        documento15.setIdPessoa(5);
        documento15.setIdDocs(1);
        documento15.setIdTipoDoc(1);

        Docs documento25 = new Docs();
        documento25.setDataEmissao("2009-04-1");
        documento25.setDocumento("283485868");
        documento25.setIdPessoa(5);
        documento25.setIdDocs(1);
        documento25.setIdTipoDoc(1);

        Docs documento35 = new Docs();
        documento35.setDataEmissao("2006-05-1");
        documento35.setDocumento("26627667");
        documento35.setIdPessoa(5);
        documento35.setIdDocs(1);
        documento35.setIdTipoDoc(1);

        Endereco endereco5 = new Endereco();
        endereco5.setCodigoPostal("62788989");
        endereco5.setIdEndereco(1);
        endereco5.setIdPais(1);
        endereco5.setLogradouro("Rua F");
        // BAIRRO
        endereco5.setNomesubdivisao1("Vila rica");
        // Municipio
        endereco5.setNomesubdivisao2("Catamar");
        // ESTADO
        endereco5.setNomesubdivisao4("Bahia");
        endereco5.setNomesubdivisao5("");
        endereco5.setTipoLogradouro("Rua");
        endereco5.setNumero("568");
    

        profissionalsaude5.setPessoa(pessoa5);
        profissionalsaude5.setDocumento1(documento15);
        profissionalsaude5.setDocumento2(documento25);
        profissionalsaude5.setDocumento3(documento35);
        profissionalsaude5.setEndereco(endereco5);
        profissionalsaude5.setCodigoCiva("BR48876543");

        profissionaisSaude.add(profissionalsaude5);
               
        // Início Supervisor 6 //
        ProfissionalSaude profissionalsaude6 = new ProfissionalSaude();

        Pessoa pessoa6 = new Pessoa();
        pessoa6.setDataNascimento("2004-10-15");
        pessoa6.setDdiContato("+55");
        pessoa6.setNomePessoa("Izaque");
        pessoa6.setSobrenomePessoa("Ferreira");
        pessoa6.setTelefoneDdd("992032872");
        pessoa6.setGenero("Homen trans");
        pessoa6.setIdNacionalidade(1);
        pessoa6.setIdPessoa(6);
        pessoa6.setNacionalidade("Brasileira");

        Docs documento16 = new Docs();
        documento16.setDataEmissao("2008-06-15");
        documento16.setDocumento("876766554");
        documento16.setIdPessoa(6);
        documento16.setIdDocs(1);
        documento16.setIdTipoDoc(1);

        Docs documento26 = new Docs();
        documento26.setDataEmissao("2010-05-12");
        documento26.setDocumento("4545677676");
        documento26.setIdPessoa(6);
        documento26.setIdDocs(1);
        documento26.setIdTipoDoc(1);

        Docs documento36 = new Docs();
        documento35.setDataEmissao("2007-06-17");
        documento35.setDocumento("9876534576");
        documento35.setIdPessoa(6);
        documento35.setIdDocs(1);
        documento35.setIdTipoDoc(1);

        Endereco endereco6 = new Endereco();
        endereco6.setCodigoPostal("635467990");
        endereco6.setIdEndereco(1);
        endereco6.setIdPais(1);
        endereco6.setLogradouro("Rua G");
        // BAIRRO
        endereco6.setNomesubdivisao1("Nova orleans");
        // Municipio
        endereco6.setNomesubdivisao2("Larangeiras");
        // ESTADO
        endereco6.setNomesubdivisao4("Mato grosso");
        endereco6.setNomesubdivisao5("");
        endereco6.setTipoLogradouro("Rua");
        endereco6.setNumero("768");
    
        profissionalsaude6.setPessoa(pessoa6);
        profissionalsaude6.setDocumento1(documento16);
        profissionalsaude6.setDocumento2(documento26);
        profissionalsaude6.setDocumento3(documento36);
        profissionalsaude6.setEndereco(endereco6);
        profissionalsaude6.setCodigoCiva("BR65765476");

        profissionaisSaude.add(profissionalsaude6);
                
        // Início Supervisor 6 //
        ProfissionalSaude profissionalsaude7 = new ProfissionalSaude();

        Pessoa pessoa7 = new Pessoa();
        pessoa7.setDataNascimento("2005-10-15");
        pessoa7.setDdiContato("+55");
        pessoa7.setNomePessoa("Kerolyne");
        pessoa7.setSobrenomePessoa("Almeida");
        pessoa7.setTelefoneDdd("999437654");
        pessoa7.setGenero("Mulher cis");
        pessoa7.setIdNacionalidade(1);
        pessoa7.setIdPessoa(7);
        pessoa7.setNacionalidade("Brasileira");

        Docs documento17 = new Docs();
        documento17.setDataEmissao("2009-07-18");
        documento17.setDocumento("87656453");
        documento17.setIdPessoa(7);
        documento17.setIdDocs(1);
        documento17.setIdTipoDoc(1);

        Docs documento27 = new Docs();
        documento27.setDataEmissao("2013-06-12");
        documento27.setDocumento("7678565645");
        documento27.setIdPessoa(7);
        documento27.setIdDocs(1);
        documento27.setIdTipoDoc(1);

        Docs documento37 = new Docs();
        documento37.setDataEmissao("2008-07-18");
        documento37.setDocumento("87654324354");
        documento37.setIdPessoa(7);
        documento37.setIdDocs(1);
        documento37.setIdTipoDoc(1);

        Endereco endereco7 = new Endereco();
        endereco7.setCodigoPostal("878756698");
        endereco7.setIdEndereco(1);
        endereco7.setIdPais(1);
        endereco7.setLogradouro("Rua I");
        // BAIRRO
        endereco7.setNomesubdivisao1("Nova era");
        // Municipio
        endereco7.setNomesubdivisao2("Jurema");
        // ESTADO
        endereco7.setNomesubdivisao4("Ceará");
        endereco7.setNomesubdivisao5("");
        endereco7.setTipoLogradouro("Rua");
        endereco7.setNumero("968");
    
        profissionalsaude7.setPessoa(pessoa7);
        profissionalsaude7.setDocumento1(documento17);
        profissionalsaude7.setDocumento2(documento27);
        profissionalsaude7.setDocumento3(documento37);
        profissionalsaude7.setEndereco(endereco7);
        profissionalsaude7.setCodigoCiva("BR98764543");

        profissionaisSaude.add(profissionalsaude7);
        
         // Início Supervisor 8 //
        ProfissionalSaude profissionalsaude8 = new ProfissionalSaude();

        Pessoa pessoa8 = new Pessoa();
        pessoa8.setDataNascimento("1999-02-23");
        pessoa8.setDdiContato("+55");
        pessoa8.setNomePessoa("Marcia");
        pessoa8.setSobrenomePessoa("Silva");
        pessoa8.setTelefoneDdd("9965438746");
        pessoa8.setGenero("Mulher trans");
        pessoa8.setIdNacionalidade(1);
        pessoa8.setIdPessoa(8);
        pessoa8.setNacionalidade("Brasileira");

        Docs documento18 = new Docs();
        documento18.setDataEmissao("1999-03-02");
        documento18.setDocumento("99654365");
        documento18.setIdPessoa(8);
        documento18.setIdDocs(1);
        documento18.setIdTipoDoc(1);

        Docs documento28 = new Docs();
        documento28.setDataEmissao("2011-06-12");
        documento28.setDocumento("7678565645");
        documento28.setIdPessoa(7);
        documento28.setIdDocs(1);
        documento28.setIdTipoDoc(1);

        Docs documento38 = new Docs();
        documento38.setDataEmissao("2010-07-18");
        documento38.setDocumento("87766556");
        documento38.setIdPessoa(8);
        documento38.setIdDocs(1);
        documento38.setIdTipoDoc(1);

        Endereco endereco8 = new Endereco();
        endereco8.setCodigoPostal("43456567");
        endereco8.setIdEndereco(1);
        endereco8.setIdPais(1);
        endereco8.setLogradouro("Rua J");
        // BAIRRO
        endereco8.setNomesubdivisao1("Alvorada nova");
        // Municipio
        endereco8.setNomesubdivisao2("Logoa grande");
        // ESTADO
        endereco8.setNomesubdivisao4("Alagoas");
        endereco8.setNomesubdivisao5("");
        endereco8.setTipoLogradouro("Rua");
        endereco8.setNumero("1958");
    
        profissionalsaude8.setPessoa(pessoa8);
        profissionalsaude8.setDocumento1(documento18);
        profissionalsaude8.setDocumento2(documento28);
        profissionalsaude8.setDocumento3(documento38);
        profissionalsaude8.setEndereco(endereco8);
        profissionalsaude8.setCodigoCiva("BR8776754");

        profissionaisSaude.add(profissionalsaude8);
        
        // Início Supervisor 8 //
        ProfissionalSaude profissionalsaude9 = new ProfissionalSaude();

        Pessoa pessoa9 = new Pessoa();
        pessoa9.setDataNascimento("1997-02-23");
        pessoa9.setDdiContato("+55");
        pessoa9.setNomePessoa("Katia");
        pessoa9.setSobrenomePessoa("Saraiva");
        pessoa9.setTelefoneDdd("99654734");
        pessoa9.setGenero("Mulher cis");
        pessoa9.setIdNacionalidade(1);
        pessoa9.setIdPessoa(9);
        pessoa9.setNacionalidade("Brasileira");

        Docs documento19 = new Docs();
        documento19.setDataEmissao("1995-05-08");
        documento19.setDocumento("99546765");
        documento19.setIdPessoa(9);
        documento19.setIdDocs(1);
        documento19.setIdTipoDoc(1);

        Docs documento29 = new Docs();
        documento29.setDataEmissao("2001-06-12");
        documento29.setDocumento("7678565645");
        documento29.setIdPessoa(8);
        documento29.setIdDocs(1);
        documento29.setIdTipoDoc(1);

        Docs documento39 = new Docs();
        documento39.setDataEmissao("2014-07-18");
        documento39.setDocumento("776545435767");
        documento39.setIdPessoa(9);
        documento39.setIdDocs(1);
        documento39.setIdTipoDoc(1);

        Endereco endereco9 = new Endereco();
        endereco9.setCodigoPostal("87657889");
        endereco9.setIdEndereco(1);
        endereco9.setIdPais(1);
        endereco9.setLogradouro("Rua K");
        // BAIRRO
        endereco9.setNomesubdivisao1("Vila são paulo");
        // Municipio
        endereco9.setNomesubdivisao2("Monte alegre");
        // ESTADO
        endereco9.setNomesubdivisao4("Espiríto Santo");
        endereco9.setNomesubdivisao5("");
        endereco9.setTipoLogradouro("Rua");
        endereco9.setNumero("008");
    
        profissionalsaude9.setPessoa(pessoa9);
        profissionalsaude9.setDocumento1(documento19);
        profissionalsaude9.setDocumento2(documento29);
        profissionalsaude9.setDocumento3(documento39);
        profissionalsaude9.setEndereco(endereco9);
        profissionalsaude9.setCodigoCiva("BR87987");

        profissionaisSaude.add(profissionalsaude9);
        
         // Início Supervisor 10 //
        ProfissionalSaude profissionalsaude10 = new ProfissionalSaude();

        Pessoa pessoa10 = new Pessoa();
        pessoa10.setDataNascimento("1998-02-23");
        pessoa10.setDdiContato("+55");
        pessoa10.setNomePessoa("Celía");
        pessoa10.setSobrenomePessoa("Barroso");
        pessoa10.setTelefoneDdd("76577676");
        pessoa10.setGenero("Mulher trans");
        pessoa10.setIdNacionalidade(1);
        pessoa10.setIdPessoa(10);
        pessoa10.setNacionalidade("Brasileira");

        Docs documento110 = new Docs();
        documento110.setDataEmissao("1994-05-08");
        documento110.setDocumento("76454656");
        documento110.setIdPessoa(10);
        documento110.setIdDocs(1);
        documento110.setIdTipoDoc(1);

        Docs documento210 = new Docs();
        documento210.setDataEmissao("2002-07-12");
        documento210.setDocumento("788878767");
        documento210.setIdPessoa(10);
        documento210.setIdDocs(1);
        documento210.setIdTipoDoc(1);

        Docs documento310 = new Docs();
        documento310.setDataEmissao("2015-03-18");
        documento310.setDocumento("8877656");
        documento310.setIdPessoa(10);
        documento310.setIdDocs(1);
        documento310.setIdTipoDoc(1);

        Endereco endereco10 = new Endereco();
        endereco10.setCodigoPostal("87657889");
        endereco10.setIdEndereco(1);
        endereco10.setIdPais(1);
        endereco10.setLogradouro("Rua L");
        // BAIRRO
        endereco10.setNomesubdivisao1("Vila são paulo");
        // Municipio
        endereco10.setNomesubdivisao2("Alegrete");
        // ESTADO
        endereco10.setNomesubdivisao4("Rio Janeiro");
        endereco10.setNomesubdivisao5("");
        endereco10.setTipoLogradouro("Rua");
        endereco10.setNumero("768");
    
        profissionalsaude10.setPessoa(pessoa10);
        profissionalsaude10.setDocumento1(documento110);
        profissionalsaude10.setDocumento2(documento210);
        profissionalsaude10.setDocumento3(documento310);
        profissionalsaude10.setEndereco(endereco10);
        profissionalsaude10.setCodigoCiva("BR4434434343");

        profissionaisSaude.add(profissionalsaude10);
        
         // Início Supervisor 8 //
        ProfissionalSaude profissionalsaude11 = new ProfissionalSaude();

        Pessoa pessoa11 = new Pessoa();
        pessoa11.setDataNascimento("1967-15-56");
        pessoa11.setDdiContato("+55");
        pessoa11.setNomePessoa("Amanda");
        pessoa11.setSobrenomePessoa("Rego Barros");
        pessoa11.setTelefoneDdd("76778787687");
        pessoa11.setGenero("Mulher cis");
        pessoa11.setIdNacionalidade(1);
        pessoa11.setIdPessoa(11);
        pessoa11.setNacionalidade("Brasileira");

        Docs documento111 = new Docs();
        documento111.setDataEmissao("1997-05-08");
        documento111.setDocumento("76454656");
        documento111.setIdPessoa(11);
        documento111.setIdDocs(1);
        documento111.setIdTipoDoc(1);

        Docs documento211 = new Docs();
        documento211.setDataEmissao("2001-06-12");
        documento211.setDocumento("54565465");
        documento211.setIdPessoa(11);
        documento211.setIdDocs(1);
        documento211.setIdTipoDoc(1);

        Docs documento311 = new Docs();
        documento311.setDataEmissao("2015-03-18");
        documento311.setDocumento("8877656");
        documento311.setIdPessoa(11);
        documento311.setIdDocs(1);
        documento311.setIdTipoDoc(1);

        Endereco endereco11 = new Endereco();
        endereco11.setCodigoPostal("54546657");
        endereco11.setIdEndereco(1);
        endereco11.setIdPais(1);
        endereco11.setLogradouro("Rua M");
        // BAIRRO
        endereco11.setNomesubdivisao1("Vila rio grande");
        // Municipio
        endereco11.setNomesubdivisao2("Altos da pedra");
        // ESTADO
        endereco11.setNomesubdivisao4("São Paulo");
        endereco11.setNomesubdivisao5("");
        endereco11.setTipoLogradouro("Rua");
        endereco11.setNumero("787");
    
        profissionalsaude11.setPessoa(pessoa11);
        profissionalsaude11.setDocumento1(documento111);
        profissionalsaude11.setDocumento2(documento211);
        profissionalsaude11.setDocumento3(documento311);
        profissionalsaude11.setEndereco(endereco11);
        profissionalsaude11.setCodigoCiva("BR89899988");

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
