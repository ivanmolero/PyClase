package control.dao;

import modelo.Usuario;
import modelo.repositorio.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UsuarioDao {
    private static EntityManager em = Persistencia.getInstancia().getEm();

    public static List<Usuario> listar(){
        Query consulta = em.createNamedQuery("Usuario.listar");
        return consulta.getResultList();
    }

    public static Usuario buscarLogin(String login){
        Query consulta = em.createNamedQuery("Usuario.buscarLogin");
        consulta.setParameter("login", login);
        Usuario salida = null;
        try {
            salida = (Usuario) consulta.getSingleResult();
        } catch (NoResultException e){
            System.out.println(e.getMessage());
        }
        return salida;
    }

    public static long contar(){
        long salida = 0;
        Query consulta = em.createNamedQuery("Usuario.contar");
        try {
            salida = (long) consulta.getSingleResult();
        } catch (NoResultException e){
            System.out.println(e.getMessage());
        }
        return salida;
    }

    public static void crear(Usuario nuevoUsuario) {
        em.getTransaction().begin();
        em.persist(nuevoUsuario);
        em.getTransaction().commit();
    }

    public static void editar(Usuario editarUsuario) {
        em.getTransaction().begin();
        em.merge(editarUsuario);
        em.getTransaction().commit();
    }

    public static void eliminar(Usuario eliminarUsuario){
        em.getTransaction().begin();
        em.remove(eliminarUsuario);
        em.getTransaction().commit();
    }
}
