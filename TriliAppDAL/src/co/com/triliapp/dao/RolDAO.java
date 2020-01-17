/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dao;

import co.com.triliapp.dto.Rol;
import co.com.triliapp.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yasuly
 */
public class RolDAO {
    
    private Rol Rol;
    public Conexion link;
    public PreparedStatement ps = null;
    
    //-----------------------------Insertar Rol
    public Rol insertarRol (Rol rolI) throws SQLException{
      Conexion connect = new Conexion() ;
        String sql = "INSERT INTO Roles ( nombreRL ) VALUES(?);";
        ps = connect.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
    
            ps.setString(1, rolI.getNombreRL());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            rolI.setIdRol(rs.getInt(1));
            
    return rolI;
    }
    
    //--------------------Mostar Datos Rol
    
    public List<Rol> mostrarRol() throws SQLException {
        ArrayList<Rol> list = new ArrayList<>();
        Conexion connect = new Conexion();

        String sql = "SELECT * FROM Roles;";
        ResultSet rs = null;
       
            ps = connect.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            Rol RoD = null;
            
            while (rs.next()) {
                
                RoD = new Rol();
               
                RoD.setIdRol(rs.getInt(1));
                RoD.setNombreRL(rs.getString(2));
                
                list.add(RoD);
            }
        
        return list;
    }
    
    //----------------Buscar Codigo Rol
    
    public Rol buscarCodigoRol(int idrolB) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Roles WHERE idRol=?;";
        ResultSet rs = null;
        Rol rol = new Rol();
        
        rol = new Rol ();
            ps = connect.getConexion().prepareStatement(sql);
            ps.setInt(1, idrolB);
            rs = ps.executeQuery();
            
            rs.next();
            rol.setIdRol(rs.getInt(1));
            rol.setNombreRL(rs.getString(2));
            
            return rol;
    }
    
    //----------Eliminar Codigo Rol
    
    public void eliminarRol(Rol rolD) throws SQLException{

        Conexion connect = new Conexion() ;
        String sql = "DELETE FROM Roles WHERE idRol = ?;";
        
            ps = connect.getConexion().prepareStatement(sql);
            ps.setInt(1, rolD.getIdRol());
            ps.executeUpdate();

        
    }
    
    //--------------------Modificar
    
        public void modificarRoL (Rol rolM) throws SQLException{
        Conexion connect = new Conexion();
        String sql = "UPDATE Roles SET   nombreRL = ? WHERE idRol = ?;";

            ps = connect.getConexion().prepareStatement(sql);
            ps.setString(1, rolM.getNombreRL());
            ps.setInt(2, rolM.getIdRol());
            
            ps.executeUpdate();

    }
        
        // prime ejemplo Lazy Loading
//         public class Rol{
//    private String IdRol;
//    private String NombreRL;
//    private List<ro> roles = null;
//    public void setIdRol(String _IdRol){ IdRol = _IdRol; }
//    public void setNombreRL(String _NombreRL){ NombreRL = _NombreRL; }
//    public void setroles(List<ro> _roles){ roles = _roles; }
//
//    public String getIdRol(){ return IdRol; }
//    public String getNombreRL(){ return NombreRL; }
//    public List<ro> getroles(){
//        roles = ro.find("byRol", this);
//        if(roles == null) roles = new ArrayList<ro>();
//        return roles;
//    }
//
//    public void addrol(RO ro){
//        getroles();
//        if(roles == null) roles = new ArrayList<>();
//        roles.add(ro);
//    }
//}
// segundo ejemplo Lazy Loading
//    class Rol {  
//    private Rol() { 
//        System.out.println("primer paso");
//    }
//     Regresa la una instancia
//    public static Rol getInstance() { 
//        return RolHolder.instance; //<-- lazy load
//    }
//    private static class RolHolder { 
//      private final static Rol instance = new Rol();
//    }
//     metodo de clase
//    public static void metodo1() { System.out.println("Si, 1"); }
//     metodo de instancia
//    public void metodoY() { System.out.println("Si, 2"); }
//
//}

     
}
