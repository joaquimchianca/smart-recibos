package br.ufrn.SmartRecibos.controller;

import br.ufrn.SmartRecibos.dto.request.ReciboRequest;
import br.ufrn.SmartRecibos.model.Recibo;
import br.ufrn.SmartRecibos.service.PDFReciboService;
import br.ufrn.SmartRecibos.service.ReciboService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Tag(name = "Recibos", description = "Endpoints para manipulação de Recibos")
@RestController
@RequestMapping("v1/recibo")
public class ReciboController {
    private final ReciboService reciboService;
    private final PDFReciboService pdfReciboService;

    public ReciboController(ReciboService reciboService, PDFReciboService pdfReciboService) {
        this.reciboService = reciboService;
        this.pdfReciboService = pdfReciboService;
    }

    @PostMapping
    public Recibo save(@RequestBody ReciboRequest recibo) {
        return reciboService.save(recibo);
    }

    @GetMapping
    // @PreAuthorize("hasAnyRole('ADM', 'CAIXA')")
    public List<Recibo> findAll(Pageable pageable) {
        return reciboService.findAll(pageable).getContent();
    }

    @GetMapping("/{id}")
    // @PreAuthorize("hasAnyRole('ADM', 'CAIXA')")
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

    @GetMapping("/pdf/export/{id}")
    // @PreAuthorize("hasAnyRole('ADM', 'CAIXA')")
    public void exportPdf(HttpServletResponse response, @PathVariable Long id) {
        Recibo recibo = reciboService.findById(id);
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        pdfReciboService.exportarRecibo(response, recibo);
    }
}
