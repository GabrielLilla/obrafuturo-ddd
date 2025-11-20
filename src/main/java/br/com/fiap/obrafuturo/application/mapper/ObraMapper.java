package br.com.fiap.obrafuturo.application.mapper;

import br.com.fiap.obrafuturo.application.dto.ObraRequest;
import br.com.fiap.obrafuturo.application.dto.ObraResponse;
import br.com.fiap.obrafuturo.domain.model.Obra;
import br.com.fiap.obrafuturo.domain.vo.EnderecoObra;

public final class ObraMapper {

    private ObraMapper() {}

    public static Obra toEntity(ObraRequest request) {
        EnderecoObra endereco = new EnderecoObra(
                request.getLogradouro(),
                request.getNumero(),
                request.getCidade(),
                request.getEstado(),
                request.getCep()
        );

        return new Obra(
                request.getNome(),
                request.getCnpj(),
                endereco,
                request.getDataInicio(),
                request.getDataFim(),
                Boolean.TRUE.equals(request.getAtiva())
        );
    }

    public static void updateEntity(Obra obra, ObraRequest request) {
        obra.setNome(request.getNome());
        obra.setCnpj(request.getCnpj());
        obra.setEndereco(new EnderecoObra(
                request.getLogradouro(),
                request.getNumero(),
                request.getCidade(),
                request.getEstado(),
                request.getCep()
        ));
        obra.setDataInicio(request.getDataInicio());
        obra.setDataFim(request.getDataFim());
        obra.setAtiva(Boolean.TRUE.equals(request.getAtiva()));
    }

    public static ObraResponse toResponse(Obra obra) {
        return new ObraResponse(
                obra.getId(),
                obra.getNome(),
                obra.getCnpj(),
                obra.getEndereco() != null ? obra.getEndereco().getLogradouro() : null,
                obra.getEndereco() != null ? obra.getEndereco().getNumero() : null,
                obra.getEndereco() != null ? obra.getEndereco().getCidade() : null,
                obra.getEndereco() != null ? obra.getEndereco().getEstado() : null,
                obra.getEndereco() != null ? obra.getEndereco().getCep() : null,
                obra.getDataInicio(),
                obra.getDataFim(),
                obra.isAtiva()
        );
    }
}
