package com.naifotografia.api.controller;

import com.naifotografia.api.model.Ensaio;
import com.naifotografia.api.service.EnsaioService;
import com.naifotografia.api.dto.EnsaioRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Controller RESTful responsável por expor os endpoints de gestão de Naifotografia.
 * Segue os padrões HTTP para manipulação de recursos.
 */
@RestController
@RequestMapping("/ensaios")
public class EnsaioController {

    @Autowired
    private EnsaioService service;

    /** GET /ensaios - Listagem global. */
    @GetMapping
    public List<Ensaio> listar() {
        return service.listarTodos();
    }

    /** GET /ensaios/{id} - Detalhamento por ID. */
    @GetMapping("/{id}")
    public ResponseEntity<Ensaio> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** POST /ensaios - Criação com processamento de negócio. */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ensaio adicionar(@Valid @RequestBody EnsaioRequestDTO dto) {
        Ensaio ensaio = new Ensaio();
        ensaio.setCliente(dto.cliente());
        ensaio.setTipoEnsaio(dto.tipoEnsaio());
        ensaio.setDataEnsaio(dto.dataEnsaio());
        ensaio.setValor(dto.valor());
        ensaio.setStatusVideo(dto.statusVideo());
        ensaio.setFotosSelecionadas(dto.fotosSelecionadas());
        ensaio.setLinkDrive(dto.linkDrive());
        ensaio.setLinkYoutube(dto.linkYoutube());
        return service.processarESalvar(ensaio);
    }

    /** DELETE /ensaios/{id} - Remoção física. */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (service.excluir(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
