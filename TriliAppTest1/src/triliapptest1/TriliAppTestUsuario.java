package triliapptest1;

import co.com.triliapp.dto.Rango;
import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dao.UsuarioDAO;
import co.com.triliapp.dto.Rol;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriliAppTestUsuario {

    public static void main(String[] args) {

        TriliAppTestUsuario triliAppUsu = new TriliAppTestUsuario();

//          triliAppUsu.Acceder();
//        triliAppUsu.insertarUsuario();
//        triliAppUsu.mostrarUsuario();
//          triliAppUsu.eliminarUsuario();
//        triliAppUsu.eliminarUsuarioPorNombre();
//        triliAppUsu.ActualizarNombreUsuario();
//        triliAppUsu.actualizarUsuario();
//        triliAppUsu.mostrarUsuario();
//        triliAppUsu.mostrarCodigoUsuario();
        triliAppUsu.mostrarNombreUsuario();
//        triliAppUsu.recuperarContrasenia();
//        triliAppUsu.recuperarDisplayName();
//        triliAppUsu.mostrarContraseniaUsuario();

    }

    //-----------------------------Insertar-----------------------------------//
    public void insertarUsuario() {
        Usuario usu = new Usuario();
        Rango rang = new Rango();
        Rol rolU = new Rol();
        rang.setIdRango(1);
        rolU.setIdRol(1); //------------Rol por defecto Invitado-----------------//

        usu.setImagenUsu("");
        usu.setDisplayName("Daniel");
        usu.setContraseniaUsu("111111");
        usu.setCorreoUsu("welbe@gamil");
        //usu.setExperienciaUsu(0);//--------------La Experiencia por defecto es 0
        usu.setRango(rang);//------------El Ranog por defecto es 1
        usu.setRol(rolU);//--------------El Rol Por defecto es invitado
        //usu.setEstadoUsuario(estadoUsuario);
        UsuarioDAO usuDao = new UsuarioDAO();
        try {
            usuDao.insertarUsuario(usu);
            System.out.println("Su Id De Usuario Es :" + "  " + usu.getIdUsuario());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        MyHelper h = new MyHelper();
        try {
            String contraseniaUsu = usu.getContraseniaUsu();
            h.validarcontraseniaUsu(contraseniaUsu);
        } catch (CustomExeption e) {
            System.out.print("No se pudo ingresar debido a" + e.getMessage());
        }

    }

    //--------------------------Mostrar---------------------------------------//
    public void mostrarUsuario() {
        UsuarioDAO usuD = new UsuarioDAO();
        Rango rang = null;
        try {
            rang = new Rango();
            for (Usuario e : usuD.mostrarUsuario()) {
                System.out.println(e.getIdUsuario() + " " + e.getImagenUsu() + " " + e.getDisplayName() + " " + e.getContraseniaUsu() + " " + e.getCorreoUsu() + " " + e.getExperienciaUsu() + " " + e.getRango().getIdRango() + " " + e.getRol().getIdRol());
            }
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //==============================MostraPorCodigo===========================//
    public void mostrarCodigoUsuario() {
        UsuarioDAO usuDAO = new UsuarioDAO();
        Usuario Usu;
        try {
            Usu = usuDAO.buscarCodigoUsuario(1);
            System.out.println(Usu.getIdUsuario() + " " + Usu.getImagenUsu() + " " + Usu.getDisplayName() + " " + Usu.getContraseniaUsu() + " " + Usu.getCorreoUsu() + " " + Usu.getRango().getIdRango() + " " + Usu.getRol().getIdRol() + " " + Usu.getExperienciaUsu() + " " + Usu.getEstadoUsuario());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //----------------------Eliminar------------------------------------------//
    public void eliminarUsuario() {

        Usuario usu = new Usuario();
        usu.setIdUsuario(1);

        UsuarioDAO usuD = new UsuarioDAO();
        Usuario dto;

        try {
            usuD.eliminarUsuarioPorNombre(usu);
            System.out.println("USUARIO ELIMIADO");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarUsuarioPorNombre() {

        Usuario usu = new Usuario();
        usu.setDisplayName("Daniel AndresLa111");

        UsuarioDAO usuD = new UsuarioDAO();
        Usuario dto;

        try {
            usuD.eliminarUsuarioPorNombre(usu);
            System.out.println("USUARIO ELIMIADO");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //----------------------------Modificar Nombre Usuario--------------------//
    public void ActualizarNombreUsuario() {
        Usuario usu = new Usuario();

        usu.setIdUsuario(1);
        usu.setDisplayName("Dazzlesonenig");
        UsuarioDAO usuDao = new UsuarioDAO();
        try {
            usuDao.modificarNombreUsuario(usu);
            System.out.println("DATOS ACTUALIZADOS");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //----------------------------Modificar Usuario---------------------------//
    public void actualizarUsuario() {
        Usuario usu = new Usuario();

        usu.setIdUsuario(1);
        usu.setImagenUsu("Imgen Encontrada1");
        usu.setDisplayName("Dazzlesonenig");
        usu.setContraseniaUsu("underGraund1");
        usu.setCorreoUsu("calle 100 # 25-356");
        usu.setExperienciaUsu(25);

        UsuarioDAO usuDao = new UsuarioDAO();

        try {
            usuDao.modificarUsuario(usu);
            System.out.println("USUARIO ACTUALIZADO");
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //==================================Acceder===============================//
    public void mostrarNombreUsuario() {
//        UsuarioDAO usuDAO = new UsuarioDAO();
//        Usuario Usu;
//        String Nombre="Daniel"+"dfasasd";
//        String Contrasenia="123";
//        Usu = usuDAO.buscarNombreUsuario(Contrasenia+Nombre);
//        System.out.println(Usu.getIdUsuario() + " " + Usu.getImagenUsu() + " " + Usu.getDisplayName() + " " + Usu.getContraseniaUsu() + " " + Usu.getCorreoUsu() + " " + Usu.getExperienciaUsu() + " " + Usu.getRango().getIdRango() + " " + Usu.getRol().getIdRol() + " " + Usu.getEstadoUsuario());
//    }
//
//    public void mostrarContraseniaUsuario() {
//        UsuarioDAO usuDAO = new UsuarioDAO();
//        Usuario Usu;
//        try {
//            Usu = usuDAO.buscarContraseniaUsuario("dazzPassword ");
//            System.out.println(Usu.getIdUsuario() + " " + Usu.getImagenUsu() + " " + Usu.getDisplayName() + " " + Usu.getContraseniaUsu() + " " + Usu.getCorreoUsu() + " " + Usu.getExperienciaUsu() + " " + Usu.getRango().getIdRango() + " " + Usu.getRol().getIdRol() + " " + Usu.getEstadoUsuario());
//        } catch (SQLException ex) {
//            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //==================================Recuperar=============================//
    public void recuperarContrasenia() {
        UsuarioDAO usuDAO = new UsuarioDAO();
        Usuario Usu;

        try {
            Usu = usuDAO.recuperarContraseniaUsuario("Carrera norte # 1119s", "Daniel AndresLa111");
            System.out.println(Usu.getContraseniaUsu());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void recuperarDisplayName() {
        UsuarioDAO usuDAO = new UsuarioDAO();
        Usuario usu;
        try {
            usu = usuDAO.recuperardisplayNameUsuario("Carrera norte # 19s", "coes");
            System.out.println(usu.getDisplayName());
        } catch (SQLException ex) {
            Logger.getLogger(TriliAppTestProducto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
