package pe.edu.upeu.sysalmacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysalmacen.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Long> {

}
