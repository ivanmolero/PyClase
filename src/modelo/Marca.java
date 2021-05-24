package modelo;

import java.util.ArrayList;
import java.util.List;

public class Marca {
    private long id;
    private String nombre;
    private boolean tieneSAC;
    private List<Modelo> tieneModelos;

    public Marca() {
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

    public boolean isTieneSAC() {
        return tieneSAC;
    }

    public void setTieneSAC(boolean tieneSAC) {
        this.tieneSAC = tieneSAC;
    }

    public List<Modelo> getTieneModelos() {
        if (tieneModelos == null) {
            tieneModelos = new ArrayList<>();
        }
        return tieneModelos;
    }

    public void setTieneModelos(List<Modelo> tieneModelos) {
        this.tieneModelos = tieneModelos;
    }
}
