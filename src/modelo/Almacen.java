package modelo;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private long id;
    private String nombre;
    private Local tieneLocal;
    private TipoAlmacen perteneceTipoAlmacen;
    private List<Producto> almacenaProductos;

    public Almacen() {
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

    public Local getTieneLocal() {
        return tieneLocal;
    }

    public void setTieneLocal(Local tieneLocal) {
        this.tieneLocal = tieneLocal;
    }

    public TipoAlmacen getPerteneceTipoAlmacen() {
        return perteneceTipoAlmacen;
    }

    public void setPerteneceTipoAlmacen(TipoAlmacen perteneceTipoAlmacen) {
        this.perteneceTipoAlmacen = perteneceTipoAlmacen;
    }

    public List<Producto> getAlmacenaProductos() {
        if (almacenaProductos == null){
            almacenaProductos = new ArrayList<>();
        }
        return almacenaProductos;
    }

    public void setAlmacenaProductos(List<Producto> almacenaProductos) {
        this.almacenaProductos = almacenaProductos;
    }
}
