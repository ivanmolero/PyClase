package modelo.repositorio;

import control.dao.UsuarioDao;
import control.utilidad.Encripta;
import modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Persistencia {
    private static Persistencia instancia;
    private EntityManager em;
    private Usuario usuario;

    private Persistencia() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_PU");
        em = emf.createEntityManager();
    }

    public static Persistencia getInstancia() {
        if (instancia == null) {
            instancia = new Persistencia();
            iniciaDatos();
        }
        return instancia;
    }

    public EntityManager getEm() {
        return em;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private static void iniciaDatos(){
        if (UsuarioDao.contar() == 0) {
            Usuario administrador = new Usuario();
            administrador.setLogin("admin");
            administrador.setContrasena(Encripta.encripta("1234"));
            UsuarioDao.crear(administrador);
            System.out.println("usuario creado con exito");
        }
    }
}
