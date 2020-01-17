package triliapptest1;

import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dto.PublicacionDeProducto;
//============================================================================//
import co.com.triliapp.dao.ReporteDAO;
import co.com.triliapp.dto.Reporte;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriliAppTestReporte {

    public static void main(String[] args) {

        TriliAppTestReporte triliAppTestRPT = new TriliAppTestReporte();

        //====================================================================//
        Reporte r = new Reporte();
        r = triliAppTestRPT.insertarReporte();
        triliAppTestRPT.mostrarReporteById(r.getIdReporte());
//        triliAppTestRPT.eliminarReporte();
//        triliAppTestRPT.modificarReporte();

    }

    //-----------------------------Insertar-----------------------------------//
    public Reporte insertarReporte() {

        Reporte Rpte = new Reporte();

        Usuario Usu = new Usuario();
        Usu.setIdUsuario(6);
        PublicacionDeProducto PDP = new PublicacionDeProducto();
        PDP.setIdPublicacionDeProducto(2);

        Rpte.setDescripcionRpte("descripcion no sirve la informacion");
        Rpte.setUsuario(Usu);//------------Depende del usuario que ingrese
        Rpte.setPublicacionDeProducto(PDP);//----Que publicacion es la que se reporta

        ReporteDAO RpteDao = new ReporteDAO();
        try {
            RpteDao.insertReporte(Rpte);
            System.out.println("Sugerencia Insertada " + Rpte.getIdReporte());
            return Rpte;
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestReporte.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //-------------------------------Eliminar---------------------------------//
    public void eliminarReporte() {

        Reporte Rpt = new Reporte();
        Rpt.setIdReporte(9);
        ReporteDAO RpteDAO = new ReporteDAO();
        Reporte dt;

        try {
            RpteDAO.eliminarReporte(Rpt);
            System.out.println("Reporte Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-----------------------------Mostrar------------------------------------//
    public void mostrarReporte() {

        ReporteDAO RpteDAO = new ReporteDAO();

        try {

            for (Reporte e : RpteDAO.mostrarDatoReporte()) {
                System.out.println(e.getIdReporte() + " " + e.getDescripcionRpte() + " " + e.getFechaRpte() + " " + e.getUsuario().getIdUsuario() + " " + e.getPublicacionDeProducto().getIdPublicacionDeProducto());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-----------------------------Mostrar------------------------------------//
    public void mostrarReporteById(Integer id) {

        ReporteDAO RpteDAO = new ReporteDAO();
        Reporte r = new Reporte();
        try {

            r = RpteDAO.buscarCodigoReporte(id);
            System.out.println(r.getIdReporte() + " " + r.getDescripcionRpte() + " " + r.getFechaRpte() + " " + r.getUsuario().getIdUsuario());

        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //----------------------------Modificar-----------------------------------//
    public void modificarReporte() {

        Reporte Rpte = new Reporte();

        Usuario Usu = new Usuario();
        Usu.setIdUsuario(4);
        PublicacionDeProducto PDP = new PublicacionDeProducto();
        PDP.setIdPublicacionDeProducto(5);

        Rpte.setIdReporte(9);
        Rpte.setDescripcionRpte("Pueba es poco informativo");
        Rpte.setUsuario(Usu);
        Rpte.setPublicacionDeProducto(PDP);

        ReporteDAO RpteDAO = new ReporteDAO();
        try {
            RpteDAO.modificarReporte(Rpte);
            System.out.println("Reporte Modificado");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
