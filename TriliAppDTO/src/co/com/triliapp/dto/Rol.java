/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yasuly
 */
public class Rol {
    private Integer idRol;
    private String nombreRL;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRL() {
        return nombreRL;
    }

    public void setNombreRL(String nombreRL) {
        this.nombreRL = nombreRL;
    }
}

  

// prime ejemplo Lazy Loading
//   public class Rol{
//    private String IdRol;
//    private String NombreRL;
//    private List<ro> roles = null;
//    public void setIdRol(String _IdRol){ IdRol = _IdRol; }
//    public void setNombreRL(String _NombreRL){ NombreRL = _NombreRL; }
//    public void setroles(List<ro> _roles){ roles = _roles; }
//
//    public String getIdRol(){ return IdRol; }
//    public String getNombreRL(){ return NombreRL; }
//    public List<ro> getroles(){
//        roles = ro.find("byRol", this);
//        if(roles == null) roles = new ArrayList<ro>();
//        return roles;
//    }
//
//    public void addrol(RO ro){
//        getroles();
//        if(roles == null) roles = new ArrayList<>();
//        roles.add(Ro);
//    }
//}

// segundo ejemplo Lazy Loading
//    class Rol {  
//    private Rol() { 
//        System.out.println("primer paso");
//    }
//    // Regresa la una instancia
//    public static Rol getInstance() { 
//        return RolHolder.instance; //<-- lazy load
//    }
//    private static class RolHolder { 
//      private final static Rol instance = new Rol();
//    }
//    // metodo de clase
//    public static void metodo1() { System.out.println("Si, 1"); }
//    // metodo de instancia
//    public void metodoY() { System.out.println("Si, 2"); }
//
//}


       
