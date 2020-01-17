/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.dto;
import java.sql.Timestamp;

/**
 *
 * @author Estudiante 2018
 */
public class Sugerencia {
    private Integer idSugerencia;
    private String tipoSug;
    private Timestamp fechaSug;
    private String descripcionSug;
    private Usuario usuario;

    public Integer getIdSugerencia() {
        return idSugerencia;
    }

    public void setIdSugerencia(Integer idSugerencia) {
        this.idSugerencia = idSugerencia;
    }

    public String getTipoSug() {
        return tipoSug;
    }

    public void setTipoSug(String tipoSug) {
        this.tipoSug = tipoSug;
    }

    public Timestamp getFechaSug() {
        return fechaSug;
    }

    public void setFechaSug(Timestamp fechaSug) {
        this.fechaSug = fechaSug;
    }

    public String getDescripcionSug() {
        return descripcionSug;
    }

    public void setDescripcionSug(String descripcionSug) {
        this.descripcionSug = descripcionSug;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
}
