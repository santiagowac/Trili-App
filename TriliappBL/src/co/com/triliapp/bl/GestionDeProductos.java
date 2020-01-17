package co.com.triliapp.bl;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.triliapp.dao.PublicacionDeProductoDAO;
import co.com.triliapp.dao.ProductoDAO;
import co.com.triliapp.dao.CategoriaDAO;
import co.com.triliapp.dto.PublicacionDeProducto;
import co.com.triliapp.dto.Producto;
import co.com.triliapp.dto.Categoria;
import java.util.List;

public class GestionDeProductos {

    //===============================Publicacion De Producto==================//
    public String IngresarPublicacionDeProducto(PublicacionDeProducto pdpDTO) {
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        try {
            pdpDAO.insertarPublicacionDeProducto(pdpDTO);
            return "Producto Publicado Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeProductos.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Publicar Producto";
        }
    }

    public String ActualizarPublicacionDeProducto(PublicacionDeProducto pdpDTO) throws SQLException {
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        pdpDAO.modificarPublicacionDeProducto(pdpDTO);
        return "Publicacion Actualizada Con Exito";
    }

    public String EliminarPublicacionDeProducto(PublicacionDeProducto pdpDTO) throws SQLException {
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        pdpDAO.eliminarPublicacionDeProductoID(pdpDTO);
        return "Publicacion Eliminado Con Exito";
    }

    public String EliminarPublicacionDeProductoID(PublicacionDeProducto pdpDTO) throws SQLException {
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        pdpDAO.eliminarPublicacionDeProductoNOM(pdpDTO);
        return "Publicacion Eliminado Con Exito";
    }

    public List<PublicacionDeProducto> MostrarPublicacionDeProducto() throws SQLException {
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        return pdpDAO.mostrarDatosPublicacionDeProducto();
    }

    //=================================Mostrar Asc & DES Publicaciones==============//
    public List<PublicacionDeProducto> MostrarPublicacionDeProductoASC(String nombrePDP) throws SQLException {
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        return pdpDAO.compararPublicacionDeProductoASC(nombrePDP);
    }

    public List<PublicacionDeProducto> MostrarPublicacionDeProductoDESC(String nombrePDP) throws SQLException {
        PublicacionDeProductoDAO pdpDAO = new PublicacionDeProductoDAO();
        return pdpDAO.compararPublicacionDeProductoDESC(nombrePDP);
    }

    //===============================Producto=================================//
    public String IngresarProducto(Producto ptoDTO) {
        ProductoDAO ptoDAO = new ProductoDAO();
        try {
            ptoDAO.insertarProducto(ptoDTO);
            return "Producto Creado Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeProductos.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Crear Producto";
        }
    }

    public String ActualizarProducto(Producto ptoDTO) throws SQLException {
        ProductoDAO ptpDAO = new ProductoDAO();
        ptpDAO.modificarProducto(ptoDTO);
        return "Producto Actualizado Con Exito";
    }

    public String EliminarProducto(Producto ptoDTO) throws SQLException {
        ProductoDAO ptoDAO = new ProductoDAO();
        ptoDAO.eliminarProducto(ptoDTO);
        return "Producto Eliminado Con Exito";
    }

    public List<Producto> MostrarProducto() throws SQLException {
        ProductoDAO ptoDAO = new ProductoDAO();
        return ptoDAO.mostrarProducto();
    }

    //===============================Categria=================================//
//    public Categoria IngresarCategoria(Categoria DTO) throws Exception{
//        CategoriaDAO catDAO = new CategoriaDAO();
//        return catDAO.insertarCategoria(DTO);
//    }
    public String IngresarCategoria(Categoria catDTO) throws Exception {
        CategoriaDAO catDAO = new CategoriaDAO();
        try {
            catDAO.insertarCategoria(catDTO);
            return "Categoria Creada Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeProductos.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Crear Categoria";
        }
    }

    public String ActualizarCategoria(Categoria catDTO) throws SQLException {
        CategoriaDAO catDAO = new CategoriaDAO();
        try {
            catDAO.modificarCategoria(catDTO);
            return "Categoria Actualizada Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeProductos.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Actualizadar Categoria";
        }
    }

    public String EliminarCategoria(Categoria catDTO) throws SQLException {
        CategoriaDAO catDAO = new CategoriaDAO();
        catDAO.eliminarCategoria(catDTO);
        return "Categoria Eliminada Con Exito";
    }

    public List<Categoria> MostrarCategoria() throws SQLException {
        CategoriaDAO catDAO = new CategoriaDAO();
        return catDAO.MostrarCategoria();
    }

}
