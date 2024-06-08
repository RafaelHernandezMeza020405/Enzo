package Servicio;

import Excepcion.PrendaNotFoundException;
import Modelo.Prenda;
import Repositorio.PrendaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DefaultPrendaService implements PrendaService{

    private final PrendaRepository prendaRepository;

    @Inject
    public DefaultPrendaService(PrendaRepository prendaRepository) {
        this.prendaRepository = prendaRepository;
    }


    @Override
    public Prenda obtenerPrendaPorId(long id) throws PrendaNotFoundException {
        return prendaRepository.findByIdOptional(id).orElseThrow(() -> new PrendaNotFoundException("Prenda no existe"));
    }

    @Override
    public List<Prenda> obtenerTodasLasprendas() {
        return prendaRepository.listAll();
    }

    @Transactional
    @Override
    public Prenda actualizarPrenda(long id, Prenda prenda) throws PrendaNotFoundException {
        Prenda existingPrenda = obtenerPrendaPorId(id);
        existingPrenda.setNombre(prenda.getNombre());
        existingPrenda.setFoto(prenda.getFoto());
        existingPrenda.setEstado(prenda.getEstado());
        existingPrenda.setColor(prenda.getColor());
        existingPrenda.setTalla(prenda.getTalla());
        existingPrenda.setPrecio(prenda.getPrecio());
        existingPrenda.setDescripcion(prenda.getDescripcion());
        existingPrenda.setTipo_catalogo(prenda.getTipo_catalogo());
        prendaRepository.persist(existingPrenda);
        return existingPrenda;
    }
    @Transactional
    @Override
    public Prenda guardarPrenda(Prenda prenda) {
        prendaRepository.persistAndFlush(prenda);
        return prenda;
    }
    @Transactional
    @Override
    public void eliminarPrenda(long id) throws PrendaNotFoundException {
        prendaRepository.delete(obtenerPrendaPorId(id));
    }
}
