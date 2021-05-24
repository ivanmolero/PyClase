package control.dao;

import modelo.Categoria;
import modelo.Tipo;
import modelo.repositorio.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CategoriaDao {
    private static EntityManager em = Persistencia.getInstancia().getEm();

    public static List<Categoria> listar(){
        Query consulta = em.createNamedQuery("Categoria.listar");
        return consulta.getResultList();
    }

    public static List<Categoria> listarTipo(Tipo tipo){
        Query consulta = em.createNamedQuery("Categoria.listarTipo");
        consulta.setParameter("tipo", tipo);
        return consulta.getResultList();
    }

    public static void crear(Categoria nuevoCategoria) {
        em.getTransaction().begin();
        em.persist(nuevoCategoria);
        em.getTransaction().commit();
        Tipo tipo = nuevoCategoria.getPerteneceTipo();
        tipo.getAgrupaCategorias().add(nuevoCategoria);
    }

    public static void editar(Categoria editarCategoria) {
//        Categoria original = em.find(Categoria.class, editarCategoria.getId());
//        Tipo tipoOriginal = original.getPerteneceTipo();
        em.getTransaction().begin();
        em.merge(editarCategoria);
        em.getTransaction().commit();
        Tipo tipo = editarCategoria.getPerteneceTipo();
        tipo.getAgrupaCategorias().add(editarCategoria);
//        em.refresh(tipoOriginal);
    }

    public static void eliminar(Categoria eliminarCategoria){
        em.getTransaction().begin();
        em.remove(eliminarCategoria);
        em.getTransaction().commit();
    }
}
