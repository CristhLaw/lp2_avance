package pe.edu.upeu.sysalmacen.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.edu.upeu.sysalmacen.model.Marca;
import pe.edu.upeu.sysalmacen.service.IMarcaService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/marcas")
public class MarcaController {
    private final IMarcaService service;
    @GetMapping
    public ResponseEntity<List<Marca>> findAll() {
        List<Marca> list = service.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(@PathVariable("id") Long id) {
        Marca obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Marca dto) {
        Marca obj = service.save(dto);
        URI location =
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdMarca()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Marca> update( @PathVariable("id") Long id,
                                         @RequestBody Marca dto) {
        dto.setIdMarca(id);
        Marca obj = service.update(id, dto);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}