package control.dao;

import modelo.Tipo;
import modelo.reporte.TipoCategoria;
import modelo.repositorio.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.util.List;

public class TipoDao {
    private static EntityManager em = Persistencia.getInstancia().getEm();

    public static List<Tipo> listar(){
        //forzar carga completa del query, no usar memoria cache
        Query consulta = em.createNamedQuery("Tipo.listar");
        List<Tipo> salida = consulta.getResultList();
        for (Tipo tipo : salida) {
            em.refresh(tipo);
        }
        return salida;
    }

    public static List<TipoCategoria> listarConteoCategoria() {
        Query consulta = em.createNamedQuery("Tipo.listaConteoCategoria");
        List<TipoCategoria> salida = consulta.getResultList();
        return salida;
    }

    public static List<Tipo> buscarNombre(String filtro) {
        Query consulta = em.createNamedQuery("Tipo.buscarNombre");
        consulta.setParameter("filtro", filtro);
        return consulta.getResultList();
    }

    public static void crear(Tipo nuevoTipo) {
        em.getTransaction().begin();
        em.persist(nuevoTipo);
        em.getTransaction().commit();
    }

    public static void editar(Tipo editarTipo) {
        em.getTransaction().begin();
        em.merge(editarTipo);
        em.getTransaction().commit();
    }

    public static void eliminar(Tipo eliminarTipo){
        em.getTransaction().begin();
        em.remove(eliminarTipo);
        em.getTransaction().commit();
    }
}
