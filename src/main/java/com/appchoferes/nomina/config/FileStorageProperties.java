package com.appchoferes.nomina.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "file.storage")
public class FileStorageProperties {

    private String basePath;
    private String imageExtension;
    private String fotoOdometroPath;
    private String fotoSelloPath;
    private String fotoTanque1Path;
    private String fotoTanque2Path;
    private String fotoFirmaPath;

    // Getters y Setters
    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getImageExtension() {
        return imageExtension;
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }

    public String getFotoOdometroPath() {
        return fotoOdometroPath;
    }

    public void setFotoOdometroPath(String fotoOdometroPath) {
        this.fotoOdometroPath = fotoOdometroPath;
    }

    public String getFotoSelloPath() {
        return fotoSelloPath;
    }

    public void setFotoSelloPath(String fotoSelloPath) {
        this.fotoSelloPath = fotoSelloPath;
    }

    public String getFotoTanque1Path() {
        return fotoTanque1Path;
    }

    public void setFotoTanque1Path(String fotoTanque1Path) {
        this.fotoTanque1Path = fotoTanque1Path;
    }

    public String getFotoTanque2Path() {
        return fotoTanque2Path;
    }

    public void setFotoTanque2Path(String fotoTanque2Path) {
        this.fotoTanque2Path = fotoTanque2Path;
    }

    public String getFotoFirmaPath() {
        return fotoFirmaPath;
    }

    public void setFotoFirmaPath(String fotoFirmaPath) {
        this.fotoFirmaPath = fotoFirmaPath;
    }

}
