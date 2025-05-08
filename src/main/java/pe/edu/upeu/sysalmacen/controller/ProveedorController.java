package pe.edu.upeu.sysalmacen.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.upeu.sysalmacen.model.Proveedor;
import pe.edu.upeu.sysalmacen.service.IProveedorService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final IProveedorService service;

    @GetMapping
    public ResponseEntity<List<Proveedor>> findAll() {
        List<Proveedor> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> findById(@PathVariable("id") Long id) {
        Proveedor obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Proveedor dto) {
        Proveedor obj = service.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getIdProveedor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> update(@PathVariable("id") Long id, @RequestBody Proveedor dto) {
        dto.setIdProveedor(id);
        Proveedor obj = service.update(id, dto);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
