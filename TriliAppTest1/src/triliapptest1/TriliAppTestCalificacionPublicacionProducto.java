package triliapptest1;

import co.com.triliapp.dto.PublicacionDeProducto;
import co.com.triliapp.dto.Usuario;
//----------------------------------------------------------------------------//
import co.com.triliapp.dto.CalificacionPublicacionProducto;
import co.com.triliapp.dao.CalificacionPublicacionProductoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriliAppTestCalificacionPublicacionProducto {

    public static void main(String[] args) {

        TriliAppTestCalificacionPublicacionProducto triliAppCPP = new TriliAppTestCalificacionPublicacionProducto();

        triliAppCPP.insertarCalificacionPublicacionProducto();
        triliAppCPP.mostrarCalificacionPublicacionProducto();
        triliAppCPP.modificarCalificacionPublicacionProducto();
        triliAppCPP.eliminarCalificacionPublicacionProducto();
        

    }

    //--------------------------------------Insertar--------------------------//
    public void insertarCalificacionPublicacionProducto() {

        Usuario Usu = new Usuario();
        Usu.setIdUsuario(6);

        PublicacionDeProducto Pdp = new PublicacionDeProducto();
        Pdp.setIdPublicacionDeProducto(2);

        CalificacionPublicacionProducto Cpp = new CalificacionPublicacionProducto();

        Cpp.setValorCPP(99);
        Cpp.setComentario("no");
        Cpp.setUsuario(Usu);
        Cpp.setPublicacionDeProducto(Pdp);

        CalificacionPublicacionProductoDAO cppDAO = new CalificacionPublicacionProductoDAO();

        try {
            Cpp = cppDAO.insertCalificacionPublicacionProducto(Cpp);// TODO: Entender Mejor
            System.out.println(Cpp.getIdCalificacionPublicacionProducto());
            System.out.println("CALIFICACION DE PUBLICACION HECHA " + Cpp.getIdCalificacionPublicacionProducto());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestCalificacionPublicacionProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------------Eliminar--------------------------------//
    public void eliminarCalificacionPublicacionProducto() {

        CalificacionPublicacionProducto Cpp = new CalificacionPublicacionProducto();
        Cpp.setIdCalificacionPublicacionProducto(5);

        CalificacionPublicacionProductoDAO cppDAO = new CalificacionPublicacionProductoDAO();

        try {
            cppDAO.eliminarCalificacionPublicacionProducto(Cpp);
            System.out.println("CALIFICACION DE PUBLICACION ELIMINADA");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestCalificacionPublicacionProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //----------------------------------------Mostrar-------------------------//
    public void mostrarCalificacionPublicacionProducto() {

        CalificacionPublicacionProductoDAO cppDAO = new CalificacionPublicacionProductoDAO();
        try {
            for (CalificacionPublicacionProducto e : cppDAO.mostrarDatosCalificacionPublicacionProducto()) {
                System.out.println("DATOS CALIFICACION DE PUBLICACION");
                System.out.println(e.getIdCalificacionPublicacionProducto() + " " + e.getValorCPP() + " " + e.getComentario() + " " + e.getFechaCPP() + " " + e.getUsuario().getIdUsuario() + " " + e.getPublicacionDeProducto().getIdPublicacionDeProducto());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestCalificacionPublicacionProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //--------------------------------------------Actualizar------------------//
    public void modificarCalificacionPublicacionProducto() {

        Usuario Usu = new Usuario();
        Usu.setIdUsuario(2);

        PublicacionDeProducto Pdp = new PublicacionDeProducto();
        Pdp.setIdPublicacionDeProducto(5);

        CalificacionPublicacionProducto Cpp = new CalificacionPublicacionProducto();

        Cpp.setIdCalificacionPublicacionProducto(2);
        Cpp.setValorCPP(69);
        Cpp.setUsuario(Usu);
        Cpp.setPublicacionDeProducto(Pdp);

        CalificacionPublicacionProductoDAO cppDAO = new CalificacionPublicacionProductoDAO();
        try {
            cppDAO.modificarCalificacionPublicacionProducto(Cpp);
            System.out.println("CALIFICACION DE PUBLICACION MODIFICADA");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestCalificacionPublicacionProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
