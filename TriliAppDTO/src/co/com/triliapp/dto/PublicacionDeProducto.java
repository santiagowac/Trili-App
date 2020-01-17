package co.com.triliapp.dto;

import java.sql.Timestamp;

public class PublicacionDeProducto {

    private Integer idPublicacionDeProducto;
    private String nombrePDP;
    private Timestamp fechaPDP;
    private String descripcionProducto;
    private String imagenProducto;
    private String marcaProducto;
    private float precioProducto;
    private String ubicacionProducto;
    private Usuario Usuario;
    private Producto Producto;

    public Integer getIdPublicacionDeProducto() {
        return idPublicacionDeProducto;
    }

    public void setIdPublicacionDeProducto(Integer idPublicacionDeProducto) {
        this.idPublicacionDeProducto = idPublicacionDeProducto;
    }

    public String getNombrePDP() {
        return nombrePDP;
    }

    public void setNombrePDP(String nombrePDP) {
        this.nombrePDP = nombrePDP;
    }

    public Timestamp getFechaPDP() {
        return fechaPDP;
    }

    public void setFechaPDP(Timestamp fechaPDP) {
        this.fechaPDP = fechaPDP;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(String ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

   

}
