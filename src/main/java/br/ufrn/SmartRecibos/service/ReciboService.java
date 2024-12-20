package br.ufrn.SmartRecibos.service;

import br.ufrn.SmartRecibos.dto.ReciboRequest;
import br.ufrn.SmartRecibos.model.Cliente;
import br.ufrn.SmartRecibos.model.Funcionario;
import br.ufrn.SmartRecibos.model.Recibo;
import br.ufrn.SmartRecibos.model.StatusRecibo;
import br.ufrn.SmartRecibos.repository.ClienteRepository;
import br.ufrn.SmartRecibos.repository.FuncionarioRepository;
import br.ufrn.SmartRecibos.repository.ReciboRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReciboService {
    private final ReciboRepository reciboRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    public ReciboService(ReciboRepository reciboRepository,
            ClienteRepository clienteRepository,
            FuncionarioRepository funcionarioRepository) {
        this.reciboRepository = reciboRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Page<Recibo> findAll(Pageable pageable) {
        return reciboRepository.findAll(pageable);
    }

    public Recibo findById(Long id) {
        return reciboRepository.findById(id).orElse(null);
    }

    public Recibo save(ReciboRequest request) {

        Recibo recibo = new Recibo();
        recibo.setValor(request.valor());
        recibo.setDescricao(request.descricao());

        recibo.setDataCriacao(LocalDateTime.now());
        recibo.setDataAtualizacao(LocalDateTime.now());
        recibo.setDataVencimento(request.dataVencimento());
        recibo.setStatus(StatusRecibo.CRIADO);

        if (recibo.getDataAtualizacao().isBefore(recibo.getDataVencimento())) {
            recibo.setStatus(StatusRecibo.PENDENTE);
        }

        Cliente cliente = clienteRepository.findById(request.cliente_id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        recibo.setCliente(cliente);

        Funcionario funcionario = funcionarioRepository.findById(request.funcionario_id())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        recibo.setFuncionario(funcionario);

        return reciboRepository.save(recibo);
    }

    public void syncStatus(long id, String status) {
        StatusRecibo statusRecibo = StatusRecibo.valueOf(status.toUpperCase());
        int rows = reciboRepository.syncStatus(id, statusRecibo);
        if (rows <= 0) {
            throw new RuntimeException("Recibo não encontrado");
        }
    }

    public void delete(Long id) {
        reciboRepository.deleteById(id);
    }
}
