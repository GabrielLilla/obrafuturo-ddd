package br.com.fiap.obrafuturo.interfaces.rest;

import br.com.fiap.obrafuturo.application.dto.ObraRequest;
import br.com.fiap.obrafuturo.application.dto.ObraResponse;
import br.com.fiap.obrafuturo.application.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraRestController {

    private final ObraService service;

    public ObraRestController(ObraService service) {
        this.service = service;
    }

    @GetMapping
    public List<ObraResponse> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ObraResponse buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ObraResponse> criar(@Valid @RequestBody ObraRequest request) {
        ObraResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ObraResponse atualizar(@PathVariable Long id,
                                  @Valid @RequestBody ObraRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
