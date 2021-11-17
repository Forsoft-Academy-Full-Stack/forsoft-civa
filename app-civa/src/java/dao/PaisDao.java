/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Pais;

/**
 *
 * @author miguel.bispo
 */
public class PaisDao {
    public static Pais find(String pais) {
        Pais p= new Pais();
        //"SELECT * FROM pais where nome = "+pais;
        p.setSigla(pais);
        p.setNomePais(pais);
        p.setIdPais(Long.MIN_VALUE);
        
        return p;
    }
}
