package com.naifotografia.api.service;

import com.naifotografia.api.model.Ensaio;
import com.naifotografia.api.repository.EnsaioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Camada de Serviço responsável pela lógica de negócio e orquestração de dados.
 * Centraliza o cálculo de precificação e validação de fluxos audiovisuais.
 */
@Service
public class EnsaioService {

    @Autowired
    private EnsaioRepository repository;

    /** @return Lista completa de registros. */
    public List<Ensaio> listarTodos() {
        return repository.findAll();
    }

    /** @param id ID único. @return Registro opcional. */
    public Optional<Ensaio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Calcula o orçamento dinamicamente e persiste o ensaio.
     * Regras: Evento (1500), Individual (350), Pet (300). YouTube (+800).
     * @param ensaio Objeto enviado via requisição.
     * @return Ensaio processado e salvo.
     */
    public Ensaio processarESalvar(Ensaio ensaio) {
        double precoBase = 500.00;

        if (ensaio.getTipoEnsaio() != null) {
            String tipo = ensaio.getTipoEnsaio().toLowerCase();
            if (tipo.contains("individual")) precoBase = 350.00;
            else if (tipo.contains("evento")) precoBase = 1500.00;
            else if (tipo.contains("pet")) precoBase = 300.00;
        }

        // Adicional por serviço de vídeo via YouTube
        if (ensaio.getLinkYoutube() != null && !ensaio.getLinkYoutube().isBlank()) {
            precoBase += 800.00;
        }

        ensaio.setValor(java.math.BigDecimal.valueOf(precoBase));
        return repository.save(ensaio);
    }

    /** @param id ID para remoção. @return booleano de confirmação. */
    public boolean excluir(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
