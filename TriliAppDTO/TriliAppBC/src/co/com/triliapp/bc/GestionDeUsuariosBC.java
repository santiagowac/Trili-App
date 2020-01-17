package co.com.triliapp.bc;

import co.com.triliapp.dao.UsuarioDAO;
import co.com.triliapp.dto.Usuario;
import java.rmi.server.UID;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionDeUsuariosBC {

    public String IngresarUsuario(Usuario usuDTO) {
        UsuarioDAO usuDAO = new UsuarioDAO();

        try {
            usuDAO.insertarUsuario(usuDTO);
            return "Usuario Creado Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeUsuariosBC.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Crear Usuario";
        }
    }

    public String ActualizarUsuario(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.modificarUsuario(usuDTO);
        return "Usuario Actualizado Con Exito";
    }

    public String EliminarUsuario(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.eliminarUsuario(usuDTO);
        return "Usuario Actualizado Con Exito";
    }

    public List<Usuario> mostrarUsuario() throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.MostrarUsuario();
    }

    //-------------------------------Busqueda Por Codigo----------------------//
    public Usuario MostrarUsuarioPorCodigo(int idUsuario) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.BuscarCodigoUsuario(idUsuario);
    }

}
