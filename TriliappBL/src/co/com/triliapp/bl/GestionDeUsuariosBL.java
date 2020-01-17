package co.com.triliapp.bl;

import co.com.triliapp.dao.UsuarioDAO;
import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dto.Rol;
import co.com.triliapp.dao.RangoDAO;
import co.com.triliapp.dto.Rango;
import co.com.triliapp.dao.RolDAO;
import java.rmi.server.UID;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionDeUsuariosBL {
    //=====================Login==========================================//
//    public boolean login(Usuario uno) throws SQLException {
//        Usuario usuDTO = new Usuario();
//        UsuarioDAO usuDAO = new UsuarioDAO();
//        usuDTO=usuDAO.buscarNombreUsuario(usuDTO.getDisplayName());
//        
//        if (usuDTO.equals(usuDTO.getContraseniaUsu())) {
//            return true;
//        }
//        return false;
//    }
    
    /**
     * Metodo Para el ingreso y verificacion del Usuario hacia el sistema
     *
     * @param usuDTO (DisplayName, Contraseña) para el funcionamiento de este el
     * usuario tiene que estar previamente registrado
     * @return
     * @throws SQLException
     */
    public boolean login(Usuario usuDTO) throws SQLException {
//        Usuario dto = new Usuario();
        UsuarioDAO usuDAO = new UsuarioDAO();

        usuDTO = usuDAO.buscarNombreUsuario(usuDTO.getDisplayName(), usuDTO.getContraseniaUsu());
//        String txtContraseña = (usuDTO.getContraseniaUsu());
        if (usuDTO.equals(usuDTO.getContraseniaUsu())) {
            return true;
        }
        return false;
    }

    /**
     * Metodo para el registro del usuario en el sistema
     *
     * @param usuDTO (NickName,Contrasenia, Correo Electronico, e imagen)
     * @return
     */
    public String IngresarUsuario(Usuario usuDTO) {
        UsuarioDAO usuDAO = new UsuarioDAO();

        try {
            usuDAO.insertarUsuario(usuDTO);
            return "Usuario Creado Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeUsuariosBL.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Crear Usuario";
        }
    }

    /**
     * Metodo para la actualizacion de los datos en un usuario
     *
     * @param usuDTO (NickName, Contrasenia, Estado Usuario, Rol, Rango,
     * Experiencia)
     * @return
     * @throws SQLException
     */
    public String ActualizarUsuario(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.modificarUsuario(usuDTO);
        return "Usuario Actualizado Con Exito";
    }
    
    /**
     * Metodo Para La Clase usuario para Actualizar un un dato del objeto Usuario
     * Para modificar el Dato (Nickname)
     * @param usuDTO (Id Usuario y NickName)
     * @return
     * @throws SQLException 
     */

    public String ActualizarNombreUsuario(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.modificarNombreUsuario(usuDTO);
        return "DisplayName de Usuario Actualizado Con Exito";
    }
    /**
     * Metodo Para La clase usuario Actualiza la experiencia del Usuario
     * @param usuDTO (Id Del Usuario y experiencia)
     * @return
     * @throws SQLException 
     */

    public String ActualizarExperienciaUsuario(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.modificarExperienciaUsuario(usuDTO);
        return "Experiencia De Usuario Actualizado Con Exito";
    }

    public String EliminarUsuarioPorNombre(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDAO.eliminarUsuarioPorNombre(usuDTO);
        return "Usuario Actualizado Con Exito";
    }

    public List<Usuario> mostrarUsuario() throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.mostrarUsuario();
    }

    //-------------------------------Busqueda Por Codigo----------------------//
    public Usuario MostrarUsuarioPorCodigo(int idUsuario) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        return usuDAO.buscarCodigoUsuario(idUsuario);
    }

    //---------------Recuperar NickName Usuario-------------------------------//
    public Usuario RecuperarNickNameUsuario(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDTO = usuDAO.recuperardisplayNameUsuario(usuDTO.getDisplayName(), usuDTO.getContraseniaUsu());
        return usuDTO;
    }

    //---------------------------Recuperar contraseña Usuario-----------------//
    public Usuario RecuperarContaseniaUsuario(Usuario usuDTO) throws SQLException {
        UsuarioDAO usuDAO = new UsuarioDAO();
        usuDTO = usuDAO.recuperarContraseniaUsuario(usuDTO.getCorreoUsu(), usuDTO.getDisplayName());
        return usuDTO;
    }

    //===============================Rol======================================//
    public String IngresarRol(Rol rolDTO) {
        RolDAO rolDAO = new RolDAO();

        try {
            rolDAO.insertarRol(rolDTO);
            return "Rol Creado Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeUsuariosBL.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Crear El Rol";
        }
    }

    public String ActualizarRol(Rol rolDTO) throws SQLException {
        RolDAO rolDAO = new RolDAO();
        rolDAO.modificarRoL(rolDTO);
        return "Rol Actualizado Con Exito";
    }

    public String EliminarRol(Rol rolDTO) throws SQLException {
        RolDAO rolDAO = new RolDAO();
        rolDAO.eliminarRol(rolDTO);
        return "Rol Eliminado Con Exito";
    }

    public List<Rol> listarRoles() {
        RolDAO rolDAO = new RolDAO();
        try {
            return rolDAO.mostrarRol();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeUsuariosBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //===========================Rango==========//
    public String IngresarRango(Rango rangoDTO) {
        RangoDAO ranDAO = new RangoDAO();

        try {
            ranDAO.insertarRango(rangoDTO);
            return "Rango Creado Con Exito";
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeUsuariosBL.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al Crear El Roango";
        }
    }

    public String ActualizarRango(Rango ranDTO) throws SQLException {
        RangoDAO ranDAO = new RangoDAO();
        ranDAO.modificarRango(ranDTO);
        return "Rango Actualizado Con Exito";
    }

    /**
     * Metodo para eliminar Objeto de tipo rango
     *
     * @param ranDTO (Id del rango a eliminar)
     * @return
     * @throws SQLException
     */

    public String EliminarRango(Rango ranDTO) throws SQLException {
        RangoDAO ranDAO = new RangoDAO();
        ranDAO.eliminarRango(ranDTO);
        return "Rango Eliminado Con Exito";
    }

    /**
     * Metodo De enlistamiento de objetos del tipo Rango
     *
     * @return
     */
    public List<Rango> listarRangos() {
        RangoDAO dAO = new RangoDAO();
        try {
            return dAO.mostrarRango();
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeUsuariosBL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
