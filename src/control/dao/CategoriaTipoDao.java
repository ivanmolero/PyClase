package control.dao;

import modelo.reporte.CategoriaTipo;
import modelo.repositorio.Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CategoriaTipoDao {
    private static EntityManager em = Persistencia.getInstancia().getEm();

    public static List<CategoriaTipo> listar(){
        Query consulta = em.createNamedQuery("Categoria.listarCategoriaTipo");
        return consulta.getResultList();
    }

}
