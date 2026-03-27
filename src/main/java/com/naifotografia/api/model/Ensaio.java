package com.naifotografia.api.model;

import jakarta.persistence.*;
import java.math.BigDecimal; 

/**
 * Entidade de domínio que representa uma produção fotográfica ou audiovisual.
 * Mapeia os dados contratuais, status de pós-produção e os endpoints de entrega digital.
 */
@Entity
@Table(name = "tb_ensaios")
public class Ensaio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String cliente;

    @Column(name = "tipo_ensaio", nullable = false)
    private String tipoEnsaio; // Ex: Individual, Evento, Pet

    @Column(name = "data_ensaio")
    private String dataEnsaio;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    /** Status do workflow de vídeo: Bruto, Em Edição ou Finalizado */
    @Column(name = "status_video")
    private String statusVideo;

    /** Indica se o cliente concluiu a seleção das fotos na galeria (Google Drive) */
    @Column(name = "fotos_selecionadas")
    private Boolean fotosSelecionadas = false;

    /** URI de entrega para fotos (Google Drive) */
    @Column(name = "link_drive", length = 500)
    private String linkDrive;

    /** URI de entrega para vídeo (YouTube) */
    @Column(name = "link_youtube", length = 500)
    private String linkYoutube;

    public Ensaio() {
    }

    // --- MÉTODOS DE ACESSO (GETTERS E SETTERS) ---

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

    public String getDataEnsaio() {
        return dataEnsaio;
    }

    public void setDataEnsaio(String dataEnsaio) {
        this.dataEnsaio = dataEnsaio;
    }

    // GETTER 
    public BigDecimal getValor() {
        return valor;
    }

    // SETTER 
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