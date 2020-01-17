/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dto;
import java.sql.Timestamp;
//import java.util.d;

/**
 *
 * @author Estudiante 2018
 */
public class Reporte {
    private Integer idReporte;
    private String descripcionRpte;
    private Timestamp fechaRpte;
    private Usuario usuario;
    private PublicacionDeProducto publicacionDeProducto;

    public Integer getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Integer idReporte) {
        this.idReporte = idReporte;
    }

    public String getDescripcionRpte() {
        return descripcionRpte;
    }

    public void setDescripcionRpte(String descripcionRpte) {
        this.descripcionRpte = descripcionRpte;
    }

    public Timestamp getFechaRpte() {
        return fechaRpte;
    }

    public void setFechaRpte(Timestamp fechaRpte) {
        this.fechaRpte = fechaRpte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PublicacionDeProducto getPublicacionDeProducto() {
        return publicacionDeProducto;
    }

    public void setPublicacionDeProducto(PublicacionDeProducto publicacionDeProducto) {
        this.publicacionDeProducto = publicacionDeProducto;
    }
    
    
    
    
    
}
