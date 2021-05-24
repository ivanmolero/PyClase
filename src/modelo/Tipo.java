package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo")
@NamedQueries({
        @NamedQuery(name = "Tipo.listar", query = "select t from Tipo t"),
        @NamedQuery(name = "Tipo.buscarNombre", query = "select t from Tipo t where t.nombre like :filtro"),
        @NamedQuery(name = "Tipo.listaConteoCategoria", query = "select new modelo.reporte.TipoCategoria(t.id, t.nombre, t.descripcion, count(c.id)) " +
                "from Tipo t join Categoria c on t = c.perteneceTipo group by t.id, t.nombre, t.descripcion")
})
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "perteneceTipo")
    private List<Categoria> agrupaCategorias;

    public Tipo() {
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

    public List<Categoria> getAgrupaCategorias() {
        if (agrupaCategorias == null){
            agrupaCategorias = new ArrayList<>();
        }
        return agrupaCategorias;
    }

    public void setAgrupaCategorias(List<Categoria> agrupaCategorias) {
        this.agrupaCategorias = agrupaCategorias;
    }
}
