package pe.edu.upeu.sysalmacen.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacen.exception.ModelNotFoundException;
import pe.edu.upeu.sysalmacen.model.Marca;
import pe.edu.upeu.sysalmacen.repository.IMarcaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements IMarcaService {
    private final IMarcaRepository repository;
    @Override
    public Marca save(Marca t) {
        return repository.save(t);
    }
    @Override
    public Marca update(Long id, Marca t) {
        repository.findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
        return repository.save(t);
    }
    @Override
    public List<Marca> findAll() {
        return repository.findAll();
    }
    @Override
    public Marca findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
    }
    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new
                ModelNotFoundException("ID NOT FOUND: " + id));
        repository.deleteById(id);
    }
}
