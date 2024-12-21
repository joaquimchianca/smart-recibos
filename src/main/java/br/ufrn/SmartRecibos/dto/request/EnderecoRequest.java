package br.ufrn.SmartRecibos.dto.request;

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
