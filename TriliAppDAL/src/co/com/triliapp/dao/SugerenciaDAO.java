/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dao;

import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dto.Sugerencia;
import co.com.triliapp.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Triliapp
 */
public class SugerenciaDAO {

    public Conexion link;
    public PreparedStatement ps = null;
    Sugerencia Suge = new Sugerencia();

//    public Date Date=null;
//    date = new java.sql.Date(d.getfechaSug());
    //--------------------Insertar Sugerencia
    public Sugerencia insertarSugerencia(Sugerencia Sug) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "INSERT INTO Sugerencias ( tipoSUG , descripcionSUG , idUsuario ) VALUES(?,?,?);";
        ps = connect.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, Sug.getTipoSug());
        ps.setString(2, Sug.getDescripcionSug());
        ps.setInt(3, Sug.getUsuario().getIdUsuario());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        Sug.setIdSugerencia(rs.getInt(1));

        return Sug;
    }

    //--------------------------Mostrar Datos Sugerencia
    public ArrayList<Sugerencia> mostrarDatoSugerencia() throws SQLException {
        ArrayList<Sugerencia> list = new ArrayList<>();
        Conexion connect = new Conexion();

        String sql = "SELECT * FROM Sugerencias;";
        ResultSet res = null;

        ps = connect.getConexion().prepareStatement(sql);
        res = ps.executeQuery();
        Sugerencia SugD = null;
        Usuario usu = null;
        UsuarioDAO usuDAO = new UsuarioDAO();

        while (res.next()) {

            SugD = new Sugerencia();
            SugD.setIdSugerencia(res.getInt(1));
            SugD.setTipoSug(res.getString(2));
            SugD.setFechaSug(res.getTimestamp(3));
            SugD.setDescripcionSug(res.getString(4));
            usu = usuDAO.buscarCodigoUsuario(res.getInt(5));
            SugD.setUsuario(usu);

            list.add(SugD);

        }

        return list;
    }

    public ArrayList<Sugerencia> mostrarSugerenciaPorFechaASC() throws SQLException {

        ArrayList<Sugerencia> list = new ArrayList<>();
        Conexion connect = new Conexion();

        String sql = "select * from Sugerencias order by fechaSUG ASC;";
        ResultSet res = null;
        ps = connect.getConexion().prepareStatement(sql);
        res = ps.executeQuery();

        Sugerencia SugD = null;
        Usuario usu = null;
        UsuarioDAO usuDAO = new UsuarioDAO();

        while (res.next()) {

            SugD = new Sugerencia();
            SugD.setIdSugerencia(res.getInt(1));
            SugD.setTipoSug(res.getString(2));
            SugD.setFechaSug(res.getTimestamp(3));
            SugD.setDescripcionSug(res.getString(4));
            usu = usuDAO.buscarCodigoUsuario(res.getInt(5));
            SugD.setUsuario(usu);

            list.add(SugD);
        }
        return list;

    }

    //--------------Buscar Codigo Sugerencia
    public Sugerencia buscarCodigoSugerencia(int idSugDPB) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Sugerencias WHERE idSugerencia=?;";
        ResultSet res = null;
        Sugerencia SugeDPB = null;

        SugeDPB = new Sugerencia();
        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, idSugDPB);
        res = ps.executeQuery();

        res.next();
        SugeDPB.setIdSugerencia(res.getInt(1));
        SugeDPB.setTipoSug(res.getString(2));
        SugeDPB.setFechaSug(res.getTimestamp(3));
        SugeDPB.setDescripcionSug(res.getString(4));
        SugeDPB.getUsuario().setIdUsuario(res.getInt(5));

        return SugeDPB;
    }

    //------------Eliminar Codigo Sugerencia
    public void eliminarSugerencia(Sugerencia SugE) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "DELETE FROM Sugerencias WHERE idSugerencia=?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setInt(1, SugE.getIdSugerencia());
        ps.executeUpdate();

    }

//   //-----------Modificar--------------------------------------------
    public void modificarSugerencia(Sugerencia SugDPU) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Sugerencias SET  descripcionSug=? , TipoSug=?   WHERE idSugerencia = ?;";

        ps = connect.getConexion().prepareStatement(sql);

        ps.setString(1, SugDPU.getDescripcionSug());
        ps.setString(2, SugDPU.getTipoSug());
        ps.setInt(3, SugDPU.getIdSugerencia());

        ps.executeUpdate();

    }
}
