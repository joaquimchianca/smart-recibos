package br.ufrn.SmartRecibos.dto;

public record EnderecoRequest(
        String logradouro,
        String numero,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String complemento
) {
}
