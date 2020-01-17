package co.com.triliapp.dao;

import co.com.triliapp.util.Conexion;
import co.com.triliapp.dto.Categoria;//-------------------Paquete Categoria
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {

    Categoria categoria = new Categoria();
    public Conexion link;
    public PreparedStatement ps = null;

    //---------------------------------Insertar Categoria---------------------//
    public Categoria insertarCategoria(Categoria Catg) throws SQLException {

        Conexion conec = new Conexion();
        String sql = "INSERT INTO Categorias ( nombreCat ) VALUES(?);";

        ps = conec.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, Catg.getNombreCategoria());
        ps.executeUpdate();
        //===============================Retornar pk==========================//
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        Catg.setIdCategoria(rs.getInt(1));
        //======================================================================

        return Catg;
    }

    //-------------------------------Mostrar Datos Categoria-----------------//
    public ArrayList<Categoria> MostrarCategoria() throws SQLException {
        ArrayList<Categoria> list = new ArrayList<>();
        Conexion conx = new Conexion();
        String sql = "SELECT * FROM Categorias;";
        ResultSet rs = null;

        ps = conx.getConexion().prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Categoria CatVar = new Categoria();
            CatVar.setIdCategoria(rs.getInt(1));
            CatVar.setNombreCategoria(rs.getString(2));

            list.add(CatVar);
        }

        return list;
    }

    //----------------------------Buscar Codigo Categoria---------------------//
    public Categoria buscarCodigoCategoria(int idCategoria) throws SQLException {
        Conexion conx = new Conexion();
        String sql = "SELECT * FROM Categorias where idCategoria =?;";
        ResultSet rs = null;
        Categoria Cat = new Categoria();

        ps = conx.getConexion().prepareStatement(sql);
        ps.setInt(1, idCategoria);
        rs = ps.executeQuery();
        rs.next();
        Cat.setIdCategoria(rs.getInt(1));
        Cat.setNombreCategoria(rs.getString(2));

        return Cat;
    }
    
    
    
    //-------------------------------Eliminar---------------------------------//

    public void eliminarCategoria(Categoria cat) throws SQLException {

        Conexion connect = new Conexion();
        String sql = "DELETE FROM Categorias WHERE idCategoria = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, cat.getIdCategoria());
        ps.executeUpdate();

        
    }

    //-----------------------------Actualiza----------------------------------//
    public void modificarCategoria(Categoria Cat) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Categorias SET   nombreCAT = ?  WHERE idCategoria = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, Cat.getNombreCategoria());
        ps.setInt(2, Cat.getIdCategoria());

        ps.executeUpdate();

    }
}
