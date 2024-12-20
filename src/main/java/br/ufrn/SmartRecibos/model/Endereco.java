package br.ufrn.SmartRecibos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String logradouro;
    @Column(nullable = false)
    public String numero;
    @Column(nullable = false)
    public String bairro;
    @Column(nullable = false)
    public String cidade;
    @Column(nullable = false)
    public String estado;
    @Column(nullable = false, length = 9)
    public String cep;
    public String complemento;
}
