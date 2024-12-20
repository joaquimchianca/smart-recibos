package br.ufrn.SmartRecibos.dto;

import br.ufrn.SmartRecibos.model.Papel;

public record FuncionarioRequest(
        String nome,
        String email,
        Papel papel,
        String username,
        String password
) {
}