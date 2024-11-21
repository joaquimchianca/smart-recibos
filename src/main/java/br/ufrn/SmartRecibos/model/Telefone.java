package br.ufrn.SmartRecibos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "telefone")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false, referencedColumnName = "id")
    private Cliente cliente;

    private String numero;
}
