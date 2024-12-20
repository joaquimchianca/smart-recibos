package br.ufrn.SmartRecibos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.ufrn.SmartRecibos.model.StatusRecibo;

public record ReciboRequest(
        LocalDateTime dataVencimento,
        BigDecimal valor,
        String descricao,
        Long cliente_id,
        Long funcionario_id) {
}
