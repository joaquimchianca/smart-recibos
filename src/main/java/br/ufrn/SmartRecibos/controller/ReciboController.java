package br.ufrn.SmartRecibos.controller;

import br.ufrn.SmartRecibos.dto.request.ReciboRequest;
import br.ufrn.SmartRecibos.model.Recibo;
import br.ufrn.SmartRecibos.service.ReciboService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/recibo")
public class ReciboController {
    private final ReciboService reciboService;

    public ReciboController(ReciboService reciboService) {
        this.reciboService = reciboService;
    }

    @PostMapping
    public Recibo save(@RequestBody ReciboRequest recibo) {
        return reciboService.save(recibo);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADM', 'CAIXA')")
    public List<Recibo> findAll() {
        return reciboService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADM', 'CAIXA')")
    public Recibo findById(@PathVariable Long id) {
        return reciboService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADM', 'CAIXA')")
    public void delete(@PathVariable Long id) {
        reciboService.delete(id);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADM', 'CAIXA')")
    public void syncStatus(@PathVariable Long id, @RequestParam String status) {
        reciboService.syncStatus(id, status);
    }
}
