package Servicio;

import Excepcion.PrendaNotFoundException;
import Modelo.Prenda;
import java.util.List;

public interface PrendaService {
    Prenda obtenerPrendaPorId(long id) throws PrendaNotFoundException;
    List<Prenda> obtenerTodasLasprendas();
    Prenda actualizarPrenda(long id, Prenda prenda) throws PrendaNotFoundException;
    Prenda guardarPrenda(Prenda prenda);
    void eliminarPrenda(long id) throws PrendaNotFoundException;
}
