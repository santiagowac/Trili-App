/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triliapptest1;

import co.com.triliapp.dao.RolDAO;
import co.com.triliapp.dto.Rol;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yasuly
 */
public class TriliAppTestRol {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TriliAppTestRol triliAppRol = new TriliAppTestRol();

        triliAppRol.insertarRol();
        triliAppRol.mostrarRol();
//        triliAppRol.modificarRol();
        triliAppRol.eliminarRol();
        
    }

    //----------------Insertar
    public void insertarRol() {

        Rol rolI = new Rol();

        rolI.setNombreRL("sssdddsdsds");

        RolDAO rolDao = new RolDAO();
        try {
            rolDao.insertarRol(rolI);
            System.out.println("El Id Del Rol Es :" + " " + rolI.getIdRol());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //------------------Mostar
    public void mostrarRol() {

        RolDAO rolDao = new RolDAO();

        try {

            for (Rol e : rolDao.mostrarRol()) {
                System.out.println(e.getIdRol() + " " + e.getNombreRL());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-------------Eliminar
    public void eliminarRol() {
        Rol rolE = new Rol();
        rolE.setIdRol(3);
        RolDAO rolDao = new RolDAO();
        Rol dt;

        try {
            rolDao.eliminarRol(rolE);
            System.out.println("Rol Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-------------Modificar
    public void modificarRol() {
        Rol rolA = new Rol();

        rolA.setIdRol(2);
        rolA.setNombreRL("Usuario");

        RolDAO rolDao = new RolDAO();
        try {
            rolDao.modificarRoL(rolA);
            System.out.println("Rol Modificado");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRol.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
