package modelo;

public class Modelo {
    private long id;
    private String nombre;
    private String descripcion;
    private Marca perteneceMarca;
    private Categoria perteneceCategoria;

    public Modelo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Marca getPerteneceMarca() {
        return perteneceMarca;
    }

    public void setPerteneceMarca(Marca perteneceMarca) {
        this.perteneceMarca = perteneceMarca;
    }

    public Categoria getPerteneceCategoria() {
        return perteneceCategoria;
    }

    public void setPerteneceCategoria(Categoria perteneceCategoria) {
        this.perteneceCategoria = perteneceCategoria;
    }

}
