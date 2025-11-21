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
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODIGO_OBRA", nullable = false, length = 30)
    private String codigoObra;

    @Column(name = "NOME_OBRA", nullable = false, length = 120)
    private String nome;

    @Column(name = "CNPJ", nullable = false, length = 14)
    private String cnpj;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "logradouro", column = @Column(name = "LOGRADOURO")),
            @AttributeOverride(name = "numero",     column = @Column(name = "NUMERO")),
            @AttributeOverride(name = "cidade",     column = @Column(name = "CIDADE")),
            @AttributeOverride(name = "estado",     column = @Column(name = "ESTADO")),
            @AttributeOverride(name = "cep",        column = @Column(name = "CEP"))
    })
    private EnderecoObra endereco;

    @Column(name = "DATA_INICIO", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDate dataFim;

    @Column(name = "STATUS_OBRA", nullable = false, length = 20)
    private String statusObra;

    @Column(name = "ATIVA")
    private Integer ativa; // 1 = ativa, 0 = inativa

    public Obra() {
    }

    public Obra(String nome,
                String cnpj,
                EnderecoObra endereco,
                LocalDate dataInicio,
                LocalDate dataFim,
                boolean ativa) {

        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.dataInicio = (dataInicio != null) ? dataInicio : LocalDate.now();
        this.dataFim = dataFim;
        this.statusObra = "EM_ANDAMENTO";
        this.ativa = ativa ? 1 : 0;
    }

    @PrePersist
    public void prePersist() {
        if (codigoObra == null || codigoObra.isBlank()) {
            this.codigoObra = "OBR-" + System.currentTimeMillis();
        }
        if (statusObra == null || statusObra.isBlank()) {
            this.statusObra = "EM_ANDAMENTO";
        }
        if (dataInicio == null) {
            this.dataInicio = LocalDate.now();
        }
        if (ativa == null) {
            this.ativa = 1; // por padrão, ativa
        }
    }

    // GETTERS

    public Long getId() {
        return id;
    }

    public String getCodigoObra() {
        return codigoObra;
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

    public String getStatusObra() {
        return statusObra;
    }

    public boolean isAtiva() {
        return ativa != null && ativa == 1;
    }

    // SETTERS

    public void setCodigoObra(String codigoObra) {
        this.codigoObra = codigoObra;
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
        this.dataInicio = (dataInicio != null) ? dataInicio : LocalDate.now();
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void setStatusObra(String statusObra) {
        this.statusObra = statusObra;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa ? 1 : 0;
    }
}
