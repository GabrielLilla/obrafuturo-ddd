package br.com.fiap.obrafuturo.domain.model;

import br.com.fiap.obrafuturo.domain.vo.EnderecoObra;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "OBRA")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OBRA")
    @SequenceGenerator(name = "SQ_OBRA", sequenceName = "SQ_OBRA", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Embedded
    private EnderecoObra endereco;

    @Column(name = "DATA_INICIO")
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDate dataFim;

    @Column(name = "ATIVA")
    private String ativa; // 'S' ou 'N'

    public Obra() {
    }

    public Obra(String nome, String cnpj, EnderecoObra endereco,
                LocalDate dataInicio, LocalDate dataFim, boolean ativa) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativa = ativa ? "S" : "N";
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

    public EnderecoObra getEndereco() {
        return endereco;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public boolean isAtiva() {
        return "S".equalsIgnoreCase(ativa);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(EnderecoObra endereco) {
        this.endereco = endereco;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa ? "S" : "N";
    }
}
