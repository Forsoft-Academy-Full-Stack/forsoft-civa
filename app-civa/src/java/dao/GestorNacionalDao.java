package dao;

import java.util.ArrayList;
import java.util.List;
import model.Docs;
import model.Endereco;
import model.GestorNacional;
import model.Pessoa;
/**
 *
 * @author Geize Kele | Israel de Araujo
 */
public class GestorNacionalDao {

    public static boolean insert(GestorNacional gestornacional) {
        boolean resultado = false;

        // Insert into Gestor Nacional values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static boolean update(GestorNacional gestorNacional) {
        boolean resultado = false;

        // Update Gestor Nacional;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(GestorNacional gestorNacional) {
        boolean resultado = false;

        // Delete Gestor Nacional;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static GestorNacional find(String codigoCivaGestorNacional) {
       for (GestorNacional gestorNacional : GestorNacionalDao.list()) {
            if( gestorNacional.getCodigoCiva().equals( codigoCivaGestorNacional )){
                return gestorNacional;
            }
        }

        return null;

    }

    public static List<GestorNacional> list() {
        List<GestorNacional> gestoresNacionais = new ArrayList<GestorNacional>();
        
       // Início Gestor Nacional 1 //
       //Integer idPessoa, Integer idNacionalidade, String nacionalidade, String nomePessoa,
       //String sobrenomePessoa, String dataNascimento, String ddiContato,
       //String email, String telefoneDdd, String genero, String codigoCiva
        Pessoa pessoa = new Pessoa(28, 1, "Brasileira", "Rebeca", "Martinelli", "1990-10-15", "+55", "rebecamartinelli@gmail.com", "996458595", "mulher cis", "BR85555544");
                
        //Integer idDocs, String documento, Integer idPessoa, Integer idTipoDoc,
        //String nomeTipoDoc, String dataEmissao, String formatoDocumento, String tipoDocumento
        Docs documento1 = new Docs(30, "89555445552", 28, 1, "Identidade", "1990-11-19", "XXXXXXXXXXX", "Civil");         
        Docs documento2 = new Docs(31, "22505555655", 28, 2, "Passaporte", "1990-11-19", "XXXXXXXXXXX", "Civil");        
        Docs documento3 = new Docs(32, "11444555445", 28, 3, "CPF", "1990-11-19", "54555665", "Civil");     
            
        //Integer idEndereco, Integer idPais, String nomePais, String tipoLogradouro,
        //String logradouro, String codigoPostal, String complemento, String nomesubdivisao1 (Bairro),
        //String nomesubdivisao2 (Municipio), String nomesubdivisao3 (Estado), String nomesubdivisao4, String nomesubdivisao5,
        //String nomesubdivisao6, String nomesubdivisao7, String numero
        Endereco endereco = new Endereco(30, 1, "Brasil", "Rua", "Rua Pedro II", "12252050", "Apto 20", "Vila Sempre", "Belem", "Para", "", "", "", "", "21552");
      
        // Pessoa pessoa, Docs documento1, Docs documento2, Docs documento3,
        // Endereco endereco, String codigoCiva      
        GestorNacional gestorNacional = new GestorNacional(pessoa, documento1, documento2, documento3, endereco, pessoa.getCodigoCiva());       
        gestoresNacionais.add(gestorNacional);
                     
        // Início Gestor Nacional 2 // 
        Pessoa pessoa2 = new Pessoa(31, 1, "Brasileira",  "Kessia", "Lima", "1995-10-10", "+55", "kessialima@gmail.com", "963232569", "mulher trans", "BR78585655");              
        
        Docs documento12 = new Docs(33, "12554850555", 31, 1, "Identidade", "1995-10-10", "XXXXXXXXXXX", "Civil");          
        Docs documento22 = new Docs(34, "25485899555", 31, 2, "Passaporte","1995-10-10", "XXXXXXXXXXX", "Civil");
        Docs documento32 = new Docs(35, "36488445595", 31, 3, "CPF", "1995-10-10", "XXX.XXX.XXX-XX", "Civil");
       
        Endereco endereco2 = new Endereco(31, 1, "Brasil", "Avenida", "Av Triste", "485855250", "Casa", "Jardim Sereno", "Barretos", "São Paulo", "", "", "", "", "555");

        GestorNacional gestorNacional2 = new GestorNacional(pessoa2, documento12, documento22, documento32, endereco2, pessoa2.getCodigoCiva());
        gestoresNacionais.add(gestorNacional2);               
         
        // Início Gestor Nacional 3 //
        Pessoa pessoa3 = new Pessoa(32, 1, "Brasileira", "Amora", "Terras", "1993-08-10",  "+55", "amoraterras@gmail.com", "955455855", "Mulher trans", "BR47855958");
          
        Docs documento13 = new Docs(36, "8885545555", 32, 1, "Identidade", "1993-08-10", "XXXXXXXXXXX", "Civil");       
        Docs documento23 = new Docs(37, "9365544558", 32, 2, "Passaporte", "1993-08-10", "XXXXXXXXXXX", "Civil");        
        Docs documento33 = new Docs(38, "1254775898", 32, 3, "CPF", "1993-08-10", "XXX.XXX.XXX-XX", "Civil");
              
        Endereco endereco3 = new Endereco(32, 1, "Brasil", "Rua", "Rua Paz", "14482552", "Casa", "Santa Barbara", "Araras", "Sao Paulo", "", "", "", "", "3900");

        GestorNacional gestorNacional3 = new GestorNacional(pessoa3, documento13, documento23, documento33, endereco3, pessoa3.getCodigoCiva());
        gestoresNacionais.add(gestorNacional3);                           
       
        // Início Gestor Nacional 4//
        Pessoa pessoa4 = new Pessoa(33, 1, "Brasileira", "Leila", "Silva", "1995-02-02", "+55", "leilasilva@gmail.com", "993845954", "Mulher cis", "BR8545585555");              
               
        Docs documento14 = new Docs(39, "155895445", 33, 1, "Identidade", "1991-02-23", "XXXXXXXXXXX", "Civil");        
        Docs documento24 = new Docs(40, "988754555", 33, 2, "Passaporte", "1991-02-23", "XXXXXXXXXXX", "Civil");       
        Docs documento34 = new Docs(41, "854554585", 33, 3, "CPF", "1991-02-23", "XXX.XXX.XXX-XX", "Civil");       
                
        Endereco endereco4 = new Endereco(33, 1, "Brasil", "Rua", "Rua Santos Dummont", "85855588", "Casa", "Santa Luz", "Frutal", "Minas Gerais", "", "", "", "", "5125");        

        GestorNacional gestorNacional4 = new GestorNacional(pessoa4, documento14, documento24, documento34, endereco4, pessoa4.getCodigoCiva());
        gestoresNacionais.add(gestorNacional4);

        // Início Gestor Nacional 5 //
        Pessoa pessoa5 = new Pessoa(34, 1, "Brasileira", "Karina", "Souza", "1996-11-10", "+55", "karinasouza@gmail.com", "45585500", "mulher cis", "BR98554550");      

        Docs documento15 = new Docs(42, "155252656", 34, 1, "Identidade", "1996-11-20", "XXXXXXXXXXX", "Civil");  
        Docs documento25 = new Docs(43, "458558555", 34, 2, "Passaporte", "1999-04-12", "XXXXXXXXXXX", "Civil");
        Docs documento35 = new Docs(44, "885449554", 34, 3, "CPF", "1996-11-20", "XXX.XXX.XXX-XX", "Civil");
         
        Endereco endereco5 = new Endereco(34, 1, "Brasil", "Rua", "Rua J", "85445555", "Apt 90", "Vila Esperanca", "Descalvado", "Sao Paulo", "", "", "", "", "1050");

        GestorNacional gestorNacional5 = new GestorNacional(pessoa5, documento15, documento25, documento35, endereco5, pessoa5.getCodigoCiva());       
        gestoresNacionais.add(gestorNacional5);

        // Início Gestor Nacional 6 //   
        Pessoa pessoa6 = new Pessoa(35, 1, "Brasileira", "Koraline", "Merchi", "1999-06-12", "+55", "koralinemerchi@gmail.com", "974325056", "mulher trans", "BR998455555");      
     
        Docs documento16 = new Docs(45, "7125550520", 35, 1, "Identidade", "1999-06-12", "XXXXXXXXXXX", "Civil");  
        Docs documento26 = new Docs(46, "4885586544", 35, 2, "Passaporte", "1999-06-12", "XXXXXXXXXXX", "Civil");
        Docs documento36 = new Docs(47, "1225050505", 35, 3, "CPF", "1992-06-12", "XXX.XXX.XXX-XX", "Civil");            

        Endereco endereco6 = new Endereco(6, 1, "Brasil", "Rua", "Rua da Saudade", "5855550", "Casa", "Vila Sem graca", "Cacoau", "Rondonia", "", "", "", "", "8855");

        GestorNacional gestorNacional6 = new GestorNacional(pessoa6, documento16, documento26, documento36, endereco6, pessoa6.getCodigoCiva());                   
        gestoresNacionais.add(gestorNacional6);

        return gestoresNacionais;
    }
}
