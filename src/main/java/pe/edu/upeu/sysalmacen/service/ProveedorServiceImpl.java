package pe.edu.upeu.sysalmacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacen.model.Proveedor;
import pe.edu.upeu.sysalmacen.repository.IProveedorRepository;
import pe.edu.upeu.sysalmacen.service.IProveedorService;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    private final IProveedorRepository repository;

    @Autowired
    public ProveedorServiceImpl(IProveedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public Proveedor update(Long id, Proveedor proveedor) {
        proveedor.setIdProveedor(id);
        return repository.save(proveedor);
    }

    @Override
    public List<Proveedor> findAll() {
        return repository.findAll();
    }

    @Override
    public Proveedor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
