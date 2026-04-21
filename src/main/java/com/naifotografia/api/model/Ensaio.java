package com.naifotografia.api.model;

import com.naifotografia.api.dto.EnsaioRequestDTO;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidade JPA representando um ensaio fotográfico/videográfico.
 * Mapeia a tabela correspondente no banco de dados MySQL.
 */
@Entity
@Table(name = "ensaios")
public class Ensaio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String tipoEnsaio;
    private LocalDate dataEnsaio;
    private BigDecimal valor;
    private String statusVideo;
    private Boolean fotosSelecionadas;
    private String linkDrive;
    private String linkYoutube;

    // Construtor padrão necessário para JPA
    public Ensaio() {}

    // Construtor para criação a partir do DTO
    public Ensaio(EnsaioRequestDTO dados) {
        this.cliente = dados.cliente();
        this.tipoEnsaio = dados.tipoEnsaio();
        this.dataEnsaio = dados.dataEnsaio();
        this.valor = dados.valor();
        this.statusVideo = dados.statusVideo();
        this.fotosSelecionadas = dados.fotosSelecionadas();
        this.linkDrive = dados.linkDrive();
        this.linkYoutube = dados.linkYoutube();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoEnsaio() {
        return tipoEnsaio;
    }

    public void setTipoEnsaio(String tipoEnsaio) {
        this.tipoEnsaio = tipoEnsaio;
    }

    public LocalDate getDataEnsaio() {
        return dataEnsaio;
    }

    public void setDataEnsaio(LocalDate dataEnsaio) {
        this.dataEnsaio = dataEnsaio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatusVideo() {
        return statusVideo;
    }

    public void setStatusVideo(String statusVideo) {
        this.statusVideo = statusVideo;
    }

    public Boolean getFotosSelecionadas() {
        return fotosSelecionadas;
    }

    public void setFotosSelecionadas(Boolean fotosSelecionadas) {
        this.fotosSelecionadas = fotosSelecionadas;
    }

    public String getLinkDrive() {
        return linkDrive;
    }

    public void setLinkDrive(String linkDrive) {
        this.linkDrive = linkDrive;
    }

    public String getLinkYoutube() {
        return linkYoutube;
    }

    public void setLinkYoutube(String linkYoutube) {
        this.linkYoutube = linkYoutube;
    }
}