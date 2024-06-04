package Repositorio;

import Modelo.Prenda;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
@ApplicationScoped
public class PrendaRepository implements PanacheRepository<Prenda>{
}
