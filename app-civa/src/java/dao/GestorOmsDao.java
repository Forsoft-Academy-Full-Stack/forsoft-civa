package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.GestorOms;
import model.Pessoa;

/**
 *
 * @author Kerolen | Ludwig
 */
public class GestorOmsDao {
     public static boolean insert(GestorOms gestoroms) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static GestorOms find(String codigoCivaGestorOms) {
        for (GestorOms gestorOms : GestorOmsDao.list()) {
            if( gestorOms.getCodigoCiva().equals( codigoCivaGestorOms )){
                return gestorOms;
            }
        }

        return null;
    }

        public static List<GestorOms> list() {
        List<GestorOms> gestoresOms = new ArrayList<GestorOms>();

          // Início Gestor OMS 1 //
       //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
       //String sobrenomePessoa, String dataNascimento, String ddiContato,
       //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa = new Pessoa(40, 1, "Brasileira", "Serena", "Valle", "1995-03-10", "+55", "serenavalle@gmail.com", "998398585", "mulher cis", "BR455555555");
                
        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento1 = new Docs(60, "98555221155", 40, 1, "Identidade", "1996-04-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(61, "14588955966", 40, 2, "Passaporte", "1996-05-20", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(62, "59975898785", 40, 3, "CPF", "1996-07-5", "112558558", "Civil");     
            
        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco = new Endereco(31, 1, "Brasil", "Rua", "Rua Jorge Santos", "9855505", "Apto 115", "Vila Terra", "Fortaleza", "Ceara", "", "", "", "", "8995");
      
        // Pessoa pessoa, Docs documento1, Docs documento2, Docs documento3,
        // Endereco endereco, String codigoCiva      
        GestorOms gestorOms = new GestorOms(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());       
        gestoresOms.add(gestorOms);
                     
        // Início Gestor OMS 2 // 
        Pessoa pessoa2 = new Pessoa(41, 1, "Brasileira",  "Keila", "Melo", "1994-02-12", "+55", "keilamelo@gmail.com", "998755450", "mulher trans", "BR89955555");              
        
        Docs documento12 = new Docs(23, "89955552552", 41, 1, "Identidade", "1995-04-1", "XXXXXXXXXXX", "Civil");          
        Docs documento22 = new Docs(24, "98555520520", 41, 2, "Passaporte","1995-04-1", "XXXXXXXXXXX", "Civil");
        Docs documento32 = new Docs(25, "89925505205", 41, 3, "CPF", "1995-04-1", "XXX.XXX.XXX-XX", "Civil");
       
        Endereco endereco2 = new Endereco(32, 1, "Brasil", "Avenida", "Av Estrela", "485855250", "Casa", "Santa Maria", "Leme", "São Paulo", "", "", "", "", "130");

        GestorOms gestorOms2 = new GestorOms(pessoa2, documento12, documento22, documento32, endereco2, pessoa2.getCodigoCiva());
        gestoresOms.add(gestorOms2);                
         
        // Início Gestor OMS 3 //
        Pessoa pessoa3 = new Pessoa(42, 1, "Brasileira", "Aline", "Teixeira", "1992-07-12",  "+55", "alineteixeira@gmail.com", "996325850", "Mulher trans", "BR988555505");
          
        Docs documento13 = new Docs(26, "7955055050", 42, 1, "Identidade", "1993-06-12", "XXXXXXXXXXX", "Civil");       
        Docs documento23 = new Docs(27, "1255588595", 42, 2, "Passaporte", "1993-06-12", "XXXXXXXXXXX", "Civil");        
        Docs documento33 = new Docs(28, "3577955855", 32, 3, "CPF", "1993-06-12", "XXX.XXX.XXX-XX", "Civil");
              
        Endereco endereco3 = new Endereco(33, 1, "Brasil", "Rua", "Rua Paz", "14482552", "Casa", "Santa Barbara", "Araras", "Sao Paulo", "", "", "", "", "3900");

        GestorOms gestorOms3 = new GestorOms(pessoa3, documento13, documento23, documento33, endereco3, pessoa3.getCodigoCiva());
        gestoresOms.add(gestorOms3);                           
       
        // Início Gestor OMS 4 //
        Pessoa pessoa4 = new Pessoa(43, 1, "Brasileira", "Laura", "Mendes", "1991-01-01", "+55", "lauramendes@gmail.com", "985458652", "Mulher cis", "BR1585596665");              
               
        Docs documento14 = new Docs(29, "155895445", 43, 1, "Identidade", "1991-02-23", "XXXXXXXXXXX", "Civil");        
        Docs documento24 = new Docs(30, "988754555", 43, 2, "Passaporte", "1991-02-23", "XXXXXXXXXXX", "Civil");       
        Docs documento34 = new Docs(31, "854554585", 43, 3, "CPF", "1991-02-23", "XXX.XXX.XXX-XX", "Civil");       
                
        Endereco endereco4 = new Endereco(34, 1, "Brasil", "Rua", "Rua Major Lucio", "7955505", "Casa", "Santa Maria", "Juiz de Fora", "Minas Gerais", "", "", "", "", "5885");        

        GestorOms gestorOms4 = new GestorOms(pessoa4, documento14, documento24, documento34, endereco4, pessoa4.getCodigoCiva());
        gestoresOms.add(gestorOms4);

        // Início Gestor OMS 5 //
        Pessoa pessoa5 = new Pessoa(44, 1, "Brasileira", "Kenia", "Braga", "1997-03-22", "+55", "keniabraga@gmail.com", "898554555", "mulher cis", "BR988455555");      

        Docs documento15 = new Docs(32, "125565588", 44, 1, "Identidade", "1997-04-12", "XXXXXXXXXXX", "Civil");  
        Docs documento25 = new Docs(33, "895411152", 44, 2, "Passaporte", "1997-04-12", "XXXXXXXXXXX", "Civil");
        Docs documento35 = new Docs(34, "325585548", 44, 3, "CPF", "1997-04-12", "XXX.XXX.XXX-XX", "Civil");
         
        Endereco endereco5 = new Endereco(35, 1, "Brasil", "Rua", "Rua Z", "89955656", "Apt 20", "Vila Nova", "Pirassununga", "Sao Paulo", "", "", "", "", "508");

        GestorOms gestorOms5 = new GestorOms(pessoa5, documento15, documento25, documento35, endereco5, pessoa5.getCodigoCiva());       
        gestoresOms.add(gestorOms5);

        // Início Gestor Oms 6 //   
        Pessoa pessoa6 = new Pessoa(45, 1, "Brasileira", "Kassia", "Machado", "1992-07-11", "+55", "kassiamachado@gmail.com", "976548955", "mulher trans", "BR98744555455");      
     
        Docs documento16 = new Docs(35, "7855815585", 45, 1, "Identidade", "1993-06-10", "XXXXXXXXXXX", "Civil");  
        Docs documento26 = new Docs(36, "6957445585", 45, 2, "Passaporte", "1993-06-10", "XXXXXXXXXXX", "Civil");
        Docs documento36 = new Docs(37, "2344479745", 45, 3, "CPF", "1993-06-10", "XXX.XXX.XXX-XX", "Civil");            

        Endereco endereco6 = new Endereco(36, 1, "Brasil", "Rua", "Rua Nova", "1552555", "Casa", "Vila Perfeita", "Vilhena", "Rondonia", "", "", "", "", "111");

        GestorOms gestorOms6 = new GestorOms(pessoa6, documento16, documento26, documento36, endereco6, pessoa6.getCodigoCiva());                   
        gestoresOms.add(gestorOms6);
        
        
        return gestoresOms;
    }
    

    public static boolean update(GestorOms gestoromsNovo) {
        boolean resultado = false;

        // Update pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
    
    public static boolean delete(GestorOms gestoroms) {
        boolean resultado = false;

        // Delete pais;
        if (true) {
            resultado = true;
        }

        return resultado;
    }
}
