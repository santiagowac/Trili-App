/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dao;

import co.com.triliapp.dto.Rango;
import co.com.triliapp.util.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante 2018
 */
public class RangoDAO {

    private Rango Rango;
    public Conexion link;
    public PreparedStatement ps = null;

    //--------------------Insertar Rango
    public Rango insertarRango(Rango RNG) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "INSERT INTO Rangos (nombreRNG,imagenRNG,descripcionRNG) values (?,?,?)";
        ps = connect.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

        ps.setString(1, RNG.getNombreRNG());
        ps.setString(2, RNG.getImagenRNG());
        ps.setString(3, RNG.getDescripcionRNG());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        RNG.setIdRango(rs.getInt(1));

        return RNG;
    }

    //--------------------------Mostrar Datos Rango
    public List<Rango> mostrarRango() throws SQLException {
        ArrayList<Rango> list = new ArrayList<>();
        Conexion connect = new Conexion();

        String sql = "SELECT * FROM Rangos;";
        ResultSet rs = null;

        ps = connect.getConexion().prepareStatement(sql);
        rs = ps.executeQuery();
        Rango RanD = null;

        while (rs.next()) {

            RanD = new Rango();
            RanD.setIdRango(rs.getInt(1));
            RanD.setNombreRango(rs.getString(2));
            RanD.setImagenRNG(rs.getString(3));
            RanD.setDescripcionRNG(rs.getString(4));

            list.add(RanD);
        }

        return list;
    }

    //--------------Buscar Codigo Rango
    public Rango buscarCodigoRango(int idRan) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "SELECT * FROM Rangos WHERE idRango=?;";
        ResultSet res = null;
        Rango Rang = null;

        Rang = new Rango();
        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, idRan);
        res = ps.executeQuery();

        res.next();
        Rang.setIdRango(res.getInt(1));
        Rang.setNombreRango(res.getString(2));
        Rang.setImagenRNG(res.getString(3));
        Rang.setDescripcionRNG(res.getString(4));

        return Rang;
    }

    //------------Eliminar Codigo Rango
    public void eliminarRango(Rango RNG) throws SQLException {

        Conexion connect = new Conexion();
        String sql = "DELETE FROM Rangos WHERE idRango = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setInt(1, RNG.getIdRango());
        ps.executeUpdate();

    }

    //-----------Modificar
    public void modificarRango(Rango RNGM) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Rangos SET   descripcionRNG = ? , imagenRNG = ? , nombreRNG = ?  WHERE idRango = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, RNGM.getDescripcionRNG());
        ps.setString(2, RNGM.getImagenRNG());
        ps.setString(3, RNGM.getNombreRNG());
        ps.setInt(4, RNGM.getIdRango());

        ps.executeUpdate();

    }

    //--------------------------------Actualizar Nombre Rango
    public void modificarnombreRango(Rango RNGMN) throws SQLException {
        Conexion connect = new Conexion();
        String sql = "UPDATE Rangos SET   nombreRNG = ? WHERE idRango = ?;";

        ps = connect.getConexion().prepareStatement(sql);
        ps.setString(1, RNGMN.getNombreRNG());
        ps.setString(2, sql);
        ps.setInt(2, RNGMN.getIdRango());

        ps.executeUpdate();

    }

}
