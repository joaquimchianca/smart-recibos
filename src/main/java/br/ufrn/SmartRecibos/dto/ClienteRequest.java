package br.ufrn.SmartRecibos.dto;

import java.util.List;

public record ClienteRequest(
        String nome,
        String cpfCnpj,
        String email,
        List<TelefoneRequest> telefone,
        int enderecoId,
        boolean isPj,
        boolean isAtivo
){
}


