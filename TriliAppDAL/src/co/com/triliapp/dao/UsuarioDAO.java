package co.com.triliapp.dao;

import co.com.triliapp.dto.Rango;
import co.com.triliapp.dto.Rol;
import co.com.triliapp.dto.Usuario;//-------------------Paquete Categoria
import co.com.triliapp.util.Conexion;//-----------------Paquete Conexion
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    Usuario usuario = new Usuario();
    public Conexion link;
    public PreparedStatement ps = null;

    //----------------------------Insertar Usuario----------------------------//
    public Usuario insertarUsuario(Usuario usu) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "INSERT INTO Usuarios (imagenUsu, DisplayName  , contraseniaUsu , correoUsu  , idRango , idRol ) VALUES(?,?,?,?,?,?);";
        ps = connect.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);//=======generar la pk

        ps.setString(1, usu.getImagenUsu());
        ps.setString(2, usu.getDisplayName());
        ps.setString(3, usu.getContraseniaUsu());
        ps.setString(4, usu.getCorreoUsu());
        ps.setInt(5, usu.getRango().getIdRango());
        ps.setInt(6, usu.getRol().getIdRol());

        ps.executeUpdate();
        //===============================Retornar pk==========================//
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        usu.setIdUsuario(rs.getInt(1));
        //=====================================================================      

        return usu;
    }

    /**
     * Esta metodo es para el formulario de registro los roles y rangos son
     * predeterminados a 1
     *
     * @param usu
     */
    public Usuario RegistroUsuario(Usuario usu) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "INSERT INTO Usuarios (imagenUsu, DisplayName  , contraseniaUsu , correoUsu ) VALUES(?,?,?,?);";
        ps = connect.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);//=======generar la pk

        ps.setString(1, usu.getImagenUsu());
        ps.setString(2, usu.getDisplayName());
        ps.setString(3, usu.getContraseniaUsu());
        ps.setString(4, usu.getCorreoUsu());

        ps.executeUpdate();
        //===============================Retornar pk==========================//
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        usu.setIdUsuario(rs.getInt(1));
        //=====================================================================      

        return usu;
    }

    //----------------------------------Mostrar Datos Usuario---------------//
    public ArrayList<Usuario> mostrarUsuario() throws SQLException {
        ArrayList<Usuario> list = new ArrayList<>();
        Conexion connect = new Conexion();

        String sql = "SELECT * FROM Usuarios;";
        ResultSet res = null;

        ps = connect.getConexion().prepareStatement(sql);
        res = ps.executeQuery();
        RangoDAO rdao = new RangoDAO();
        RolDAO rolDAO = new RolDAO();
        Usuario usu = null;
        Rango rang = null;
        Rol rol = null;
        while (res.next()) {

            usu = new Usuario();

            usu.setIdUsuario(res.getInt(1));
            usu.setImagenUsu(res.getString(2));
            usu.setDisplayName(res.getString(3));
            usu.setContraseniaUsu(res.getString(4));
            usu.setCorreoUsu(res.getString(5));
            usu.setExperienciaUsu(res.getInt(6));
            rang = rdao.buscarCodigoRango(res.getInt(7));
            usu.setRango(rang);
            rol = rolDAO.buscarCodigoRol(res.getInt(8));
            usu.setRol(rol);
            usu.setEstadoUsuario(res.getString(9));

            list.add(usu);
        }
        return list;
    }

    //-------------------------------Buscar Codigo Usuario-------------------//
    public Usuario buscarCodigoUsuario(int idUsuario) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Usuarios WHERE idUsuario=?;";
        ResultSet rs = null;

        Usuario usuarioVar = new Usuario();

        RangoDAO rangDAO = new RangoDAO();
        RolDAO rolDAO = new RolDAO();

        Rango rang = null;
        Rol rol = null;

        ps = connect.getConexion().prepareStatement(sql);

        ps.setInt(1, idUsuario);
        rs = ps.executeQuery();
        rs.next();

        usuarioVar.setIdUsuario(rs.getInt(1));
        usuarioVar.setImagenUsu(rs.getString(2));
        usuarioVar.setDisplayName(rs.getString(3));
        usuarioVar.setContraseniaUsu(rs.getString(4));
        usuarioVar.setCorreoUsu(rs.getString(5));
        usuarioVar.setExperienciaUsu(rs.getInt(6));
        rang = rangDAO.buscarCodigoRango(rs.getInt(7));
        usuarioVar.setRango(rang);
        rol = rolDAO.buscarCodigoRol(rs.getInt(8));
        usuarioVar.setRol(rol);

        return usuarioVar;
    }

    public Usuario buscarNombreUsuario(String nombreUsu, String contraseniaUsu) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Usuarios WHERE DisplayName=? && contraseniaUsu= ? && estadoUsuario= 'Activo';";
        ResultSet rs = null;

        Usuario usuarioVar = new Usuario();

        RangoDAO rangDAO = new RangoDAO();
        RolDAO rolDAO = new RolDAO();

        Rango rang = null;
        Rol rol = null;

        ps = connect.getConexion().prepareStatement(sql);

        ps.setString(1, nombreUsu);
        ps.setString(2, contraseniaUsu);
        rs = ps.executeQuery();
        rs.next();

        usuarioVar.setIdUsuario(rs.getInt(1));
        usuarioVar.setImagenUsu(rs.getString(2));
        usuarioVar.setDisplayName(rs.getString(3));
        usuarioVar.setContraseniaUsu(rs.getString(4));
        usuarioVar.setCorreoUsu(rs.getString(5));
        usuarioVar.setExperienciaUsu(rs.getInt(6));
        rang = rangDAO.buscarCodigoRango(rs.getInt(7));
        usuarioVar.setRango(rang);
        rol = rolDAO.buscarCodigoRol(rs.getInt(8));
        usuarioVar.setRol(rol);
        usuarioVar.setEstadoUsuario(rs.getString(9));

        return usuarioVar;
    }

    public Usuario buscarContraseniaUsuario(String contraUsu) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Usuarios WHERE contraseniaUsu  =?;";
        ResultSet rs = null;

        Usuario usuarioVar = new Usuario();

        RangoDAO rangDAO = new RangoDAO();
        RolDAO rolDAO = new RolDAO();

        Rango rang = null;
        Rol rol = null;

        ps = connect.getConexion().prepareStatement(sql);

        ps.setString(1, contraUsu);
        rs = ps.executeQuery();
        rs.next();

        usuarioVar.setIdUsuario(rs.getInt(1));
        usuarioVar.setImagenUsu(rs.getString(2));
        usuarioVar.setDisplayName(rs.getString(3));
        usuarioVar.setContraseniaUsu(rs.getString(4));
        usuarioVar.setCorreoUsu(rs.getString(5));
        usuarioVar.setExperienciaUsu(rs.getInt(6));
        rang = rangDAO.buscarCodigoRango(rs.getInt(7));
        usuarioVar.setRango(rang);
        rol = rolDAO.buscarCodigoRol(rs.getInt(8));
        usuarioVar.setRol(rol);

        return usuarioVar;
    }
//    -------------------------------ELIMINAR Codigo Usuario-------------------//

    public void eliminarUsuarioPorCodigo(Usuario usu) throws SQLException {

        Conexion connect = new Conexion();
        String sql = "DELETE FROM Usuarios WHERE idUsuario = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, usu.getIdUsuario());

        int a = ps.executeUpdate();
        if (a <= 0) {
            System.out.println();

        }

    }

    public void eliminarUsuarioPorNombre(Usuario usu) throws SQLException {

        Conexion connect = new Conexion();
        String sql = "DELETE FROM Usuarios WHERE DisplayName = ?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setString(1, usu.getDisplayName());

        int a = ps.executeUpdate();
        if (a <= 0) {
            System.out.println();

        }

    }
    
    /**
     * Metodo Del DAL para actualizar solamente el Display Del usuario
     * Datos Solicitados (El Id del Usuario a actualizar y el DisplayName)
     */

    //--------------------------------Actualizar Nombre Usuario----------------------//
    public void modificarNombreUsuario(Usuario Usu) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Usuarios SET    DisplayName  = ? WHERE idUsuario = ?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setString(1, Usu.getDisplayName());
        ps.setInt(2, Usu.getIdUsuario());

        ps.executeUpdate();
    }
    /**
     * Metodo Del Dal Para Actualizar Solamente La Experiencia Del Usuarios
     * Datos Solicitados Son 
     * (El Id Del Usuario y la Experiencia del Usuario)
     */
    
    //--------------------------------Actualizar Experiencia Usuario----------------------//
    public void modificarExperienciaUsuario(Usuario Usu) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Usuarios SET  experienciaUsu= ? WHERE idUsuario = ?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setInt(1, Usu.getExperienciaUsu());
        ps.setInt(2, Usu.getIdUsuario());

        ps.executeUpdate();
    }

    //-------------------------------------Actualizar Usuario-----------------//
    public void modificarUsuario(Usuario Usu) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Usuarios SET   imagenUsu = ? , DisplayName  = ? ,contraseniaUsu = ? , correoUsu = ? , experienciaUsu = ? , estadoUsuario = ? WHERE idUsuario = ?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setString(1, Usu.getImagenUsu());
        ps.setString(2, Usu.getDisplayName());
        ps.setString(3, Usu.getContraseniaUsu());
        ps.setString(4, Usu.getCorreoUsu());
        ps.setInt(5, Usu.getExperienciaUsu());
        ps.setString(6, Usu.getEstadoUsuario());
        ps.setInt(7, Usu.getIdUsuario());
        

        ps.executeUpdate();
    }

    //===================================Recuperar Datos======================//
    public Usuario recuperarContraseniaUsuario(String correoUsu, String nombreUsu) throws SQLException {

        Conexion connec = new Conexion();
        String sql = "select (contraseniaUsu) from Usuarios where correoUsu = ? && DisplayName = ?;";
        ResultSet rs = null;
        Usuario Usu = new Usuario();

        ps = connec.getConexion().prepareStatement(sql);
        ps.setString(1, correoUsu);
        ps.setString(2, nombreUsu);
        rs = ps.executeQuery();

        rs.next();

        Usu.setContraseniaUsu(rs.getString(1));

        return Usu;

    }

    public Usuario recuperardisplayNameUsuario(String correoUsu, String contraseniaUsu) throws SQLException {

        Conexion connec = new Conexion();
        String sql = "select (DisplayName) from Usuarios where correoUsu = ? && contraseniaUsu = ?;";
        ResultSet rs = null;
        Usuario Usu = new Usuario();

        ps = connec.getConexion().prepareStatement(sql);
        ps.setString(1, correoUsu);
        ps.setString(2, contraseniaUsu);
        rs = ps.executeQuery();

        rs.next();

        Usu.setDisplayName(rs.getString(1));

        return Usu;

    }
}
