package co.com.triliapp.dto;

public class Usuario {

    private Integer idUsuario;
    private String imagenUsu;
    private String displayName;
    private String contraseniaUsu;
    private String correoUsu;
    private Integer experienciaUsu;
    private Rango rango;
    private Rol rol;
    private String estadoUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getImagenUsu() {
        return imagenUsu;
    }

    public void setImagenUsu(String imagenUsu) {
        this.imagenUsu = imagenUsu;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getContraseniaUsu() {
        return contraseniaUsu;
    }

    public void setContraseniaUsu(String contraseniaUsu) {
        this.contraseniaUsu = contraseniaUsu;
    }

    public String getCorreoUsu() {
        return correoUsu;
    }

    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public Integer getExperienciaUsu() {
        return experienciaUsu;
    }

    public void setExperienciaUsu(Integer experienciaUsu) {
        this.experienciaUsu = experienciaUsu;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
 
}