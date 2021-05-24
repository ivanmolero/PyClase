package modelo.reporte;

public class TipoCategoria {
    private long idTipo;
    private String nombreTipo;
    private String descripcionTipo;
    private long cantidadCategoria;

    public TipoCategoria(long idTipo, String nombreTipo, String descripcionTipo, long cantidadCategoria) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.descripcionTipo = descripcionTipo;
        this.cantidadCategoria = cantidadCategoria;
    }

    public TipoCategoria() {
    }

    public long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public long getCantidadCategoria() {
        return cantidadCategoria;
    }

    public void setCantidadCategoria(long cantidadCategoria) {
        this.cantidadCategoria = cantidadCategoria;
    }
}
