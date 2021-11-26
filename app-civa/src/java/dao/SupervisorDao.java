package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.Pessoa;
import model.Supervisor;
/**
 *
 * @author randel
 */
public class SupervisorDao {
    private static List<Supervisor> supervisores;
    
    public static boolean insert(Supervisor supervisor) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (supervisores.add(supervisor)) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Supervisor find(String codigoCivaSupervisor) {
        
        for (Supervisor supervisor : SupervisorDao.list()) {
            if( supervisor.getCodigoCiva().equals( codigoCivaSupervisor )){
                return supervisor;
            }
        }        

        return null;
    }

    public static List<Supervisor> list() {
        supervisores = new ArrayList<Supervisor>();        
        
       // Início Supervisor 1 //
       //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
       //String sobrenomePessoa, String dataNascimento, String ddiContato,
       //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa = new Pessoa(1, 1, "Brasileira", "José", "Carlos", "1977-07-03", "+55", "joséCarlos@gmail.com", "983578300", "homem cis", "BR672537621576");
                
        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento1 = new Docs(1, "99383946577", 1, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(2, "21676786876", 1, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(3, "06543456478", 1, 3, "CPF", "1946-07-5", "XXX.XXX.XXX-XX", "Civil");     
            
        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco = new Endereco(1, 1, "Brasil", "Rua", "Rua José", "54678000", "Apto 14", "Vila Bela", "Niterói", "Rio de Janeiro", "", "", "", "", "23");
      
        // Pessoa pessoa, Docs documento1, Docs documento2, Docs documento3,
        // Endereco endereco, String codigoCiva      
        Supervisor supervisor = new Supervisor(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());       
        supervisores.add(supervisor);
                     
        // Início Supervisor 2 // 
        Pessoa pessoa2 = new Pessoa(2, 1, "Brasileira",  "Pedro", "Silva", "1996-07-11", "+55", "pedroSilva@gmail.com", "217687655645", "Homem trans", "BR999923721873");              
        
        Docs documento12 = new Docs(4, "7657328490", 2, 1, "Identidade", "1999-04-1", "XXXXXXXXXXX", "Civil");          
        Docs documento22 = new Docs(5, "99383946577", 2, 2, "Passaporte","2000-04-1", "XXXXXXXXXXX", "Civil");
        Docs documento32 = new Docs(6, "99383946577", 2, 3, "CPF", "2001-04-1", "XXX.XXX.XXX-XX", "Civil");
       
        Endereco endereco2 = new Endereco(2, 1, "Brasil", "Rua", "Rua José", "54678000", "Apto 12", "Vila Bela", "Niterói", "Rio de Janeiro", "", "", "", "", "21");

        Supervisor supervisor2 = new Supervisor(pessoa2, documento12, documento22, documento32, endereco2, pessoa2.getCodigoCiva());
        supervisores.add(supervisor2);                
         
        // Início Supervisor 3 //
        Pessoa pessoa3 = new Pessoa(3, 1, "Brasileira", "Maria", "Alcantara", "1998-07-11",  "+55", "mariaAlcantara@gmail.com", "112121212", "Mulher trans", "BR87675645");
          
        Docs documento13 = new Docs(7, "879879879", 3, 1, "Identidade", "2000-04-1", "XXXXXXXXXXX", "Civil");       
        Docs documento23 = new Docs(8, "99383946577", 3, 2, "Passaporte", "2001-04-1", "XXXXXXXXXXX", "Civil");        
        Docs documento33 = new Docs(9, "4567895445", 3, 3, "CPF", "2002-04-1", "XXX.XXX.XXX-XX", "Civil");
              
        Endereco endereco3 = new Endereco(3, 1, "Brasil", "Avenida", "Rua C", "67437643", "Casa B", "Santa Marta", "Santa Marta", "Rio Grande do Norte", "", "", "", "", "245");

        Supervisor supervisor3 = new Supervisor(pessoa3, documento13, documento23, documento33, endereco3, pessoa3.getCodigoCiva());
        supervisores.add(supervisor3);                           
       
        // Início Supervisor 4 //
        Pessoa pessoa4 = new Pessoa(4, 1, "Brasileira", "Lucia", "Aruda", "1999-09-11", "+55", "luciaAruda@gmail.com", "98989898", "Mulher cis", "BR7764545");              
               
        Docs documento14 = new Docs(10, "676767676", 4, 1, "Identidade", "2001-04-1", "XXXXXXXXXXX", "Civil");        
        Docs documento24 = new Docs(11, "878786555", 4, 2, "Passaporte", "2002-04-1", "XXXXXXXXXXX", "Civil");       
        Docs documento34 = new Docs(12, "545455565", 4, 3, "CPF", "2003-05-1", "XXX.XXX.XXX-XX", "Civil");       
                
        Endereco endereco4 = new Endereco(4, 1, "Brasil", "Rua", "Rua D", "67734243", "Casa Z", "Alto da paz", "Ilha", "Rio Grande do Sul", "", "", "", "", "258");        

        Supervisor supervisor4 = new Supervisor(pessoa4, documento14, documento24, documento34, endereco4, pessoa4.getCodigoCiva());
        supervisores.add(supervisor4);

        // Início Supervisor 5 //
        Pessoa pessoa5 = new Pessoa(5, 1, "Brasileira", "Tadeu", "Virgo", "2003-09-15", "+55", "tadeuVirgo@gmail.com", "954543768", "Homen cis", "BR48876543");      

        Docs documento15 = new Docs(13, "123454321", 5, 1, "Identidade", "2007-04-14", "XXXXXXXXXXX", "Civil");  
        Docs documento25 = new Docs(14, "283485868", 5, 2, "Passaporte", "2009-04-1", "XXXXXXXXXXX", "Civil");
        Docs documento35 = new Docs(15, "26627667", 5, 3, "CPF", "2006-05-1", "XXX.XXX.XXX-XX", "Civil");
         
        Endereco endereco5 = new Endereco(5, 1, "Brasil", "Rua", "Rua F", "62788989", "Apt 2", "Catamar", "Ilha", "Bahia", "", "", "", "", "568");

        Supervisor supervisor5 = new Supervisor(pessoa5, documento15, documento25, documento35, endereco5, pessoa5.getCodigoCiva());       
        supervisores.add(supervisor5);

        // Início Supervisor 6 //   
        Pessoa pessoa6 = new Pessoa(6, 1, "Brasileira", "Izaque", "Ferreira", "2004-10-15", "+55", "izaqueFerreira@gmail.com", "992032872", "Homen trans", "BR65765476");      
     
        Docs documento16 = new Docs(16, "876766554", 6, 1, "Identidade", "2008-06-15", "XXXXXXXXXXX", "Civil");  
        Docs documento26 = new Docs(17, "4545677676", 6, 2, "Passaporte", "2010-05-12", "XXXXXXXXXXX", "Civil");
        Docs documento36 = new Docs(18, "9876534576", 6, 3, "CPF", "2007-06-17", "XXX.XXX.XXX-XX", "Civil");            

        Endereco endereco6 = new Endereco(6, 1, "Brasil", "Rua", "Rua G", "635467990", "Casa AB", "Nova orleans", "Larangeiras", "Mato grosso", "", "", "", "", "768");

        Supervisor supervisor6 = new Supervisor(pessoa6, documento16, documento26, documento36, endereco6, pessoa6.getCodigoCiva());                   
        supervisores.add(supervisor6);

        // Início Supervisor 7 //        
        Pessoa pessoa7 = new Pessoa(7, 1, "Brasileira", "Kerolyne", "Almeida", "2005-10-15", "+55", "kerolyne@gmail.com", "999437654", "Mulher cis", "BR98764543");      
    
        Docs documento17 = new Docs(19, "87656453", 7, 1, "Identidade", "2009-07-18", "XXXXXXXXXXX", "Civil");  
        Docs documento27 = new Docs(20, "4545677676", 7, 2, "Passaporte", "2013-06-12", "XXXXXXXXXXX", "Civil");
        Docs documento37 = new Docs(21, "87654324354", 7, 3, "CPF", "2008-07-18", "XXX.XXX.XXX-XX", "Civil");     
        
        Endereco endereco7 = new Endereco(7, 1, "Brasil", "Rua", "Rua I", "878756698", "Casa AC", "Nova era", "Jurema", "Ceará", "", "", "", "", "968");
        
        Supervisor supervisor7 = new Supervisor(pessoa7, documento17, documento27, documento37, endereco7, pessoa7.getCodigoCiva());                  
        supervisores.add(supervisor7);

        // Início Supervisor 8 //
        Pessoa pessoa8 = new Pessoa(8, 1, "Brasileira", "Marcia", "Silva", "1999-02-23", "+55", "marciaSilva@gmail.com", "9965438746", "Mulher trans", "BR8776754");      
    
        Docs documento18 = new Docs(22, "99654365", 8, 1, "Identidade", "1999-03-02", "XXXXXXXXXXX", "Civil");  
        Docs documento28 = new Docs(23, "7678565645", 8, 2, "Passaporte", "2011-06-12", "XXXXXXXXXXX", "Civil");
        Docs documento38 = new Docs(24, "87766556", 8, 3, "CPF", "2010-07-18", "XXX.XXX.XXX-XX", "Civil");     
       
        Endereco endereco8 = new Endereco(8, 1, "Brasil", "Rua", "Rua J", "43456567", "Casa AD", "Alvorada nova", "Logoa grande", "Alagoas", "", "", "", "", "1958");
        
        Supervisor supervisor8 = new Supervisor(pessoa8, documento18, documento28, documento38, endereco8, pessoa8.getCodigoCiva());                         
        supervisores.add(supervisor8);

        // Início Supervisor 9 //
        Pessoa pessoa9 = new Pessoa(9, 1, "Brasileira", "Katia", "Saraiva", "1997-02-23", "+55", "katiaSaraiva@gmail.com", "99654734", "Mulher cis", "BR87987");      
    
        Docs documento19 = new Docs(25, "99546765", 9, 1, "Identidade", "1995-05-08", "XXXXXXXXXXX", "Civil");  
        Docs documento29 = new Docs(26, "7678565645", 9, 2, "Passaporte", "2001-06-12", "XXXXXXXXXXX", "Civil");
        Docs documento39 = new Docs(27, "776545435767", 9, 3, "CPF", "2014-07-18", "XXX.XXX.XXX-XX", "Civil");     
       
        Endereco endereco9 = new Endereco(9, 1, "Brasil", "Rua", "Rua K", "87657889", "Casa AL", "Vila São paulo", "Monte alegre", "Espiríto Santo", "", "", "", "", "008");
        
        Supervisor supervisor9 = new Supervisor(pessoa9, documento19, documento29, documento39, endereco9, pessoa9.getCodigoCiva());    
        supervisores.add(supervisor9);

        // Início Supervisor 10 //
        Pessoa pessoa10 = new Pessoa(10, 1, "Brasileira", "Celía", "Barroso", "1998-02-23", "+55", "celiaBarroso@gmail.com", "76577676", "Mulher trans", "BR4434434343");      
    
        Docs documento110 = new Docs(28, "76454656", 10, 1, "Identidade", "1994-05-08", "XXXXXXXXXXX", "Civil");  
        Docs documento210 = new Docs(29, "788878767", 10, 2, "Passaporte", "2002-07-12", "XXXXXXXXXXX", "Civil");
        Docs documento310 = new Docs(30, "8877656", 10, 3, "CPF", "2015-03-18", "XXX.XXX.XXX-XX", "Civil");     

        Endereco endereco10 = new Endereco(10, 1, "Brasil", "Rua", "Rua L", "87657889", "Casa AG", "Vila Santos", "Alegrete alegre", "Rio Janeiro", "", "", "", "", "768");
        
        Supervisor supervisor10 = new Supervisor(pessoa10, documento110, documento210, documento310, endereco10, pessoa10.getCodigoCiva());                
        supervisores.add(supervisor10);

        // Início Supervisor 11 //      
        Pessoa pessoa11 = new Pessoa(11, 1, "Brasileira", "Amanda", "Rego Barros", "1967-15-56", "+55", "amandaRb2021@gmail.com", "76778787687", "Mulher cis", "BR89899988");      
    
        Docs documento111 = new Docs(31, "76454656", 11, 1, "Identidade", "1977-05-08", "XXXXXXXXXXX", "Civil");  
        Docs documento211 = new Docs(32, "54565465", 11, 2, "Passaporte", "2001-06-12", "XXXXXXXXXXX", "Civil");
        Docs documento311 = new Docs(33, "8877656", 11, 3, "CPF", "1976-03-18", "XXX.XXX.XXX-XX", "Civil");     
        
        Endereco endereco11 = new Endereco(11, 1, "Brasil", "Rua", "Rua M", "54546657", "Casa HG", "Vila rio grande", "Altos da pedra", "São Paulo", "", "", "", "", "787");
        
        Supervisor supervisor11 = new Supervisor(pessoa11, documento111, documento211, documento311, endereco11, pessoa11.getCodigoCiva());            
        supervisores.add(supervisor11);

        return supervisores;
    }

    public static boolean update(Supervisor supervisorNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(String codigoCivaSupervisor) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
}
