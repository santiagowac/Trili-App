package triliapptest1;

import co.com.triliapp.dto.Producto;
import co.com.triliapp.dao.ProductoDAO;
//----------------------------------------------------------------------------//
import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dto.Categoria;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriliAppTestProducto {

    public static void main(String[] args) {

        TriliAppTestProducto triliAppProd = new TriliAppTestProducto();

//        triliAppProd.insertarProducto();
//        triliAppProd.mostrarProducto();
//        triliAppProd.eliminarProducto();
//        triliAppProd.actualizarProducto();
        triliAppProd.mostrarPorNombreProducto();
//        triliAppProd.mostrarPorCodigoProducto();
//        triliAppProd.compararProductoASC();

    }

    //---------------------------------Insertar-------------------------------//
    public void insertarProducto() {
        Producto prod = new Producto();
        Usuario usu = new Usuario();
        usu.setIdUsuario(1);
        Categoria cat = new Categoria();
        cat.setIdCategoria(1);

        prod.setNombreProducto("Celular huawei");
        prod.setUsuario(usu);
        prod.setCategoria(cat);

        ProductoDAO prodD = new ProductoDAO();

        try {
            prodD.insertarProducto(prod);
            System.out.println(usu.getIdUsuario());
        } catch (Exception ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------------Mostrar Producto------------------------//
    public void mostrarProducto() {

        ProductoDAO prodD = new ProductoDAO();
        try {
            for (Producto e : prodD.mostrarProducto()) {
                System.out.println(e.getIdProducto() + " " + e.getNombreProducto() + " " + e.getUsuario().getIdUsuario() + " " + e.getCategoria().getIdCategoria());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //-----------------------------Eliminar-----------------------------------//
    public void eliminarProducto() {

        Producto prod = new Producto();
        prod.setIdProducto(1);

        ProductoDAO prodD = new ProductoDAO();
        Producto pdto = new Producto();
        try {
            prodD.eliminarProducto(prod);
            System.out.println(pdto.getIdProducto());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //-----------------------------Actualizar---------------------------------//

    public void actualizarProducto() {

        Producto prod = new Producto();

        prod.setIdProducto(1);
        prod.setNombreProducto("Camara");

        ProductoDAO prodD = new ProductoDAO();
        try {
            prodD.modificarProducto(prod);
            System.out.println("Producto Actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarPorNombreProducto() {

        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoDTO;
        try {
            productoDTO = productoDAO.mostrarPorNombreProducto("Celular huawei");
            System.out.println(productoDTO.getIdProducto() + " " + productoDTO.getNombreProducto() +" "+ productoDTO.getUsuario().getIdUsuario());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarPorCodigoProducto() {

        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoDTO;
        try {
            productoDTO = productoDAO.buscarPorCodigoProducto(2);
            System.out.println(productoDTO.getIdProducto() + " " + productoDTO.getNombreProducto() + " " + productoDTO.getUsuario().getIdUsuario());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public void compararProductoASC() {
//
//        try {
//            ProductoDAO prodD = new ProductoDAO();
//            for (Producto e : prodD.compararProductoASC("Celular samsung")) {
//                System.out.println(e.getIdProducto() + " " + e.getNombreProducto() + " " + e.getMarcaProducto() + " " + e.getPrecioProducto() + " " + e.getUbicacionProducto());
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//    }

}
