package modelo;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@NamedQueries({
        @NamedQuery(name = "Usuario.listar", query = "select u from Usuario u"),
        @NamedQuery(name = "Usuario.buscarLogin", query = "select u from Usuario u where u.login = :login"),
        @NamedQuery(name = "Usuario.contar", query = "select count(u) from Usuario u")
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "login", length = 15, unique = true, nullable = false)
    private String login;
    @Column(name = "contrasena", length = 256)
    private String contrasena;

    public Usuario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
