package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Alquiler;
import com.cinejam2.cinejam.models.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AlquilerDaoImp implements AlquilerDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Alquiler> getAlquileres() {
        String query = "FROM Alquiler";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer alq_id) {
        Alquiler alquiler = entityManager.find(Alquiler.class, alq_id);
        entityManager.remove(alquiler);
    }

    @Override
    public void registrar(Alquiler alquiler) {
        entityManager.merge(alquiler);
    }
}
