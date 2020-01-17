package co.com.triliapp.dao;

import co.com.triliapp.dto.Producto;//-------------------Paquete Categoria
import co.com.triliapp.util.Conexion;//-----------------Paquete Conexion
import co.com.triliapp.dto.Usuario;//-----------------Paquete  fk Usuario 
import co.com.triliapp.dto.Categoria;//-----------------Paquete  fk Categoria 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {

    private Producto producto;
    public Conexion link;
    public PreparedStatement ps = null;

    //----------------------------Insertar Producto----------------------------//
    public Producto insertarProducto(Producto prod) throws SQLException {
        Conexion conec = new Conexion();
        String sql = "INSERT INTO Productos ( nombrePR , idUsuario , idCategoria) VALUES(?,?,?);";

        ps = conec.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, prod.getNombreProducto());
        ps.setInt(2, prod.getUsuario().getIdUsuario());
        ps.setInt(3, prod.getCategoria().getIdCategoria());
        ps.executeUpdate();

        //================================================================//
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        prod.setIdProducto(rs.getInt(1));
        //================================================================//

        return prod;
    }

    //----------------------------------Mostrar Datos Producto---------------//
    public ArrayList<Producto> mostrarProducto() throws SQLException {
        ArrayList<Producto> list = new ArrayList<>();
        Conexion conc = new Conexion();
        String sql = "SELECT * FROM Productos;";
        ResultSet res = null;

        ps = conc.getConexion().prepareStatement(sql);
        res = ps.executeQuery();

        UsuarioDAO usuDAO = new UsuarioDAO();
        CategoriaDAO catDAO = new CategoriaDAO();

        Producto prod = null;
        Usuario usu = null;
        Categoria cat = null;

        while (res.next()) {

            prod = new Producto();
            prod.setIdProducto(res.getInt(1));
            prod.setNombreProducto(res.getString(2));
            usu = usuDAO.buscarCodigoUsuario(res.getInt(3));
            prod.setUsuario(usu);
            cat = catDAO.buscarCodigoCategoria(res.getInt(4));
            prod.setCategoria(cat);

            list.add(prod);
        }
        return list;
    }
    //-------------------------------Buscar Codigo Producto-------------------//

    public Producto buscarPorCodigoProducto(int idProd) throws SQLException {

        Conexion conc = new Conexion();
        String sql = "SELECT * FROM Productos WHERE idProducto=?;";
        ResultSet rs = null;

        Producto productoVar = new Producto();

        UsuarioDAO usuDAO = new UsuarioDAO();
        CategoriaDAO catDAO = new CategoriaDAO();
        Usuario usu = null;
        Categoria cat = null;

        ps = conc.getConexion().prepareStatement(sql);
        ps.setInt(1, idProd);
        rs = ps.executeQuery();

        rs.next();
        productoVar.setIdProducto(rs.getInt(1));
        productoVar.setNombreProducto(rs.getString(2));
        usu = usuDAO.buscarCodigoUsuario(rs.getInt(3));
        productoVar.setUsuario(usu);
        cat = catDAO.buscarCodigoCategoria(rs.getInt(4));
        productoVar.setCategoria(cat);

        return productoVar;
    }

    //-------------------------------Eliminar---------------------------------//
    public void eliminarProducto(Producto Prod) throws SQLException {

        Conexion connect = new Conexion();
        String sql = "DELETE FROM Productos WHERE idProducto = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, Prod.getIdProducto());
        ps.executeUpdate();

    }
    //-------------------------Update-----------------------------------------//

    public void modificarProducto(Producto prod) throws SQLException {
        Conexion connect = new Conexion();

        Categoria cat = new Categoria();

        String sql = "UPDATE Productos SET   nombrePR = ?  WHERE idproducto = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, prod.getNombreProducto());
        ps.setInt(2, prod.getIdProducto());

        ps.executeUpdate();

    }

    public Producto mostrarPorNombreProducto(String nombreProd) throws SQLException {

        Conexion conc = new Conexion();
        String sql = "SELECT * FROM Productos WHERE nombrePR = ?;";
        ResultSet rs = null;
        Producto productoVar = new Producto();

        Usuario usu = null;
        Categoria cat = null;

        UsuarioDAO usuDAO = new UsuarioDAO();
        CategoriaDAO catDAO = new CategoriaDAO();

        ps = conc.getConexion().prepareStatement(sql);
        ps.setString(1, nombreProd);
        rs = ps.executeQuery();

        rs.next();
        productoVar.setIdProducto(rs.getInt(1));
        productoVar.setNombreProducto(rs.getString(2));
        
        usu = usuDAO.buscarCodigoUsuario(rs.getInt(3));
        productoVar.setUsuario(usu);
        cat = catDAO.buscarCodigoCategoria(rs.getInt(4));
        productoVar.setCategoria(cat);

        return productoVar;
    }

    public ArrayList<Producto> compararProductoASC(String nombreProd) throws SQLException {

        ArrayList<Producto> list = new ArrayList<>();
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Productos WHERE nombrePR = ? order by precioPR ASC;";
        ResultSet rest = null;

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, nombreProd);
        rest = ps.executeQuery();

        while (rest.next()) {

            Producto prodDTO = new Producto();

            prodDTO.setIdProducto(rest.getInt(1));
            prodDTO.setNombreProducto(rest.getString(2));

            list.add(prodDTO);
        }

        return list;
    }
}
