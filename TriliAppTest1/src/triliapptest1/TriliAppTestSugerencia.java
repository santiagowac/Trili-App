package triliapptest1;

import co.com.triliapp.dto.Usuario;
//============================================================================//
import co.com.triliapp.dao.SugerenciaDAO;
import co.com.triliapp.dto.Sugerencia;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriliAppTestSugerencia {

    public static void main(String[] args) {

        TriliAppTestSugerencia triliAppTestSUG = new TriliAppTestSugerencia();

        //====================================================================//
//        triliAppTestSUG.insertarSugerencia();
//        triliAppTestSUG.mostrarSugerencia();
//        triliAppTestSUG.mostrarSugerenciaFechaASC();
//        triliAppTestSUG.eliminarSugerencia();
//        triliAppTestSUG.mostrarSugerencia();
        triliAppTestSUG.modificarSugerencia();

    }

//    -----------------------------Insertar-----------------------------------//
    public void insertarSugerencia() {

        Sugerencia Sug = new Sugerencia();

        Usuario Usu = new Usuario();
        Usu.setIdUsuario(8);

        Sug.setTipoSug("buena informacion");
        Sug.setDescripcionSug("descripcion sugerencia");
        Sug.setUsuario(Usu);

        SugerenciaDAO SugDao = new SugerenciaDAO();

        try {
            SugDao.insertarSugerencia(Sug);
            System.out.println("El Id De La Sugerencia Es :" + " " + Sug.getIdSugerencia());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestSugerencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    //-------------------------------Eliminar---------------------------------//

    public void eliminarSugerencia() {

        Sugerencia Sug = new Sugerencia();
        Sug.setIdSugerencia(1);
        SugerenciaDAO SugDAO = new SugerenciaDAO();
        Sugerencia dt;

        try {
            SugDAO.eliminarSugerencia(Sug);
            System.out.print("Sugerencia Eliminada");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestSugerencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    //-----------------------------Mostrar------------------------------------//

    public void mostrarSugerencia() {

        SugerenciaDAO SugDAO = new SugerenciaDAO();

        try {
            for (Sugerencia e : SugDAO.mostrarDatoSugerencia()) {
//                System.out.println("Sugerencia Publicada");
                System.out.println(e.getIdSugerencia() + " " + e.getTipoSug() + " " + e.getFechaSug() + " " + e.getDescripcionSug() + " " + e.getUsuario().getIdUsuario());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestSugerencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-----------------------------Mostrar Por Fecha ASC----------------------//
    public void mostrarSugerenciaFechaASC() {

        SugerenciaDAO sugDAO = new SugerenciaDAO();

        try {
            for (Sugerencia e : sugDAO.mostrarSugerenciaPorFechaASC()) {
                System.out.println(e.getIdSugerencia() + " " + e.getTipoSug() + " " + e.getFechaSug() + " " + e.getDescripcionSug() + " " + e.getUsuario().getIdUsuario());

            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestSugerencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------------------Modificar-----------------------------------//

    public void modificarSugerencia() {

        Sugerencia Sug = new Sugerencia();


        Sug.setIdSugerencia(1);
        Sug.setTipoSug("erros de plataforma");
        Sug.setDescripcionSug("descrip actu");
 

        SugerenciaDAO SugDAO = new SugerenciaDAO();
        try {
            SugDAO.modificarSugerencia(Sug);
            System.out.println("Sugerencia Modificada");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestSugerencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
