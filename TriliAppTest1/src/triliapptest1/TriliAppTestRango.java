package triliapptest1;

import co.com.triliapp.dto.Rango;
import co.com.triliapp.dao.RangoDAO;
//----------------------------------------------------------------------------//
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TriliAppTestRango {
    
    public static void main(String[] args) {
        
        TriliAppTestRango triliAppRang = new  TriliAppTestRango();
        
        triliAppRang.insertarRango();
        triliAppRang.mostrarRango();
//        triliAppRang.eliminarRango();
//        triliAppRang.modificarRango();
        
    }
   //---------------------------Insertar-------------------------------------//
    public void insertarRango() {

        Rango rang = new Rango();       

        rang.setNombreRango("Madera");
        rang.setImagenRNG("l-piso-alto-rango-din%C3%A1mico-image72378684");
        rang.setDescripcionRNG("Usuario Empieza Aca ");

        RangoDAO ranDao = new RangoDAO();
       try {
            ranDao.insertarRango(rang);
            System.out.println("El Id Del Rango Es :"+" "+ rang.getIdRango());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRango.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //------------------------------Mostrar-----------------------------------//
    public void mostrarRango() {

    RangoDAO ranDao = new RangoDAO();

        try {   
            for(Rango e : ranDao.mostrarRango()){
                System.out.println("Rango Publicado");
                System.out.println(e.getIdRango()+ " " + e.getNombreRNG()+" "+ e.getImagenRNG()+" "+e.getDescripcionRNG());
            }
        }catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRango.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------Eliminar--------------------------------------//
    public void eliminarRango() {
 
    Rango Rang = new Rango();
    Rang.setIdRango(8);
    RangoDAO RangD = new RangoDAO();
    Rango dt;
    
        try {
        RangD.eliminarRango(Rang);
           System.out.print("Rango Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRango.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//--------------Actualizar-----------------------------------//

    public void modificarRango() {
        Rango RNG = new Rango();
        
        
        RNG.setIdRango(2);
        RNG.setNombreRango("oro");
        RNG.setImagenRNG("not null");
        RNG.setDescripcionRNG("eres bueno ");

        RangoDAO ranDao = new RangoDAO();
        try{
            ranDao.modificarRango(RNG);
            System.out.println("Rango Modificado");  
        }catch (SQLException ex) {
            Logger.getLogger(TriliAppTestRango.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
