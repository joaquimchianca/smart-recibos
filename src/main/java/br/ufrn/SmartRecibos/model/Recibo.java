package br.ufrn.SmartRecibos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "recibo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recibo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataVencimento;
    private BigDecimal valor;
    private String descricao;
    private StatusRecibo status;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}
