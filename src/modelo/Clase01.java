package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clase01")
public class Clase01 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany
    private List<Clase02> tieneClase02;

    public List<Clase02> getTieneClase02() {
        if (tieneClase02 == null) {
            tieneClase02 = new ArrayList<>();
        }
        return tieneClase02;
    }

    public void setTieneClase02(List<Clase02> tieneClase02) {
        this.tieneClase02 = tieneClase02;
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

    public Clase01() {
    }
}
