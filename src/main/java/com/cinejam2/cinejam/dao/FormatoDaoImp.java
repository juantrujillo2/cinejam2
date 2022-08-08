package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Formato;
import com.cinejam2.cinejam.models.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class FormatoDaoImp implements FormatoDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Formato> getFormatos() {
        String query = "FROM Formato";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer for_id) {
        Formato formato = entityManager.find(Formato.class, for_id);
        entityManager.remove(formato);
    }

    @Override
    public void registrar(Formato formato) {
        entityManager.merge(formato);
    }

}
