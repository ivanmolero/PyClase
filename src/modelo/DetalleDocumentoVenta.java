package modelo;

public class DetalleDocumentoVenta {
    private long id;
    private int cantidad;
    private DocumentoVenta perteneceDocumentoVenta;
    private Producto refiereProducto;

    public DetalleDocumentoVenta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DocumentoVenta getPerteneceDocumentoVenta() {
        return perteneceDocumentoVenta;
    }

    public void setPerteneceDocumentoVenta(DocumentoVenta perteneceDocumentoVenta) {
        this.perteneceDocumentoVenta = perteneceDocumentoVenta;
    }

    public Producto getRefiereProducto() {
        return refiereProducto;
    }

    public void setRefiereProducto(Producto refiereProducto) {
        this.refiereProducto = refiereProducto;
    }
}
