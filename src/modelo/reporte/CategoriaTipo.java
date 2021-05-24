package modelo.reporte;

public class CategoriaTipo {
    private long idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;
    private long idTipo;
    private String nombreTipo;
    private String descripcionTipo;

    public CategoriaTipo() {
    }

    public CategoriaTipo(long idCategoria, String nombreCategoria, String descripcionCategoria, long idTipo, String nombreTipo, String descripcionTipo) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.descripcionTipo = descripcionTipo;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public long getIdTipo() {
        return idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }
}
