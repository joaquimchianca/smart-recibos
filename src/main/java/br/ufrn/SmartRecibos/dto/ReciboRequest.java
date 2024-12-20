package br.ufrn.SmartRecibos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.ufrn.SmartRecibos.model.StatusRecibo;

public record ReciboRequest(
        Long id,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao,
        BigDecimal valor,
        String descricao,
        StatusRecibo status,
        Long cliente_id,
        Long funcionario_id) {
}
