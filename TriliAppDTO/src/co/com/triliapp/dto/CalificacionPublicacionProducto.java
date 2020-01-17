
package co.com.triliapp.dto;
import java.sql.Timestamp;


public class CalificacionPublicacionProducto {
   private Integer idCalificacionPublicacionProducto;
    private float valorCPP;
    private String comentario;
    private Timestamp fechaCPP;
    private Usuario Usuario;
    private PublicacionDeProducto PublicacionDeProducto;

    public Integer getIdCalificacionPublicacionProducto() {
        return idCalificacionPublicacionProducto;
    }

    public void setIdCalificacionPublicacionProducto(Integer idCalificacionPublicacionProducto) {
        this.idCalificacionPublicacionProducto = idCalificacionPublicacionProducto;
    }

    public float getValorCPP() {
        return valorCPP;
    }

    public void setValorCPP(float valorCPP) {
        this.valorCPP = valorCPP;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Timestamp getFechaCPP() {
        return fechaCPP;
    }

    public void setFechaCPP(Timestamp fechaCPP) {
        this.fechaCPP = fechaCPP;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public PublicacionDeProducto getPublicacionDeProducto() {
        return PublicacionDeProducto;
    }

    public void setPublicacionDeProducto(PublicacionDeProducto PublicacionDeProducto) {
        this.PublicacionDeProducto = PublicacionDeProducto;
    }

    
    
}
