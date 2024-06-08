package Modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="prenda")

public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String nombre;

    @Column(name="foto", nullable = false)
    @NotBlank
    private String foto;

    @Column(name="color", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String color;

    @Column(name="talla", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String talla;

    @Column(name="descripcion", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String descripcion;

    @Column(name="precio", nullable = false)
    private double precio;

    @Column(name="estado", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String estado;

    @Column(name="tipo_catalogo", nullable = false)
    @NotBlank
    @Size(max = 256)
    private String tipo_catalogo;



    public Prenda(){

    }

    public Prenda(long id, String nombre, String foto, String color, String talla, String descripcion, double precio, String estado, String tipo_catalogo){
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.color = color;
        this.talla = talla;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.tipo_catalogo = tipo_catalogo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_catalogo() {
        return tipo_catalogo;
    }

    public void setTipo_catalogo(String tipo_catalogo) {
        this.tipo_catalogo = tipo_catalogo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "tipo_catalogo='" + tipo_catalogo + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", foto='" + foto + '\'' +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                '}';
    }
}
