package pe.edu.upeu.sysalmacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacen.model.Categoria;
import pe.edu.upeu.sysalmacen.repository.ICategoriaRepository;
import pe.edu.upeu.sysalmacen.service.ICategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private final ICategoriaRepository repository;

    @Autowired
    public CategoriaServiceImpl(ICategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {
        if (repository.existsById(id)) {
            categoria.setIdCategoria(id);
            return repository.save(categoria);
        }
        throw new RuntimeException("Categoria no encontrada");
    }

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
