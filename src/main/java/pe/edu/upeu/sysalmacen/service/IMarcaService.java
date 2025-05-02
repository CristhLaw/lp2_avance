package pe.edu.upeu.sysalmacen.service;

import pe.edu.upeu.sysalmacen.model.Marca;

import java.util.List;

public interface IMarcaService {
    Marca save(Marca t);
    Marca update(Long id, Marca t);
    List<Marca> findAll();
    Marca findById(Long id);
    void delete(Long id);
}