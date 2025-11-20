package br.com.fiap.obrafuturo.domain.vo;

import jakarta.persistence.Embeddable;

@Embeddable
public class EnderecoObra {

    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoObra() {
    }

    public EnderecoObra(String logradouro, String numero,
                        String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
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
}
