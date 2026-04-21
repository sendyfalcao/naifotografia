package com.naifotografia.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

/**
 * DTO para recebimento de dados na criação de um novo ensaio.
 * O uso de record garante imutabilidade e um código mais conciso.
 * Inclui validações usando Jakarta Bean Validation.
 */
public record EnsaioRequestDTO(
    @NotBlank(message = "Cliente é obrigatório")
    String cliente,
    
    @NotBlank(message = "Tipo de ensaio é obrigatório")
    String tipoEnsaio,
    
    @NotNull(message = "Data do ensaio é obrigatória")
    @PastOrPresent(message = "Data do ensaio não pode ser no futuro")
    LocalDate dataEnsaio,
    
    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Valor deve ser maior que zero")
    BigDecimal valor,
    
    String statusVideo,
    
    Boolean fotosSelecionadas,
    
    String linkDrive,
    
    String linkYoutube
) {
}
