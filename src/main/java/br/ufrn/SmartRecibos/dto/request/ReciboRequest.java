package br.ufrn.SmartRecibos.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReciboRequest(
        LocalDateTime dataVencimento,
        BigDecimal valor,
        String descricao,
        Long cliente_id,
        Long funcionario_id) {
}
