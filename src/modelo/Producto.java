package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private long id;
    private BigDecimal precio;
    private String serie;
    private Almacen estaAlmacen;
    private List<DetalleDocumentoVenta> perteneceDetalleDocumentoVentas;

    public Producto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Almacen getEstaAlmacen() {
        return estaAlmacen;
    }

    public void setEstaAlmacen(Almacen estaAlmacen) {
        this.estaAlmacen = estaAlmacen;
    }

    public List<DetalleDocumentoVenta> getPerteneceDetalleDocumentoVentas() {
        if (perteneceDetalleDocumentoVentas == null) {
            perteneceDetalleDocumentoVentas = new ArrayList<>();
        }
        return perteneceDetalleDocumentoVentas;
    }

    public void setPerteneceDetalleDocumentoVentas(List<DetalleDocumentoVenta> perteneceDetalleDocumentoVentas) {
        this.perteneceDetalleDocumentoVentas = perteneceDetalleDocumentoVentas;
    }
}
