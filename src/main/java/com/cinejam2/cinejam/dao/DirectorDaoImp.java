package com.cinejam2.cinejam.dao;

import com.cinejam2.cinejam.models.Director;
import com.cinejam2.cinejam.models.Socio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DirectorDaoImp implements DirectorDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Director> getDirectores() {
        String query = "FROM Director";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer dir_id) {
        Director director = entityManager.find(Director.class, dir_id);
        entityManager.remove(director);
    }

    @Override
    public void registrar(Director director) {
        entityManager.merge(director);
    }
}
