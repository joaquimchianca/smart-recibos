package br.ufrn.SmartRecibos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cliente")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String nome;

    @Column(nullable = false, unique = true, length = 14)
    public String cpfCnpj;

    @Column(nullable = false, unique = true)
    public String email;

    @Column(nullable = false)
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<Telefone> telefone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    public Endereco endereco;
    private boolean isPj;
    private boolean isAtivo;
}
