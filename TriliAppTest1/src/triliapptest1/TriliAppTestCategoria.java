package triliapptest1;

import co.com.triliapp.dao.CategoriaDAO;
import co.com.triliapp.dto.Categoria;
//------------------------------------------Paquetes de clases----------------//
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriliAppTestCategoria {

    public static void main(String[] args) throws SQLException {

        TriliAppTestCategoria appTest = new TriliAppTestCategoria();

        appTest.insertarCategoriaTest();
        appTest.mostrarCategoria();
//        appTest.eliminarCategoria();
//        appTest.actualizarCategoria();

    }

    //---------------------------Insertar-------------------------------------//
    public void insertarCategoriaTest() {

        Categoria cat = new Categoria();
        cat.setNombreCategoria("Electrodomesticos Hogar");

        CategoriaDAO catDAO = new CategoriaDAO();
        try {
            catDAO.insertarCategoria(cat);
            System.out.println("El Id De la Categoria Es : "+" "+cat.getIdCategoria());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //------------------------------Mostrar-----------------------------------//
    public void mostrarCategoria() {

        try {
            CategoriaDAO cat = new CategoriaDAO();
            for (Categoria e : cat.MostrarCategoria()) {
                System.out.println(e.getIdCategoria() + " " + e.getNombreCategoria());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //--------------------------Eliminar--------------------------------------//
    public void eliminarCategoria() {
        Categoria cat = new Categoria();
        cat.setIdCategoria(2);

        try {
            CategoriaDAO catD = new CategoriaDAO();
            catD.eliminarCategoria(cat);
            System.out.println("Categoria Eliminada");
        } catch (Exception ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //---------------------------Actualizar-----------------------------------//

    public void actualizarCategoria() {
        Categoria cat = new Categoria();
        cat.setIdCategoria(3);
        cat.setNombreCategoria("Electricos Para El Hogar");

        try {
            CategoriaDAO catD = new CategoriaDAO();
            catD.modificarCategoria(cat);
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
