package br.com.fiap.obrafuturo.application.service;

import br.com.fiap.obrafuturo.application.dto.ObraRequest;
import br.com.fiap.obrafuturo.application.dto.ObraResponse;
import br.com.fiap.obrafuturo.application.mapper.ObraMapper;
import br.com.fiap.obrafuturo.domain.model.Obra;
import br.com.fiap.obrafuturo.infrastructure.repository.ObraRepository;
import br.com.fiap.obrafuturo.interfaces.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObraService {

    private final ObraRepository repository;

    public ObraService(ObraRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ObraResponse> listarTodas() {
        return repository.findAll()
                .stream()
                .map(ObraMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ObraResponse buscarPorId(Long id) {
        Obra obra = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obra não encontrada: " + id));
        return ObraMapper.toResponse(obra);
    }

    public ObraResponse criar(ObraRequest request) {
        Obra obra = ObraMapper.toEntity(request);
        Obra salva = repository.save(obra);
        return ObraMapper.toResponse(salva);
    }

    public ObraResponse atualizar(Long id, ObraRequest request) {
        Obra obra = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Obra não encontrada: " + id));

        ObraMapper.updateEntity(obra, request);
        Obra atualizada = repository.save(obra);
        return ObraMapper.toResponse(atualizada);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Obra não encontrada: " + id);
        }
        repository.deleteById(id);
    }
}
