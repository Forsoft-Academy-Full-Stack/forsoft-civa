/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Endereco;
import model.Pais;
import model.Pessoa;
/**
 *
 * @author miguel.bispo
 */
public class PessoaDao {

    public static Pessoa find(Pessoa pbusca) {
        Pessoa p = new Pessoa();
        
        if (pbusca.getNomePessoa().equals("João") && pbusca.getSobrenomePessoa().equals("Lopes")) {
            p.setNomePessoa(pbusca.getNomePessoa());
            p.setSobrenomePessoa(pbusca.getSobrenomePessoa());
            p.setTelefoneDdd("21900101123");
            p.setGenero("Masculino");
            p.setDataNascimento("02-04-1999");
        }
        
        return p;
    }
    
    
    public static boolean insert(Pessoa pinsert) {
        boolean resultado = false;
        
        if (pinsert.getNomePessoa()!=null) {
            //se conseguir inserir no banco
            
            // Brasil
            Pais pais = PaisDao.find(1);
            
            Endereco e = new Endereco();
            e.setIdPais(pais.getIdPais());
            EnderecoDao.insert(e);
            
            resultado = true;
        }
        
        return resultado;
    }
    
    
    public static Pessoa selectAll(String pattern) {
        
        return new Pessoa();
    }
}
