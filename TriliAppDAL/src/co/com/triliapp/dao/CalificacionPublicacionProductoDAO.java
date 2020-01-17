/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dao;

import co.com.triliapp.dto.CalificacionPublicacionProducto;
import co.com.triliapp.dto.PublicacionDeProducto;
import co.com.triliapp.dto.Usuario;
import co.com.triliapp.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Triliapp
 */
public class CalificacionPublicacionProductoDAO {

    public Conexion link;
    public PreparedStatement ps = null;
    

    public CalificacionPublicacionProducto insertCalificacionPublicacionProducto(CalificacionPublicacionProducto CalPDI) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "INSERT INTO calificacionespublicacionesproductos ( valorCPP , comentarioCPP , idUsuario , idPublicacionDeProducto) VALUES(?,?,?,?);";
       
            ps = connect.getConexion().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setFloat(1, CalPDI.getValorCPP());
            ps.setString(2, CalPDI.getComentario());
            ps.setInt(3, CalPDI.getUsuario().getIdUsuario());
            ps.setInt(4, CalPDI.getPublicacionDeProducto().getIdPublicacionDeProducto());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            CalPDI.setIdCalificacionPublicacionProducto(rs.getInt(1));
                    
    return CalPDI;
    }

    public void eliminarCalificacionPublicacionProducto(CalificacionPublicacionProducto CalPDD) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "DELETE FROM calificacionespublicacionesproductos WHERE idCalificacionPublicacionProducto=?;";      
            ps = connect.getConexion().prepareStatement(sql);
            ps.setInt(1, CalPDD.getIdCalificacionPublicacionProducto());
        
    }

    public ArrayList<CalificacionPublicacionProducto> mostrarDatosCalificacionPublicacionProducto() throws SQLException {
        ArrayList<CalificacionPublicacionProducto> list = new ArrayList<>();
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM calificacionespublicacionesproductos;";
        ResultSet res = null;

            ps = connect.getConexion().prepareStatement(sql);
            res = ps.executeQuery();
            CalificacionPublicacionProducto CalPDAL = null;
            Usuario usu = new Usuario();
            PublicacionDeProducto pubP = new PublicacionDeProducto();
            UsuarioDAO usudao = new UsuarioDAO();
            PublicacionDeProductoDAO pubPDAO = new PublicacionDeProductoDAO();
            while (res.next()) {
                CalPDAL = new CalificacionPublicacionProducto();
                CalPDAL.setIdCalificacionPublicacionProducto(res.getInt(1));
                CalPDAL.setValorCPP(res.getFloat(2));
                CalPDAL.setComentario(res.getString(3));
                CalPDAL.setFechaCPP(res.getTimestamp(4));
                usu = usudao.buscarCodigoUsuario(res.getInt(5));
                CalPDAL.setUsuario(usu);
                pubP = pubPDAO.buscarCodigoPublicacionDeProducto(res.getInt(6));
                CalPDAL.setPublicacionDeProducto(pubP);
                list.add(CalPDAL);
            }
        return list;
    }

    public CalificacionPublicacionProducto buscarCodigoCalificacionPublicacionProducto(int idCalPDB) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM calificacionespublicacionesproductos WHERE idCalificacionPublicacionProducto=?;";
        ResultSet res = null;
        CalificacionPublicacionProducto CalPDBC = new CalificacionPublicacionProducto();    
            ps = connect.getConexion().prepareStatement(sql);
            ps.setInt(1, idCalPDB);
            res = ps.executeQuery();
            res.next();
            CalPDBC.setIdCalificacionPublicacionProducto(res.getInt(1));
            CalPDBC.setValorCPP(res.getFloat(2));
            CalPDBC.setComentario(res.getString(3));
            CalPDBC.setFechaCPP(res.getTimestamp(4));
            CalPDBC.getUsuario().setIdUsuario(res.getInt(5));
            CalPDBC.getPublicacionDeProducto().setIdPublicacionDeProducto(res.getInt(6));
        return CalPDBC;
    }
    public void modificarCalificacionPublicacionProducto(CalificacionPublicacionProducto CalPDU) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE calificacionpublicacionproducto SET  valorCPP=? , comentarioCPP=? , idUsuario=? , idPublicacionDeProducto=? WHERE idCalificacionPublicacionProducto = ?;";
        
            ps = connect.getConexion().prepareStatement(sql);
            ps.setFloat(1, CalPDU.getValorCPP());
            ps.setString(2, CalPDU.getComentario());
            ps.setInt(3, CalPDU.getUsuario().getIdUsuario());
            ps.setInt(4, CalPDU.getPublicacionDeProducto().getIdPublicacionDeProducto());
            ps.setInt(5, CalPDU.getIdCalificacionPublicacionProducto());
            
    }
}
