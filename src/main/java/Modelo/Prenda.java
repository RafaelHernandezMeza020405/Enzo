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

    public Prenda(){

    }

    public Prenda(long id, String nombre){
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Nombre --->" + nombre + "Id ---> " + id;
    }
}
