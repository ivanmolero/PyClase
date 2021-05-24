package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clase02")
public class Clase02 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "tieneClase02")
    private List<Clase01> tieneClase01;

    public List<Clase01> getTieneClase01() {
        if (tieneClase01 == null){
            tieneClase01 = new ArrayList<>();
        }
        return tieneClase01;
    }

    public void setTieneClase01(List<Clase01> tieneClase01) {
        this.tieneClase01 = tieneClase01;
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

    public Clase02() {
    }
}
