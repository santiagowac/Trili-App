package co.com.triliapp.dao;

import co.com.triliapp.dto.Producto;
import co.com.triliapp.dto.PublicacionDeProducto;
import co.com.triliapp.dto.Usuario;
import co.com.triliapp.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PublicacionDeProductoDAO {

    private Conexion link;
    private PreparedStatement ps = null;
    PublicacionDeProducto PubDP = new PublicacionDeProducto();

    public PublicacionDeProducto insertarPublicacionDeProducto(PublicacionDeProducto PubDPI) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "INSERT INTO publicacionesdeproductos (nombrePDP  , descripcionProducto , imagenProducto , marcaProducto , precioProducto , ubicacionProducto , idUsuario, idProducto) VALUES(?,?,?,?,?,?,?,?);";

        ps = connect.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, PubDPI.getNombrePDP());
        ps.setString(2, PubDPI.getDescripcionProducto());
        ps.setString(3, PubDPI.getImagenProducto());
        ps.setString(4, PubDPI.getMarcaProducto());
        ps.setFloat(5, PubDPI.getPrecioProducto());
        ps.setString(6, PubDPI.getUbicacionProducto());
        ps.setInt(7, PubDPI.getUsuario().getIdUsuario());
        ps.setInt(8, PubDPI.getProducto().getIdProducto());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        PubDPI.setIdPublicacionDeProducto(rs.getInt(1));

        return PubDPI;
    }

    //-------------------------------------Eliminar---------------------------//
    public void eliminarPublicacionDeProductoID(PublicacionDeProducto PubDPE) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "DELETE FROM publicacionesdeproductos WHERE idPublicacionDeProducto=?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, PubDPE.getIdPublicacionDeProducto());
        ps.executeUpdate();
        
    }

    public void eliminarPublicacionDeProductoNOM(PublicacionDeProducto PubDPE) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "DELETE FROM publicacionesdeproductos WHERE nombrePDP=?;";
        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, PubDPE.getNombrePDP());
        ps.executeUpdate();
        
    }

    public ArrayList<PublicacionDeProducto> mostrarDatosPublicacionDeProducto() throws SQLException {
        ArrayList<PublicacionDeProducto> list = new ArrayList<>();
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM publicacionesdeproductos;";
        ResultSet res = null;

        ps = connect.getConexion().prepareStatement(sql);
        res = ps.executeQuery();
        PublicacionDeProducto PubDPAL = null;
        Usuario usu = new Usuario();
        Producto prod = new Producto();
        UsuarioDAO usudao = new UsuarioDAO();
        ProductoDAO proddao = new ProductoDAO();
        while (res.next()) {

            PubDPAL = new PublicacionDeProducto();
            PubDPAL.setIdPublicacionDeProducto(res.getInt(1));
            PubDPAL.setNombrePDP(res.getString(2));
            PubDPAL.setFechaPDP(res.getTimestamp(3));
            PubDPAL.setDescripcionProducto(res.getString(4));
            PubDPAL.setImagenProducto(res.getString(5));
            PubDPAL.setMarcaProducto(res.getString(6));
            PubDPAL.setPrecioProducto(res.getFloat(7));
            PubDPAL.setUbicacionProducto(res.getString(8));
            usu = usudao.buscarCodigoUsuario(res.getInt(9));
            PubDPAL.setUsuario(usu);
            prod = proddao.buscarPorCodigoProducto(res.getInt(10));
            PubDPAL.setProducto(prod);

            list.add(PubDPAL);

        }
        return list;
    }

    public PublicacionDeProducto buscarCodigoPublicacionDeProducto(int idPubDPB) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM publicacionesdeproductos WHERE idPublicacionDeProducto=?;";
        ResultSet res = null;
        PublicacionDeProducto PubBDBC = null;

        PubBDBC = new PublicacionDeProducto();
        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, idPubDPB);
        res = ps.executeQuery();

        Usuario usu = null;
        UsuarioDAO usuDAO = new UsuarioDAO();

        Producto prod = null;
        ProductoDAO prodDAO = new ProductoDAO();

        res.next();
        PubBDBC.setIdPublicacionDeProducto(res.getInt(1));
        PubBDBC.setNombrePDP(res.getString(2));
        PubBDBC.setFechaPDP(res.getTimestamp(3));
        PubBDBC.setDescripcionProducto(res.getString(4));
        PubBDBC.setImagenProducto(res.getString(5));
        PubBDBC.setMarcaProducto(res.getString(6));
        PubBDBC.setPrecioProducto(res.getFloat(7));
        PubBDBC.setUbicacionProducto(res.getString(8));
        usu = usuDAO.buscarCodigoUsuario(res.getInt(9));
        PubBDBC.setUsuario(usu);
        prod = prodDAO.buscarPorCodigoProducto(res.getInt(10));
        PubBDBC.setProducto(prod);

        return PubBDBC;
    }

    //
    public ArrayList<PublicacionDeProducto> buscarNombrePublicacionDeProducto(String nombrePDP) throws SQLException {

        ArrayList<PublicacionDeProducto> list = new ArrayList<>();
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM publicacionesdeproductos WHERE nombrePDP = ?;";
        ResultSet res = null;
        PublicacionDeProducto PubBDBC = null;

        PubBDBC = new PublicacionDeProducto();
        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, nombrePDP);
        res = ps.executeQuery();

        Usuario usu = null;
        UsuarioDAO usuDAO = new UsuarioDAO();

        Producto prod = null;
        ProductoDAO prodDAO = new ProductoDAO();

        while (res.next()) {

            PublicacionDeProducto pdpDTO = new PublicacionDeProducto();

         

            pdpDTO.setIdPublicacionDeProducto(res.getInt(1));
            pdpDTO.setNombrePDP(res.getString(2));
            pdpDTO.setFechaPDP(res.getTimestamp(3));
            pdpDTO.setDescripcionProducto(res.getString(4));
            pdpDTO.setImagenProducto(res.getString(5));
            pdpDTO.setMarcaProducto(res.getString(6));
            pdpDTO.setPrecioProducto(res.getFloat(7));
            pdpDTO.setUbicacionProducto(res.getString(8));
            usu = usuDAO.buscarCodigoUsuario(res.getInt(9));
            pdpDTO.setUsuario(usu);
            prod = prodDAO.buscarPorCodigoProducto(res.getInt(10));
            pdpDTO.setProducto(prod);

            list.add(pdpDTO);
        }

        return list;

    }

    //------------------------------Modificar---------------------------------//
    public void modificarPublicacionDeProducto(PublicacionDeProducto PibDPU) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE publicacionesdeproductos SET  nombrePDP =? , descripcionPDP=? , imagenProducto=? , marcaProducto  = ? , precioProducto = ? , ubicacionProducto = ? , idProducto= ? WHERE idPublicacionDeProducto = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, PibDPU.getNombrePDP());
        ps.setString(2, PibDPU.getDescripcionProducto());
        ps.setString(3, PibDPU.getImagenProducto());
        ps.setString(4, PibDPU.getMarcaProducto());
        ps.setFloat(5, PibDPU.getPrecioProducto());
        ps.setString(6, PibDPU.getUbicacionProducto());
        ps.setInt(7, PibDPU.getProducto().getIdProducto());
        ps.setInt(8, PibDPU.getIdPublicacionDeProducto());

        ps.execute();
    }

    public ArrayList<PublicacionDeProducto> compararPublicacionDeProductoASC(String nombrePDP) throws SQLException {

        ArrayList<PublicacionDeProducto> list = new ArrayList<>();
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM publicacionesdeproductos WHERE nombrePDP = ? order by precioProducto "+Ordenamientos.ASC+";";
        ResultSet rest = null;

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, nombrePDP);
        rest = ps.executeQuery();

        while (rest.next()) {

            PublicacionDeProducto pdpDTO = new PublicacionDeProducto();

            Usuario usu = null;
            UsuarioDAO usuDAO = new UsuarioDAO();

            Producto prod = null;
            ProductoDAO prodDAO = new ProductoDAO();

            pdpDTO.setIdPublicacionDeProducto(rest.getInt(1));
            pdpDTO.setNombrePDP(rest.getString(2));
            pdpDTO.setFechaPDP(rest.getTimestamp(3));
            pdpDTO.setDescripcionProducto(rest.getString(4));
            pdpDTO.setImagenProducto(rest.getString(5));
            pdpDTO.setMarcaProducto(rest.getString(6));
            pdpDTO.setPrecioProducto(rest.getFloat(7));
            pdpDTO.setUbicacionProducto(rest.getString(8));
            usu = usuDAO.buscarCodigoUsuario(rest.getInt(9));
            pdpDTO.setUsuario(usu);
            prod = prodDAO.buscarPorCodigoProducto(rest.getInt(10));
            pdpDTO.setProducto(prod);

            list.add(pdpDTO);
        }

        return list;
    }

    public ArrayList<PublicacionDeProducto> compararPublicacionDeProductoDESC(String nombrePDP) throws SQLException {

        ArrayList<PublicacionDeProducto> list = new ArrayList<>();
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM publicacionesdeproductos WHERE nombrePDP = ? order by precioProducto DESC;";
        ResultSet rest = null;

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, nombrePDP);
        rest = ps.executeQuery();

        while (rest.next()) {

            PublicacionDeProducto pdpDTO = new PublicacionDeProducto();

            Usuario usu = null;
            UsuarioDAO usuDAO = new UsuarioDAO();

            Producto prod = null;
            ProductoDAO prodDAO = new ProductoDAO();

            pdpDTO.setIdPublicacionDeProducto(rest.getInt(1));
            pdpDTO.setNombrePDP(rest.getString(2));
            pdpDTO.setFechaPDP(rest.getTimestamp(3));
            pdpDTO.setDescripcionProducto(rest.getString(4));
            pdpDTO.setImagenProducto(rest.getString(5));
            pdpDTO.setMarcaProducto(rest.getString(6));
            pdpDTO.setPrecioProducto(rest.getFloat(7));
            pdpDTO.setUbicacionProducto(rest.getString(8));
            usu = usuDAO.buscarCodigoUsuario(rest.getInt(9));
            pdpDTO.setUsuario(usu);
            prod = prodDAO.buscarPorCodigoProducto(rest.getInt(10));
            pdpDTO.setProducto(prod);

            list.add(pdpDTO);
        }

        return list;
    }

}
