package Controlador;

import Excepcion.PrendaNotFoundException;
import Modelo.Prenda;
import Servicio.PrendaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
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

        public String getNombre(){
            return nombre;
        }
        public void setNombre(String nombre){
            this.nombre = nombre;

        }
        public Prenda toPrenda(){
            Prenda prenda = new Prenda();
            prenda.setNombre(nombre);
            return prenda;
        }
    }
}
