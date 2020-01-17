/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dao;

import co.com.triliapp.dto.Reporte;
import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dto.PublicacionDeProducto;
import co.com.triliapp.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Triliapp
 */
public class ReporteDAO {

    private Reporte Reporte;
    public Conexion link;
    public PreparedStatement ps = null;

    //--------------------Insertar Reporte
    public Reporte insertReporte(Reporte Rpte) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "INSERT INTO Reportes ( descripcionRpte, idUsuario, idPublicacionDeProducto ) VALUES(?,?,?);";
        ps = connect.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, Rpte.getDescripcionRpte());
        ps.setInt(2, Rpte.getUsuario().getIdUsuario());
        ps.setInt(3, Rpte.getPublicacionDeProducto().getIdPublicacionDeProducto());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        Rpte.setIdReporte(rs.getInt(1));

        return Rpte;
    }

    //--------------------------Mostrar Datos Reporte
    public ArrayList<Reporte> mostrarDatoReporte() throws SQLException {
        ArrayList<Reporte> list = new ArrayList<>();
        Conexion connect = new Conexion();

        String sql = "SELECT * FROM Reportes;";
        ResultSet res = null;

        ps = connect.getConexion().prepareStatement(sql);
        res = ps.executeQuery();

        Reporte RpteD = null;
        Usuario usu = null;
        PublicacionDeProducto Pudp = null;

        UsuarioDAO usuDAO = new UsuarioDAO();
        PublicacionDeProductoDAO PudpDAO = new PublicacionDeProductoDAO();

        while (res.next()) {

            RpteD = new Reporte();
            RpteD.setIdReporte(res.getInt(1));
            RpteD.setDescripcionRpte(res.getString(2));
            RpteD.setFechaRpte(res.getTimestamp(3));
            usu = usuDAO.buscarCodigoUsuario(res.getInt(4));
            RpteD.setUsuario(usu);
            Pudp = PudpDAO.buscarCodigoPublicacionDeProducto(res.getInt(5));
            RpteD.setPublicacionDeProducto(Pudp);

            list.add(RpteD);

        }

        return list;
    }

    //--------------Buscar Codigo Rporte
    public Reporte buscarCodigoReporte(int idRpteDPB) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Reportes WHERE idReporte=?;";
        ResultSet res = null;
        Reporte RptBC = null;
        Usuario u = new Usuario();
        UsuarioDAO udao = new UsuarioDAO();

        RptBC = new Reporte();
        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, idRpteDPB);
        res = ps.executeQuery();

        res.next();
        //res.next();
        RptBC.setIdReporte(res.getInt(1));
        RptBC.setDescripcionRpte(res.getString(2));
        RptBC.setFechaRpte(res.getTimestamp(3));
        
        u = udao.buscarCodigoUsuario(res.getInt(4));
        
        RptBC.setUsuario(u);
        
        
        //RptBC.getPublicacionDeProducto().setIdPublicacionDeProducto(res.getInt(5));

        return RptBC;
    }

    //------------Eliminar Codigo Reporte
    public void eliminarReporte(Reporte Rpt) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "DELETE FROM Reportes WHERE idReporte=?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setInt(1, Rpt.getIdReporte());

        ps.executeUpdate();

    }

    //-----------Modificar
    public void modificarReporte(Reporte RpteDPU) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Reportes SET  descripcionRpte=?  , idUsuario=? , idPublicacionDeProducto=? WHERE idReporte = ?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setString(1, RpteDPU.getDescripcionRpte());
        ps.setInt(2, RpteDPU.getUsuario().getIdUsuario());
        ps.setInt(4, RpteDPU.getPublicacionDeProducto().getIdPublicacionDeProducto());
        ps.setInt(3, RpteDPU.getIdReporte());

        ps.executeUpdate();

    }
}
