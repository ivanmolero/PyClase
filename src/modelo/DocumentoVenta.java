package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DocumentoVenta {
    private long id;
    private LocalDateTime fechaEmision;
    private String serie;
    private Cliente perteneceCliente;
    private List<DetalleDocumentoVenta> tieneDetalleDocumentoVentas;

    public DocumentoVenta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Cliente getPerteneceCliente() {
        return perteneceCliente;
    }

    public void setPerteneceCliente(Cliente perteneceCliente) {
        this.perteneceCliente = perteneceCliente;
    }

    public List<DetalleDocumentoVenta> getTieneDetalleDocumentoVentas() {
        if (tieneDetalleDocumentoVentas == null) {
            tieneDetalleDocumentoVentas = new ArrayList<>();
        }
        return tieneDetalleDocumentoVentas;
    }

    public void setTieneDetalleDocumentoVentas(List<DetalleDocumentoVenta> tieneDetalleDocumentoVentas) {
        this.tieneDetalleDocumentoVentas = tieneDetalleDocumentoVentas;
    }
}
