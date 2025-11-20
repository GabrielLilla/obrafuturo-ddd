package br.com.fiap.obrafuturo.application.dto;

import java.time.LocalDate;

public class ObraResponse {

    private Long id;
    private String nome;
    private String cnpj;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean ativa;

    public ObraResponse(Long id, String nome, String cnpj,
                        String logradouro, String numero,
                        String cidade, String estado, String cep,
                        LocalDate dataInicio, LocalDate dataFim,
                        Boolean ativa) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativa = ativa;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Boolean getAtiva() {
        return ativa;
    }
}
