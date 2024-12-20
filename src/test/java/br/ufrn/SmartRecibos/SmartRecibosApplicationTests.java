package br.ufrn.SmartRecibos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.model.Recibo;
import br.ufrn.SmartRecibos.service.ClienteService;
import br.ufrn.SmartRecibos.service.ReciboService;

@SpringBootTest
class SmartRecibosApplicationTests {

	@Autowired
	ClienteService clienteService;
	@Autowired
	ReciboService reciboService;

	@Test
	void testClientePaginado() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Cliente> clientes = clienteService.findAll(pageable);
		assertEquals("13171444810", clientes.getContent().get(0).getCpfCnpj());

	}

	@Test
	void testReciboPaginado() {
		Pageable pageable = PageRequest.of(0, 3);
		Page<Recibo> recibos = reciboService.findAll(pageable);
		assertEquals(1, recibos.getContent().get(0).getId());
		assertEquals(53, recibos.getContent().get(1).getId());

		pageable = PageRequest.of(1, 1);
		recibos = reciboService.findAll(pageable);
		assertEquals(53, recibos.getContent().get(0).getId());

	}

}
