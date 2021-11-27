package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.Gerente;
import model.Pessoa;

/**
 *
 * @author Rafael Marçal | Antonio Henrique
 */
public class GerenteDao {

    public static boolean insert(Gerente gerente) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static boolean update(Gerente gerente) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Gerente gerente) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static Gerente find(String codigoCivaGerente) {
       for (Gerente gerente : GerenteDao.list()) {
            if( gerente.getCodigoCiva().equals( codigoCivaGerente )){
                return gerente;
            }
        }        

        return null;
    }

    public static List<Gerente> list() {
        List<Gerente> gerentes = new ArrayList<Gerente>();

       // Início Genrente 1 //
       //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
       //String sobrenomePessoa, String dataNascimento, String ddiContato,
       //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa = new Pessoa(22, 1, "Brasileira", "Maria", "Ferreira de Almeida", "1980-08-02", "+55", "mariaferreira@gmail.com", "987898758", "mulher cis", "BR89855455");
                
        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento1 = new Docs(20, "99383946577", 22, 1, "Identidade", "1945-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(21, "21676786876", 22, 2, "Passaporte", "1946-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(22, "06543456478", 22, 3, "CPF", "1946-07-5", "09878765678", "Civil");     
            
        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco = new Endereco(22, 22, "Brasil", "Rua", "Rua Alvorada", "58665645", "Apto 20", "Vila Nova", "Aracaju", "Sergipe", "", "", "", "", "20");
      
        // Pessoa pessoa3, Docs documento1, Docs documento2, Docs documento3,
        // Endereco endereco, String codigoCiva      
        Gerente gerente = new Gerente(pessoa, endereco, pessoa.getCodigoCiva(), documento1, documento2, documento3);       
        gerentes.add(gerente);
                     
        // Início Gerente 2 // 
        Pessoa pessoa2 = new Pessoa(23, 1, "Brasileira",  "Lais", "Dantas", "1998-03-21", "+55", "laisdantas@gmail.com", "998756455", "mulher trans", "BR999923721873");              
        
        Docs documento12 = new Docs(23, "7657328490", 23, 1, "Identidade", "1999-04-1", "XXXXXXXXXXX", "Civil");          
        Docs documento22 = new Docs(24, "99383946577", 23, 2, "Passaporte","2000-04-1", "XXXXXXXXXXX", "Civil");
        Docs documento32 = new Docs(25, "99383946577", 23, 3, "CPF", "2001-04-1", "XXX.XXX.XXX-XX", "Civil");
       
        Endereco endereco2 = new Endereco(23, 1, "Brasil", "Avenida", "Av Brasil", "98755855", "Casa", "Vila Bela", "Jundiai", "São Paulo", "", "", "", "", "30");

        Gerente gerente2 = new Gerente(pessoa2, endereco2, pessoa2.getCodigoCiva(), documento12, documento22, documento32);
        gerentes.add(gerente2);                
         
        // Início Gerente 3 //
        Pessoa pessoa3 = new Pessoa(24, 1, "Brasileira", "Marina", "Alcantara", "1993-08-03",  "+55", "marinaalcantara@gmail.com", "9856458655", "Mulher trans", "BR998544574");
          
        Docs documento13 = new Docs(26, "879879879", 24, 1, "Identidade", "1998-05-21", "XXXXXXXXXXX", "Civil");       
        Docs documento23 = new Docs(27, "99383946577", 24, 2, "Passaporte", "2000-06-12", "XXXXXXXXXXX", "Civil");        
        Docs documento33 = new Docs(28, "4567895445", 24, 3, "CPF", "2000-06-12", "XXX.XXX.XXX-XX", "Civil");
              
        Endereco endereco3 = new Endereco(24, 1, "Brasil", "Rua", "Rua D", "9855655", "Casa J", "Santa Luz", "Campinas", "Sao Paulo", "", "", "", "", "300");

        Gerente gerente3 = new Gerente(pessoa3, endereco3, pessoa3.getCodigoCiva(), documento13, documento23, documento33);
        gerentes.add(gerente3);                           
       
        // Início Gerente 4 //
        Pessoa pessoa4 = new Pessoa(25, 1, "Brasileira", "Luana", "Tavares", "1995-07-23", "+55", "luanatavares@gmail.com", "98559855", "Mulher cis", "BR8559556");              
               
        Docs documento14 = new Docs(29, "485595758", 25, 1, "Identidade", "1996-02-23", "XXXXXXXXXXX", "Civil");        
        Docs documento24 = new Docs(30, "987555455", 25, 2, "Passaporte", "1998-04-12", "XXXXXXXXXXX", "Civil");       
        Docs documento34 = new Docs(31, "255581412", 25, 3, "CPF", "1998-04-12", "XXX.XXX.XXX-XX", "Civil");       
                
        Endereco endereco4 = new Endereco(25, 1, "Brasil", "Rua", "Rua Marajor", "67734243", "Casa", "Alto do Céu", "Uberaba", "Minas Gerais", "", "", "", "", "258");        

        Gerente gerente4 = new Gerente(pessoa4, endereco4, pessoa4.getCodigoCiva(), documento14, documento24, documento34);
        gerentes.add(gerente4);

        // Início Gerente 5 //
        Pessoa pessoa5 = new Pessoa(26, 1, "Brasileira", "Kerolen", "Rodrigues", "1998-02-23", "+55", "kerolenrodrigues@gmail.com", "59555555", "mulher cis", "BR98855956");      

        Docs documento15 = new Docs(32, "855455658", 26, 1, "Identidade", "2000-03-12", "XXXXXXXXXXX", "Civil");  
        Docs documento25 = new Docs(33, "994744444", 26, 2, "Passaporte", "2000-03-12", "XXXXXXXXXXX", "Civil");
        Docs documento35 = new Docs(34, "886665556", 26, 3, "CPF", "2000-03-12", "XXX.XXX.XXX-XX", "Civil");
         
        Endereco endereco5 = new Endereco(26, 1, "Brasil", "Rua", "Rua Z", "89955656", "Apt 20", "Vila Nova", "Pirassununga", "Sao Paulo", "", "", "", "", "508");

        Gerente gerente5 = new Gerente(pessoa5, endereco5, pessoa5.getCodigoCiva(), documento15, documento25, documento35);       
        gerentes.add(gerente5);

        // Início Gerente 6 //   
        Pessoa pessoa6 = new Pessoa(26, 1, "Brasileira", "Katarina", "Martine", "1999-03-10", "+55", "katarinamartine@gmail.com", "985895585", "mulher trans", "BR998555655");      
     
        Docs documento16 = new Docs(35, "9875522005", 6, 1, "Identidade", "2000-07-10", "XXXXXXXXXXX", "Civil");  
        Docs documento26 = new Docs(36, "1235687585", 6, 2, "Passaporte", "2000-07-10", "XXXXXXXXXXX", "Civil");
        Docs documento36 = new Docs(37, "3588566812", 6, 3, "CPF", "2000-07-10", "XXX.XXX.XXX-XX", "Civil");            

        Endereco endereco6 = new Endereco(27, 1, "Brasil", "Rua", "Rua Jau", "97785855", "Casa", "Nova Pedra", "Sapezal", "Mato grosso", "", "", "", "", "100");

        Gerente gerente6 = new Gerente(pessoa6, endereco6, pessoa6.getCodigoCiva(), documento16, documento26, documento36);                   
        gerentes.add(gerente6);

        return gerentes;
    }

}
