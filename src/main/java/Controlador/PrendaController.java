package Controlador;

import Excepcion.PrendaNotFoundException;
import Modelo.Prenda;
import Servicio.PrendaService;
import jakarta.inject.Inject;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrendaController {
    private final PrendaService prendaService;

    @Inject
    public PrendaController(PrendaService prendaService){
        this.prendaService = prendaService;
    }

    @GET
    public List<Prenda> obtenerPrendas(){
        return prendaService.obtenerTodasLasprendas();
    }


    @GET
    @Path("/{id}")
    public Prenda obtenerPrenda(@PathParam("id") int id) throws PrendaNotFoundException {
        return prendaService.obtenerPrendaPorId(id);
    }
    @POST
    public Prenda crearPrenda(@Valid PrendaDto prendaDto){
        return prendaService.guardarPrenda(prendaDto.toPrenda());
    }
    @PUT
    @Path("/{id}")
    public Prenda actualizarPrenda(@PathParam("id") int id, @Valid PrendaDto prendaDto) throws PrendaNotFoundException{
        return prendaService.actualizarPrenda(id, prendaDto.toPrenda());
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrenda(@PathParam("id") int id) throws PrendaNotFoundException{
        prendaService.eliminarPrenda(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public static class PrendaDto {
        @NotBlank
        private String nombre;
        @NotBlank
        private String foto;
        @NotBlank
        private String color;
        @NotBlank
        private String talla;
        @NotBlank
        private String descripcion;
        private double precio;
        @NotBlank
        private String estado;

        @NotBlank
        private String tipo_catalogo;

        public String getNombre(){
            return nombre;
        }
        public void setNombre(String nombre){
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
        public Prenda toPrenda(){
            Prenda prenda = new Prenda();
            prenda.setNombre(nombre);
            prenda.setFoto(foto);
            prenda.setColor(color);
            prenda.setTalla(talla);
            prenda.setTipo_catalogo(tipo_catalogo);
            prenda.setDescripcion(descripcion);
            prenda.setPrecio(precio);
            prenda.setEstado(estado);
            return prenda;
        }
    }
}
