package triliapptest1;

import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dto.Producto;
//============================================================================//
import co.com.triliapp.dto.PublicacionDeProducto;
import co.com.triliapp.dao.PublicacionDeProductoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriliAppTestPublicacionDeProducto {

    public static void main(String[] args) {

        TriliAppTestPublicacionDeProducto triliAppTestPDP = new TriliAppTestPublicacionDeProducto();

        //====================================================================//
       triliAppTestPDP.insertarPublicacionDeProducto();
//        triliAppTestPDP.mostrarPublicacionDeProducto();
 //       triliAppTestPDP.mostrarPorNombrePublicacionDeProducto();
 //       triliAppTestPDP.mostrarPorCodigoPublicacionDeProducto();
//        triliAppTestPDP.compararPublicacionDeProductoASC();
//        triliAppTestPDP.compararPublicacionDeProductoDESC();
//        triliAppTestPDP.eliminarPublicacionDeProductoID(); // por ID
//        triliAppTestPDP.eliminarPublicacionDeProductoNOM(); // por NOMBRE
//        triliAppTestPDP.modificarPublicacionDeProducto();

    }

    //-----------------------------Insertar-----------------------------------//
    public void insertarPublicacionDeProducto() {

        PublicacionDeProducto Pdp = new PublicacionDeProducto();

        Usuario Usu = new Usuario();
        Usu.setIdUsuario(6);

        Producto Prod = new Producto();
        Prod.setIdProducto(3);

        Pdp.setNombrePDP("Celular Samsung ");
        Pdp.setDescripcionProducto("Celular De Gama Alta");
        Pdp.setImagenProducto("No hay Imagen");
        Pdp.setMarcaProducto("Samsung");
        Pdp.setPrecioProducto(998000);
        Pdp.setUbicacionProducto("katronix call 94 ");
        Pdp.setUsuario(Usu);//----------Depende del Usuario que realiza la insercion
        Pdp.setProducto(Prod);//--------Es la marca del producto

        PublicacionDeProductoDAO pdpDao = new PublicacionDeProductoDAO();

        try {
            pdpDao.insertarPublicacionDeProducto(Pdp);
            System.out.println("PUBLICACION INSERTADA" + " " + Pdp.getIdPublicacionDeProducto());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestPublicacionDeProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-------------------------------Eliminar---------------------------------//
    public void eliminarPublicacionDeProductoID() {

        PublicacionDeProducto Pdp = new PublicacionDeProducto();
        Pdp.setIdPublicacionDeProducto(2);

        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();

        try {
            pdpDAO.eliminarPublicacionDeProductoID(Pdp);
            System.out.println("PUBLICACION ELIMINADA");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestPublicacionDeProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarPublicacionDeProductoNOM() {

        PublicacionDeProducto Pdp = new PublicacionDeProducto();
        Pdp.setNombrePDP("nombre publicacion borrar");
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        try {
            pdpDAO.eliminarPublicacionDeProductoNOM(Pdp);
            System.out.println("PUBLICACION ELIMINADA");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestPublicacionDeProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //----------------------------Modificar-----------------------------------//
    public void modificarPublicacionDeProducto() {

        PublicacionDeProducto Pdp = new PublicacionDeProducto();

        Usuario Usu = new Usuario();
        Usu.setIdUsuario(4);
        Producto prod = new Producto();
        prod.setIdProducto(1);

        Pdp.setIdPublicacionDeProducto(1);//--------------Que publicacion de producto va ser actualizada
        Pdp.setNombrePDP("Pueba Update");
        Pdp.setDescripcionProducto("Descripcion Actualizada");
        Pdp.setImagenProducto("Imagen Update");
        Pdp.setMarcaProducto("Smart Phone");
        Pdp.setPrecioProducto(987000);
        Pdp.setUbicacionProducto("Carrera N Norte");
        Pdp.setProducto(prod);

        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        try {
            pdpDAO.modificarPublicacionDeProducto(Pdp);
            System.out.println("PUBLICACION MODIFICADA");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestPublicacionDeProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //-----------------------------Mostrar------------------------------------//
    public void mostrarPublicacionDeProducto() {

        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        try {
            for (PublicacionDeProducto e : pdpDAO.mostrarDatosPublicacionDeProducto()) {
                System.out.println("DATOS PUBLICACION");
                System.out.println(e.getIdPublicacionDeProducto() + " " + e.getNombrePDP() + " " + e.getFechaPDP() + " " + e.getDescripcionProducto() + " " + e.getImagenProducto() + " " + " " + e.getMarcaProducto() + " " + e.getPrecioProducto() + " " + e.getUbicacionProducto() + " " + e.getUsuario().getIdUsuario() + " " + e.getProducto().getIdProducto());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestPublicacionDeProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarPorNombrePublicacionDeProducto() {

        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        PublicacionDeProducto pdpDTO = new PublicacionDeProducto();

        try {
            for (PublicacionDeProducto e : pdpDAO.buscarNombrePublicacionDeProducto("Camara Cannon")) {
                System.out.println(e.getIdPublicacionDeProducto() + " " + e.getNombrePDP() + " " + e.getFechaPDP() + " " + e.getDescripcionProducto() + " " + e.getImagenProducto() + " " + e.getMarcaProducto() + " " + e.getPrecioProducto() + " " + e.getUbicacionProducto() + " " + e.getUsuario().getIdUsuario() + " " + e.getProducto().getIdProducto());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarPorCodigoPublicacionDeProducto() {

        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        PublicacionDeProducto pdpDTO = new PublicacionDeProducto();

        try {
            pdpDTO = pdpDAO.buscarCodigoPublicacionDeProducto(2);
            System.out.println(pdpDTO.getIdPublicacionDeProducto() + " " + pdpDTO.getNombrePDP() + " " + pdpDTO.getFechaPDP() + " " + pdpDTO.getDescripcionProducto() + " " + pdpDTO.getImagenProducto() + " " + pdpDTO.getMarcaProducto() + " " + pdpDTO.getPrecioProducto() + " " + pdpDTO.getUbicacionProducto() + " " + pdpDTO.getUsuario().getIdUsuario() + " " + pdpDTO.getProducto().getIdProducto());

        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //----------------------------------Comparar------------------------------//
    public void compararPublicacionDeProductoASC() {

        try {
            PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
            for (PublicacionDeProducto e : pdpDAO.compararPublicacionDeProductoASC("Camara Cannon ")) {
                System.out.println(e.getIdPublicacionDeProducto() + " " + e.getNombrePDP() + " " + e.getFechaPDP() + " " + e.getDescripcionProducto() + " " + e.getImagenProducto() + " " + e.getMarcaProducto() + " " + e.getPrecioProducto() + " " + e.getUbicacionProducto() + " " + e.getUsuario().getIdUsuario() + " " + e.getProducto().getIdProducto());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void compararPublicacionDeProductoDESC() {

        try {
            PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
            for (PublicacionDeProducto e : pdpDAO.compararPublicacionDeProductoDESC("Camara Cannon")) {
                System.out.println(e.getIdPublicacionDeProducto() + " " + e.getNombrePDP() + " " + e.getFechaPDP() + " " + e.getDescripcionProducto() + " " + e.getImagenProducto() + " " + e.getMarcaProducto() + " " + e.getPrecioProducto() + " " + e.getUbicacionProducto() + " " + e.getUsuario().getIdUsuario() + " " + e.getProducto().getIdProducto());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
