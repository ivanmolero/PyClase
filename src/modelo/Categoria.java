package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@NamedQueries({
        @NamedQuery(name = "Categoria.listar", query = "select c from Categoria c"),
        @NamedQuery(name = "Categoria.listarTipo", query = "select c from Categoria c where c.perteneceTipo = :tipo"),
        @NamedQuery(name = "Categoria.listarCategoriaTipo", query = "select new modelo.reporte.CategoriaTipo(c.id, c.nombre, c.descripcion, t.id, t.nombre, t.descripcion) " +
                "from Categoria c join Tipo t on c.perteneceTipo = t")
})
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "pertenecetipo", referencedColumnName = "id")
    private Tipo perteneceTipo;
    @Transient
    private List<Modelo> tieneModelos;

    public Categoria() {
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

    public Tipo getPerteneceTipo() {
        return perteneceTipo;
    }

    public void setPerteneceTipo(Tipo perteneceTipo) {
        this.perteneceTipo = perteneceTipo;
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
